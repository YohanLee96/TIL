const fs = require('fs');

const read = fs.createReadStream('./hash.txt');
const write = fs.createWriteStream('C:\\test3.txt');

read.pipe(write);