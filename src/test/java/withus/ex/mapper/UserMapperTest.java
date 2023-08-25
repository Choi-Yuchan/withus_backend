package withus.ex.mapper;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.UsersVO;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        UsersVO user = new UsersVO();
        user.setUserNumber(1);
        user.setUserId("user3");
        user.setPassword("user3");
        user.setPhoneNumber("1234567890");
        user.setBirth(new Date(2000,10,25));
        user.setEmail("user3@example.com");
        user.setGender('M');
        user.setUserName("user3");
      //  user.setEnabled(1); // Set the enabled value
        
        userMapper.insert(user);
        // userMapper.insertAuthorities(user); // Commented for now, based on your requirement
    }
}
