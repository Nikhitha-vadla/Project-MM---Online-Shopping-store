package com.massmutual.demo.service;

import java.util.List;

import com.massmutual.demo.entity.Product;


public interface ProductService {

	Product addProduct(Product product);

	Product viewProduct(Integer productId);

	List<Product> viewAllProducts();

	Product removeProductById(Integer productId);

	Product updateProduct(Product product);

	List<Product> viewProductsByCategory(String cname);

}
