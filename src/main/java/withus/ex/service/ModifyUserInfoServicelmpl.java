package withus.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public interface ModifyUserInfoServicelmpl implements ModifyUserInfoService {
	
	@Autowired // 주입
	private UserMapper userMapper;
	

	// 회원정보수정
	@Override
	public void modifyUserInfo(UsersVO user) {

		log.info("modify()..");
		userMapper.modify(user);
	}
	
}
