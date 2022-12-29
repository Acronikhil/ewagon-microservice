package com.ewagon.userservice.service;

import java.util.List;

import com.ewagon.userservice.entity.Users;
import com.ewagon.userservice.exception.UserNotFoundByEmailException;
import com.ewagon.userservice.to.UserTo;

public interface UserService {

//	create
	public UserTo createUser(UserTo userTo);
//	read
	public List<Users> getAllUser();
	public Users getUserByEmail(String email) throws UserNotFoundByEmailException;
//	update
	public UserTo updateUser(String email, UserTo userDetails) throws UserNotFoundByEmailException;
//	delete
	public String deleteUser(String email) throws UserNotFoundByEmailException;
	
	
	
	

}
