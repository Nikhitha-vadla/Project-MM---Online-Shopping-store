package com.massmutual.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massmutual.demo.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

    int deleteAddressByAddressID(long id);

}
