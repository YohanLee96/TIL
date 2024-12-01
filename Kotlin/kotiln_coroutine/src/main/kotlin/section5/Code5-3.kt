package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazeJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] launch 코루틴 실행")
    }
    delay(3000L)
    lazeJob.start()
}

fun getElapsedTime(startTime: Long): String {
    return "${System.currentTimeMillis() - startTime} ms"
}
