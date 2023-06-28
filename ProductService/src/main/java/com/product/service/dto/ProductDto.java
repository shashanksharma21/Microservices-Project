package com.product.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private String productId;
	private String productName;
	private String productDescription;
	private String productCompanyName;
	private Double productPrice;
	private Integer stockQuantity;
//	private String productCategoryId;
//	private String productRatingId;
	
}
