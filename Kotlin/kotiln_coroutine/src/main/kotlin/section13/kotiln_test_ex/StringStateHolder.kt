package section13.kotiln_test_ex

import kotlinx.coroutines.*

class StringStateHolder(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val coroutineScope = CoroutineScope(dispatcher)

    var stringState = ""
        private set

    fun updateStringWithDelay(string: String) {
        coroutineScope.launch {
            delay(1000)
            stringState = string
        }
    }
}