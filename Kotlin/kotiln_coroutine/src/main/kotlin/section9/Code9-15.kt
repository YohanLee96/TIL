package section9

import kotlinx.coroutines.*

/**
 * 전파되지 않는 예외인 CancellationException에 대한 코드
 */
fun main() = runBlocking<Unit> {
    launch(CoroutineName("C1")) {
        launch(CoroutineName("C2")) {
            throw CancellationException()
        }
        delay(100)
        //예외가 전파되지 않으므로, 로직은 계속 전개된다.
        println("[${Thread.currentThread().name}] 코루틴 실행.")
    }
    delay(100)
    println("[${Thread.currentThread().name}] 코루틴 실행.")
}