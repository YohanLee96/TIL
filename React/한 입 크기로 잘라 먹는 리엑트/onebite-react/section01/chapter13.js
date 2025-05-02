//콜백 함수 > 자신이 아닌 다른 함수에, 인수로써 전달된 함수를 의미.
function main(value) {
    value();
}

function sub() {
    console.log("sub");
}
//콜백함수 호출
main(sub);

//함수 표현식
main(function sub() {
    console.log("sub");
})
//화살표 함수
main(() => {
    console.log("sub");
})