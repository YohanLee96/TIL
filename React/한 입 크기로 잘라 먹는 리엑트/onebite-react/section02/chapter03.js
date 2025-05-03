// 1. 배열 구조분해 할당
let arr = [1, 2, 3];

//four = 기본값 설정.
let [one, two, three, four = 4] = arr;
// console.log(one, two, three, four)

// 2. 객체 구조 분해 할당
let person = {
  name: "이요한",
  age: 30,
  hobby: "헬스",
  extra: "hello",
};

let { name, age: myAge, hobby, extra = "hello" } = person;
console.log(name, myAge, hobby, extra);

//3. 객체 구조 분해 할당을 이용해서 함수의 매개변수를 받는 방법
const func = ({ name, age, hobby, extra }) => {
  console.log(name, age, hobby, extra);
};
func(person);
