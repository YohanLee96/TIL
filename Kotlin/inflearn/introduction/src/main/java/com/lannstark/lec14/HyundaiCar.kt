package com.lannstark.lec14

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/
sealed class HyundaiCar(
    val name : String,
    val price : Long
) {
}

class Avante : HyundaiCar("아반떼", 1000L)
class Sonata : HyundaiCar("소나타", 2000L)
class Grandeur : HyundaiCar("그랜져", 3000L)