package com.lannstark.lec10

/**
 * Created by Yohan lee
 * Created on 2022/10/15.
 **/
class Penguin (
    species : String,
) : Animal(species, 2), Flyable, Swimable {

    private val wingCount : Int = 2;

    override fun move() {
        println("펭귄이 움직입니다~ 꿱꿱")
    }

    override val legCount: Int
        get() = super.legCount + wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override val swimAbility: Int
        get() = TODO("Not yet implemented")
}