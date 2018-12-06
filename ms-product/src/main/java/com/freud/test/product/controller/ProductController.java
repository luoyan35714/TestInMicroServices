package com.freud.test.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freud.test.product.bean.Product;
import com.freud.test.product.model.UpdateStatus;
import com.freud.test.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/all")
	public @ResponseBody List<Product> getProduct(@RequestBody List<Integer> productIds) {
		return productService.getProducts(productIds);
	}

	@PostMapping("/order")
	public @ResponseBody UpdateStatus updateStorage(@RequestBody Map<Integer, Integer> order) {
		UpdateStatus response = new UpdateStatus();
		try {
			productService.updateStorage(order);
			response.setIssue(false);
		} catch (Exception e) {
			response.setIssue(true);
			response.setIssueDescription(e.getMessage());
		}
		return response;
	}
}
