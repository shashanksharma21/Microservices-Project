package com.user.service.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private String orderId;
	private String productId;
	private String userId;
	private Integer orderQuantity;
	private LocalDateTime createdAt;
	private String orderStatus;
	private Product product;
}
