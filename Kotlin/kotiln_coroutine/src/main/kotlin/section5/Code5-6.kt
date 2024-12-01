package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
//        Thread.sleep(1000L) > 스레드 자체를 블록킹하기 때문에 아래 로직이 실행됨.
        delay(1000L)
        println("longJob이 실행되었습니다.")
    }
    longJob.cancelAndJoin()
    println("longJob 취소 후, 실행되어야 하는 동작")
}

