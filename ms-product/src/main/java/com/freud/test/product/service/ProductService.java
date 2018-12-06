package com.freud.test.product.service;

import java.util.List;
import java.util.Map;

import com.freud.test.product.bean.Product;

public interface ProductService {

	List<Product> getProducts(List<Integer> ids);

	void updateStorage(Map<Integer, Integer> order);
}
