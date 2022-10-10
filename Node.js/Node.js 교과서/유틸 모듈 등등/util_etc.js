const util = require('util');


console.log('==========util.format()===========');

let f_a = util.format('%s',11);

console.log('%s',11);

let f_b = util.format('%d',456);

console.log(f_b);


console.log('==========util.isArray()===========');

let a_a =  util.isArray([]);
  // true
let a_b = util.isArray(new Array);
  // true
let a_c = util.isArray({});
  // false

  console.log(a_a);
  console.log(a_b);
  console.log(a_c);

  console.log('==========util.isError()===========');
function a(){
  console.log(wefwef);
}



    let e_a = util.isError(new Error());
    // true
    let e_b = util.isError(new TypeError());
    // true
    let e_c = util.isError({ name: 'Error', message: 'an error occurred' });
    let test = util.isError(new ReferenceError());
  console.log(test);
  //console.log(e_b);
  //console.log(e_c);