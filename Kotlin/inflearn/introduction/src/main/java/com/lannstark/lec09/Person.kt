package com.lannstark.lec09

import java.lang.IllegalArgumentException

/**
 * Created by Yohan lee
 * Created on 2022/10/12.
 **/

fun main() {
    val person = Person("이요한", 27);
    println(person.name)
    person.age = 23;
    println(person.age)
    val javaPerson = JavaPerson("이요한", 27);
    println(javaPerson.name)
}

class Person(name : String, var age : Int) {
    init {
        if(age <= 0) {
            throw IllegalArgumentException("나이는 $age 일 수 없습니다.")
        }
    }

    //부생성자(Secondary Constructor)
    constructor(name: String) : this(name, 23) {
        println("1번쨰 부생성자")
    }

    constructor() : this("이요한") {
        println("2번째 부생성")
    }

    var name : String = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    fun isAdult() : Boolean {
        return this.age >= 20;
    }

    val isAdult2 : Boolean
        get() = this.age >=20
}