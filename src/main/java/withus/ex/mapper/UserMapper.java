package withus.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import org.apache.ibatis.annotations.Param;

import withus.ex.vo.UsersVO;


@Mapper
public interface UserMapper {
    void insert(UsersVO user); //회원가입
    UsersVO selectUserInfo(int userNumber); //회원정보조회    
    void modify(UsersVO user); //회원정보 수정
    
    
    
    //회원가입 + 권한설정
    
//    @Insert("insert into users(userid,password,enabled) values(#{userid},#{password},#{enabled})")
//    public int insertUser(UsersVO usersVO);
//
//    @Insert("insert into withus_auth (user_id,AUTHORITY) values(#{userid},'ROLE_USER')")
//    public void insertAuthorities(UsersVO UsersVO);

    
}



