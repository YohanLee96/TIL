package com.lannstark.lec18

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/
data class GoodFruit(
    val id : Long,
    val name : String,
    val factoryPrice : Long,
    val currentPrice : Long
) {

    //출고가와 현재가가 맞는지 체크하는 함수
    val isSamePrice : Boolean
        get() = factoryPrice == currentPrice
}