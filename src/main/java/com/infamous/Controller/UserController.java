package com.infamous.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infamous.Dao.UserDao;
import com.infamous.Model.UserModel;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String name) {
		UserModel user = null;
		try {
			user = new UserModel(email, name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getUserid() + ")";
	}


	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id) {
		try {
			UserModel user = new UserModel(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			UserModel user = userDao.findByEmail(email);
			userId = String.valueOf(user.getUserid());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			UserModel user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}


}