package com.escass.springbootbasicproject.mapper;

import com.escass.springbootbasicproject.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT 1")
    int select1();

    @Select("SELECT now()")
    Date selectNow();

    // 모든 유저를 DB에서 조회함
    @Select("SELECT * FROM basic.user")
    List<User> selectUsers();

    // 아이디를 기반으로 유저 한 명만 조회하기
    @Select("SELECT * FROM basic.user WHERE id = #{userID}")
    User selectUserById(String userId);

    // 아이디와 패스워드를 기반으로 유저 한 명을 조회하기
    @Select("SELECT * FROM user WHERE id = #{userID} AND password = #{password}")
    User selectUser(String userID, String password);

    // MyBatis는 Getter를 사용해서 객체의 변수 값을 가져가서 쓴다
    @Insert("INSERT INTO `basic`.`user` VALUES (#{id}, #{password}, #{nickName}, now())")
    void insertUser(User user);
}
