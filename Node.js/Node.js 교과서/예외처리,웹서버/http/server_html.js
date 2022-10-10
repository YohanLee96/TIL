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

server.listen(8081);

server.on('listening',()=>{
    console.log('서버가 열렸습니다!!');
});