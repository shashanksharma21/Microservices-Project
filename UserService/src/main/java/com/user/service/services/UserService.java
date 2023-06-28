package com.user.service.services;

import java.util.List;

import com.user.service.request.dto.UserRequestDto;



public interface UserService<T> {

	// REGISTER
	T registerUser(UserRequestDto userRequestDto);
	
	// UPDATE
	T updateUser(UserRequestDto userRequestDto, String userId);

	// DELETE
	T deleteUser(String userId);
	
	// GET ALL
	List<T> getAllUsers();
	
	// GET BY ID
	T getUserById(String userId);
}
