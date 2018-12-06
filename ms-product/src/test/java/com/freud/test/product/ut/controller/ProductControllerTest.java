package com.freud.test.product.ut.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.freud.test.product.bean.Product;
import com.freud.test.product.controller.ProductController;
import com.freud.test.product.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductService productService;

	@Test
	public void testGetProduct() {

		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Shoes");
		p1.setDescription("Beautiful shoes");
		p1.setStorage(10);
		products.add(p1);

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("T-shirt");
		p2.setDescription("Cheap T-shirt");
		p2.setStorage(20);
		products.add(p2);
		Mockito.when(productService.getProducts(Mockito.any(List.class))).thenReturn(products);

		List<Integer> productIds = new ArrayList<>();
		productIds.add(new Integer(1));
		productIds.add(new Integer(2));

		List<Product> response = productController.getProduct(productIds);

		Assert.assertNotNull(response);
		Assert.assertEquals(2, response.size());
		Assert.assertEquals(new Integer(1), response.get(0).getId());
		Assert.assertEquals(new Integer(2), response.get(1).getId());
	}
}
