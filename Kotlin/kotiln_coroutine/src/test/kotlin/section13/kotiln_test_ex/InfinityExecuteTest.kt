package section13.kotiln_test_ex

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

/**
 * runTest 코루틴 내부에서 새롭게 launch 함수를 호출하고 launch코루틴 내부에서 무한히 실행되는 작업이 실행되면
 * runTest코루틴은 끝나지 않고 계속해서 실행된다.
 */
class InfinityExecuteTest {

    @Test
    fun `끝나지 않아 실패하는테스트`() = runTest {
        var result = 0
        launch {
            while (true) {
                delay(1000)
                result++
            }
        }

        advanceTimeBy(1500)
        assert(result == 1)
        advanceTimeBy(1000)
        assert(result == 2)
        //테스트는 통과하였으나, runTest코루틴 내부에 launch코루틴이 끝나지 않아 테스트는 결국 실패한다.
    }

    @Test
    fun `backgroundScope을 사용하는 테스트`() = runTest {
          var result = 0
        backgroundScope.launch {
            while (true) {
                delay(1000)
                result++
            }
        }

        advanceTimeBy(1500)
        assert(result == 1)
        advanceTimeBy(1000)
        assert(result == 2)
        //모든코드가 실행되었으로, backgroundScope가 자동으로 취소시킨다.
    }
}