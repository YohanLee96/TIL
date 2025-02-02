package section9

import kotlinx.coroutines.*

/**
 * [CoroutineExceptionHandler]를 구조화된 코루틴에 적용하는 방법
 */
fun main() = runBlocking<Unit> {
    val exHandler1 = CoroutineExceptionHandler { _, throwable ->
        println("[예외 발생1] $throwable")
    }
    val exHandler2 = CoroutineExceptionHandler { _, throwable ->
        println("[예외 발생2] $throwable")
    }


    CoroutineScope(exHandler1)
        //exHandler2에서 예외를 처리하므로, exHandler1은 실행되지 않는다.
        .launch(CoroutineName("C1") + exHandler2) {
            launch(CoroutineName("C2")) {
                throw Exception("C2 예외 발생.")
            }
        }

    delay(1000)
}