package com.anilagcalar.sellhan.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anilagcalar.sellhan.dao.AdminRepository;
import com.anilagcalar.sellhan.model.Admin;

@Repository("adminRepository")
public class AdminRepositoryJdbcImpl implements AdminRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Admin> rowMapper = new RowMapper<Admin>() {
		@Override
		public Admin mapRow(ResultSet rs,int rowNum) throws SQLException{
			Admin admin=new Admin();
			admin.setId(rs.getLong("id"));
			admin.setFirstName(rs.getString("first_name"));
			admin.setLastName(rs.getString("last_name"));
			admin.setEmail(rs.getString("email"));
			
			return admin;
		}
	};
	@Override
	public List<Admin> findAll() {
	 String sql ="select id,first_name,last_name,email from t_admin";
	 return jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public Admin findById(Long id) {
		String sql="select id,first_name,last_name,email from t_admin where id=?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql,rowMapper,id));
	}

	@Override
	public List<Admin> findByLastName(String lastName) {
		String sql="select id,first_name,last_name,email from t_admin where last_name like ?";
		return jdbcTemplate.query(sql, rowMapper,"%" + lastName + "%");
	}

	@Override
	public void create(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin update(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		String sql="delete from t_admin where id=?";
		jdbcTemplate.update(sql,id);
	}

}
