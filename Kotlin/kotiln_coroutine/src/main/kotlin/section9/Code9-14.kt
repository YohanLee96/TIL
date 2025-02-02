package section9

import kotlinx.coroutines.*

/**
 * async 코루틴 빌더함수에 대한 예외 전파 이펙트 설명.
 */
fun main() = runBlocking<Unit> {
    async(CoroutineName("C1")) {
        throw Exception("C1 예외 발생")
    }
    //C1에서 예외가 발생하여 부모코루틴인 runBlocking코루틴으로 예외가 전파되면서 부모코루틴 취소로 인해 C2는 실행되지 않음.
    launch(CoroutineName("C2")) {
        delay(100)
        println("[${Thread.currentThread().name}] 코루틴 실행.")

    }
}