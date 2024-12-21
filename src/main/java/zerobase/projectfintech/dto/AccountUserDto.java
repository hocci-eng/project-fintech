package zerobase.projectfintech.dto;

import lombok.*;
import zerobase.projectfintech.domain.AccountUser;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUserDto {

    private String userId;
    private String userPw;
    private String userName;

    public static AccountUserDto fromEntity(AccountUser accountUser) {
        return AccountUserDto.builder()
                .userId(accountUser.getUserId())
                .userPw(accountUser.getUserPw())
                .userName(accountUser.getUserName())
                .build();
    }
}
