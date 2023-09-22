package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.mapper.LetterImgMapper;

@SpringBootTest
class LetterImgServiceImplTest {

	@Autowired
	private LetterImgService letterImgService;

	
	@Test
	void test() {
		int wid = 1;
		System.out.println("이미지 정보 : " + letterImgService.getImgList(wid));
		
	}

}
