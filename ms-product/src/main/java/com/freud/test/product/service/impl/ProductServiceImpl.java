package com.freud.test.product.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freud.test.product.bean.Product;
import com.freud.test.product.mapper.ProductMapper;
import com.freud.test.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> getProducts(List<Integer> ids) {
		if (CollectionUtils.isNotEmpty(ids)) {
			return productMapper.getAllProductByIds(ids);
		} else {
			return new ArrayList<>();
		}

	}

	@Override
//	@Transactional
	public void updateStorage(Map<Integer, Integer> order) {
		List<Integer> ids = new ArrayList<>();
		for (Entry<Integer, Integer> entry : order.entrySet()) {
			ids.add(entry.getKey());
		}
		if (CollectionUtils.isNotEmpty(ids)) {
			List<Product> products = productMapper.getAllProductByIds(ids);
			for (Product product : products) {
				if (product.getStorage() >= order.get(product.getId())) {
					product.setStorage(product.getStorage() - order.get(product.getId()));
					productMapper.update(product);
				} else {
					throw new RuntimeException(MessageFormat.format("Product [{0}] under stock.", product.getName()));
				}
			}
		}
	}

}
