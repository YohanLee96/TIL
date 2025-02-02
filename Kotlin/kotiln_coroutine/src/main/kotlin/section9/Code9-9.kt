package section9

import kotlinx.coroutines.*

/**
 * CoroutineExceptionHandler를 사용한 예외 처리
 */
fun main() = runBlocking<Unit> {
    val exHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 발생] $throwable")
    }

    //CoroutineContext로 CoroutineExceptionHandler를 넘겨준다.
    CoroutineScope(context = exHandler).launch(CoroutineName("C1")) {
        launch(CoroutineName("C2")) {
            throw Exception("C2 예외 발생.")
        }
    }

    delay(1000)
}