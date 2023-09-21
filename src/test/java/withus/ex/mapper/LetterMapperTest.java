package withus.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import withus.ex.vo.LetterVO;

class LetterMapperTest {
	
	@Autowired
    private LetterMapper letterMapper;

    @Test
    public void SelectLeList() {
    	
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
