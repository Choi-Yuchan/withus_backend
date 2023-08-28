package withus.ex.service;



import java.util.List;

import withus.ex.vo.UsersVO;


public interface GetUserInfoService{

	List<UsersVO> getUserInfoList(UsersVO usersVO); // 회원정보조회
	
	
}
