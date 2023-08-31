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
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		log.warn("Load User by UserVo.number:" + userId);

		UsersVO user = userMapper.getUser(userId);

		log.warn("queried by UserVo Maooer:" + user);

		return user == null ? null : new CustomUserDetailsVO(user);

	}
}
