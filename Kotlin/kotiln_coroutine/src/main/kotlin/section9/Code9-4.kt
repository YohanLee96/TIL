package section9

import kotlinx.coroutines.*

/**
 * SupervisorJob을 사용한 코루틴 예외처리
 */
fun main() = runBlocking<Unit> {
    val supervisorJob = SupervisorJob()
    launch(CoroutineName("C1") + supervisorJob) {
        launch(CoroutineName("C3")) {
            throw Exception("Error in C3")
        }
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    //supervisorJob객체가 부모이므로, C3의 예외가 전파되도 부모코루틴이 취소되지 않으므로 정상작동한다.
    launch(CoroutineName("C2") + supervisorJob) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    delay(1000L)
}