package section7

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Yohan Lee. Created on 2024-12-10 <br/>
 **/
//coroutineContext2[CoroutineDispatcher] 같은 경우, 아직 실험중인 API라서 @OptIn을 사용해야한다.
@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    val coroutineContext: CoroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO;
    val coroutineName = coroutineContext[CoroutineName.Key]
    println(coroutineName)

    //.key 없이 접근가능.
    val coroutineContext2: CoroutineContext = CoroutineName("MyCoroutine2") + Dispatchers.IO;
    val coroutineName2 = coroutineContext2[CoroutineName]
    println(coroutineName2)


    val coroutineContext3: CoroutineContext = CoroutineName("MyCoroutine2") + Dispatchers.IO;
    val coroutineName3 = coroutineContext2[CoroutineDispatcher]
    println(coroutineName3)

}

