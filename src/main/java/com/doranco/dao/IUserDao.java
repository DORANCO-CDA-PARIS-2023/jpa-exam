package com.doranco.dao;

import java.util.List;
import java.util.Set;

import com.doranco.entity.uers.User;

public interface IUserDao {
	
	User addUser(User user) throws Exception;
	User getUserById(Long id) throws Exception;
	User getUserByEmail(String email) throws Exception;
	List<User> getUsers() throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(Long id) throws Exception;
	Set<String> getEmails() throws Exception;

	
}
