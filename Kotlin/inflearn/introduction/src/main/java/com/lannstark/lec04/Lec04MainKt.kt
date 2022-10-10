package com.lannstark.lec04

import java.util.Arrays

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    //compareTo() 편의성
    val money1 = JavaMoney(2_000L);
    val money2 = JavaMoney(1_000L);
    val money3 = JavaMoney(2_000L);
    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 큽니다.");
    }

    //주소 비교이기 때문에 false
    println(money1 === money3);
    //값 비교이기 때문에 true
    println(money1 == money3);

    val numbers : List<Int> = listOf(1,2,3);
    println(3 in numbers);
    println(money1 + money2);
}