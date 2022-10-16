package com.lannstark.lec19

/**
 * Created by Yohan lee
 * Created on 2022/10/17.
 **/

fun main() {
    println(getNumberOrNull(3))
    println(getNumberOrNullV2(3))
    println(getNumberOrNullV3(3))
}

fun getNumberOrNull(num : Int) : Int? {
    return if(num <= 0) {
        null
    } else {
        num
    }
}

fun getNumberOrNullV2(num : Int) : Int? {
    return num.takeIf { it >=0 }
}

fun getNumberOrNullV3(num : Int) : Int? {
    return num.takeUnless { it <=0 }
}