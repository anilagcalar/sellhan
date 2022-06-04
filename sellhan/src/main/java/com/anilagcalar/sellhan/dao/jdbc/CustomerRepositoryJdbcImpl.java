package com.anilagcalar.sellhan.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anilagcalar.sellhan.dao.CustomerRepository;
import com.anilagcalar.sellhan.model.Customer;


@Repository
public class CustomerRepositoryJdbcImpl implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByAdminId(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByAdminId(Long adminId) {
		// TODO Auto-generated method stub

		String sql="delete from t_customer where owner id=?";
		jdbcTemplate.update(sql,adminId);
	}

}
