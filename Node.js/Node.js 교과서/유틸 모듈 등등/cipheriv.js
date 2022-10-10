const crypto = require('crypto');

const cipher = crypto.createCipheriv('aes-256-cbc','afewf','reherheh');
let result = cipher.update('356장 6번째 줄에 있다.','utf8','base64');
result += cipher.final('base64');
console.log('암호화:',result);


const decipher = crypto.createDecipheriv('aes-256-cbc','afewf','reherheh');
let result2 = decipher.update(result,'base64','utf8');
result2 += decipher.final('utf8');
console.log('복호화:', result2);
