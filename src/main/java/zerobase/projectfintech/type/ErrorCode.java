package zerobase.projectfintech.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다."),
    ALREADY_EXISTS_USER("이미 존재하는 회원입니다."),
    NOT_FOUND_USER("회원을 찾을 수 없습니다.")
    ;


    private final String description;
}
