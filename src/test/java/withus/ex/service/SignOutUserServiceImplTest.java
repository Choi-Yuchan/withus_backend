package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.CartVO;
import withus.ex.vo.UsersVO;

@SpringBootTest
class SignOutUserServiceImplTest {
	
	@Autowired
	private SignOutService signOutService;

	@Test
	void testRemove() {
		UsersVO user = new UsersVO();
		int userNumber = 1;
		signOutService.signOutUser(userNumber);
	}

}
