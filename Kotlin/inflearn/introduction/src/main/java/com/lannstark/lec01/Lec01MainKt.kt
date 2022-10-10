package com.lannstark.lec01

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/
fun main() {
    /**
     * 가변, 불변
     */
    var num1 = 10L; //가변
    num1 = 5L; //가능
    println(num1);
    val num2 = 10L; //불변
    // num2 = 5L; //불가능. 컴파일 에러.
    println(num2);
    /**
     * 변수 자료형 지정
     */
    val num3 : Long = 1_000L;
    println(num3);
    /**
     * Nullable, Not Nullable
     */
    var num4: Long = 1000L;
//  num4 = null; // null 바인딩 불가능. 컴파일 에러.
    var num5: Long? = 1000L; //"?"를 붙히면 Optional 변수로 취급.
    num5 = null;
    /**
     * 객체 인스턴스화
     */
    var person = Person("이요한");

}