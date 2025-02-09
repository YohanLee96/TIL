package section13.kotiln_test_ex

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class FollowerSearcher(
    private val officialAccountRepository: OfficialAccountRepository,
    private val personAccountRepository: PersonAccountRepository,
) {
    suspend fun searchByName(name: String): List<Follower> = coroutineScope {
        val officialAccountsDeferred = async {
            officialAccountRepository.searchByName(name)
        }
        val personAccounts = async {
            personAccountRepository.searchByName(name)
        }
        return@coroutineScope listOf(
            *officialAccountsDeferred.await(),
            *personAccounts.await()
        )
    }
}

interface OfficialAccountRepository {
    suspend fun searchByName(name: String): Array<Follower.OfficialAccount>
}

interface PersonAccountRepository {
    suspend fun searchByName(name: String): Array<Follower.PersonAccount>
}