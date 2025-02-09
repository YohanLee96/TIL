package section13

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatAddUseCaseTest {

    @Test
    fun `100번 더하면 100이 반환된다`() = runBlocking {
        val repeatAddUseCase = RepeatAddUseCase()
        val result = repeatAddUseCase.add(100)
        assertEquals(100, result)
    }

    @Test
    fun `delay_100번 더하면 100이 반환된다`() = runBlocking {
        val repeatAddUseCase = RepeatAddUseCase()
        /*
        안에 delay(100)으로 인해, 테스트가 10초 소요.
        repeatTime 인자의 값에 따라 테스트시간이 큰폭으로 늘어날 수 있음.
        */
        val result = repeatAddUseCase.addByDelay(100)
        assertEquals(100, result)
    }
}