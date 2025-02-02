package section9

import kotlinx.coroutines.*

/**
 * [CoroutineExceptionHandler]가 예외를 부모 코루틴에게 전파하였을 때, 동작하지 않는다는 점을 설명하는 예제.
 */
fun main() = runBlocking<Unit> {
    val exHandler = CoroutineExceptionHandler { _, throwable ->
        println("[예외 발생] $throwable")
    }

    CoroutineScope(Dispatchers.IO).launch(CoroutineName("C1")) {
        launch(CoroutineName("C2") + exHandler) { //C1으로 전파되었기 때문에 ExHandler는 작동하지 않는다.
            throw Exception("C2 예외 발생.")
        }
    }

    delay(1000)
}