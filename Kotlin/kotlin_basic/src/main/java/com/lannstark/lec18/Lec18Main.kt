package com.lannstark.lec18

import com.lannstark.lec17.Fruit

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000),
        Fruit("바나나", 15000)
    );


    val values = fruits
        .filter {fruit -> fruit.name == "사과"}
    val notNullValues = fruits.mapNotNull { fruit -> fruit.name }
    val isAllApple = fruits.all {fruit -> fruit.name == "사과" }
    val isNoneApple = fruits.none {fruit -> fruit.name == "사과" }
    val isAnyApple = fruits.any {fruit -> fruit.name == "사과" }
    val count = fruits.count { fruit -> fruit.name == "사과" }
    val sortedFruits = fruits.sortedBy { fruit -> fruit.price }
    val sortedDescFruits = fruits.sortedByDescending { fruit -> fruit.price }
    val distinctFruitNames = fruits
        .distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    val firstFruit = fruits.first()
    val firstOrNullFruit = fruits.firstOrNull()
    val lastFruit = fruits.last()
    val lastOrNullFruit = fruits.lastOrNull()
    val map : Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    val idMap : Map<String, Fruit> = fruits.associateBy { fruit -> fruit.name }
    val nameAndPriceMap : Map<String, List<Int>> = fruits.groupBy({fruit -> fruit.name}, {fruit -> fruit.price})
    val idAndPriceMap : Map<String, Int> = fruits.associateBy({fruit -> fruit.name}, {fruit -> fruit.price})


    val fruitsInList : List<List<GoodFruit>> = listOf(
        listOf(
            GoodFruit(1L, "사과", 1000, 2000),
            GoodFruit(2L, "사과", 1000, 2000),
            GoodFruit(3L, "사과", 1000, 2000)
        ),
        listOf(
            GoodFruit(4L, "사과", 1000, 2000),
            GoodFruit(5L, "사과", 1000, 2000),
            GoodFruit(6L, "사과", 1000, 2000)
        ),
        listOf(
            GoodFruit(7L, "사과", 1000, 2000),
            GoodFruit(8L, "사과", 1000, 2000),
            GoodFruit(9L, "사과", 1000, 2000)
        )
    )


    fruitsInList.flatMap { list -> list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice } }
    fruitsInList.flatMap { list -> list.samePriceFilter }
    val convertFruits : List<GoodFruit> = fruitsInList.flatten()
}

val List<GoodFruit>.samePriceFilter : List<GoodFruit>
    get() = this.filter(GoodFruit::isSamePrice)