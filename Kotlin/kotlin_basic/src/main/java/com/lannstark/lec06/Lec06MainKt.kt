package com.lannstark.lec06

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    printOriginForStep();
}

fun pringLong() {
    val list = listOf(1L, 2L, 3L)
    for (num in list) {
        println(list)
    }
}

fun printOriginFor() {
    for(i in 1..3) {
        println(i)
    }
}

fun printOriginForDown() {
    for (i in 3 downTo 1) {
        println(i)
    }
}

fun printOriginForStep() {
    for(i in 1..5 step 2) {
        println(i);
    }
}