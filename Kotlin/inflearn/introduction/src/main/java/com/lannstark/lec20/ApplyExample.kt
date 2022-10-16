package com.lannstark.lec20


/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

fun main() {
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
    return Person(name, age).apply { this.hobby = hobby }
}