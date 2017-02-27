package com.naver.test.orm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.test.orm.entity.User;

@Repository
public interface UserMapper {
	List<User> getUserList();

	User getUserListById(String id);
}
