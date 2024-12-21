package zerobase.projectfintech.dto;

import lombok.*;
import zerobase.projectfintech.domain.Account;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long userId;
    private String accountNumber;
    private String accountPw;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId(account.getUser().getId())
                .accountNumber(account.getAccountNumber())
                .accountPw(account.getAccountPw())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnregisteredAt())
                .build();
    }

}
