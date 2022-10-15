package com.lannstark.lec12

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    val person = Person.newBaby("이요한")
    Person.log()
}

class Person private constructor(
    var name : String,
    var age : Int
){
    companion object  Factory : Log {
        private const val MIN_AGE = 1
        @JvmStatic
        fun newBaby(name : String) : Person {
            return Person("이요한", MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }
}