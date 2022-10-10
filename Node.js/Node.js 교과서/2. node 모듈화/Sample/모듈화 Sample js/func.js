const{odd,even,zero} = require('./var');

function checkOddorEven(num){
    console.log('1');
    if(num % 2){
        return odd;
    }else if(num ==0){
        return zero;
    }
    return even;
}

function show(num){
    console.log('앙!');
    return "ytest";
}



module.exports = checkOddorEven;
console.log('2 ::' + module);
module.exports = show;
