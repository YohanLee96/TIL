package com.lannstark.lec19

/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

fun main() {
    val numbers = listOf(1, 2, 3)
    for (number in numbers) {
        if(number ==2) {
            break
        }
    }

    //break
    run {
        numbers.forEach {number ->
            if(number == 2) {
                return@run
            }
        }
    }

    //continue
    numbers.forEach {number ->
        if(number == 2) {
            return@forEach
        }
    }

    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if(j ==2) {
                break@abc
            }
        }
    }
}