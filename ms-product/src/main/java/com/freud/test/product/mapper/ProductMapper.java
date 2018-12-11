package com.freud.test.product.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.freud.test.product.bean.Product;

@Component
public interface ProductMapper {

	List<Product> getAllProductByIds(List<Integer> productIds);

	void update(Product product);

}
