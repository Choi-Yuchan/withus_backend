package withus.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.AuthVO;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired // 주입
	private UserMapper userMapper;


	// 회원가입
	@Override
	public void signup(UsersVO user) {
		log.info("signup()..");
		userMapper.insert(user); // 매퍼의 메서드이름은 쿼리문에 비슷하게짓고, 서비스의 함수명은 기능에가깝게지음
		userMapper.insertAuth(user);
		
		
		//비밀번호 암호화하는 함수 수정할것(이건테스트임)
//	     List<AuthVO> authList = new ArrayList<>();
//	        AuthVO auth = new AuthVO();
//	        auth.setUserId("user3");
//	        auth.setAuthority("ROLE_USER");
//	        authList.add(auth);
//	        user.setAuthList(authList);
//
//	        userMapper.insert(user);
//	        userMapper.insertAuth(user); 
//		
		
	}

}
