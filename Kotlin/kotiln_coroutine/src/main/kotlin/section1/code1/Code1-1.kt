package section1.code1

/**
 * Created by Yohan Lee. Created on 2024-11-30 <br/>
 **/

fun main() {
    println("[${Thread.currentThread().name}] 시작")
    Thread.sleep(1000)
    println("[${Thread.currentThread().name}] 종료")
}
