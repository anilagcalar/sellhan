package com.anilagcalar.sellhan.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.anilagcalar.sellhan.model.Admin;

public class SellhanRestControllerTest {

	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		restTemplate=new RestTemplate();

	}

	/*
	@Test
	 public void testDeleteAdmin() {
		restTemplate.delete("http://localhost:8080/rest/admin/1");
		try {
		restTemplate.getForEntity("http://localhost:8080/rest/admin/1",Admin.class);
		Assert.fail("should have not returned admin");
		}catch(RestClientException ex) {
			
		}
	} */
	@Test
	public void testUpdateAdmin() {
		Admin admin = restTemplate.getForObject("http://localhost:8080/rest/admin/2",Admin.class);
		MatcherAssert.assertThat(admin.getFirstName(),Matchers.equalTo("Anıl"));
		admin.setFirstName("Selhan Anıl");
		restTemplate.put("http://localhost:8080/rest/admin/2", admin);
		
		admin = restTemplate.getForObject("http://localhost:8080/rest/admin/2",Admin.class);
		MatcherAssert.assertThat(admin.getFirstName(),Matchers.equalTo("Selhan Anıl"));
	}
	@Test
	public void testCreateAdmin() {
		Admin admin = new Admin();
		admin.setFirstName("Esma");
		admin.setLastName("Boyacı");
		
		URI location=restTemplate.postForLocation("http://localhost:8080/rest/admin", admin);
		Admin admin2= restTemplate.getForObject(location,Admin.class);
		MatcherAssert.assertThat(admin2.getFirstName(),Matchers.equalTo(admin.getFirstName()));
		MatcherAssert.assertThat(admin2.getLastName(),Matchers.equalTo(admin.getLastName()));
		
	}
	
	@Test
	public void testGetAdminById() {
		ResponseEntity<Admin> response=restTemplate.getForEntity("http://localhost:8080/rest/admin/1", Admin.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(),Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(),Matchers.equalTo("Ebru"));
	}
	@Test
	public void testGetAdminByLastName() {
		ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/admin?ln=Boyacı", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(),Matchers.equalTo(200));
		List<Map<String,String>> body= response.getBody();
		List<String> firstNames=body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Ebru"));
	}
}
