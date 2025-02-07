package section12

import kotlinx.coroutines.*

/**
 * 무제한 디스패처로 실행된 코루틴을 일시중단했을 때의 예제.
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("[Dispatchers.Unconfined] 시작: ${Thread.currentThread().name}")
        delay(100)
        /**
         * kotlinx.coroutines.DefaultExecutor스레드에서 실행됨.
         * kotlinx.coroutines.DefaultExecutor? delay함수내부에서 코루틴을 재개시킬때 사용하는 스레드.
         */
        println("[Dispatchers.Unconfined] 재개: ${Thread.currentThread().name}")
    }
}

