const util = require('util');
const crypto = require('crypto');

const dontTouchMe = util.deprecate((x,y) =>{
    console.log(x+y);
},'폐기 기모띠~');
dontTouchMe(1,2);
const randomBytesPromise = util.promisify(crypto.randomBytes);
randomBytesPromise(60).then((buf) =>{
    console.log(buf.toString('base64'));
})
.catch((error) => {
    console.log('error');
});



