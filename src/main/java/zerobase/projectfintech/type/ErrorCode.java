package zerobase.projectfintech.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다."),
    AlreadyExistsMember("이미 존재하는 회원입니다.");

    private final String description;
}
