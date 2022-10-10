const fs = require('fs');

fs.copyFile('./copy/copy1.txt','./copy/copy2.txt',(error) =>{
    if(error){
        return console.error(error);
    }

    console.log('복사 완료');
});