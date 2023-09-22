package withus.ex.mapper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

<<<<<<< HEAD
import withus.ex.vo.AuthVO;
=======
import withus.ex.service.SignOutService;
>>>>>>> c50f895c102da3e760261c7fad5e19a4ea109bbe
import withus.ex.vo.UsersVO;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    

//    @Test
//    void insert() {
//        UsersVO user = new UsersVO();
//        
//        user.setUserNumber(5);
//        user.setUserName("user5");
//        user.setUserId("user5");
//        user.setPassword(new BCryptPasswordEncoder().encode("user5"));
//        user.setPhoneNumber("1234567890");
//        user.setAddr1("서울시");
//        user.setAddr2("강동구");
//        user.setAddr3("어딘가");
//        user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
//        user.setGender("M");
//        userMapper.insert(user);
//        userMapper.insertAuth(user); 
//    }
//    
//    //회원정보조회테스트// List<UsersVO> selectUserInfo(Integer userNumber);
//    @Test
//    void selectUserInfo() {
//        int userNumber = 1;
//
//        UsersVO user = userMapper.selectUserInfo(userNumber);
//
//    }
    
    
    
    
    @Test
    void testInsert() throws ParseException {
    	UsersVO user = new UsersVO();
    	
    	int userNumber =1;
    	String userName = "홍길동";
    	String userId = "globalin123";
    	String password = "globalin123";
    	String phoneNumber = "010-1234-4567";
    	String addr1 = "서울시";
    	String addr2 = "동작구";
    	String addr3 = "여의대방로 44길 10";
    	//Date birth = 2023-09-21;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthDate = dateFormat.parse("2023-09-20");
    	String gender = "남";
    	
    	user.setUserNumber(userNumber);
    	user.setUserName(userName);
    	user.setUserId(userId);
    	user.setPassword(password);
    	user.setPhoneNumber(phoneNumber);
    	user.setAddr1(addr1);
    	user.setAddr2(addr2);
    	user.setAddr3(addr3);
    	user.setBirth(birthDate);
    	user.setGender(gender);
    	
    	int result = 0;
    	try {
			result = userMapper.insert(user);
		} catch (Exception e) {
			System.out.println("에러 발생");
		}
    	
    	System.out.println("결과 : " + result);
    }
    
    @Test
    void testInsertAuth() {
    	UsersVO user = new UsersVO();
    	AuthVO auth = new AuthVO();
    	
    	auth.setUserNumber(1);
    	auth.setAuthority("권한 부여");
    	
    	int result = 0;
    	try {
			result = userMapper.insertAuth(user);
		} catch (Exception e) {
			System.out.println("에러 발생");
		}
    	
    	System.out.println("결과 : " + result);
    	
    	
    }
    
    @Test
    void testGetUser() {
    	String userId = "globalin123";
    	UsersVO users = userMapper.getUser(userId);
    	System.out.println("===");
    	System.out.println(users);
    	System.out.println("===");
    }
    
    /*
    @Test
    void testSelectUserInfo() {
    	UsersVO user = new UsersVO();
    	int userNumber = 1;
    	UsersVO users = userMapper.selectUserInfo(userNumber);
    	System.out.println(users);
    }
    
    
    @Test
    void testUpdateUserInfo(UsersVO modifiedUser) {
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
		
		userMapper.updateUserInfo(modifiedUser);
    }
    */
 // 회원정보 삭제
    @Autowired 
    private SignOutService signOutService;
    
    @Test
    void deleteUser() {
       int userNumber = 3;
       signOutService.signOutUser(userNumber);

    }

}