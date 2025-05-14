//6가지의 요소 조작 메소드

// 1. push > 배열의 맨뒤에 새로운 요소 추가.
let arr1 = [1, 2, 3];
//push후 배열 길이 반환.
const newLength = arr1.push(4, 5, 6, 7);
// console.log(arr1);
// console.log(newLength);

// 2. pop > 배열의 맨뒤에 있는 요소를 제거하고 반환.
let arr2 = [1, 2, 3];
const poppedItem = arr2.pop();
// console.log(poppedItem);

// 3.shift > 배열의 맨앞에 있는 요소를 제거하고 반환.
let arr3 = [1, 2, 3];
const shiftedItem = arr3.shift();
// console.log(shiftedItem, arr3);

// 4. unshift > 배열의 맨앞에 새로운 요소를 추가.
let arr4 = [1, 2, 3];
const newLength2 = arr4.unshift(0);
// console.log(arr4);
// console.log(newLength2);

// 5. slice > 배열의 특정 범위를 잘라내서 새로운 배열로 반환.
let arr5 = [1, 2, 3, 4, 5];
const s1 = arr5.slice(2, 5);
// 2번째 인수가 없는 경우, 뒤에는 배열의 마지막기준으로 자름.
const s2 = arr5.slice(2);
//음수일 경우 배열 맨뒤기준으로 범위선정.
const s3 = arr5.slice(-3);
//3,4,5
// console.log(s1);
//3,4,5
// console.log(s2);
//3,4,5
// console.log(s3);

// 6. concat > 2개의 서로 다른 배열을 이어 붙혀서 새로운 배열을 반환.
let arr6 = [1, 2];
let arr7 = [3, 4];
let cArr = arr6.concat(arr7);
console.log(cArr);
