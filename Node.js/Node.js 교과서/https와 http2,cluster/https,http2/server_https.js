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
}).listen(8081,() =>{
    console.log('8081포트 대기중');
});