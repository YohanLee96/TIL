package section9

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * try-catch를 통해 예외를 처리할 경우, 발생할수 있는 사이드 이펙트
 */
fun main() = runBlocking<Unit> {
    try {
        launch(CoroutineName("C1")) {
            //try-catch가 C1 스코프내에서 감싸져야 예외가 잡힌다.
            throw Exception("C1에 예외가 발생하였습니다.")
        }
    } catch (e: Exception) {
        println(e.message)
    }
    /**
     * C1과 C2코루틴은 코루틴 특성상 독립적으로 실행되는 코루틴이기 때문에 외부 scope에서 try-catch로 예외를 잡아도 전파된다.
     * C1의 예외를 try-catch로 잡아도 예외는 전파된다.
     */
    launch(CoroutineName("C2")) {
        delay(100)
        println("C2 실행 완료")
    }
}