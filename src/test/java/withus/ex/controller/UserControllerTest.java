package withus.ex.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import withus.ex.vo.UsersVO;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testsignup() throws Exception {
       UsersVO user = new UsersVO();   
       user.setUserNumber(6);
       user.setUserName("Test4");
       user.setUserId("Test4");
       user.setPassword("Test4");
       user.setPhoneNumber("1234567890");
       user.setAddr1("서울시");
       user.setAddr2("강동구");
       user.setAddr3("어딘가");
       user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
       user.setGender("M");
       
       String jsonStr = new ObjectMapper().writeValueAsString(user);
       
       log.info(jsonStr);
       
       mockMvc.perform(post("/user/signup")
             .contentType(MediaType.APPLICATION_JSON)
             .content(jsonStr))
          .andExpect(status().is(200))
          .andDo(MockMvcResultHandlers.print());
       
    } 
    
    @Test
    void testGetUserInfo() throws Exception {
        int userNumber = 1; // 사용자 번호를 원하는 값으로 설정
        
        mockMvc.perform(get("/user/userInfo/{userNumber}", userNumber))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }
}
