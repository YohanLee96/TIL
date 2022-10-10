const http = require('http');

http.createServer((req,res) =>{
    res.write('<p>test</p>');
    res.end('<span>End</span>');
}).listen(8081,() =>{
    console.log('8081포트 서버 열림');
});