package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("일시 중단 전에는 CoroutineDispatcher를 거치지 않고 즉시 메인스레드에서 실행됩니다.")
        delay(100) //메인스레드를 반납.
        println("일시 중단 후에는 CoroutineDispatcher를 거쳐 실행됩니다.") //runBlocking블록이 실행된 후 실행.
    }
    println("runBlocking 블록")
}