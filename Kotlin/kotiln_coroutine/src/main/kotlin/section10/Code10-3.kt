package section10

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword("coroutine")
    println("[결과] ${results.toList()}")
    //모두 별도의 코루틴으로 실행되므로 약 1초 소요.
    println(getElapsedTime(startTime))
}

suspend fun searchByKeyword(keyword: String): Array<String> =
    coroutineScope { //별도의 CoroutineScope를 생성.
        val dbResults = async {
            searchFromDB(keyword)
        }
        val apiResults = async {
            searchFromAPI(keyword)
        }
        return@coroutineScope arrayOf(*dbResults.await(), *apiResults.await())
    }

suspend fun searchFromAPI(keyword: String): Array<String> {
    delay(1000)
    return arrayOf("[API]${keyword}1", "[API]${keyword}2")
}

suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}
