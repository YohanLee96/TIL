package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(100L)
            println("[${getElapsedTime(startTime)}] 반복횟수 $repeatTime")
        }
    }
    delay(250L)
    longJob.cancel()
}

