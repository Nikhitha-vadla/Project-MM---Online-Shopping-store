package com.massmutual.demo.controller;

import java.util.List;

import com.massmutual.demo.entity.Product;
import com.massmutual.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/admin/product")
@RestController
public class ProductController
{
	@Autowired
	private ProductService service;

	//ADMIN
	@PostMapping("/save") //, produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		Product saved = null;
		//product.setCategory(category);
		saved = service.addProduct(product);
		return new ResponseEntity<Product>(saved, HttpStatus.OK);
	}

	//BOTH
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
		Product product = service.viewProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	//BOTH
	@GetMapping("/get/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = service.viewAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	//ADMIN
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("productId")Integer productId) {
		Product product= service.removeProductById(productId);
		if(product==null) {
			return new ResponseEntity("Sorry! Products are not available!",HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	//ADMIN
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(
			@RequestBody Product product){
		Product products= service.updateProduct(product);
		
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}

	//BOTH
	@GetMapping("/get/category/{cname}")
	ResponseEntity<List<Product>> getProffessorCourse(@PathVariable("cname") String cname){
		List<Product> rtnObj = service.viewProductsByCategory(cname);
		
		return new ResponseEntity<List<Product>>(rtnObj, HttpStatus.OK);
	}
	
}
