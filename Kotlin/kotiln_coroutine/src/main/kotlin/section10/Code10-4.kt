package section10

import kotlinx.coroutines.*

/**
 * 자식 코루틴의 에러전파를 supervisorScope를 통해 방지하는법.
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword2("coroutine")
    println("[결과] ${results.toList()}")
    //모두 별도의 코루틴으로 실행되므로 약 1초 소요.
    println(getElapsedTime(startTime))
}

suspend fun searchByKeyword2(keyword: String): Array<String> =
    supervisorScope { //supervisorScope로 생성하게되면 특정 자식 코루틴이 에러가 발생해도 전파되지 않는다..
        val dbResultsDeferred: Deferred<Array<String>> = async {
            throw Exception("DB 에러 발생")
            searchFromDB2(keyword)
        }
        val apiResultsDeferred: Deferred<Array<String>> = async {
            searchFromAPI2(keyword)
        }
        val dbResults = try {
            //await을 통해 DB결과값을 처리할 때, Deferred내부의 예외가 전파되므로 try-catch로 감싸줘야한다.
            dbResultsDeferred.await()
        } catch (e: Exception) {
            arrayOf()
        }
        val apiResults = try {
            apiResultsDeferred.await()
        } catch (e: Exception) {
            arrayOf()
        }
        return@supervisorScope arrayOf(*dbResults, *apiResults)
    }

suspend fun searchFromAPI2(keyword: String): Array<String> {
    delay(1000)
    return arrayOf("[API]${keyword}1", "[API]${keyword}2")
}

suspend fun searchFromDB2(keyword: String): Array<String> {
    delay(1000)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}
