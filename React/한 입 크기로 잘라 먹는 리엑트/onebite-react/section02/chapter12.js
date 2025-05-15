function task(a, b, callback) {
  setTimeout(() => {
    const sum = a + b;
    callback(sum);
  }, 3000);
}
// task(1, 2, (value) => {
//   console.log(value);
// });

function orderFood(callBack) {
  setTimeout(() => {
    const food = "떡볶이";
    callBack(food);
  }, 3000);
}

function cooldownFood(food, callBack) {
  setTimeout(() => {
    const cooldownedFood = `식은 ${food}`;
    callBack(cooldownedFood);
  }, 2000);
}

function freezeFood(food, callBack) {
  setTimeout(() => {
    const freezedFood = `냉동된 ${food}`;
    callBack(freezedFood);
  }, 1500);
}

orderFood((food) => {
  //음식을 만든다.
  console.log(food);
  //음식을 식힌다.
  cooldownFood(food, (cooldownedFood) => {
    console.log(cooldownedFood);
    freezeFood(cooldownedFood, (freezedFood) => {
      console.log(freezedFood);
    });
  });
});
