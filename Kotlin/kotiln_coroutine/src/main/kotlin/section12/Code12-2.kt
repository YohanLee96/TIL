package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @Volatile를 사용하여 메모리 가시성문제 해결해보기.
 */
@Volatile
var count_2 = 0
fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count_2++
            }
        }
    }
    //허나, 여러 스레드가 동시에 count_2 값에 접근하게되면서 값이 10,000이 아닌 경우가 여전히 발생.
    println("Count: $count_2")
}