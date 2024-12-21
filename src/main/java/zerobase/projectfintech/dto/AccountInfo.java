package zerobase.projectfintech.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {

    private String accountNumber;
    private Long balance;
}
