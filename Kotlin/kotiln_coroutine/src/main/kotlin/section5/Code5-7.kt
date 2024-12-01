package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            //** 취소되지않음.
            println("whileJob이 실행되었습니다.")
        }
    }
    delay(100L)
    whileJob.cancel()
}

