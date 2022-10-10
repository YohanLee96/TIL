## https

**http통신의 약점**
 ->  브라우저와 웹서버가 통신 시, 데이터를 암호화하지 않고, 평문전송을 하여 보안에 취약함.
이러한 http통신의 약점을 보완하여 나온 방식이 http방식에 SSL암호화를 추가한 https방식이다.

![ssl 통신 로직](D:\스터디\Node\8부(https와 http2,cluster)\https,http2\images\ssl 통신 로직.png)

위와 같이,  데이터 전송 시,  암호화 알고리즘을 통해 데이터를 암호화하여, 웹서버에 전송해주면
웹서버에서는 해당 데이터를 복호화하여, 데이터를 받는다.

웹서버에 SSL인증서를 적용시킬 때, 인증기관에 대한 정보도 담아주는데, 브라우저에서 웹서버와 https통신 시, 이 인증기관을 통해 데이터를 암호화 시켜서 웹서버에 전송한다. 

여기서 궁금한 점은, 웹서버는 암호화에 대한 키값과 알고리즘정보를 SSL인증서 적용 시에 정보를 담아놔서,
알고있겠지만, 브라우저는 어떻게 암호화 키에 대한 정보를 받는가에 대해 궁금할텐데, 이 부분은 브라우저와 웹서버가 SSL통신을 할때마다 브라우저에서 SSL인증기관에 요청해서 가져온  암호화 키를 이용하여 데이터를 암호화한다고 
한다.

**https 통신 과정**

1. 브라우저에서 인증기관에 인증서를 요청.
2. 인증기관에서는 해당 도메인에 대한 정보를 조회하여 존재할 경우, 브라우저에게 암호화 키를 담아서 인증서 전송.
3. 암호화키를 이용하여 데이터를 암호화하여, 브라우저에서 웹서버로 데이터 전송.
4. 받은 데이터를 웹서버에서 복호화하여 사용.



**#Node에서의 https 통신방식**

```javascript
const https = require('https');
const fs = require('fs');

https.createServer({
    cert : fs.readFileSync('./ssl/edasan.goe.go.kr.cer'), //SSL 인증서 경로
    key : fs.readFileSync('./ssl/edasan.goe.go.kr.key'), //비밀키 경로
    ca : [
        fs.readFileSync('./ssl/new_rootca.cer'), //상위 인증서 경로
        fs.readFileSync('./ssl/new_caChain_change.cer')  //상위 인증서 경로
    ],
}, (req,res) =>{
    res.write('<h1>hello Node</h1>');
    res.end('<p>hello server!</p>');
}).listen(443,() =>{
    console.log('443포트 대기중');
});
```

-> https 통신에 대한 코드이다.   보통 ssl 인증서 발급기관에서 인증서를 발급받을 때,    
**도메인에 대한 인증서(.cer)와 비밀키(.key) 파일과**
**해당 인증서를 발급해준 인증기관의 인증서 파일 2개를 발급해준다.**

## http/2

**#Node에서의 http/2 통신방식**

```javascript
const http2 = require('http2'); //http2모듈
const fs = require('fs');

http2.createSecureServer({ //createServer (X) createSecureServer (O)
    cert : fs.readFileSync('./ssl/edasan.goe.go.kr.cer'), //SSL 인증서 경로
    key : fs.readFileSync('./ssl/edasan.goe.go.kr.key'), //비밀키 경로
    ca : [
        fs.readFileSync('./ssl/new_rootca.cer'), //상위 인증서 경로
        fs.readFileSync('./ssl/new_caChain_change.cer')  //상위 인증서 경로
    ],
}, (req,res) =>{
    res.write('<h1>hello Node</h1>');
    res.end('<p>hello server!</p>');
}).listen(8081,() =>{
    console.log('8081포트 대기중');
});
```

Node에서는 http/2통신을 위한 http2라는 모듈을 제공한다. http모듈과 다른점은,  
createServer메소드를 createSecureServer로 대체한다는 점이다.

**http/2 방식은 기존 http/1.1 방식과 비교했을 때, 속도측면에서 훨씬 우월하다.**

**#http/2방식의 이점**
http/1.1 같은경우 한 Request 당, 하나의 Response만 받아온다. 
http/2은 한 Request 당, 여러개의 Response를 받아올 수 있다.

예를 들어,  기존 http같은 경우, 
메인페이지에 받아올 css파일이 3개라면, 총 3번의 request요청을 하여 받아와야되지만, 
http/2 같은 경우,  
Multiplexing방식을 이용하여 한번의 request 요청만으로 받아올 수 있다. 아래 이미지를 참조하자.

![http2방식의 이점](D:\스터디\Node\8부(https와 http2,cluster)\https,http2\images\http2방식의 이점.png)

## cluster

노드는 단일 쓰레드이다. 그러한 노드를 멀티스레드로 구현할 수 있게끔 만들어주는 모듈이 **cluster** 모듈이다.
코어를 8개를 가진 서버에서 보통 하나의 코어만 사용하는 노드서버를 요청이 들어왔을 때, 다중코어에서
병렬처리를 할 수있도록 만들어주는 모듈이다.  매우 효율적이긴 하지만,  세션을 공유를 못한다는 단점이 있다.

  

```javascript
const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length; //CPU 갯수
let number = 3;

if(cluster.isMaster){ //서버 실행 시, 마스터라고 하는 프로세스가 실행됨. 실행 될 경우, true
    console.log(`마스터 프로세스 아이디 :${process.pid}`);
    number++;
    for(let i =0; i<numCPUs;i++){
        cluster.fork(); //워커 생성(워커 생성 시, 해당코드를 다시 첫줄부터 읽는다.)
    }
    
    cluster.on('exit',(worker,code,signal) => {
        console.log(`${worker.process.pid}번 워커가 종료되었습니다.`);
    }) ;
}else{
    http.createServer((req,res) =>{
        res.write('<h1>hello Node!</h1>');
        res.end('<p>Bye Bye</p>');
    }).listen(8081);
    console.log(number);
    console.log(`${process.pid}번 워커 실행`);
}
```

**#메소드 설명**
cluster.isMaster : 마스터프로세스가 실행될 경우, true 아닌 경우, false
cluster.fork() : 워커 생성. 워커가 실행되면 코드를 다시 실행한다.

number라는 변수에 숫자 3을 입력하고, 마스터프로세스가 실행 될 경우, 1씩 증가시키도록 해놓았다.
실행 결과, number변수에 선언한 3이 증가되지않으면서 워커가 실행되는걸 볼 수 있다. 
이러한 결과를 보면, 각각의 워커끼리는 각자의 상태를 공유하지않는다는 사실을 도출할 수 있다.



```javascript
const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length; //CPU 갯수

if(cluster.isMaster){
    console.log(`마스터 프로세스 아이디 :${process.pid}`);
    for(let i =0; i<numCPUs;i++){
        cluster.fork(); //워커 생성
    }
    
    cluster.on('exit',(worker,code,signal) => {
        console.log(`${worker.process.pid}번 워커가 종료되었습니다.`);
    }) ;
}else{
    http.createServer((req,res) =>{
        res.write('<h1>hello Node!</h1>');
        res.end('<p>Bye Bye</p>');
        setTimeout(() =>{
            process.exit(1);
        }, 1000);
    }).listen(8081);

    console.log(`${process.pid}번 워커 실행`);
}
```

요청이 들어올 때마다, 1초후에 서버가 종료되도록 해보았다.
해당 코드를 실행하고, 작업관리자에 프로세스를 보면, 로컬호스트에 접속 할때마다, 
프로세스가 하나씩 죽는걸 볼 수 있다.













