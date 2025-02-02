package section9

import kotlinx.coroutines.*

/**
 * 구조화를 깨서, 자식 코루틴의 예외전파를 막았을때, 발생하는 사이드 이펙트 예제
 */
fun main() = runBlocking<Unit> {
    val parentJob = launch(CoroutineName("Parent C")) {
        //** 구조화가 깨졌으므로, 부모코루틴이 취소되어도 자식 코루틴은 취소되지 않음.
        launch(CoroutineName("C1") + Job()) {
            launch(CoroutineName("C3")) {
                delay(100L)
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("C2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(20L)
    parentJob.cancel() // 부모 코루틴 취소
    delay(1000L)
}