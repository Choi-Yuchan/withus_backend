package withus.ex.mapper;

import java.sql.Date;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import withus.ex.vo.UsersVO;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        UsersVO user = new UsersVO();
        
        user.setUserNumber(5);
        user.setUserName("user5");
        user.setUserId("user5");
        user.setPassword(new BCryptPasswordEncoder().encode("user5"));
        user.setPhoneNumber("1234567890");
        user.setAddr1("서울시");
        user.setAddr2("강동구");
        user.setAddr3("어딘가");
        user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
        user.setGender("M");
        userMapper.insert(user);
        userMapper.insertAuth(user); 
    }
    
    //회원정보조회테스트// List<UsersVO> selectUserInfo(Integer userNumber);
    @Test
    void selectUserInfo() {
        int userNumber = 1;

        UsersVO user = userMapper.selectUserInfo(userNumber);

    }
}