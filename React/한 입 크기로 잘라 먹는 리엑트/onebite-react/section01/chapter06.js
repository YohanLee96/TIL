// 1. 묵시적 형변환
let num = 10;
let str = "20";

//"1020"
console.log(num + str);


// 2. 명시적 형변환
let str1 = "10";
let num1 = 10;
//20
console.log(Number(str1) + num1);


let str2 = "10개";
//NaN
console.log(Number(str2))
//10(앞에 숫자만 있을 경우, 숫자만 형변환 처리. 못하는 경우도 있음.)
console.log(parseInt(str2))
// 숫자 > 문자열
console.log(String(num1))