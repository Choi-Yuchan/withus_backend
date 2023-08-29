package withus.ex.mapper;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.UsersVO;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
   
    //회원가입테스트: void insert(UsersVO user); //회원가입

    @Test
    void insert() {
        UsersVO user = new UsersVO();
        user.setUserNumber(1);
        user.setUserName("user3");
        user.setUserId("user3");
        user.setPassword("user3");
        user.setPhoneNumber("1234567890");
        user.setAddr1("서울시");
        user.setAddr2("강동구");
        user.setAddr3("어딘가");
        user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
        user.setGender("M");

        userMapper.insert(user);
      //  userMapper.insertAuthorities(user); 
    }
    
    //회원정보조회테스트// List<UsersVO> selectUserInfo(Integer userNumber);
    @Test
    void selectUserInfo() {
        int userNumber = 1;

        UsersVO user = userMapper.selectUserInfo(userNumber);

    }
}