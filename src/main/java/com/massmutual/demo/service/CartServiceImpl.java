package com.massmutual.demo.service;

import java.util.List;

import com.massmutual.demo.entity.Cart;
import com.massmutual.demo.entity.Product;
import com.massmutual.demo.entity.User;
import com.massmutual.demo.repository.CartRepository;
import com.massmutual.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserService userService;
	

	
	@Override
	public Cart addProductTocart(Integer cartId, Product product) {
		Cart cart1 =cartRepository.findById(cartId).get();
		
		Product exists=productRepository.getProductById(product.getProductId());
		if(exists==null) {
			System.out.println("Product is not available");
		}
		else {
			cart1.getProducts().add(exists);
			cartRepository.save(cart1);
			return cart1;
		}
		return null;

	}
	
	@Override
	public Cart updateProductQuantity(int cartId,int pid,int quantity) {
		Cart cart1 =cartRepository.findById(cartId).get();
		Product exists=productRepository.getProductById(pid);
		if(exists==null) {
			System.out.println("Product is not available");
		}
		else {
			cart1.getProducts().remove(exists);
			if(exists != null) {
				exists.setQuantity(quantity);
				productRepository.save(exists);
			}
			
			cart1.getProducts().add(exists);
			cartRepository.save(cart1);
			return cart1;
		}
		return null;
	}
//
//	@Override
//	public Cart saveCart(Cart cart) {
//		User customer=userService.fetchCustomerById(cart.);
//		if(customer==null) {
//			System.out.println("Customer is not active");
//		}
//		else {
//			cart.setCustomer(customer);
//			return cartRepository.save(cart);
//		}
//		return null;
//	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		return cart.getProducts();

	}

	@Override
	public Cart removeProductFromCart(Integer cartId, Integer pid) {
		Cart cart1 =cartRepository.findById(cartId).get();
		Product exists=productRepository.findById(pid).get();
		cart1.getProducts().remove(exists);
		return cart1;
	

	}

	@Override
	public Cart saveCart(Cart cart) {
		return null;
	}


	@Override
	public Cart removeAllProducts(Cart cart) {
		List<Product> cart1=cart.getProducts();
		cart.getProducts().removeAll(cart1);
		return cart;
	}

}
