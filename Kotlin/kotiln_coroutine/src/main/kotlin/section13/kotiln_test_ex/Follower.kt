package section13.kotiln_test_ex

sealed class Follower(
    open val id: String,
    open val name: String,
) {
    data class OfficialAccount(
        override val id: String,
        override val name: String,
    ) : Follower(id, name) {}

    data class PersonAccount(
        override val id: String,
        override val name: String,
    ) : Follower(id, name) {}
}