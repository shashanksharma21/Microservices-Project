package com.product.service.normal.response.dto;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {


	private String productId;
	private String productName;
	private String productDescription;
	private String productCompanyName;
	private Double productPrice;
	private AtomicInteger  stockQuantity;
//	private String productCategoryId;
//	private String productRatingId;
	
}
