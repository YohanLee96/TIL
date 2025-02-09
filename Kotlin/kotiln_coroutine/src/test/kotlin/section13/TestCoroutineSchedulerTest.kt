package section13

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestCoroutineSchedulerTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `가상 시간 조절 테스트`() {
        val testCoroutineScheduler = TestCoroutineScheduler()
        testCoroutineScheduler.advanceTimeBy(3000)
        assertEquals(3000, testCoroutineScheduler.currentTime)
        testCoroutineScheduler.advanceTimeBy(10000)
        assertEquals(13000, testCoroutineScheduler.currentTime)
        testCoroutineScheduler.advanceTimeBy(5000)
        assertEquals(18000, testCoroutineScheduler.currentTime)
    }

    @Test
    fun `가상 시간 위에서 테스트`() {
        val testCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        testCoroutineScope.launch {
            delay(10000)
            result = 1
            delay(10000)
            result = 2
        }

        //5초 미래로.
        testCoroutineScheduler.advanceTimeBy(5000)
        assertEquals(0, result)
        //5.001초 미래로.
        testCoroutineScheduler.advanceTimeBy(5001)
        assertEquals(1, result)
        //10초 미래로.
        testCoroutineScheduler.advanceTimeBy(10000)
        assertEquals(2, result)
    }

    @Test
    fun `advanceUntilIdle 테스트`() {
        /*
        val testCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        */
        //scheduler 인자를 넘기지 않으면, 기본값으로 TestCoroutineScheduler으로 설정한다.
        /**
         * val testDispatcher = StandardTestDispatcher()
         * val testCoroutineScope = CoroutineScope(context = testDispatcher)
         */
        //TestScope을 사용하면 위 선행 설정이 모두 기본값으로 셋팅되므로, 작성안해도 된다!!
        val testCoroutineScope = TestScope()

        var result = 0

        testCoroutineScope.launch {
            delay(10000)
            result = 1
            delay(10000)
            result = 2
        }

        //코루틴 완료되는 시점으로 점프.
        testCoroutineScope.advanceUntilIdle()
        assertEquals(2, result)
    }

    @Test
    fun `runTest 테스트`() = runTest {
        var result = 0
        delay(10000)
        result = 1
        delay(10000)
        result = 2

        assertEquals(2, result)

    }

    @Test
    fun `runTest 테스트내부에서 advanceUntilIdle을 사용하기`() = runTest {
        var result = 0
        launch {
            delay(1000)
            result++
        }
        println("가상시간 : ${this.currentTime}ms, result: ${result}")
        //주석하면 가상시간이 흐르지 않음.
        advanceUntilIdle()
        println("가상시간 : ${this.currentTime}ms, result: ${result}")
    }

}