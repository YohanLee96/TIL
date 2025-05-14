//5가지 요소 순회 및 탐색 메소드

// 1. forEach > 순회하며, 각각의 요소에 특정 동작 수행
let arr1 = [1, 2, 3];
//item > 요소, idx > 현재 인덱스, arr > 순회하는 배열
arr1.forEach((item, idx, arr) => {
  //   console.log(item);
  //   console.log(idx);
  //   console.log(arr);
});

// 2. includes > 특정 요소가 있는지 확인.
let arr2 = [1, 2, 3];
let isInclude = arr2.includes(10);
// console.log(isInclude);

// 3. indexOf > 특정 요소의 인덱스를 찾아서 반환.
let arr3 = [1, 2, 3];
let index = arr3.indexOf(2);
// console.log(index);
let arr4 = [2, 2, 2];
//동일요소가 존재할 경우, 제일 처음에 찾은 인덱스 반환
let index2 = arr4.indexOf(2);
// console.log(index2);

// 4. findIndex > 특정 요소의 인덱스를 반환. 대신 모든 요소를 순회하면서, 콜백함수를 만족해야됨.
let arr5 = [1, 2, 3];
//조건을 만족하지 않으면 -1 반환.
const fIndex = arr5.findIndex((item) => item % 2 !== 0);
//0
// console.log(fIndex);

//5. find > 모든 요소를 순회하면서 콜백함수를 만족하는 요소를 찾는데, 요소를 그대로 반환.
let arr6 = [{ name: "이요한" }, { name: "홍길동" }];

const finded = arr6.find((item) => item.name === "이요한");
//배열의 첫번째 객체
console.log(finded);
