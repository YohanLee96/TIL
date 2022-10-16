package com.lannstark.lec14

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    val dto = PersonDto(
        name = "이요한", //named arguments
        age = 23
    )
    val dto2 = PersonDto(
        name = "이요한",
        age = 25
    )
    println(dto.toString()) //PersonDto(name=이요한, age=23)
    println(dto.equals(dto2)) //false

    handleCountry(Country.AMERICA)
    handleCar(Avante())
}

fun handleCountry(country: Country) {
    when(country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

fun handleCar(car : HyundaiCar) {
    when(car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}