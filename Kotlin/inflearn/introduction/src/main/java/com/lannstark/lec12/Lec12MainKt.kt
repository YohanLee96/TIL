package com.lannstark.lec12

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main () {
    moveSomething(object  : Movable{ //object 키워드를 통해 인터페이스를 직접 구현.
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }

    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}