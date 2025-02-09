package section13.kotiln_test_ex

class UserProfileFetcher(
    private val userNameRepository: UserNameRepository,
    private val userPhoneNumberRepository: UserPhoneNumberRepository,
) {

    fun getUserProfileById(id: String): UserProfile {
        val userName = userNameRepository.findUserNameById(id)
        val userPhoneNumber = userPhoneNumberRepository.findUserPhoneNumberById(id)
        return UserProfile(id, userName, userPhoneNumber)
    }
}

interface UserNameRepository {
    fun saveUserName(id: String, name: String)
    fun findUserNameById(id: String): String
}

interface UserPhoneNumberRepository {
    fun saveUserPhoneNumber(id: String, phoneNumber: String)
    fun findUserPhoneNumberById(id: String): String
}