package com.anilagcalar.sellhan.service;

import java.util.List;

import com.anilagcalar.sellhan.exception.AdminNotFoundException;
import com.anilagcalar.sellhan.model.Admin;

public interface SellhanService {

	List<Admin> findAdmins();
	List<Admin> findAdmins(String lastName);
	Admin findAdmins(Long id) throws AdminNotFoundException;
	void createAdmin(Admin admin);
	void updateAdmin(Admin admin);
	void deleteOwner(Long id);
	
}
