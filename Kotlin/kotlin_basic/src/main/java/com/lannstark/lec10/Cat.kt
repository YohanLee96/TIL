package com.lannstark.lec10

/**
 * Created by Yohan lee
 * Created on 2022/10/15.
 **/
class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}