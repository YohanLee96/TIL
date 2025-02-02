package section9

import kotlinx.coroutines.*

/**
 * 구조화를 깨서 자식 코루틴의 예외전파를 막는 방법
 */
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Parent C")) { //구조화가 깨져서 C3의 예외가 전파되지 않음.
        launch(CoroutineName("C1") + Job()) { //구조화를 깸. C3의 예외는 C1까지만 전파.
            launch(CoroutineName("C3")) {
                throw Exception("Error in C3")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("C2")) { //C2의 코루틴은 정상적으로 실행됨.
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(1000L)
}