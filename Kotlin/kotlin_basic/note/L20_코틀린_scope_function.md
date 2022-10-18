## scope function이란?
scope : 영역  
function : 함수  
**scope function : 일시적인 영역을 형성하는 함수**  

아래 2개의 함수는 동일한 기능을 하는 함수이다.  
let은 확장함수 이며, 람다를 받아 람다결과를 반환하는 함수이다.
```kotlin
fun printPerson(person : Person?) {
    if(person != null) {
        println(person.name)
        println(person.age)
    }
}
fun printPerson(person : Person?) {
    person?.let { //person을 받아서 해당 람다 실행.
        println(it.name)
        println(it.age)
    }
}
```
---
### scope function 종류
- ```let``` 람다의 결과를 반환(객체 접근 시, 키워드 it 사용)
- ```run``` 람다의 결과를 반환(객체 접근 시, 키워드 this 사용)
- ```also``` 객체 자체를 반환(객체 접근 시, it 사용)
- ```apply``` 객체 자체를 반환(객체 접근 시, this 사용)
```kotlin
fun main() {
    val person = Person("이요한", 27)
    val val1 = person.let { //age 프로퍼티 반환
        it.age
    }
    val val2 = person.run { //age 프로퍼티 반환
        this.age
    }

    val val3 = person.also { //person 객체 반환
        it.age
    }

    val val4 = person.apply { //person 객체 반환
        this.age
    }
}
```
**this 와 it의 차이점**  
this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다.  
it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다.
```kotlin
val val5 = person.let { p -> //별칭 가능
        p.age
}
val val6 = person.run { 
    age //별칭은 불가능한 대신 this 키워드 생략가능
}
```
**위 케이스는 let은 일반함수를 받고, run은 확장함수를 받기때문으로써 해당 차이가 발생한다.**  

with함수는 아래와 같이 사용할 수 있으 확장함수가 아니기때문에  
```this``` 로 접근 가능하고```this```는 생략 가능하다.
```kotlin
val person = Person("이요한", 27)
with(person) {
    println(name)
    println(this.age)
}
```
---
### Scope Function 사용 사례
#### let
하나 이상의 함수를 call chain 결과로 호출 할 때
```kotlin
val strings = listOf("APPLE", "CAR")
strings.map { it.length }
    .filter { it > 3 }
    .let { lengths : List<Int> -> println(lengths) } //최종 결과 호출
```
non-null 값에 대해서만 code block을 실행시킬 때
```kotlin
val str = "ㅎㅇ";
val length = str?.let { //null이 아닐때만 실행.
    println(it.uppercase())
    it.length
}  
```
일회성으로 제한된 영역에 지역 변수를 만들 때
```kotlin
val numbers = listOf("one", "two", "three", "four")
val firstItem = numbers.first()
    .let { item ->
           if(item.length>= 5) {
               item
           } else {
               "!$item"
           }
    }.uppercase()
println(firstItem)
```
#### run
객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때

```kotlin
val person = Person("이요한", 27).run(personRepository::save)
val person = Person("이요한", 27).run { //인스턴스화 이후중간처리 가능.
    enable = true 
    personRepository.save(this)
}
```

#### apply
객체 설정을 할때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
```kotlin
fun main() {
    //Person(name=이요한, age=27, hobby=축구)
    println(createPerson("이요한", 27, "축구").toString()) 
}

data class Person(
    val name: String,
    val age: Int,
    var hobby: String?
) {
    constructor(name: String, age: Int) : this(name, age, null)
}

fun createPerson(
    name : String,
    age : Int,
    hobby : String) : Person {
    return Person(name, age)
        .apply { this.hobby = hobby } //생성자에 없는 hobby 추가바인딩 가능.
}
```
#### also
메소드 콜체인에서 중간에 로직이 끼워넣을때 사용.
```kotlin
fun main() {
    mutableListOf("one", "two", "three")
        .also { println("새로운 값 추가 $it") }
        .add("four")
    
    val numbers = mutableListOf("one", "two", "three")
    println("새로운 값 추가 $numbers")
    numbers.add("four")
}
```

#### with
특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해 정적 팩토리 혹은  
toClass 함수를 만들기 어려울때. this를 생략할 수 있어 코드가 간결해 진다.
```kotlin
return with(person) {
    PersonDto(
        name = name,
        age = age
    )
}
```