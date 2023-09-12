package withus.ex.service;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.SignUpService;
import withus.ex.vo.UsersVO;

@Slf4j
@SpringBootTest
class SignUpServiceImplTest {
	
    @Autowired
    private SignUpService signUpService;

    @Test
    void testSignup() {
        assertNotNull(signUpService);

        UsersVO user = new UsersVO();
        user.setUserNumber(7);
        user.setUserName("user7");
        user.setUserId("user7");
        user.setPassword("user7"); // 원시 비밀번호 설정
        user.setPhoneNumber("1234567890");
        user.setAddr1("서울시");
        user.setAddr2("강동구");
        user.setAddr3("어딘가");
        user.setBirth(new Date(2000 - 1900, 9, 25)); // Month starts from 0
        user.setGender("M");

    //    signUpService.signup(user);

        // 사용자가 제대로 등록되었는지 확인할 수 있는 코드 추가
//        UsersVO savedUser = // 사용자를 데이터베이스에서 가져오는 방법을 구현해야 합니다. 예를 들어, userRepository.findById(savedUserId)를 사용할 수 있습니다.
//        assertNotNull(savedUser);

        // 저장된 사용자 정보와 입력한 정보를 비교하여 검증합니다.
//        assertEquals("user7", savedUser.getUserId());
//        assertEquals("user7", savedUser.getPassword());
//        assertEquals("1234567890", savedUser.getPhoneNumber());
//        assertEquals("서울시", savedUser.getAddr1());
//        assertEquals("강동구", savedUser.getAddr2());
//        assertEquals("어딘가", savedUser.getAddr3());
//        assertEquals(new Date(2000 - 1900, 9, 25), savedUser.getBirth());
//        assertEquals("M", savedUser.getGender());
    }
}
