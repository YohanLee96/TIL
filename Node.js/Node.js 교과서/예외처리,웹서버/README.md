## 예외 처리하기

- 에러날만한 부분을 예외처리를 제대로 안해주면 라이브 서비스 환경에서 해당 에러로 인해 서버가 다운되는 일이 일어날 수 있다. 이러한 불상사를 방지해주기 위해 예외처리를 확실하게 꼼꼼히 잘해주는 것이 중요하다.

**#try ~ catch() 문을 이용한 예외처리 방식**

```javascript
//error1.js

setInterval( () => {
    console.log('시작');
    try{
        throw new Error('오류 방출');
    }catch(err){
        console.error(err);
    }
}, 1000);

```

-> 에러를 throw하는 코드를 try~catch문으로 감싸서 작성할 경우, 에러는 방출하나 서버는 죽지않고 계속 돌아간다는걸 볼 수 있다.

**#노드 내장 모듈 이용 시, 에러가 발생할 경우**

```javascript
//error2-1.js

const fs = require('fs');

setInterval(() => {
    fs.unlink('./abc.js',(err) =>{
        if(err){
            console.error('abc.js라는 파일은 존재하지 않습니다.');
        }
    });
},1000);
```

-> 노드 내장 모듈인 fs모듈을 이용하여, 존재하지않는 파일을 삭제해볼려고 해보았다. 
다행히 해당 경우에는 에러로인해 서버가 다운되지않는다. 그런데..

```javascript
//error2-2.js

const fs = require('fs');

setInterval(() => {
    fs.unlink('./abc.js',(err) =>{
        if(err){
           throw err;       
        }   
    });
},1000);
```

-> 위와같이 에러를 throw하게 될경우 서버가 멈추게 된다.  이와같은 경우도 try~catch문으로 감싸주면된다.

```javascript
//error2-3.js

const fs = require('fs');

setInterval(() => {
    fs.unlink('./abc.js',(err) =>{
        try{
           throw err;       
        }catch(err){
            console.error('에러');
        }      
    });
    
},1000);
```

-> 요런식으로 감싸주면 내장모듈내에 에러처리도 가능하게 된다.

**#정말 에러가 어디서 생길지 모를 경우..**

```javascript
//error3-1.js

const a = "aa";
process.on('uncaughtException',(err)=>{
     console.error('예기치못한 에러',err);
 });


setInterval(() => {
   a--; //String타입이 담겨진 변수에 증감연산자를 사용하여, 에러 방출.
},1000);

```

-> 정말 에러가 어디서 생길지 모를경우에는 process 객체에 있는 "uncaughtException"라는 이벤트리스너를 달아주면 된다.  그럼 서버 실행중에 에러가 발생해도 해당 객체가 에러를 잡아주고 서버가 멈추지않는다. 

**허나, uncaughtException 이벤트 리스너는 정말 최후의 수단으로 생각하고 개발을 해야된다.**
**어떤에러든간에 다잡고 우선 서버는 실행시켜두기때문에, 서비스 개발 시, 중구난방**
**써버리면 데이터가 꼬인다던가 사용자가 어떠한 데이터를 등록했는데 에러가 발생되지 않아,  **
**사용자는 등록됬다고 생각하지만, 실제 DB에는 등록되지않는 불상사가 일어날 수 있다.**

이렇게 node에서는 try~catch문으로 예외처리하는 방식과 uncaughtException이벤트 리스너를 이용한 
두가지 예외처리방식이 있다. 



## 요청과 응답

- 드디어 웹서버를 다룰 수 있는 단원이다. 노드에서는 http 서버를 다루기가 매우 간편하다.

  

   **#http 프로토콜을 이용한 서버 구축**

  ```javascript
  const http = require('http');
  
  http.createServer((req,res) =>{ //createServer메소드의 인자값은 request,response값
      res.write('<p>test</p>');
      res.end('<span>End</span>');
  }).listen(8081,() =>{
      console.log('8081포트 서버 열림');
  });
  ```

  -> http 프로토콜을 이용하여 node 서버를 구축해봤다. 8081포트를 열어서,
   html 태그를 클라이언트에 response객체에 태워보냈다. 

  **Request : 클라이언트 -> 서버  로 보내는 값.**

  **Response : 서버 -> 클라이언트로 보내는 값.**

**#http프로토콜의 listen메소드의 이벤트**

```javascript
const http = require('http');

const server  = http.createServer((req,res) =>{
    res.write('<p>test</p>');
    res.end('<span>End</span>');
});

server.listen(8081);

//포트 열렸을 때 이벤트.
server.on('listening',() =>{
    console.log('8081포트 Open');
});

//서버 에러가 났을 경우 이벤트.
server.on('error',(error) =>{
 console.error('에러가났어요!! 얼른 처리해주세요 개발자님!!!')
 console.log('에러내용:' + error);
});


```

-> listen상태가 될 때, 이벤트를 걸어 줄 수 도 있다. 해당 예제는 "listening" 이벤트와 "error" 이벤트를 
보여주고있다.



**#html 파일을 이용하여  http 통신하기**

```javascript
const http = require('http');
const fs = require('fs');

const server = http.createServer((req,res) =>{
    fs.readFile('./main.html',(err,data) =>{
        if(err){
            throw err;
        }
        res.end(data);
    });
});

server.listen(8081); //8081 포트 열림.

server.on('listening',()=>{ //포트가 열렸을 시, 이벤트 추가.
    console.log('서버가 열렸습니다!!');
});
```

-> fs모듈을 이용하여, html파일을 가져와서 response객체에 추가한 후,  
  서버를 오픈했음. 허나 지금 상태는 서버가 클라이언트가 누군지 모르기에, 어떤 응답을 보내든
  똑같은 페이지를 표출한다.

