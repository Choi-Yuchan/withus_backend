package withus.ex.service;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired // 주입
	private UserMapper userMapper;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	// 회원가입
	@Override
	public void signup(UsersVO user) {

		log.info("signup()..");
		userMapper.insert(user); // 매퍼의 메서드이름은 쿼리문에 비슷하게짓고, 서비스의 함수명은 기능에가깝게지음
	}
	
	//비밀번호 암호화
	
	@Override
	public void bcrypt() {
	      UsersVO user = new UsersVO();
	      user.setUserId("user2");
	      user.setPassword(new BCryptPasswordEncoder().encode("user2"));
	      user.setEnabled(1);
	      
	      userMapper.insert(user);
	      userMapper.insertAuthorities(user);
	   }
	
	 public void registerUser(UsersVO user) {
	        String encryptedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encryptedPassword);
	        user.setEnabled(1);

	        userMapper.insertUser(user);
	        userMapper.insertAuthorities(user);
	    }



}
