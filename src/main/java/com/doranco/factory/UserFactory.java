package com.doranco.factory;

import com.doranco.entity.uers.User;
import com.doranco.interfaces.IUserAbstractFactory;

public final class UserFactory {

	private UserFactory() {}
	
	public static User createUser(IUserAbstractFactory<User> userAbstractFactory) {
		return userAbstractFactory.createUser();
	}
}
