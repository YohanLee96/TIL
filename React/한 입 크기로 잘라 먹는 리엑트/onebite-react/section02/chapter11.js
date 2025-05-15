console.log(1);

// ** Web APIs(Web Browser의 별도 영역)
setTimeout(() => {
  console.log(2); //Web APIs에서 처리함(타이머 포함)
}, 3000);
console.log(3);
