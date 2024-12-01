package section4.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default) {
        //Dispatchers.Default의 자식 코루틴 3개
        launch {
            println("[${Thread.currentThread().name}] 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 실행")
        }
    }
}
