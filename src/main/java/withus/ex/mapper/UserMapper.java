package withus.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;


@Mapper
public interface UserMapper {
    void insert(UsersVO user); //회원가입
    List<UsersVO> selectUserInfo(UsersVO user); //회원정보조회
}