package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import com.ssh.entities.User;

public class UsersDao extends BaseDao {

	public boolean usersLogin(User user) {
		String hql = "FROM User WHERE username=? and password=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		List list = query.list();
		if (list.size() > 0) {
			return true;
		} else {

			return false;
		}
	}

}
