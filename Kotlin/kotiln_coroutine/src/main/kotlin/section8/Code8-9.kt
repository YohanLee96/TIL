package section8

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // 루트 Job 생성
    val newScope = CoroutineScope(Dispatchers.IO) // 새로운 루트 Job 생성
    newScope.launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    newScope.launch(CoroutineName("Coroutine2")) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(200L)
}
