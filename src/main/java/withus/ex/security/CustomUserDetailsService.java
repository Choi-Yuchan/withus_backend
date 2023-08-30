package withus.ex.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    // 사용자 정보를 데이터베이스에서 조회하는 로직
		
//	    UsersVO user = userMapper.selectUserInfo(userNumber); // username을 기반으로 사용자 정보 조회
	    
//	    return user == null ? null : new CustomUserDetailsVO(user);
		return null;
	}
}

