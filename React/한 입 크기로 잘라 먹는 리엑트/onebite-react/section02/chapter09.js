//5가지 배열 변형

// 1.filter > 조건을 만족하는 요소들만 필터링하여 새로운 배열로 반환.
let arr1 = [
  { name: "이요한", hobby: "테니스" },
  { name: "홍길동", hobby: "테니스" },
  { name: "김덕배", hobby: "독서" },
];
const tennisPeople = arr1.filter((obj) => obj.hobby === "테니스");

// console.log(tennisPeople);

// 2. map > 배열의 모든 요소를 순회하면서, 모든 콜백함수를 실행하고 결과값들을 모아서 새로운배열로 반환.
let arr2 = [1, 2, 3];
const mapResult1 = arr2.map((item, idx, arr) => {
  return item * 2;
});
// console.log(mapResult1);
const mapResult2 = arr1.map((obj) => obj.name);
// console.log(mapResult2);

// 3. sort > 배열을 사전순으로 정렬하는 메소드.
let arr3 = ["b", "a", "c"];
// ** sort()는 사전순으로만 정렬해줘서 숫자는 정상적으로 정렬되지 않음.
arr3.sort();
// console.log(arr3);
let arr4 = [10, 3, 5];
// ** 숫자를 정렬하고 싶으면 콜백함수로 정렬조건을 정의해주면된다.
arr4.sort((a, b) => {
  if (a > b) {
    return 1; //양수를 반환하면 b가 a 앞으로 감.
  } else if (a < b) {
    return -1; //음수를 반환하면 a가 b앞으로 감.
  }
  return 0; //자리안바꿈.
});
// console.log(arr4);

// 4. toSorted > sort와 같이 정렬은 동일하게 수행. 대신 정렬한 배열을 새로운배열로 반환함.
let arr5 = ["c", "a", "b"];
const sorted = arr5.toSorted();
// console.log(sorted);

// 5. join > 배열의 모든 요소를 하나의 문자열로 합쳐서 반환하는 메소드.
let arr6 = ["hi", "im", "winterhood"];
//기본 구분자 = ,
const joined = arr6.join();
// console.log(joined)
// 구분자를 달리 주고 싶다면 원하는 구분자를 인자로 전달해주면됨.
const joined2 = arr6.join(" ");
//공백 구분자로 합쳐짐.
console.log(joined2);
