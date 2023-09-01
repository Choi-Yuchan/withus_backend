package withus.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestUsersVO {

	@Test
	void UsersVO() {
		UsersVO user = new UsersVO();
		assertNotNull(user);
		
		
		//이 값들을 설정함
		user.setUserId("user2");
		user.setPassword("user2");
		
		//이것과 동일하면 ok하도록 설정함
		assertEquals("user2",user.getUserId());
		assertEquals("user2",user.getPassword());
		
		System.out.println(user.getUserId());
		System.out.println(user); 
	}

}
