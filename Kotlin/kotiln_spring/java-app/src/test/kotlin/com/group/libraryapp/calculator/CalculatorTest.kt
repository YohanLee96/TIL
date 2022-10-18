package com.group.libraryapp.calculator


/**
 * Created by Yohan lee
 * Created on 2022/10/18.
 **/

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.divideExTest()
}
class CalculatorTest {


    fun addTest() {

        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //then
        if(calculator.number !=8) {
            throw IllegalStateException()
        }
    }

    fun multiplyTest() {

        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //then
        if(calculator.number !=15) {
            throw IllegalStateException()
        }
    }

    fun divideTest() {

        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //then
        if(calculator.number !=2) {
            throw IllegalStateException()
        }
    }

    fun divideExTest() {

        //given
        val calculator = Calculator(5)

        //when
        try {
            calculator.divide(0)
        }catch (e : IllegalArgumentException) {
            if(e.message != "0으로 나눌 수 없습니다.") {
                throw IllegalStateException("기대한 메시지가 아닙니다.")
            }
            return
        } catch (e : Exception) {
            throw IllegalStateException();
        }

        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.");


        //then
    }
}