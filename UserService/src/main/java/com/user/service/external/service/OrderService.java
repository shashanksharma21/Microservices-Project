     package com.user.service.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.user.service.entities.Order;

@FeignClient(url = "http://localhost:8083/api/v1/orders", name = "USER-SERVICE")
public interface OrderService {

	// GET ALL ORDERS BY USER ID
	@GetMapping("/get/user/{userId}")
	public ResponseEntity<List<Order>> getAllOrderByUserId(@PathVariable String userId,  @RequestHeader(value = "Authorization", required = true) String token);

}
