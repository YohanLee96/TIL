package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * CoroutineStart.UNDISPATCHED실행옵션에 대한 예제
 */
fun main() = runBlocking<Unit> {
    val job = launch(start = CoroutineStart.UNDISPATCHED) {
        println("작업1") //CoroutineDispatcher를 통하지 않고 즉시 메인스레드에서 실행되므로, 무조건 먼저 출력된다.
    }
    println("작업2") //launch 코루틴이 메인스레드를 반납한 후에 실행된다.
}