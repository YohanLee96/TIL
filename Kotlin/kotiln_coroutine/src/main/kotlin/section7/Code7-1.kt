package section7

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

fun main() = runBlocking<Unit> {
    /**
     * CoroutineDispatcher > key: MyThread
     * CoroutineName > name: MyCoroutine
     */
    val coroutineContext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}] 실행.")
    }
    delay(100L)

    val coroutineContext2: CoroutineContext = coroutineContext + CoroutineName("MyCoroutine2")
    /**
     * CoroutineDispatcher > key: MyThread
     * CoroutineName > key: MyCoroutine2
     */
    launch(context = coroutineContext2) {
        println("[${Thread.currentThread().name}] 실행.")
    }
    delay(100L)
    /**
     * CoroutineDispatcher > key: MyThread4
     * CoroutineName > key: MyCoroutine4
     */
    val coroutineContext3: CoroutineContext = newSingleThreadContext("MyThread3") + CoroutineName("MyCoroutine3")
    val coroutineContext4: CoroutineContext = newSingleThreadContext("MyThread4") + CoroutineName("MyCoroutine4")
    val combinedContext3_4: CoroutineContext = coroutineContext3 + coroutineContext4
    launch(context = combinedContext3_4) {
        println("[${Thread.currentThread().name}] 실행.")
    }
    delay(100L)
    //Job 객체 생성.
    val myJob: Job = Job()
    val combinedJobContext: CoroutineContext = Dispatchers.IO + myJob
    launch(context = combinedJobContext) {
        println("[${Thread.currentThread().name}] 실행.")
    }
}
