package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.UsersVO;

@SpringBootTest
class ModifyUserServiceImplTest {
	
	@Autowired
	private ModifyUserService modifyUserService;

	@Test
    void testUpdateUserInfo() {
    	UsersVO users = new UsersVO();
		
		users.setUserNumber(1);
		users.setUserName("홍길동");
		users.setUserId("globalin123");
		users.setPassword("globalin123");
		users.setPhoneNumber("010-1234-4567");
		users.setAddr1("서울시");
		users.setAddr2("동작구");
		users.setAddr3("여의대방로 44길 10");
		users.setBirth(new Date(2000 - 1900, 9, 25));
		users.setGender("남");
		
//		modifyUserService.modifyUser(modifiedUser);
    }

}
