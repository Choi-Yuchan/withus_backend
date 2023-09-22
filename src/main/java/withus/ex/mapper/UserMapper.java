package withus.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;

@Mapper
public interface UserMapper {
<<<<<<< HEAD
    void insert(UsersVO user); //회원가입
    void insertAuth(UsersVO user); //회원가입시 권한부여
    
   public UsersVO getUser(String userId);  //권한있는지조회
   
    UsersVO selectUserInfo(int userNumber); //회원정보조회  
    
    int updateUserInfo(UsersVO modifiedUser); //회원정보 수정
   
    
    
    //회원가입 + 권한설정
    
//    @Insert("insert into users(userid,password,enabled) values(#{userid},#{password},#{enabled})")
//    public int insertUser(UsersVO usersVO);
//
//    @Insert("insert into withus_auth (user_id,AUTHORITY) values(#{userid},'ROLE_USER')")
//    public void insertAuthorities(UsersVO UsersVO);
=======
	void insert(UsersVO user); // 회원가입

	void insertAuth(UsersVO user); // 회원가입시 권한부여

	public UsersVO getUser(String userId); // 권한있는지조회

	UsersVO selectUserInfo(int userNumber); // 회원정보조회

	int updateUserInfo(UsersVO modifiedUser); // 회원정보 수정

	public int deleteUser(int userNumber); // 회원탈퇴
>>>>>>> c50f895c102da3e760261c7fad5e19a4ea109bbe

}
