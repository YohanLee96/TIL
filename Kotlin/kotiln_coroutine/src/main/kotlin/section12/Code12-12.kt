package section12

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread
import kotlin.coroutines.resume

/**
 * suspendCancellableCoroutine을 통해 코루틴을 직접 제어하는 사용 예제.
 */
fun main() = runBlocking<Unit> {
    val result =
        suspendCancellableCoroutine<String> { continuation: CancellableContinuation<String> ->
            thread {
                Thread.sleep(1000)
                continuation.resume("실행결과") //코루틴을 직접 재개 가능.
            }
        }
    println(result)
}