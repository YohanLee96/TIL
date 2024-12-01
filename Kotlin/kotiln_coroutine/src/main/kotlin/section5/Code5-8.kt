package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("whileJob이 실행되었습니다.")
            delay(1L) // 딜레이 시점에 취소가 확인돼 취소할 수 있음.
        }
    }
    delay(100L)
    whileJob.cancel()
}

