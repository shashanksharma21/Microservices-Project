package com.product.service.entities;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private String productCompanyName;
	private Double productPrice;
	private AtomicInteger stockQuantity;
//	private String productCategoryId;
//	private String productRatingId;
	
}
