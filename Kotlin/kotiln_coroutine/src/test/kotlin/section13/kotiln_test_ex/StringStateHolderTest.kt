package section13.kotiln_test_ex

import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * 일반 함수 내부에서 새로운 코루틴을 실행하는 객체에 대한 테스트 문제
 */
class StringStateHolderTest {

    @Test
    fun `updateStringWithDelay(ABC)가 호출되면 문자열이 ABC로 변경된다`() = runTest {
        //given
        /**
         * StringStateHolder 내부의 CoroutineScope 객체는 별도의 루트 Job객체를 가져 runTest로 실행되는
         * 코루틴과 구조화 되지않고, Dispatcher.IO를 사용해 코루틴을 실행하기 때문에 실제 시간 위에서 실행된다.
         */

        //해결방식 > StringStateHolder 생성자에 TestCoroutineDispatcher를 전달하는 방식으로 해결
        val testDispatcher = StandardTestDispatcher()
        val stringStateHolder = StringStateHolder(dispatcher = testDispatcher)

        //when
        stringStateHolder.updateStringWithDelay("ABC")
        //then
        // advanceUntilIdle() //구조화가 깨져, 무용지물.
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals("ABC", stringStateHolder.stringState)

    }
}