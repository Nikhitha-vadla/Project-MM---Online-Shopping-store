package com.massmutual.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massmutual.demo.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findByAddressPincode(String pincode);

	List<Order> findByCustomer(Long customerId);
	
}
