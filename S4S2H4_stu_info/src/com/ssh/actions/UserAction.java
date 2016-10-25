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

	// 用户登录动作
	public String login() {
		if (usersService.usersLogin(user)) {
			// 将用户名保存到session中
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}

	// 用户注销功能
	@SkipValidation
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		// 用户名不能为空
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		if (user.getPassword().length() < 5) {
			this.addFieldError("passwordError", "密码长度不能少于5位");
		}
	}

	@Override
	public User getModel() {
		user = new User();
		return user;
	}

}
