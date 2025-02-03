package section10


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * suspend 사용 예제. delayHelloWorld()에 suspend 키워드를 붙히지 않으면 에러가 발생한다.
 */
fun main() = runBlocking<Unit> {
    //suspend 함수는 코루틴이 아니므로, runBlocking코루틴만을 이용하여 실행된다. 고로 아래 로직은 순차적으로 실행된다.
    delayHelloWorld()
    delayHelloWorld()
}

suspend fun delayHelloWorld() {
    delay(1000) //일시중단 함수
    println("Hello, World!")
}