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
        log.info("사용자 인증을 시도합니다");

        // 로그인 로직 시작

        // 사용자 이름을 기반으로 DB에서 사용자 정보를 가져옵니다.
        UsersVO user = userMapper.getUser(username);

        log.info("사용자 정보 조회 결과: " + user);

        // 사용자 정보가 null인 경우 예외 처리
        if (user == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        // CustomUserDetailsVO에 사용자 정보를 담아서 반환
        return new CustomUserDetailsVO(user);
	}
}
