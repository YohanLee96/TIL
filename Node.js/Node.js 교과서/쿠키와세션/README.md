## 쿠키를 이용한 로그인서비스 만들기

**쿠키란?**
-> 클라이언트에 저장되는 키와 값이 들어있는 데이터 파일. 

 **쿠키를 이용하면 간단한 로그인 서비스를 만들 수있다!!** 

**#쿠키를 이용한 로그인 서비스**

```javascript
const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');


//쿠키를 파싱하는 코드
const parseCookie = (cookie = '') =>
    cookie
        .split(';')
        .map(v=>v.split('='))
        .map(([k, ...vs]) =>[k,vs.join('=')])
        .reduce((acc,[k,v]) => {
            acc[k.trim()] = decodeURIComponent(v);
            return acc;
        }, {});
//쿠키를 파싱하는 코드 끝

http.createServer((req,res) => {
    const cookies = parseCookie(req.headers.cookie);
    
    //클라이언트에서 받은 url이 /login으로 시작할 경우..
    if(req.url.startsWith('/login')){   
        //url모듈 사용하여, url에 담긴 정보 추출.
        const {query} = url.parse(req.url);         
        //추출한 정보를 다시 쿼리스트링 모듈을 이용하여 추출.
        const {name} = qs.parse(query); 
       
        //현재 시간 가져오기.
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 1); //현재시간에 1분을 추가하여 쿠키 만료기한 지정.
        res.writeHead(302, { //쿠키 기록.
            Location : '/',
            'Set-Cookie' : `name=${encodeURIComponent(name)};Expires=${expires.toGMTString()};HttpOnly;Path=/`
        });
        res.end();
    //쿠키에 name이라는 쿠키가 있을경우..
    }else if(cookies.name){
        res.writeHead(200,{'Content-Type': 'text/html; charset=utf-8'});
        res.end(`${cookies.name}님 안녕하세요`);
    }else{
        fs.readFile('./login.html',(err,data) =>{
            if(err){
                throw err;
            }
            res.end(data);
        });
    }
})
    .listen(8081,() =>{
        console.log('8081 포트 대기');
    });
```

여기서 로그인 시, 담은 쿠키정보는

> name = 아이디값.
> Expires =  쿠기 만료기한.
> httpOnly =  http만 쿠키 사용.[<> secure(https만 쿠키사용)]
> path = 쿠키가 전송될 URL.

해당 4개의 정보이다.  해당 코드를 실행하면, 한번 로그인 시,  해당 정보가 쿠키에 저장되어, 쿠키가 만료 되기전 까지,
아래와 같이 환영합니다 라는 페이지로 계속 넘어간다. 

![1563711488763](C:\Users\Yohan Lee\AppData\Roaming\Typora\typora-user-images\1563711488763.png)



하지만 쿠키로 로그인 서비스를 하기에는 값들이 전부 그대로 담아지기 때문에 보안에 위험하다!!
그래서 로그인서비스를 구현할 때, 세션방식을 많이 사용한다.

**#세션 자체 구현 코드**

```javascript
const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');

const parseCookie = (cookie = '') =>
cookie
    .split(';')
    .map(v=>v.split('='))
    .map(([k, ...vs]) =>[k,vs.join('=')])
    .reduce((acc,[k,v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
    }, {});

const session = {}; //session이라는 배열 선언.

http.createServer((req,res) =>{
    const cookies = parseCookie(req.headers.cookie);
    
    if(req.url.startsWith('/login')){
        const {query} = url.parse(req.url);
        const {name} = qs.parse(query);
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 5);

        const random = +new Date(); //현재날짜에 대한 밀리초값.
        session[random] = {
            name, //session이라는 배열의 random값에 아이디와 세션만료기한 지정.
            expires
        };
        res.writeHead(302, {
            Location : '/',
            'Set-Cookie' : `session=${random};Expires=${expires.toGMTString()};HttpOnly;Path=/`,
        }); //session이라는 키값에 random변수에 들어있는 값 지정하여 쿠키 생성.
        res.end();
    }else if(cookies.session && session[cookies.session].expires > new Date()){
        res.writeHead(200,{'Content-Type': 'text/html; charset=utf-8'});
        res.end(`${session[cookies.session].name}님 안녕하세요`);
    }else{
        fs.readFile('./login.html',(err,data) =>{
            if(err){
                throw err;
            }
            res.end(data);
        });
    }
})
    .listen(8082, () =>{
        console.log('8082포트 대기 ');
    });
```

**세션이란?**
-> 서버가 검증을하기위해 클라이언트에 일련의 고유값을 담아 검증하는 방식.

하지만 위와같은 방법으로하면 쿠키에 정보들이 모두 깡으로 담아지므로, 위험해진다. 그래서 쿠키값을  Date()객체를 사용해 변조시켜서 세션과 비스무리한 기능처럼 만들어 보았다.   

하지만 해당 코드또한 [ /login ] 으로 바로 접근하면 로그인이 가능해지는 취약점이 있다.



**#취약점을 보완한 코드**

```javascript
const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');

const parseCookie = (cookie = '') =>
cookie
    .split(';')
    .map(v=>v.split('='))
    .map(([k, ...vs]) =>[k,vs.join('=')])
    .reduce((acc,[k,v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
    }, {});

const session = {};

http.createServer((req,res) =>{
    const cookies = parseCookie(req.headers.cookie);
    const {query} = url.parse(req.url);
    const {name} = qs.parse(query);
    if(req.url.startsWith('/login') && {name}.name != undefined){
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 5);
      
        const random = +new Date();
        session[random] = {
            name,
            expires
        };
        res.writeHead(302, {
            Location : '/',
            'Set-Cookie' : `session=${random};Expires=${expires.toGMTString()};HttpOnly;Path=/`,
        });
        res.end();
    }else if(cookies.session && session[cookies.session].expires > new Date()){
        res.writeHead(200,{'Content-Type': 'text/html; charset=utf-8'});
        res.end(`${session[cookies.session].name}님 안녕하세요`);
    }else{
        fs.readFile('./login.html',(err,data) =>{
            if(err){
                throw err;
            }
            res.end(data);
        });
    }
})
    .listen(8082, () =>{
        console.log('8082포트 대기 ');
    });
```

쿼리스트링안에 있는 name값을 비교해 로그인을 시킬지 안시킬지 분기처리를 해주면된다. 

이러한 쿠키와 세션방식을 잘 이용하면, 여러 기능에 유용하게 사용할 수 있다. 

**쿠키 사용 예** 

-  자동로그인 기능

- 팝업에서 "오늘 더이상 이 창을 보지 않음" 체크기능

-   방문 사이트에서 로그인 시, "아이디와 비밀번호를 저장하시겠습니까?

- 쇼핑몰 장바구니(이건 어떤 방식으로 적용해서 사용하는지 모르겠음..)

  