package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.mapper.LetterMapper;
import withus.ex.vo.LetterVO;

@SpringBootTest
class LetterServiceImplTest {

	@Autowired
    private LetterService letterService;

    @Test
    public void SelectLeList() {
    	int wid = 1;
    	LetterVO letter = letterService.getLeInfoList(wid);
    	System.out.println("===");
    	System.out.println(letter);
    	System.out.println("===");
    }
    
    @Test
    public void testSelectLeList() {
    	System.out.println("Letter Mapper" + letterService);
    	System.out.println("Letter List" + letterService.getLeList().size());
    	
    	//반복문으로 리스트 불러오기
    	for(LetterVO vo : letterService.getLeList()) {
    		System.out.println("Letter: " + vo);
    	}
    }

}
