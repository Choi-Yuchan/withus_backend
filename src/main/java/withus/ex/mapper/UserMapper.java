package withus.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;

@Mapper
public interface UserMapper {
	void insert(UsersVO user); // 회원가입

	void insertAuth(UsersVO user); // 회원가입시 권한부여

	public UsersVO getUser(String userId); // 권한있는지조회

	UsersVO selectUserInfo(int userNumber); // 회원정보조회

	int updateUserInfo(UsersVO modifiedUser); // 회원정보 수정

	public int deleteUser(int userNumber); // 회원탈퇴

}
