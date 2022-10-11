package com.lannstark.lec08

/**
 * Created by Yohan lee
 * Created on 2022/10/11.
 **/

fun main() {
//    repeat("abc", useNewLine = false);
//    printNameAndGender(name = "FEMALE", gender = "최태현")

    printAll("A", "B", "C")
    val array = arrayOf("A", "B", "C")
    printAll(*array)
}

fun max(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun max2(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else { b }

fun max3(a: Int, b: Int) = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for(i in 1..num) {
        if(useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}