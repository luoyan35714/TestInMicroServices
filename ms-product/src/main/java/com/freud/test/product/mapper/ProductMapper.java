package com.freud.test.product.mapper;

import java.util.List;

import com.freud.test.product.bean.Product;

public interface ProductMapper {

	List<Product> getAllProductByIds(List<String> productIds);

	void update(Product product);
	
}
