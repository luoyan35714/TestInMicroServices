package com.freud.test.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.freud.test.product.bean.Product;
import com.freud.test.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getProducts(List<Integer> ids) {
		return null;
	}

	@Override
	public void updateStorage(Map<Integer, Integer> order) {
	}

}
