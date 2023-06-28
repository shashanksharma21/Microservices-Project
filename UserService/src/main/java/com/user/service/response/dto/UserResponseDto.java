 package com.user.service.response.dto;

import java.util.ArrayList;
import java.util.List;

import com.user.service.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

	private String id;
	private String name;
	private String email;
	private String userName;
	private String address;
	private List<Order> orders = new ArrayList<>();
}
