package com.lannstark.lec10

/**
 * Created by Yohan lee
 * Created on 2022/10/15.
 **/

fun main() {
    val derived = Dervied(300)
}

open class Base(
    open val number : Int = 100
) {
    init {
        println(number)
    }
}

class Dervied(
    override val number : Int
) : Base(number) {
}