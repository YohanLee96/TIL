//CommonJS와 ESM 방식은 혼용할 수 없다. ESM 방식을 쓸려면 package.json에 "type" : "module" 정의.
//** CommonJS 방식
// const { add, sub } = require("./math");
// ** ESM 방식(확장자까지 꼭 명시해야됨)

//기본함수는 별칭을 커스텀하게 네이밍 할 수 있다.
// import mul from "./math.js";
//이런식으로 합쳐서 import하는게 깔끔함.
import mul, { add, sub } from "./math.js";
//라이브러리에서 가져올땐 from뒤에 라이브러리명만 명시하면됨.
import randomColor from "randomcolor";
// console.log(add(1, 2));
// console.log(sub(1, 2));
// console.log(mul(1, 2));

const color = randomColor();
console.log(color);
