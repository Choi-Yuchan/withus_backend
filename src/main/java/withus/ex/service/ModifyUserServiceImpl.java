package withus.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class ModifyUserServiceImpl implements ModifyUserService {
	
	@Autowired // 주입
	private UserMapper userMapper;
	
//회원정보수정	
	@Override
	public int modifyUser(UsersVO modifiedUser) {
		return userMapper.updateUserInfo(modifiedUser);
		
	}



	
}
