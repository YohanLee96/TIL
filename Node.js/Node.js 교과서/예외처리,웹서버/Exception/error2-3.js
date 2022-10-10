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