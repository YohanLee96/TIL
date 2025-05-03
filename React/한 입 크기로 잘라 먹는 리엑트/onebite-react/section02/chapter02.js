// function returnFalse() {
//     console.log("False 함수")
//     return undefined;
// }
// function returnTrue() {
//     console.log("True 함수")
//     return 10;
// }

// console.log(returnFalse() && returnTrue())

/**
 * 단락 평가 활용사례
 */
function printName(person) {
    const name = person && person.name;
    //name이 undefined(Falsy)이므로 다음 단락을 검사함.
    console.log(name || "person에 값이 없음")
}

printName();
