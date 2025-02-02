package section9

import kotlinx.coroutines.*


/**
 * async 함수 사용 시, 예외 전파 설명.
 */
fun main() = runBlocking<Unit> {
    supervisorScope {
        val deferred: Deferred<String> = async(CoroutineName("C1")) {
            throw Exception("Error in async")
        }

        try {
            //이시점에 예외가 전파됨.
            deferred.await()
        } catch (e: Exception) {
            //전파된 예외가 Catch되어 출력됨.
            println("[노출된 예외] ${e.message}")
        }

    }
}