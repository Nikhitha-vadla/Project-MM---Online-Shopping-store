package com.massmutual.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.massmutual.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryCategoryName(String cname);
	
	@Query(value = "SELECT * FROM products ld WHERE ld.product_id=?1 AND ld.product_status = 'active'", 
			nativeQuery = true)
	Product getProductById(Integer pid);
	
}
