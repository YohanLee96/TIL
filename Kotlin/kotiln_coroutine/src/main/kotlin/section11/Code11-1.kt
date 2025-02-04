package section11

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴의 스레드 양보를 확인
 */
fun main() = runBlocking<Unit> {
    val starTime = System.currentTimeMillis()
    repeat(10) { c ->
        launch {
            //동시에 10개의 코루틴이 스레드를 양보하면서 동시에 실행된다.
            delay(1000L)
            println("[${getElapsedTime(starTime)}] 코루틴 ${c} 실행완료")
        }
    }
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime} ms"