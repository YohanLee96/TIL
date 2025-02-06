package section12

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Mutex객체를 사용하여 경쟁 상태를 해결하는 예제
 */
var count_4 = 0
var countChangeDispatcher = newSingleThreadContext("전용 스레드")
/**
 * 아래처럼도 사용가능.
 * var countChangeDispatcher = Dispatchers.IO.limitedParallelism(1)
 * var countChangeDispatcher = Dispatchers.Default.limitedParallelism(1)
 */
fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                launch(countChangeDispatcher) {
                    count_4++
                }
            }
        }
    }
    //싱글 스레드로 동작하므로 count_4의 값은 10000이 된다.
    println("Count: $count_4")
}