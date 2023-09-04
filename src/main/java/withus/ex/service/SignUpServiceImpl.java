package withus.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired  
	private UserMapper userMapper;
	
	//암호화
	@Autowired
    private PasswordEncoder passwordEncoder;
    
    // 회원가입
    @Override
    public void signup(UsersVO user) {
        log.info("signup()..");
        // 비밀번호를 암호화하여 저장
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
        userMapper.insert(user);
        userMapper.insertAuth(user);
	
		
	}

}
