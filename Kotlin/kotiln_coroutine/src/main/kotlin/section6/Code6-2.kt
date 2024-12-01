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
    val p1Results = p1List.await()
    val p2List: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("민수", "형준")
    }
    val p2Results = p2List.await()
    //병렬처리를 하지 않고 순차적으로 처리되어 오래걸림.
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*p1Results, *p2Results)}")

}
private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
