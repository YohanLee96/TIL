function add10(num) {
  const promise = new Promise((resolve, reject) => {
    //executor 함수
    //비동기 작업
    // setTimeout(() => {
    //   console.log("안녕");
    //   //resolve함수에 인자로 전달한값은 PromiseResult에 저장됨.
    //   resolve("a");
    // }, 2000);
    // setTimeout(() => {
    //   console.log("안녕");
    //   //reject함수에 인자로 전달한값은 PromiseResult에 저장됨.
    //   reject("a");
    // }, 2000);
    setTimeout(() => {
      if (typeof num === "number") {
        resolve(num + 10);
      } else {
        reject("num이 숫자가 아닙니다.");
      }
    }, 2000);
  });
  return promise;
}

//then 메소드 > resolve로 전달한 인자가 넘어온다.
// promise.then((value) => {
//   console.log(value);
// });
//catch 메소드 > reject로 전달한 인자가 넘어온다.
// promise.catch((error) => {
//   console.log(error);
// });

//체이닝 가능.
// promise
//   .then((value) => {
//     console.log(value);
//   })
//   .catch((error) => {
//     console.log(error);
//   });

add10(0)
  .then((result) => {
    console.log(result);
    const newP = add10(result);
    //새로운 Promise객체를 반환하면 다음 체이닝에 새로운 Promise로 연계할 수 있다.
    return newP;
  })
  .then((result) => {
    console.log(result);
    return add10(result);
  })
  .then((result) => {
    console.log(result);
  })
  //catch함수는 위 then함수가 어디에 위치해있든간에 모두 캐치할 수 있다.
  .catch((err) => {
    console.log(err);
  });
