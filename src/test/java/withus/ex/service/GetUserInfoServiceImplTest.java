package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.UsersVO;

@SpringBootTest
class GetUserInfoServiceImplTest {
	
	@Autowired
	private GetUserInfoService getUserInfoService;

	@Test
    void testGetUserInfoList() {
    	UsersVO user = new UsersVO();
    	int userNumber = 1;
    	UsersVO users = getUserInfoService.getUserInfoList(userNumber);
    	System.out.println(users);
    }

}
