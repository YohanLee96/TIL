package com.lannstark.lec15

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    // Array
    val array = arrayOf(100, 200)
    for(i in array.indices) {
        println("$i ${array[i]}")
    }

    for((i, value) in array.withIndex()) {
        println("$i $value")
    }

    array.plus(300)

    //Collection - List
    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()
    useNumbers(emptyList())

    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((i, number) in numbers.withIndex()) {
        println("$i $number")
    }

    val mutuableNumbers = mutableListOf(100, 200)
    mutuableNumbers.add(400)


    //Collection - Set
    val numberSet = setOf(100, 200)
    val mutuableNumberSet = mutableSetOf(100, 200)

    //Collection - Map
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"
    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for(key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

private fun useNumbers(numbers : List<Int>) {

}