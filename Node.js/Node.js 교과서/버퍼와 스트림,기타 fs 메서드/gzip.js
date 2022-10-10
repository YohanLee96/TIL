const zlib = require('zlib');
const fs = require('fs');

const read = fs.createReadStream('./test2.txt');
const zlibStream = zlib.createGzip();
const write = fs.createWriteStream('./Bandi.gz');
read.pipe(zlibStream).pipe(write);
