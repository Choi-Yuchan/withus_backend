package withus.ex.mapper;


import org.apache.ibatis.annotations.Mapper;

import withus.ex.vo.UsersVO;


@Mapper
public interface UserMapper {
    void insert(UsersVO user); //회원가입
}