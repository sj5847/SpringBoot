package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

@Mapper
//마이바티스에서 SQL구문을 등록할 매퍼는 XML 또는 인터페이스로 작성한다.
public interface UserMapper {


	 @Insert("INSERT INTO users (id, username, password, email) VALUES ((SELECT COALESCE(MAX(id), 0) + 1 FROM users), #{username}, #{password}, #{email})")
	    void insertUser(User user);

	    @Update("UPDATE users SET password = #{password}, email = #{email} WHERE id = #{id}")
	    void updateUser(User user);

	    @Delete("DELETE FROM users WHERE id = #{id}")
	    void deleteUser(User user);

	    @Select("SELECT * FROM users WHERE username = #{username}")
	    User getUser(String username);

	    @Select("SELECT * FROM users ORDER BY username DESC")
	    List<User> getUserList();
}
