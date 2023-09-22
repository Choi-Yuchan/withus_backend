package withus.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LetterImgMapperTest {
	
	@Autowired
	private LetterImgMapper letterImgMapper;

	
	@Test
	void test() {
		int wid = 1;
		System.out.println("이미지 정보 : " + letterImgMapper.selectImgList(wid));
		
	}

}
