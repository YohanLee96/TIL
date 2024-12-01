package section4.code1

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/


val singleThreadDispatcher: CoroutineDispatcher = newSingleThreadContext("SingleThread")

fun main() = runBlocking<Unit> {
    launch(singleThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }

}
