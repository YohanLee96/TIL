package com.lannstark.lec20

/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

fun main() {
    mutableListOf("one", "two", "three")
        .also { println("새로운 값 추가 $it") }
        .add("four")

    val numbers = mutableListOf("one", "two", "three")
    println("새로운 값 추가 $numbers")
    numbers.add("four")
}
