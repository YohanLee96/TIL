const http = require('http');

const server  = http.createServer((req,res) =>{
   // res.write('<p>test</p>');
   // res.end('<span>End</span>');
   res.write('<p>test</p>');
   res.write(wefwfw);
   res.end('<span>End</span>');
  
   
});

server.listen(8081);

server.on('listening',() =>{
    console.log('8081포트 Open');
});

server.on('error',(error) =>{
 console.error('에러가났어요!! 얼른 처리해주세요 개발자님!!!')
 console.log('에러내용:' + error);
});

