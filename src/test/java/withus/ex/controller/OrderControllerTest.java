package withus.ex.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testOrderPageCart() throws Exception{
        int userNumber = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/product/order/{userNumber}", userNumber)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.userNumber").value(userNumber))
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void testOrderPageGetList() throws Exception{
		int userNumber =1;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/orderList/{userNumber}", userNumber)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.userNumber").value(userNumber))
                .andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	void testMyOrder() throws Exception{
		int userNumber =1;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/myOrder/{userNumber}", userNumber)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.userNumber").value(userNumber))
                .andDo(MockMvcResultHandlers.print());
	}
	
	/*
	@Test
	void testBuy() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product/buy")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
	}
	*/
	
	@Test
	void testList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/product/list")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
	}

}
