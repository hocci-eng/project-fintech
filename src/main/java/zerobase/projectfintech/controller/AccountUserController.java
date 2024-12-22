package zerobase.projectfintech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zerobase.projectfintech.dto.CreateAccountUser;
import zerobase.projectfintech.service.AccountUserService;

@RestController
@RequiredArgsConstructor
public class AccountUserController {

    private final AccountUserService accountUserService;

    @PostMapping("/user")
    CreateAccountUser.Response createAccountUser(
            @RequestBody CreateAccountUser.Request request) {
        return CreateAccountUser.Response.from(
                accountUserService.createUser(
                        request.getUserId(), request.getUserPw(), request.getUserName()
                )
        );
    }
}
