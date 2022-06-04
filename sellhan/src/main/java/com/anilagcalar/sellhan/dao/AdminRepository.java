package com.anilagcalar.sellhan.dao;

import java.util.List;

import com.anilagcalar.sellhan.model.Admin;

public interface AdminRepository {

	List<Admin> findAll();
	Admin findById(Long id);
	List<Admin> findByLastName(String lastName);
	void create(Admin admin);
	Admin update(Admin admin);
	void delete(Long id);
	
}
