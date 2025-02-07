package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 무제한 디스페처 테스트 예제.
 */
fun main() = runBlocking<Unit> {
    println("작업1")
    launch(Dispatchers.Unconfined) { //해당 Scope가 즉시 스레드에서 실행되기때문에 순차적으로 작업1,2,3이 출력된다.
        println("작업2")
    }
    println("작업3")
}