package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 코루틴의 동시성 이슈 예제
 */
var count_1 = 0
fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count_1++
            }
        }
    }
    // count 값이 10,000이 아닌 경우가 발생.
    println("Count: $count_1")
}