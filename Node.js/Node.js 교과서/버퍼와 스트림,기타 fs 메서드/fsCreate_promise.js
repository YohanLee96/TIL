const fs = require('fs');

const fsPromise  = fs.promises;

fsPromise.access('./folder',fs.constants.F_OK | fs.constants.R_OK |fs.constants.W_OK)
.then(() => console.log('폴더 이미 있지롱~'))
.catch(() => 
    function(err){
        if(err.code=='ENOENT'){
            console.log('폴더없음')
        }else{
           exit();
        }
    },
    fs.mkdir('./folder',(err) =>{
        if(err){
            throw err;
        }
        console.log('폴더 만들기 성공')
    }),
    fs.open('./folder/file.js','w',(err,fd) =>{
        if(err){
            throw err;
        }
        console.log('빈 파일 만들기 성공',fd);
    }),
    fs.rename('./folder/file.js','./folder/newfile.js',(err) =>{
        if(err){
            console.log('안바뀜 ㅜㅜ');
            throw err;
        }
        console.log('이름 바꾸기 성공');
    })
 );
    
    

