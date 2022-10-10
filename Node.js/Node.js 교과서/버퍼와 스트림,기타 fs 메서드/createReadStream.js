const fs = require('fs');

const readStream = fs.createReadStream('./hash.txt',{highWaterMark: 10 });
const data = [];



// readStream.on('open', () => {
//     console.log('open : 파일이 정상적으로 열리면 발동.');
// });

readStream.on('data',(chunk) => {
    console.log('데이터 읽을 꺼임!!!')
    data.push(chunk);
    console.log('data :',chunk,chunk.length);
});

readStream.on('end', () => {
 console.log('end :',Buffer.concat(data).toString());
});


readStream.on('close', () => {
     console.log('close : 파일을 닫을 경우 발생 .');
 });

readStream.on('error',(err) => {
    console.log('error:',err);
});
readStream.on('readable', () => {
    console.log('readable : 파일 읽기 시작!');
 });