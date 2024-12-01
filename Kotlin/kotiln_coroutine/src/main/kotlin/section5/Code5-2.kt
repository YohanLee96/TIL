package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val convertImageJob1 = launch(Dispatchers.Default) {
        delay(100)
        println("[${Thread.currentThread().name}] 이미지1 변환 완료")
    }

    val convertImageJob2 = launch(Dispatchers.Default) {
        delay(100)
        println("[${Thread.currentThread().name}] 이미지2 변환 완료")
    }

    joinAll(convertImageJob1, convertImageJob2)

    val uploadImageJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지 1,2 업로드")
    }
}
