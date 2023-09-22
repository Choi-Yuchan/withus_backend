package withus.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.LetterVO;

@SpringBootTest
class LetterMapperTest {
	
	@Autowired
    private LetterMapper letterMapper;

    @Test
    public void SelectLeList() {
    	int wid = 1;
    	LetterVO letter = letterMapper.selectLeInfo(wid);
    	System.out.println("===");
    	System.out.println(letter);
    	System.out.println("===");
    }
    
    @Test
    public void testSelectLeList() {
    	System.out.println("Letter Mapper" + letterMapper);
    	System.out.println("Letter List" + letterMapper.selectLeList().size());
    	
    	//반복문으로 리스트 불러오기
    	for(LetterVO vo : letterMapper.selectLeList()) {
    		System.out.println("Letter: " + vo);
    	}
    }
}
