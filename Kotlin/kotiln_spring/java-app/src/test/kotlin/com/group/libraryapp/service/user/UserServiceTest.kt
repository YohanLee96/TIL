package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by Yohan lee
 * Created on 2022/10/18.
 **/

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun afterEach() {
        userRepository.deleteAll()
    }


    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("이요한", null)

        // when
        userService.saveUser(request)

        // then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("이요한")
        assertThat(results[0].age).isNull()

    }

    @Test
    fun getUsersTest() {
        //given
        userRepository.saveAll(listOf(User("A", 20), User("B", null)))
        //when
        val results = userService.getUsers()

        //then
        assertThat(results).hasSize(2)
        assertThat(results) // [JavaUser, JavaUser]
            .extracting("name") //name필드만 추출. [A, B]
            .containsExactlyInAnyOrder("A", "B") // A 또는 B인지 체크

        assertThat(results)
            .extracting("age")
            .containsExactlyInAnyOrder(20, null)
    }

    @Test
    fun updateUserNameTest() {
        //given
        val savedUser = userRepository.save(User("A", null))
        val request = UserUpdateRequest(savedUser.id!!, "B")
        //when
        userService.updateUserName(request)

        //then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("B")
    }

    @Test
    fun deleteUserTest() {

        //given
        userRepository.save(User("A", null))

        //when
        userService.deleteUser("A")

        //then
        assertThat(userRepository.findAll()).isEmpty()
    }

    @Test
    @DisplayName("대출기록이 없는 유저도 응답에 포함된다.")
    fun getUserLoanHistories1() {
        //given
        userRepository.save(User("A",  null))
        //when
        val results = userService.getUserLoanHistories()
        //then
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("A")
        assertThat(results[0].books).isEmpty()
    }

    @Test
    @DisplayName("대출 기록이 많은 유저의 응답이 정상 동작한다.")
    fun getUserLoanHistories2() {
        //given
        val savedUser = userRepository.save(User("A", null))
        userLoanHistoryRepository.saveAll(listOf(
            UserLoanHistory.fixture(user = savedUser, bookName = "책1", status = UserLoanStatus.LOANED),
            UserLoanHistory.fixture(user = savedUser, bookName = "책2", status = UserLoanStatus.LOANED),
            UserLoanHistory.fixture(user = savedUser, bookName = "책3", status = UserLoanStatus.RETURNED),
        ))
        //when
        val results = userService.getUserLoanHistories()
        //then
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("A")
        assertThat(results[0].books).hasSize(3)
        assertThat(results[0].books)
            .extracting("name")
            .containsExactlyInAnyOrder("책1", "책2", "책3")
        assertThat(results[0].books)
            .extracting("isReturn")
            .containsExactlyInAnyOrder(false, false, true)
    }

}