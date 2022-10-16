package com.lannstark.lec20

import com.lannstark.lec09.Person

/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

fun main() {
    val person = Person("이요한", 27)
    val val1 = person.let {
        it.age
    }
    val val2 = person.run {
        this.age
    }

    val val3 = person.also {
        it.age
    }

    val val4 = person.apply {
        this.age
    }

    val val5 = person.let { p ->
        p.age
    }

    val val6 = person.run {
        age
    }

    with(person) {
        println(name)
        println(this.age)
    }

    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println)

    val str = "ㅎㅇ";
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

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
}

fun printPerson(person : Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
    if(person != null) {
        println(person.name)
        println(person.age)
    }
}