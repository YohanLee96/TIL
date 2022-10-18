package com.lannstark.lec17

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
        Fruit("수박", 10000)
    );

    //람다를 만드는 방법1
    val isApple : (Fruit) -> Boolean = fun(frult : Fruit) : Boolean {
        return frult.name == "사과"
    }
    //람다를 만드는 방법2
    val isApple2 : (Fruit) -> Boolean = {frult : Fruit -> frult.name == "사과"}

    //호출방식1
    isApple(fruits[0])
    //호출방식2
    isApple.invoke(fruits[0])


    filterFruits(fruits, isApple)
    //filterFruits()함수의 마지막 함수 파라미터에 바인딩됨.
    filterFruits(fruits, {frult : Fruit -> frult.name == "사과"})
    //함수에 타입이 지정되있으니, 타입추론이 가능하여 호출부에서 타입은 생략가능하다!
    filterFruits(fruits) {frult : Fruit -> frult.name == "사과"}
    //파라미터가 1개인경우, 코틀린에서 지원하는 it 키워드를 통해 좀더 간결하게 표현가능!
    filterFruits(fruits) {it.name == "사과"}

    var fruitName = "바나나"
    fruitName = "수박"
    filterFruits(fruits) {it.name == fruitName}

}

private fun filterFruits(
    fruits : List<Fruit>, filter : (Fruit) -> Boolean) : List<Fruit> {
    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if(filter(fruit)) {
            results.add(fruit)
        }
    }

    return results;
}
