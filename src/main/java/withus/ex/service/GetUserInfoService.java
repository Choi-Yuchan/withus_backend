package withus.ex.service;



import withus.ex.vo.UsersVO;


public interface GetUserInfoService{

	UsersVO getUserInfoList(int userNumber); // 회원정보조회
	
}
