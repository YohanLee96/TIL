package com.lannstark.lec07

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * Created by Yohan lee
 * Created on 2022/10/10.
 **/

fun main() {
    val printer = FilePrinter();
    println(printer.readFile());
    val file = File(".")
    println(printer.readFile(file.absolutePath + "/a.txt"))
}

fun parseIntToThrow(str:String) : Int {
    try {
        return str.toInt();
    } catch (e : NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
}

fun parseIntToThrow2(str:String) : Int? {
    return try {
        str.toInt();
    } catch (e : NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.");
    }
}