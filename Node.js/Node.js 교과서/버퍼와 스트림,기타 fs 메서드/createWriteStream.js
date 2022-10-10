const fs =require('fs');

const write = fs.createWriteStream('./test.txt');

write.on('finish',() =>{
    console.log('파일 쓰기 완료');
});

write.write('기모띠.\r\n');
write.write('김김김김기모띠');
write.end();

