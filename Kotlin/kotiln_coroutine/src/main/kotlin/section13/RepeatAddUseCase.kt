package section13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RepeatAddUseCase {
    suspend fun add(repeatTime: Int) = withContext(Dispatchers.Default) {
        var result = 0
        repeat(repeatTime) {
            result++;
        }
        return@withContext result
    }

    suspend fun addByDelay(repeatTime: Int) = withContext(Dispatchers.Default) {
        var result = 0
        repeat(repeatTime) {
            delay(100)
            result++;
        }
        return@withContext result
    }
}