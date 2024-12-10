package section8

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/
fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        delay(100)
        println("[${Thread.currentThread().name}] 코루틴 실행완료.")
    }
    Thread.sleep(1000L)
}
