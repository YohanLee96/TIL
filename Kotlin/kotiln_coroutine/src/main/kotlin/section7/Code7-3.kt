package section7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

fun main() = runBlocking<Unit> {
    val coroutineName = CoroutineName("MyCoroutine")
    val dispatcher = Dispatchers.IO
    val job = Job()
    val coroutineContext = coroutineName + dispatcher + job
    println(coroutineContext) //AS-IS
    val removedContext = coroutineContext.minusKey(CoroutineName) //기존 객체 유지. 구성요소가 제거된 새로운 객체로 반환됨.
    println(removedContext) //TO-BE
}
