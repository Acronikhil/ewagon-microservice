package com.ewagon.userservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewagon.userservice.entity.Users;
import com.ewagon.userservice.exception.UserNotFoundByEmailException;
import com.ewagon.userservice.repository.UserRepository;
import com.ewagon.userservice.to.UserTo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

//	create
	@Override
	public UserTo createUser(UserTo userTo) {

		ModelMapper modelMapper = new ModelMapper();

		Users user = modelMapper.map(userTo, Users.class);
		userRepo.save(user);
		return userTo;
	}

//	read
	@Override
	public List<Users> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public Users getUserByEmail(String email) throws UserNotFoundByEmailException {

		Users user = userRepo.findByEmail(email);
		if (user != null) {
			return user;
		}
		throw new UserNotFoundByEmailException("User not exist by this email");
	}

//	update
	@Override
	public UserTo updateUser(String email, UserTo userDetails) throws UserNotFoundByEmailException {
		System.out.println("Email here:" + email);
		Users user = userRepo.findByEmail(email);
		if (user != null) {
			ModelMapper modelMapper = new ModelMapper();
			Users usersDetail = modelMapper.map(userDetails, Users.class);
			usersDetail.setId(user.getId());
			Users updatedUser = userRepo.save(usersDetail);
			
			return modelMapper.map(updatedUser, UserTo.class);
		}
		throw new UserNotFoundByEmailException("User not exist by this email");
	}

//	delete
	@Override
	public String deleteUser(String email) throws UserNotFoundByEmailException {
		Users user = userRepo.findByEmail(email);
		if(user != null) {
			userRepo.delete(user);
			return "User Deleted Successfully";
		}
		throw new UserNotFoundByEmailException("No user Exists with this email: "+email);
	}

}
