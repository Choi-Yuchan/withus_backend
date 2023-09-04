package withus.ex.mapper;


import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;


@Mapper
public interface UserMapper {
    void insert(UsersVO user); //회원가입
    void insertAuth(UsersVO user); //회원가입시 권한부여
    UsersVO selectUserInfo(int userNumber); //회원정보조회
    
   public UsersVO getUser(String userId);  //권한있는지조회
    

        
}



