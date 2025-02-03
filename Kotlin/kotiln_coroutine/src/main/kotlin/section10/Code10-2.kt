package section10

import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 일시 중단 함수를 별도의 코루틴으로 실행하는 방법
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val job = launch {
        delayHelloWorld2()
    }
    val job2 = launch {
        delayHelloWorld2()
    }
    joinAll(job, job2)
    //각각 별도의 코루틴으로 실행됬으므로, 1초씩 걸린다.
    println(getElapsedTime(startTime))
}

fun getElapsedTime(startTime: Long): String {
    return "${System.currentTimeMillis() - startTime} ms"
}

suspend fun delayHelloWorld2() {
    delay(1000) //일시중단 함수
    println("Hello, World!")
}