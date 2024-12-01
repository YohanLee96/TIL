package section6

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val result1: String = withContext(Dispatchers.IO) {
        delay(1000L) // 네트워크 요청
        "결과값1" // 결과값 반환
    }
    val result2: String = withContext(Dispatchers.IO) {
        delay(1000L) // 네트워크 요청
        "결과값2" // 결과값 반환
    }

    val results = listOf(result1, result2)
    println("[${getElapsedTime(startTime)}] [${Thread.currentThread().name}] ${results.joinToString(", ")}") // 결과값 출력
}

//fun main() = runBlocking<Unit> {
//    val startTime = System.currentTimeMillis()
//    val networkDeferred1: Deferred<String> = async(Dispatchers.IO) {
//        delay(1000L) // 네트워크 요청
//        "결과값1" // 결과값 반환
//    }
//    val networkDeferred2: Deferred<String> = async(Dispatchers.IO) {
//        delay(1000L) // 네트워크 요청
//        "결과값2" // 결과값 반환
//    }
//
//    val results: List<String> = awaitAll(networkDeferred1, networkDeferred2)
//    println("[${getElapsedTime(startTime)}] [${Thread.currentThread().name}] ${results.joinToString(", ")}") // 결과값 출력
//}

private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
