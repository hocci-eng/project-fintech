package zerobase.projectfintech.dto;

import lombok.*;
import zerobase.projectfintech.type.ErrorCode;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private ErrorCode errorCode;
    private String errorMessage;
}
