package com.freud.test.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.freud.test.product.bean.Product;

@Service
public interface ProductService {

	List<Product> getProducts(List<Integer> ids);

	void updateStorage(Map<Integer, Integer> order);
}
