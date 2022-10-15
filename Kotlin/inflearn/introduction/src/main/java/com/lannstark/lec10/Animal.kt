package com.lannstark.lec10

/**
 * Created by Yohan lee
 * Created on 2022/10/15.
 **/
abstract class Animal(
    protected val species : String,
    protected open val legCount : Int
){

    abstract fun move()
}