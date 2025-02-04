package section11

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

/**
 * 멀티스레드 환경에서 스레드를 양보하지 않으면, 실행 스레드는 바뀌지 않음.
 */
fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(2, "Thread")
    launch(dispatcher) {
        repeat(5) {
            //Thread1만 사용. ** 1만 사용하는 이유는 디스패처는 일반적으로 첫번째 가용 스레드를 우선 사용하기때문.
            println("[${Thread.currentThread().name}] 스레드를 점유한채로 1초간 대기합니다")
            Thread.sleep(1000L)
            println("[${Thread.currentThread().name}] 점유한 스레드에서 마저 실행됩니다")
        }
    }
}