package zerobase.projectfintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import zerobase.projectfintech.dto.AccountUserDto;
import zerobase.projectfintech.dto.CreateAccountUser;
import zerobase.projectfintech.service.AccountUserService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountUserController.class)
class AccountUserControllerTest {

    @MockitoBean
    private AccountUserService accountUserService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void 회원가입_성공() throws Exception {
        // given
        given(accountUserService.createUser(anyString(), anyString(), anyString()))
                .willReturn(
                        AccountUserDto.builder()
                                .userId("userid")
                                .userPw("userpw")
                                .userName("유저1")
                                .build()
                );
        // when & then
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new CreateAccountUser.Request(
                                        "userid", "userpw", "유저1"
                                )
                        ))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("userid"))
                .andExpect(jsonPath("$.userPw").value("userpw"))
                .andExpect(jsonPath("$.userName").value("유저1"))
                .andDo(print());

    }
}