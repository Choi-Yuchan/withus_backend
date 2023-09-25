package withus.ex.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class KakaoPayControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testReadyToKakaoPay() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/payment/ready")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
	}
	
	/*
	@Test
	void testAfterPayRequest() throws Exception {
	    String pgToken = "pg_token";

	    mockMvc.perform(MockMvcRequestBuilders.get("/payment/success")
	            .param("pg_token", pgToken)  // pg_token을 요청 매개변수로 추가
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
	            .andDo(MockMvcResultHandlers.print());
	}
	*/

}
