package zerobase.projectfintech.exception;

import lombok.*;
import zerobase.projectfintech.type.ErrorCode;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AccountException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String errorMessage;

    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        errorMessage = errorCode.getDescription();
    }
}
