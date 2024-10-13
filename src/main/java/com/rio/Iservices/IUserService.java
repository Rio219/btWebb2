package com.rio.Iservices;

import com.rio.entity.User;

import java.util.List;

public interface IUserService {
	void insert(User user);

	void update(User user);

	void delete(int userId) throws Exception;

	User findById(int userId);

	List<User> findAll();

	User findByUsername(String username);
}
