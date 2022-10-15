package com.lannstark.lec11

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    val car = Car("이요한", "이요한오너", 3000)
    car.name = "이요한2"
//    println(car.owner) // 컴파일 에러
    println(car.price)
//    car.price = 2300; //컴파일 에러
}

class Car(
    internal var name : String,
    private var owner : String,
    _price : Int
){
    var price = _price
        private set
}