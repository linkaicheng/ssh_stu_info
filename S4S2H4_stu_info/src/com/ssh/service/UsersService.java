package com.ssh.service;

import com.ssh.dao.UsersDao;
import com.ssh.entities.User;

public class UsersService {
	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public boolean usersLogin(User user) {
		return usersDao.usersLogin(user);
		//
		////
	}

}
