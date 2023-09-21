package withus.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class SignOutUserServiceImpl implements SignOutService {
	
	@Autowired // 주입
	private UserMapper userMapper;

	//회원정보삭제
	@Override
	public int signOutUser(int userNumber) {
		System.out.println("Service userNumber: " + userNumber);
		return userMapper.deleteUser(userNumber);

	}

	@Override
	public void deleteUser(int userNumber) {
		// TODO Auto-generated method stub
		
	}

	
}
