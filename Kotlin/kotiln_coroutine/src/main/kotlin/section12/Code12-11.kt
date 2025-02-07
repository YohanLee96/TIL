package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//CoroutineStart.UNDISPATCHED옵션이 적용된 코루틴은 재개 시, CoroutineDispatcher에 실행요청된다.
fun main() = runBlocking<Unit> {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("[CoroutineStart.UNDISPATCHED] 시작쓰레드: ${Thread.currentThread().name}")
        delay(100)
        println("[CoroutineStart.UNDISPATCHED] 재개쓰레드: ${Thread.currentThread().name}")
    }
}