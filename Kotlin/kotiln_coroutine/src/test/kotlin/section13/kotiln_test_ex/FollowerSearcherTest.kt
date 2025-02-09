package section13.kotiln_test_ex

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import section13.test_double.StubOfficialAccountRepository
import section13.test_double.StubPersonAccountRepository

class FollowerSearcherTest {
    private lateinit var followerSearcher: FollowerSearcher

    @BeforeEach
    fun setUp() {
        followerSearcher = FollowerSearcher(
            officialAccountRepository = stubOfficialAccountRepository,
            personAccountRepository = stubPersonAccountRepository
        )
    }

    @Test
    fun `공식 계정과 개인 계정이 합쳐져 반환되는지 테스트`() = runTest {
        //given
        val searchName = "A"
        val expectedResults = listOf(companyA, personA)
        //내부에 일시중단함수가 있어도 일시중단한 시간만큼 흐르지 않는다.
        val results = followerSearcher.searchByName(searchName)

        assertEquals(expectedResults, results)
    }

    @Test
    fun `빈 배열이 반환되는지 테스트`() = runTest {
        //given
        val searchName = "Empty"
        val expectedResults = emptyList<Follower>()
        val results = followerSearcher.searchByName(searchName)

        assertEquals(expectedResults, results)
    }


    companion object {
        private val companyA = Follower.OfficialAccount(id = "0x0000", name = "CompanyA")
        private val companyB = Follower.OfficialAccount(id = "0x0001", name = "CompanyB")
        private val companyC = Follower.OfficialAccount(id = "0x0002", name = "CompanyC")

        private val stubOfficialAccountRepository = StubOfficialAccountRepository(
            users = listOf(companyA, companyB, companyC)
        )

        private val personA = Follower.PersonAccount(id = "0x1000", name = "PersonA")
        private val personB = Follower.PersonAccount(id = "0x1001", name = "PersonB")
        private val personC = Follower.PersonAccount(id = "0x1002", name = "PersonC")


        private val stubPersonAccountRepository = StubPersonAccountRepository(
            users = listOf(personA, personB, personC)
        )
    }
}