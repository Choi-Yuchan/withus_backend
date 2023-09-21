package withus.ex.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.ModifyUserService;
import withus.ex.service.SignOutService;
import withus.ex.vo.AuthVO;
import withus.ex.vo.UsersVO;

@Slf4j
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
//
//	@Autowired
//	private ModifyUserService modifyUserService;

//	@Test
//	@Disabled
//	void insert() {
//		UsersVO user = new UsersVO();
//
//		user.setUserNumber(1);
//		user.setUserName("user1");
//		user.setUserId("user1");
//		user.setPassword(new BCryptPasswordEncoder().encode("user1"));
//		user.setPhoneNumber("1234567890");
//		user.setAddr1("서울시");
//		user.setAddr2("강동구");
//		user.setAddr3("어딘가");
//		user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
//		user.setGender("M");
//		List<AuthVO> authList = new ArrayList<>();
////        AuthVO auth = new AuthVO();
////        auth.setUserId("user1");
////        auth.setAuthority("ROLE_USER");
////        authList.add(auth);
////        user.setAuthList(authList);
//		userMapper.insert(user);
//		userMapper.insertAuth(user);
//	}

	// 회원정보조회테스트// List<UsersVO> selectUserInfo(Integer userNumber);
//	@Test
//	@Disabled
//	void selectUserInfo() {
////		int userNumber = 2;
////
////		UsersVO user = userMapper.selectUserInfo(userNumber);
//	}

//	@Test
//	void updateUserInfo() {
//		int userNumber = 1;
//
//		// 기존 사용자 정보 가져오기
//		UsersVO user = userMapper.selectUserInfo(userNumber);
//
//		// 사용자 정보 수정
//		user.setUserName("허정식");
//
//		// 사용자 정보 업데이트
//		modifyUserService.modifyUser(user);
//
//		System.out.println("Updated user: " + user.getUserNumber());
//	}
//	
	
	


	
	@Autowired // 회원정보 삭제
	private SignOutService signOutService;
	
	@Test
	void deleteUser() {
		int userNumber = 2;
		signOutService.signOutUser(userNumber);

	}

}