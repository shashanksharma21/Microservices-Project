package com.user.service.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.payloads.SharedData;
import com.user.service.repositories.UserRepository;
import com.user.service.request.dto.UserRequestDto;
import com.user.service.response.dto.UserResponseDto;
import com.user.service.services.UserService;


@Service
public class UserServiceImpl<T> implements UserService<T> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public T registerUser(UserRequestDto userRequestDto) {
		User user = this.modelMapper.map(userRequestDto, User.class);
		user.setId(UUID.randomUUID().toString());
		user.setIsVerified(false);
		user.setOtp(null);
		user.setRole("ROLE_NORMAL");
		User savedUser = this.userRepository.save(user);
		return (T) this.modelMapper.map(savedUser, UserResponseDto.class);
	}

	@Override
	public T updateUser(UserRequestDto userRequestDto, String userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", userId));
		user.setId(userId);
		user.setName(userRequestDto.getName());
		user.setUserName(userRequestDto.getUserName());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());
		user.setAddress(userRequestDto.getAddress());
		user.setIsVerified(false);
		user.setOtp(null);
		user.setRole("ROLE_NORMAL");
		
		User savedUser = this.userRepository.save(user);
		return (T) this.modelMapper.map(savedUser, UserResponseDto.class);
	}

	@Override
	public T deleteUser(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", userId));
		this.userRepository.delete(user);
		return (T) this.modelMapper.map(user, UserResponseDto.class);
	}

	@Override
	public List<T> getAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		List<UserResponseDto> allUserResponseList = allUsers.stream().map(user -> this.modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
		return (List<T>) allUserResponseList;
	}

	@Override
	public T getUserById(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user_id", userId));
		String token = SharedData.getSharedDataMap().get("jwtToken");
		UserResponseDto userResponseDto = this.modelMapper.map(user, UserResponseDto.class);		
		return (T) userResponseDto;
	}
	
}
