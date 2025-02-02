package section9

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 특정 자식코루틴의 예외가 부모에게 전파되었을 때, 다른 자식코루틴에게 영향을 주는지 확인하는 예제
 */
fun main() = runBlocking { //runBlocking 코루틴 또한 C3의 예외가 전파됨.
    launch(CoroutineName("C1")) { //C3의 예외가 전파됨.
        launch(CoroutineName("C3")) {
            throw Exception("Error in C3")
        }
    }
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행")

    //C2코루틴은 부모코루틴이 취소됬으므로, 취소가 되어 실행되지 않음.
    launch(CoroutineName("C2")) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    delay(1000L)
}