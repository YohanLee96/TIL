package com.lannstark.lec04

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/
data class Money(
    val amount : Long
) {

    operator fun plus(other : Money) : Money {
        return Money(this.amount + other.amount);
    }
}
