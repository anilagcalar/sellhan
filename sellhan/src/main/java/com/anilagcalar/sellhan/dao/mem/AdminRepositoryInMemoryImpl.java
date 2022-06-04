package com.anilagcalar.sellhan.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.anilagcalar.sellhan.dao.AdminRepository;
import com.anilagcalar.sellhan.model.Admin;

@Repository
public class AdminRepositoryInMemoryImpl implements AdminRepository {
	
	private Map<Long,Admin> adminsMap= new HashMap<>();
	
	public AdminRepositoryInMemoryImpl() {
	     Admin admin1 = new Admin();
	     admin1.setId(1L);
	     admin1.setFirstName("Ebru");
	     admin1.setLastName("Boyacı");
	     admin1.setEmail("ebruboyaci@gmail.com");
	     admin1.setPassword("123456");
	     
	     Admin admin2 = new Admin();
	     admin2.setId(2L);
	     admin2.setFirstName("Anıl");
	     admin2.setLastName("Ağcalar");
	     admin2.setEmail("anilagcalar@gmail.com");
	     admin2.setPassword("12345678");
	     
	     adminsMap.put(admin1.getId(), admin1);
	     adminsMap.put(admin2.getId(), admin2);
	     
	     
	}

	@Override
	public List<Admin> findAll() {
	
		return new ArrayList<>(adminsMap.values());		
	}
	

	@Override
	public Admin findById(Long id) {
		
		return adminsMap.get(id);
	}

	@Override
	public List<Admin> findByLastName(String lastName) {
		
		return adminsMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
		
	}

	@Override
	public void create(Admin admin) {
		admin.setId(new Date().getTime());
		adminsMap.put(admin.getId(), admin);
		
	}

	@Override
	public Admin update(Admin admin) {
	 adminsMap.replace(admin.getId(), admin);
	 return admin;
	}

	@Override
	public void delete(Long id) {
	adminsMap.remove(id);
	
	}

}
