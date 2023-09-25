package withus.ex.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import withus.ex.vo.UsersVO;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	/*
	@Test
    void testSignup() throws Exception {
        // 테스트용 UsersVO 객체 생성
        UsersVO usersVO = new UsersVO();
        usersVO.setUserName("userName");
        usersVO.setUserId("userId");
        usersVO.setPassword("password");
        usersVO.setPhoneNumber("phoneNumber");
        usersVO.setAddr1("addr1");
        usersVO.setAddr2("addr2");
        usersVO.setAddr3("addr3");
        usersVO.setBirth(new Date(2000 - 1900, 9, 25));
        usersVO.setGender("gender");
        
        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("SUCCESS"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void loginTest() throws Exception{
    	mockMvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.APPLICATION_JSON))
    		   .andExpect(MockMvcResultMatchers.status().isOk())
    		   .andDo(MockMvcResultHandlers.print());
    }
    */
	
	
	
	
	
	
	
	
	/*
	@Test
	public void testLogin() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.APPLICATION_JSON))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(MockMvcResultHandlers.print());
	}
	*/
	
	/*
	@Test
	public void testSignup() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/signup").accept(MediaType.APPLICATION_JSON))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(MockMvcResultHandlers.print());
	}
	*/
}
