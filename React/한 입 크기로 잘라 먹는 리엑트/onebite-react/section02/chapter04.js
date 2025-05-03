/**
 * 1. Spread 연산자
 * > Spread : 흩뿌리다, 펼치다 라는 뜻
 * > 객체나 배열에 저장된 여러개의 값을 개별로 흩뿌려주는 역할
 */

//배열
let arr1 = [1, 2, 3];
// ...arr1 = Spread연산자
let arr2 = [4, ...arr1, 5, 6];
// console.log(arr2);

//객체
let obj1 = {
  a: 1,
  b: 2,
};

let obj2 = {
  ...obj1,
  c: 3,
  d: 4,
};

// console.log(obj2);

function fnA(p1, p2, p3) {
  console.log(p1, p2, p3);
}

//함수에도 사용가능!!
fnA(...arr1);

/**
 * 2. Rest 매개변수
 * 가변인자!!
 */

function fnB(one, ...rest) {
  console.log(rest);
}

fnB(...arr1);
