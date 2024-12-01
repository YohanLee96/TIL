package section5

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-02 <br/>
 **/

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }
    println(job) // Active
}

