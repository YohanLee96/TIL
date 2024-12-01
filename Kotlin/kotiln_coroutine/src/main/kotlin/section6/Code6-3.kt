package section6

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/


fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val p1List: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "영수")
    }
    val p2List: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("민수", "형준")
    }
//    val results = awaitAll(p1List, p2List)
    val results = listOf(p1List, p2List).awaitAll()
    //두 작업이 동시에 처리되어 빠르게 처리됨.
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")

}

private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
