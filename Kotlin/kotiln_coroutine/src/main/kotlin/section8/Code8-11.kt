package section8

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) { //runBlocking의 자식 Job
        val coroutine1Job = this.coroutineContext[Job]
        val newJob = Job(parent = coroutine1Job)
        launch(CoroutineName("Coroutine2") + newJob) { // Coroutine1의 Job이 부모 Job이 됨.
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        //명시적으로 Job을 완료시키지 않으면 부모 Job이 완료되지 않음.
//        newJob.complete()
    }
}
