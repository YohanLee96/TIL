// 1.객체 생성 방법
let obj1 = new Object();
let obj2 = {}

let person = {
    //2. 객체 프로퍼티
    name: '이요한',
    age: 30,
    hobby: '배드민턴',
    extra: {},
    fun: () => {}
}

//3. 객체 프로퍼티 다루는 방법
// 점 표기법
console.log(person.name)
// 괄호 표기법
console.log(person['age'])

let property = "hobby";
console.log(person[property])

//프로퍼티 추가
person.job = "Backend Developer";
console.log(person.job)
//프로퍼티 수정
person.job = "Developer";
console.log(person.job)
//프로퍼티 삭제(예약어 사용 필요)
delete person.job
delete person.hobby
console.log(person)

//프로퍼티 존재 유무 확인(in 연산자)
let result1 = "name" in person
console.log(result1)
let result2 = "cat" in person
console.log(result2)