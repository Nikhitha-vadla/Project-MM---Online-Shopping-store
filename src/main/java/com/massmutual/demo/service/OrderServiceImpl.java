package com.massmutual.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.massmutual.demo.entity.Order;
import com.massmutual.demo.repository.AddressRepository;
import com.massmutual.demo.repository.OrderRepository;
import com.massmutual.demo.repository.ProductRepository;
import com.massmutual.demo.repository.UserRepository;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	UserRepository customerrepo;
	
	@Autowired
	AddressRepository addressrepo;
	
//	@Override
//	public Order addOrder(Order order) {
//
//		Product p1 = productrepo.getProductById(order.getProduct().getProductId());
//		User c1 = customerrepo.getCustomerById(order.getCustomer().getCustomerID());
////		Address a1 = addressrepo.getById(order.getAddress().getAddressID());
//		if(c1==null) {
//			System.out.println("Customer is inactive");
//		}else if (p1==null) {
//			System.out.println("product is unavailable");
//		}
//		else {
//			order.setProduct(p1);
//			order.setCustomer(c1);
////			order.setAddress(a1);
//			return repository.save(order);
//		}
//		return null;
//	}


	@Override
	public Order addOrder(Order order) {
		return null;
	}

	@Override
	public Order viewOrder(Long orderID) {
		return repository.findById(orderID).get();
	}

	@Override
	public List<Order> viewAllOrders() {
		return repository.findAll();
	}

	@Override
	public Order removeOrderById(Long orderID) {
		Order exists = repository.findById(orderID).get();
		Order resultOrder=null;
		if(exists != null) {
			repository.deleteById(orderID);
			resultOrder=exists;
		}
		return resultOrder;
	}

	@Override
	public Order getOrderByLocation(String pincode) {
		
		return repository.findByAddressPincode(pincode);
	}

	@Override
	public Order updateOrder(Long orderID, Order order) {
		
		Order o1 = repository.findById(orderID).get();
		if(Objects.nonNull(order.getOrderStatus()) && !"".equalsIgnoreCase(order.getOrderStatus())) {
			o1.setOrderStatus(order.getOrderStatus());
		}
		
		return repository.save(o1);
}

	@Override
	public List<Order> viewOrderByUserId(Long customerID) {
		return repository.findByCustomer(customerID);
	}
	
}