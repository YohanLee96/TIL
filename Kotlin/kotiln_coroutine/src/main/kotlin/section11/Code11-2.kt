package section11


import kotlinx.coroutines.*

/**
 * join에 대한 스레드 양보 예제
 */
fun main() = runBlocking<Unit> {
    val job = launch {
        println("1. launch 코루틴 작업이 시작됐습니다") //2. 양보한 메인 스레드를 사용하여 처리됨.
        delay(1000L)
        println("2. launch 코루틴 작업이 완료됐습니다") //3. 양보한 메인 스레드를 사용하여 처리됨.
    }
    println("3. runBlocking 코루틴이 곧 일시 중단 되고 메인 스레드가 양보됩니다") //1. 먼저 실행됨.
    job.join() //메인 스레드 양보
    println("4. runBlocking이 메인 스레드에 보내져 작업이 다시 재개됩니다") // 4. 마지막
}