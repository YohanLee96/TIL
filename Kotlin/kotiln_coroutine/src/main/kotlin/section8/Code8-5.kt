package section8

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch { // 부모 코루틴 실행
        launch { // 자식 코루틴 실행
            delay(1000L) // 1초간 대기
            println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")  //2
        }
        println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드") //1
    }
    parentJob.invokeOnCompletion { // 부모 코루틴이 완료될 시 호출되는 콜백 등록
        println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료") //3
    }

    delay(500L) // 500밀리초간 대기
    println(parentJob)
    /**
     * isCancelled >> false
     * isCompleted >> false
     */
    printJobState(parentJob) // parentJob 상태 출력
}

private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
private fun printJobState(job: Job) {
    println(
        "Job State\n" +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted} "
    )
}
