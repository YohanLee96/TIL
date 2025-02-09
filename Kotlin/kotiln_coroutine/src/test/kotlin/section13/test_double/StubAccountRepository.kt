package section13.test_double

import kotlinx.coroutines.delay
import section13.kotiln_test_ex.Follower
import section13.kotiln_test_ex.OfficialAccountRepository
import section13.kotiln_test_ex.PersonAccountRepository

class StubOfficialAccountRepository(
    private val users: List<Follower.OfficialAccount>
) : OfficialAccountRepository {
    override suspend fun searchByName(name: String): Array<Follower.OfficialAccount> {
        delay(1000L)
        return users.filter { it.name.contains(name) }.toTypedArray()
    }
}

class StubPersonAccountRepository(
    private val users: List<Follower.PersonAccount>
) : PersonAccountRepository {
    override suspend fun searchByName(name: String): Array<Follower.PersonAccount> {
        delay(1000L)
        return users.filter { it.name.contains(name) }.toTypedArray()
    }
}