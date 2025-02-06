package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * CoroutineStart.ATOMIC실행옵션에 대한 예제
 */
fun main() = runBlocking<Unit> {
    val job = launch(start = CoroutineStart.ATOMIC) {
        println("작업1")
    }
    job.cancel() //생성 상태에 코루틴이라서 취소되지 않는다.
    println("작업2")
}