package com.lannstark.lec03

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    val num1: Int? = null;
    val num2: Long = num1?.toLong() ?: 0L; // Safe Call과 Elvis연산자로 null safe하게 처리 가능.
    println(num2)
    val num3 = 5;
    val num4 = 8;
    val result = num3 / num4.toDouble(); // 결과값이 double로 변환
    println(result);

    val person = Person("이요한", 23);
    val name = "이요한";
    //변수와 문자열을 간편하게 조합가능.
    println("이름 : ${person.name}, 나이 : ${person.age}");
    println("이름 : $name");

    //Text Blocks 기능 사용가능.
    val content = """
        안녕 나는 ${person.name} 이야.
        하하하하하하.
    """.trimIndent();
    println(content);

    //문자열의 문자 접근이 자바보다 간편.
    val str = "ABC";
    println(str[0]);
    println(str[1]);
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person: Person = obj as Person;
        println(person.age);
    }
}

fun printAgeNullablePerson(obj: Any?) {
    val person = obj as? Person; //Person이면 Person으로 캐스팅. 타입이 아니거나, 객체자체가 null이면 null.
    println(person?.age);
}