const buffer = Buffer.from('저를 바꿔보셈');
console.log('from():',buffer);
console.log('length:',buffer.length);
console.log('toString():',buffer.toString());

const array = [Buffer.from('띄엄 '),Buffer.from('띄엄 '),Buffer.from('띄어쓰기')];
const buffer2 = Buffer.concat(array);
console.log('concat():', buffer2.toString());

const buffer3 = Buffer.alloc(5);
console.log('alloc():',buffer3);