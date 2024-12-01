package section4.code1

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/


val multiThreadDispatcher: CoroutineDispatcher = newFixedThreadPoolContext(2, "MultiThread")

fun main() = runBlocking<Unit> {
    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }

    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }

}
