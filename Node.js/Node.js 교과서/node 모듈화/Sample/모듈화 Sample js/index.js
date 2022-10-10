const {odd,even,zero} = require('./var');
const checkNumber = require('./func');

console.log("teststs");

function checkStringOddOrEven(str){
    if(str.length %2){
        return odd;
    }else if(str.length ==0){
        return zero;
    }
    return even; 
}

console.log("test :: " + checkNumber(3));
//console.log(checkStringOddOrEven('wefwegertgetrgergwfrge'));
