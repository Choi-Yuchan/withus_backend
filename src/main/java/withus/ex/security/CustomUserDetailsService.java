package withus.ex.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.CustomUserDetailsVO;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override   //userId로 로그인, 권한조회
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("인증을 받습니다");
		
		//로그인 로직 시작
		 // loginId를 이용하여 DB에서 User 객체를 가져옵니다.
        		
		log.warn("Load User by UserVo.number:" + username);
		
		//userID를 기반으로 DB에 검색함
		UsersVO user = userMapper.getUser(username);
		
		log.warn("queried by UserVo Maooer:" + user);
		//null값이 아니면 CusonUserDetailsVO에 그 값을 등록함
		return user == null ? null : new CustomUserDetailsVO(user);

	}
}
