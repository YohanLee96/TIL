//math 모듈

//이런식으로 함수옆에 export를 명시하면 아래처럼 export할 함수를 정의안해도된다.
export function add(a, b) {
  return a + b;
}

export function sub(a, b) {
  return a - b;
}

//기본 함수 정의
export default function multiply(a, b) {
  return a * b;
}

//CommonJS 방식
// module.exports = {
//   // add: add,
//   // sub: sub,
//   add,
//   sub,
// };

//ESM 방식
// export { add, sub };
