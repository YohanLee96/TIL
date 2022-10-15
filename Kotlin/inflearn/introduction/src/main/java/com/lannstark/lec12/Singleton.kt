package com.lannstark.lec12

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/
fun main() {
    println(Singleton.a)
    Singleton.a += 10
}

object Singleton {
    var a : Int = 0
}