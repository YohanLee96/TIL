package section9

import kotlinx.coroutines.*

/**
 * supervisorScope를 사용한 코루틴 예외처리.
 */
fun main() = runBlocking<Unit> {
    supervisorScope {
        launch(CoroutineName("C1")) {
            launch(CoroutineName("C3")) {
                throw Exception("Error in C3")
            }
            delay(100)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
        launch(CoroutineName("C2")) { // C2 코루틴은 C3 코루틴이 예외가 발생되도 supervisorScope이 부모이기때문에 정상적으로 실행된다.
            delay(100)
            println("[${Thread.currentThread().name}] 코루틴 실행.")
        }
    }
    //supervisorScope를 통해 생성된 코루틴은 명시적으로 complete()함수를 실행하지 않아도, 모든 자식코루틴이 완료되면 자동으로 완료된다.
}