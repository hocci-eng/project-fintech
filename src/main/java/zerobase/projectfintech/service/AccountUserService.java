package zerobase.projectfintech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zerobase.projectfintech.domain.AccountUser;
import zerobase.projectfintech.dto.AccountUserDto;
import zerobase.projectfintech.exception.AccountException;
import zerobase.projectfintech.repository.AccountUserRepository;
import zerobase.projectfintech.type.ErrorCode;

import java.time.LocalDateTime;

import static zerobase.projectfintech.type.ErrorCode.ALREADY_EXISTS_USER;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountUserService {

    private final AccountUserRepository userRepository;

    public AccountUserDto createUser(String userId, String userPw, String userName) {
        validateUser(userId);

        return AccountUserDto.fromEntity(
                userRepository.save(
                        AccountUser.builder()
                                .userId(userId)
                                .userPw(userPw)
                                .userName(userName)
                                .createdAt(LocalDateTime.now())
                                .build()
                ));
    }

    private AccountUser findAccountUser(String userId) {

        return userRepository.findByUserId(userId).orElseThrow(
                () -> new AccountException(ErrorCode.NOT_FOUND_USER)
        );
    }

    private void validateUser(String userId) {
        boolean exists = userRepository.existsByUserId(userId);

        if (exists) {
            throw new AccountException(ALREADY_EXISTS_USER);
        }
    }
}
