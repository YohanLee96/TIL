const fs = require('fs');

setInterval(() => {
    fs.unlink('./abc.js',(err) =>{
        if(err){
           throw err;       
        }   
    });
},1000);