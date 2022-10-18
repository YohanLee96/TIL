package com.lannstark.lec02

import java.lang.IllegalArgumentException

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    println(startWith(null));
    val person = Person(null);
    startsWithA1(person.name); //NPE
}

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.");
}

fun startWithA2(str: String?): Boolean? {
    return str?.startsWith("A");
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A")
        ?: false;
}

fun startWith(str: String?): Boolean {
    return str!!.startsWith("A");
}
