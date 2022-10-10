const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length; //CPU 갯수
let number = 3;

if(cluster.isMaster){
    console.log(`마스터 프로세스 아이디 :${process.pid}`);
    number++;
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
    }).listen(8081);
    console.log(number);
   // throw new error();;
    console.log(`${process.pid}번 워커 실행`);
}