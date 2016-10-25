package com.ssh.actions;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entities.User;
import com.ssh.service.UsersService;

public class UserAction extends SuperAction implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UsersService usersService;

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	// �û���¼����
	public String login() {
		if (usersService.usersLogin(user)) {
			// ���û������浽session��
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}

	// �û�ע������
	@SkipValidation
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		// �û�������Ϊ��
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "�û�������Ϊ�գ�");
		}
		if (user.getPassword().length() < 5) {
			this.addFieldError("passwordError", "���볤�Ȳ�������5λ");
		}
	}

	@Override
	public User getModel() {
		user = new User();
		return user;
	}

}
