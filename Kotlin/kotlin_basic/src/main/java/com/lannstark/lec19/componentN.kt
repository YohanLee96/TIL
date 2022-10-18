package com.lannstark.lec19

/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

data class Person(
    val name : String,
    val age : Int
)

class Animal(
    val name : String,
    val age : Int
) {
    //componentN()함수는 연산자속성을 갖고있기 때문에, operator 키워드를 붙혀줘야한다.
    operator fun component1() : String {
        return this.name
    }
    operator fun component2() : Int {
        return this.age
    }
}

fun main() {
    val person = Person("이요한", 27)
    val cName = person.component1()
    val cAge = person.component2()
    println("이름 : $cName 나이 : $cAge")
    val (name, age) = person //구조 분해.
    println("이름 : $name 나이 : $age") //바로 사용 가능!
    val animal = Animal("개근석", 12)
    val (aName, aAge)  = animal
    println("이름 : $aName 나이 : $aAge")
}