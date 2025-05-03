// 메소드 > 값이 함수인 프로퍼티
const person = {
    name: '이요한',
    //메소드
    say: () => {
        console.log('say')
    }
}

person.say();
person['say']();