package com.lannstark.lec16

/**
 * Created by Yohan lee
 * Created on 2022/10/16.
 **/

fun main() {
    val str = "ABC"
    println(str.lastChar())
    val person = JavaPerson("이", "요한", 27)
    println(person.nextYearAge())

    val train : Train = Train()
    train.isExpensive() //Train의 isExpensive() 호출

    val srt1 : Train = Srt()
    srt1.isExpensive() //Train의 isExpensive() 호출

    val srt2 : Srt = Srt()
    srt2.isExpensive() //Srt의 isExpensive() 호출

    val num : Int = 3
    num.add(2)
    num add2 2
    num.add3(2)
}

//지역함수을 이용한 중복코드 제거전
fun createPersonBefore(fName : String, lName : String) : JavaPerson {
    if(fName.isEmpty()) {
        throw IllegalArgumentException("fName은 비어있을 수 없습니다! 현재 값 : $fName")
    }

    if(lName.isEmpty()) {
        throw IllegalArgumentException("lName 비어있을 수 없습니다! 현재 값 : $lName")
    }

    return JavaPerson(fName, lName, 1)
}

//지역함수을 이용한 중복코드 제거후
fun createPersonAfter(fName : String, lName : String) : JavaPerson {
    fun validateName(name :String, fieldName : String) {
        if(name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다. 현재 값 : $name")
        }
    }

    validateName(fName, "fName")
    validateName(lName, "lName")

    return JavaPerson(fName, lName, 1)
}



//inline 함수
inline fun Int.add3(other : Int) : Int {
    return this + other
}

//중위함수
infix fun Int.add2(other : Int) : Int {
    return this + other
}

fun Int.add(other : Int) : Int {
    return this + other
}

fun JavaPerson.nextYearAge() : Int {
    println("확장 함수")
    return this.age + 1;
}

fun String.lastChar() : Char {
    return this[this.length -1]
}

open class Train(
    val name : String = "새마을 기차",
    val price : Int = 5000
)

fun Train.isExpensive() : Boolean {
    println("Train의 확장 함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40000)

fun Srt.isExpensive() : Boolean {
    println("SRT의 확장함수")
    return this.price >= 10000
}