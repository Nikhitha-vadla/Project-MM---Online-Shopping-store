package com.massmutual.demo.service;

import java.util.List;

import com.massmutual.demo.entity.Order;

public interface OrderService {

	Order addOrder(Order order);

	Order viewOrder(Long orderID);

	List<Order> viewAllOrders();

	Order removeOrderById(Long orderID);

	Order getOrderByLocation(String pincode);

	Order updateOrder(Long orderID, Order order);

	List<Order> viewOrderByUserId(Long customerID);


}
