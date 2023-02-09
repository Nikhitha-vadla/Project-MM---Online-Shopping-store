package com.massmutual.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.massmutual.demo.entity.Address;
import com.massmutual.demo.exceptions.AddressNotFoundException;
import com.massmutual.demo.exceptions.AppException;
import com.massmutual.demo.exceptions.NoRecordFoundException;
import com.massmutual.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save") // http://localhost:8085/address
	public Address saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	
	}
	
	

	@GetMapping("/get")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Address> fetchCustomerList() throws AppException {
		try {
			return service.fetchAddressList();
		} catch (AppException e) {
			throw new AppException("Some error occurred");
		}
	}

	
	
	@GetMapping("/get/{addressID}")
	public ResponseEntity<Address> fetchAddressById(@PathVariable("addressID") Long addressID)
			throws NoRecordFoundException {

		return new ResponseEntity(service.fetchAddressById(addressID), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/delete/{addressID}")
	public int deleteAddressById(@PathVariable("addressID") Long addressID) throws AddressNotFoundException {

		return service.deleteAddressById(addressID);
	}

	
	
	/// Hi this is my Address controller
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/update/{addressID}")
	public Address updateAddress(@PathVariable("addressID") Long addressID, @RequestBody Address address)
			throws AddressNotFoundException {
		return service.updateAddress(addressID, address);
	}

}
