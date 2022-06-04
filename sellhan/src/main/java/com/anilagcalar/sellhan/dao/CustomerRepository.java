package com.anilagcalar.sellhan.dao;

import java.util.List;

import com.anilagcalar.sellhan.model.Customer;

public interface CustomerRepository {

	Customer findById(Long id);
	List<Customer> findByAdminId(Long adminId);
	void create(Customer customer);
	Customer update(Customer customer);
	void delete(Long id);
	void deleteByAdminId(Long adminId);
	
}
