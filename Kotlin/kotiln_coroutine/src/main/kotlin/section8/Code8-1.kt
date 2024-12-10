package section8

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] 부모 코루틴")
        launch { //부모의 CoroutineContext가 자식에게 전이됨.
            println("[${Thread.currentThread().name}] 자식 코루틴")
        }
    }
    delay(100L)
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] 부모 코루틴")
        launch(CoroutineName("ChildCoroutine")) { //전달한 CoroutineContext 덮어씌워짐.
            println("[${Thread.currentThread().name}] 자식 코루틴")
        }
    }
}
