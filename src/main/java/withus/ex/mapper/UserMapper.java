package withus.ex.mapper;


import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;


@Mapper
public interface UserMapper {
    void insert(UsersVO user); //회원가입
    UsersVO selectUserInfo(int userNumber); //회원정보조회
    
    
    //로그인+권한관련
    public UsersVO getUser(String userId);   
    
//    @Insert("insert into withus_users(userId,password,enabled) values(#{user_id},#{password},#{enabled})")
//    public int insertUser(UsersVO userVO);
//
//    @Insert("insert into withus_auth (userNumber,authority) values(#{user_number},'ROLE_USER')")
//    public void insertAuthorities(UsersVO UserVO);


    
    
}



