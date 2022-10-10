const path = require('path');


console.log('현재 경로->' + __dirname);
console.log(path.join(__dirname,'C:\\abc','\\def','D:\\ghi','\\qwe'));

console.log(path.resolve(__dirname,'\\abc','\\def','\\ghi','\\qwe'));

console.log(path.resolve(__dirname,'asd','qwe'));