package com.abdul.useradmin.dao;

import com.abdul.useradmin.dto.User;
import com.abdul.useradmin.util.IDGenerator;

public class UserDAO {

	public int create(User user) {
		int id = IDGenerator.generateID();
		
		//save the user object to the DB
		return id;
	}
}
