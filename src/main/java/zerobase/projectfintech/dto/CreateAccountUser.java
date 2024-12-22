package zerobase.projectfintech.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class CreateAccountUser {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {

        @NotBlank
        private String userId;
        @NotBlank
        private String userPw;
        @NotBlank
        private String userName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private String userId;
        private String userPw;
        private String userName;

        public static Response from(AccountUserDto accountUserDto) {
            return Response.builder()
                    .userId(accountUserDto.getUserId())
                    .userPw(accountUserDto.getUserPw())
                    .userName(accountUserDto.getUserName())
                    .build();
        }
    }
}
