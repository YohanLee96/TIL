package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (this.isActive) {
            println("whileJob이 실행되었습니다.")


        }
    }
    delay(100L)
    whileJob.cancel()
}

