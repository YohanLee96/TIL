// 1. Date 객체 생성 방법
let date1 = new Date();
// console.log(date1);

//원하는 날짜로 생성가능.
// ".", "/" 모두 사용가능.
let date2 = new Date("1996-08-05 10:00:00");
// console.log(date2);
let date3 = new Date(1996, 8, 5, 10, 0, 0);
// console.log(date3);

//2. 타임 스탬프 > 특정 시간이 "1970.01.01 00시00분00초"로 부터 몇 ms가 지났는지를 의미하는 숫자값.
let ts1 = date1.getTime();
//현재시간의 타임스탬프
// console.log(ts1);
let date4 = new Date(ts1);
// console.log(date1, date4);

// 3. 시간 요소들을 추출하는 방법
let year = date1.getFullYear();
//월은 0부터 시작함.
let month = date1.getMonth() + 1;
let date = date1.getDate();

let hour = date1.getHours();
let min = date1.getMinutes();
let seconds = date1.getSeconds();

// console.log(year, month, date, hour, min, seconds);

// 4. 시간 수정하기
date1.setFullYear(2023);
date1.setMonth(2); //3월
date1.setDate(30);
date1.setHours(24);
date1.setMinutes(50);
date1.setSeconds(50);
// console.log(date1);

// 5. 시간을 여러 포맷으로 출력하기.
console.log(date1.toDateString());
//현지화된 포맷으로 출력
console.log(date1.toLocaleString());
