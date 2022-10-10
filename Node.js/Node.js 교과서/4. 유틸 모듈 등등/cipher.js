const crypto = require('crypto');

const cipher = crypto.createCipher('aes-256-cbc','열쇠');

let result = cipher.update('356장 6번째 줄에 있다.','utf8','base64');
//console.log("--->" + result);
result += cipher.final('base64');

console.log('암호화:',result);


const decipher = crypto.createDecipher('aes-256-cbc','열쇠');
let result2 = decipher.update(result,'base64','utf8');
console.log('-->' + result2);
let result3 = decipher.final('utf8');
console.log('-->' + result3);
console.log('복호화:', result2);


