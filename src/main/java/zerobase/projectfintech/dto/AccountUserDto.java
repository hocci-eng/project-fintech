package zerobase.projectfintech.dto;

import lombok.*;
import zerobase.projectfintech.domain.AccountUser;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUserDto {

    private String userId;
    private String userPw;
    private String userName;
    private LocalDateTime createdAt;

    public static AccountUserDto fromEntity(AccountUser accountUser) {
        return AccountUserDto.builder()
                .userId(accountUser.getUserId())
                .userPw(accountUser.getUserPw())
                .userName(accountUser.getUserName())
                .createdAt(accountUser.getCreatedAt())
                .build();
    }
}
