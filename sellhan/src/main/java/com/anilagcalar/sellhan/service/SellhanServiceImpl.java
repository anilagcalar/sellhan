package com.anilagcalar.sellhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anilagcalar.sellhan.dao.AdminRepository;
import com.anilagcalar.sellhan.dao.CustomerRepository;
import com.anilagcalar.sellhan.exception.AdminNotFoundException;
import com.anilagcalar.sellhan.model.Admin;

@Service
@Transactional
public class SellhanServiceImpl implements SellhanService {
	
	private AdminRepository adminRepository;
	private CustomerRepository customerRepository;
	@Autowired
	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Admin> findAdmins() {
	
		return adminRepository.findAll();
	}

	@Override
	public List<Admin> findAdmins(String lastName) {

		return adminRepository.findByLastName(lastName);
		
		
	}

	@Override
	public Admin findAdmins(Long id) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(id);
		if(admin==null) throw new AdminNotFoundException("Admin not found with id" +id);
		return admin;
		
	}

	@Override
	public void createAdmin(Admin admin) {
	
		adminRepository.create(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		
		adminRepository.update(admin);
	}

	@Override
	public void deleteOwner(Long id) {
		
		customerRepository.deleteByAdminId(id);
		adminRepository.delete(id);
	
		//if(true) throw new RuntimeException("testing rollback");
		
		
	}
	

}
