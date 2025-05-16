/**
 * async > 어떤 함수를 비동기 함수로 만들어주는 키워드.
 *       > 함수가 프로미스를 반환하도록 변환해주는 키워드.
 */

//promise를 반환함
async function getData() {
  return {
    name: "이요한",
    age: 30,
  };
}

// console.log(getData());

// 함수내부에서 Promise를 반환하다면 그냥 그대로 반환함.
async function getData2() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve({
        name: "이요한",
        age: 30,
      });
    }, 1000);
  });
}

// console.log(getData2());

/**
 * await > async 함수 내부에서만 사용 가능한 키워드
 *       > 비동기 함수가 다처리되기를 기다리는 역할
 */

async function printData() {
  const data = await getData();
  console.log(data);
}

printData();
