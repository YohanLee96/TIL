package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

/**
 * Mutex객체를 사용하여 경쟁 상태를 해결하는 예제
 */
var count_3 = 0
val mutex = Mutex()
fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
//                mutex.lock()
//                count_3++
//                mutex.unlock()
                mutex.withLock { //이렇게 사용하면 unLock() 호출을 깜빡하는것을 방지할 수있다.
                    count_3++
                }
            }
        }
    }
    //경쟁상태를 해결하므로서 10,000이 출력된다.
    println("Count: $count_3")
}