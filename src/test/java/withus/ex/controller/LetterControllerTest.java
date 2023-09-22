package withus.ex.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
class LetterControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testLetterList() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/letter/letterList").accept(MediaType.APPLICATION_JSON))
	           .andExpect(MockMvcResultMatchers.status().isOk())
	           .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
    void testDetail() throws Exception {
        // 가상의 wid 값으로 테스트를 수행합니다. 필요에 따라 실제 값으로 변경하세요.
        int wid = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/letter/detail/{wid}", wid)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.wid").value(wid)) // JSON 응답에서 필드 wid를 검증합니다.
                .andDo(MockMvcResultHandlers.print());
    }
	
	

}
