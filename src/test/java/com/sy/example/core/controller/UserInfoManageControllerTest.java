package com.sy.example.core.controller;

import com.sy.example.core.convertor.UserDTOConvertor;
import com.sy.example.core.dto.UserDTO;
import com.sy.example.core.entity.User;
import com.sy.example.core.service.UserInfoManageService;
import com.sy.example.core.service.impl.UserInfoManageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class UserInfoManageControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserInfoManageService userInfoManageService;

    @Test
    public void should_return_success_when_call_getUserInfoTest_given_userName_and_token() throws Exception {
        User user = new User("Gold", "Lin123.", "12345678901", "editor", "I am a editor", "Img");
        when(userInfoManageService.getInfoByName("Gold")).thenReturn(UserDTOConvertor.newBuilder()
                .setUser(user).userInfoBuild("123"));
        mvc.perform(get("/user/getInfo?name=Gold&token=123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))// 数据的格式
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

}
