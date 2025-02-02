package section9

import kotlinx.coroutines.*

/**
 * 잘못된 SupervisorJob 사용 예제.
 */
fun main() = runBlocking<Unit> {
    //Parent Coroutine은 SupervisorJob가 아니므로, C3의 예외를 그대로 전파받아 취소된다.
    launch(CoroutineName("Parent Coroutine") + SupervisorJob()) {
        launch(CoroutineName("C1")) {
            launch(CoroutineName("C3")) {
                throw Exception("Error in C3")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
        launch(CoroutineName("c2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
    }
    delay(1000L)
}