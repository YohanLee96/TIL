

const fs = require('fs');

setInterval(() => {
    fs.unlink('./abc.js',(err) =>{
        if(err){
            console.error('abc.js라는 파일은 존재하지 않습니다.');          
        }
       
    });
},1000);


