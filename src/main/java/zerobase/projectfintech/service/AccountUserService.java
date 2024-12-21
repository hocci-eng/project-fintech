package zerobase.projectfintech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.projectfintech.domain.AccountUser;
import zerobase.projectfintech.dto.AccountUserDto;
import zerobase.projectfintech.exception.AccountException;
import zerobase.projectfintech.repository.AccountUserRepository;

import static zerobase.projectfintech.type.ErrorCode.AlreadyExistsMember;

@Service
@RequiredArgsConstructor
public class AccountUserService {

    private final AccountUserRepository userRepository;

    public AccountUserDto createUser(AccountUserDto accountUserDto) {
        validateUser(accountUserDto);

        return AccountUserDto.fromEntity(
                userRepository.save(
                        AccountUser.builder()
                                .userId(accountUserDto.getUserId())
                                .userPw(accountUserDto.getUserPw())
                                .userName(accountUserDto.getUserName())
                                .build()
                ));
    }

    private void validateUser(AccountUserDto accountUserDto) {
        boolean exists = userRepository.existsByUserId(accountUserDto.getUserId());

        if (exists) {
            throw new AccountException(AlreadyExistsMember);
        }
    }
}
