package com.lannstark.lec05

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    println(getGrade(70));
    println(isInclude(50));
}

fun validateScoreIsNotNegative(score:Int) {
    if(score < 0) {
        throw IllegalArgumentException("$score 는 0보다 작을 수 없습니다.");
    }
}

fun getPassOrFail(score: Int) : String {
    return if(score >= 50) {
        "P";
    } else {
        "F";
    }
}

fun getGrade(score: Int) : String {
    return if(score >= 90) {
        "A";
    } else if(score >= 80) {
        "B";
    } else if(score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun isInclude(score: Int) : Boolean {
    return (score in 0.. 100);
}

fun getGradeWithSwitch(score: Int) : String {
    return when (score /10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int) : String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startWithA(obj : Any) : Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number : Int) {
    return when(number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어지는 숫자는 홀수입니다")
    }
}