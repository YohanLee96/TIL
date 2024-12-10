package section8

import kotlinx.coroutines.*

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/
fun main() = runBlocking<Unit> {
    val newScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)
    newScope.launch(context = CoroutineName("LaunchCoroutine")) {
        println("newScope의 coroutineContext: ${newScope.coroutineContext}")
        println("launch의 coroutineContext: ${this.coroutineContext}")
        println("launch의 parent: ${this.coroutineContext[Job]!!.parent}")
        println("newScope의 children: ${newScope.coroutineContext[Job]!!.children.first()}")
    }
    Thread.sleep(1000L)

}
