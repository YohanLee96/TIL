package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 무제한 디스패처를 사용하는 예제.
 */
fun main() = runBlocking<Unit> {
    println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}")
    launch(Dispatchers.Unconfined) { //몇번을 실행하든 같은 스레드에서 실행됨.
        println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}")
    }
}