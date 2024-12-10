package section8

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val newRootJob = Job()
    launch(CoroutineName("Coroutine1") + newRootJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    launch(CoroutineName("Coroutine2") + newRootJob) {
        //여기서는 newRootJob에서 벗어나 새로운 Job을 생성 > 기존 newRootJob과의 구조화가 깨짐.
        launch(CoroutineName("Coroutine5") + Job()) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(50L) // 모든 코루틴이 생성될 때까지 대기
    newRootJob.cancel() // 새로운 루트 Job 취소
    delay(1000L)
}
