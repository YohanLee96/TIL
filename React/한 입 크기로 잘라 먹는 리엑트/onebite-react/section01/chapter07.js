// 1. null 병합 연산자
// -> 존재하는 값을 추려내는 기능
// -> null, undefined가 아닌 값을 찾아내는 연산자
let var1;
let var2 = 10;
let var3 = 20;

let var4 = var1 ?? var2;
//var1이 undefined이므로 10
console.log(var4);


let userName = "이요한";
let userNickName = "john";
//이름이 없다면 닉네임로 대체.
console.log(userName ?? userNickName);

// 2. typeof 연산자(타입 알 수 있음)
let var7 = 1;
var7 = "hello";
let t1 = typeof var7;
console.log(t1)