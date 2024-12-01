package section4.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val imageProcessingDispatcher = Dispatchers.Default.limitedParallelism(2)

    repeat(100) {
        launch(imageProcessingDispatcher) {
            Thread.sleep(1000L)
            println("[${Thread.currentThread().name}] 이미지 처리 완료") //100개의 코루틴을 사용해도 스레드는 2개만 사용.
        }
    }
}
