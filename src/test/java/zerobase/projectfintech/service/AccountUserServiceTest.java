package zerobase.projectfintech.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zerobase.projectfintech.domain.AccountUser;
import zerobase.projectfintech.dto.AccountUserDto;
import zerobase.projectfintech.repository.AccountUserRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountUserServiceTest {

    /**
     * repository는 Mock 객체로 생성되어 실제 구현체 없이 동작을 정의한다.
     */
    @Mock
    private AccountUserRepository userRepository;

    /**
     * userService는 실제 객체로 생성되며,
     * @Mock으로 선언된 userRepository가 주입된다.
     */
    @InjectMocks
    private AccountUserService userService;

    @Test
    void 사용자_생성 () {
        // given
        AccountUserDto userToSave = new AccountUserDto(
                "userid", "userpw", "유저1");

        given(userRepository.save(any(AccountUser.class))).willReturn(
                new AccountUser(
                        1L, "userid", "userpw", "유저1",
                        LocalDateTime.now()
                )
        );

        // when
        AccountUserDto savedUser = userService.createUser(userToSave);

        // then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isEqualTo("userid");
        assertThat(savedUser.getUserPw()).isEqualTo("userpw");
        assertThat(savedUser.getUserName()).isEqualTo("유저1");
    }


}