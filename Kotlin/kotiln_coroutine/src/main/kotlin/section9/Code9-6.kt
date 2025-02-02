package section9

import kotlinx.coroutines.*

/**
 * CoroutineScope를 사용하여 코루틴을 생성하고, SupervisorJob을 사용하여 자식 코루틴의 에러를 처리하는 예제
 */
fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(SupervisorJob())
    coroutineScope.apply {
        launch(CoroutineName("C1")) {
            launch(CoroutineName("C3")) {
                throw Exception("Error in C3")
            }
            delay(100)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
        launch(CoroutineName("C2")) { //C2는 취소되지 않음.
            delay(100)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
    }
    delay(1000L)
}