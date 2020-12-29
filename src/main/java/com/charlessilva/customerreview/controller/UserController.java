package com.charlessilva.customerreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.charlessilva.customerreview.dao.UserDao;
import com.charlessilva.customerreview.model.UserModel;


@RestController
public class UserController
{
	@Autowired
	private UserDao userDao;

	@PostMapping({ "users" })
	public UserModel createUser()
	{
		UserModel user = new UserModel();
		user.setName("user test");
		userDao.save(user);
		return user;
	}
}
