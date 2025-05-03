// 1. 배열 순회
let arr = [1, 2, 3];

//기본 반복문
for (let i = 0; i < arr.length; i++) {
  //   console.log(arr[i]);
}

// of 반복문
for (let item of arr) {
  //   console.log(item);
}

// 2. 객체 순회
let person = {
  name: "이요한",
  age: 30,
  hobby: "헬스",
};

// Object.keys 사용
let keys = Object.keys(person);

for (let item of keys) {
  //   console.log(item, person[item]);
}

// Object.values 사용 (value만 뽑음)
let values = Object.values(person);
// console.log(values);

// for in (객체에서만 사용가능!!)
for (let key in person) {
  console.log(key, person[key]);
}
