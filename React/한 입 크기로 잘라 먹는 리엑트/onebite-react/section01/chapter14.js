// 스코프
// > 전역 스코프 / 지역 스코프

let a = 1; //전역 스코프
function fnA() {
    let b = 2; // 지역 스코프
}

if(true) {
    let c=  1;  //블록내이므로 지역 스코프
}