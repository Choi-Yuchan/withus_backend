package withus.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
class CartControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCartList() throws Exception{
		int userNumber =1;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cart/cartList/{userNumber}", userNumber)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.userNumber").value(userNumber))
                .andDo(MockMvcResultHandlers.print());
	}
	
	/*
	@Test
	public void testDelete() throws Exception{
		mockMvc.perform(delete("/cart/delete")
				.with(csrf())).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}
	*/
	
	@Test
	public void testAddToCart() throws Exception{
		
	}

}
