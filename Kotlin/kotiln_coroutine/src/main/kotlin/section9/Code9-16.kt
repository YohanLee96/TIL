package section9

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch {
        delay(1000)
    }
    job.invokeOnCompletion { ex ->
        println(ex)
    }
    job.cancel()
}