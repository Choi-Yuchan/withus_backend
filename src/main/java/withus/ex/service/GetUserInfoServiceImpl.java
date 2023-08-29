package withus.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class GetUserInfoServiceImpl implements GetUserInfoService {

	@Autowired // 주입
	private UserMapper userMapper;

	// 회원정보조회
	@Override
	public List<UsersVO> getUserInfoList(UsersVO user) {

		log.info("getUserInfoList()..");
		return userMapper.selectUserInfo(user); // 매퍼의 메서드이름은 쿼리문에 비슷하게짓고, 서비스의 함수명은 기능에가깝게지음
	}



}
