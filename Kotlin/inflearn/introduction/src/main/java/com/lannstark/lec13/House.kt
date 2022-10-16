package com.lannstark.lec13

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/
class House(
    val address: String,
    val livingRoom : LivingRoom
) {

    class LivingRoom(
        private val area : Double
    )

    inner class LivingRoom2(
        private val area : Double
    ){
        val address : String
            get() = this@House.address
    }
}