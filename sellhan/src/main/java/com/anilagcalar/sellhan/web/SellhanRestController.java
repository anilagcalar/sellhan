package com.anilagcalar.sellhan.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anilagcalar.sellhan.exception.AdminNotFoundException;
import com.anilagcalar.sellhan.model.Admin;
import com.anilagcalar.sellhan.service.SellhanService;

@RestController
@RequestMapping("/rest")
public class SellhanRestController {
	
	@Autowired
	private SellhanService sellhanService;
	
	@RequestMapping(method=RequestMethod.DELETE,value="/admin/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id")Long id) {
		try {
		sellhanService.deleteOwner(id);
		return ResponseEntity.ok().build();
		}catch(AdminNotFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/admin/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable("id") Long id,@RequestBody Admin adminRequest) {
		try {
			Admin admin=sellhanService.findAdmins(id);
			admin.setFirstName(adminRequest.getFirstName());
			admin.setLastName(adminRequest.getLastName());
			sellhanService.updateAdmin(admin);
			return ResponseEntity.ok().build();
		}catch(AdminNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/admin")
	public ResponseEntity<URI> createAdmin(@RequestBody Admin admin) {
		try {
		sellhanService.createAdmin(admin);
		Long id = admin.getId();
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	@RequestMapping(method=RequestMethod.GET,value="/admins")
	public ResponseEntity<List<Admin>> getAdmins() {
		List<Admin> admins= sellhanService.findAdmins();
		 return ResponseEntity.ok(admins);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/admin")
	public ResponseEntity<List<Admin>> getAdmins(@RequestParam("ln")String lastName) {
		List<Admin> admins= sellhanService.findAdmins(lastName);
		return ResponseEntity.ok(admins);
		
	}
/*	@RequestMapping(method=RequestMethod.GET,value= "/admin/{id}",produces="application/json")
	public ResponseEntity<?> getAdminAsHateoasResource(@PathVariable("id")Long id) {
		try {
		Admin admin = sellhanService.findAdmins(id);
		Link self= ControllerLinkBuilder.linkTo(SellhanRestController.class).slash("/admin/" +id).withSelfRel();
		Link create = ControllerLinkBuilder.linkTo(SellhanRestController.class).slash("/admin").withRel("create");
		Link update = ControllerLinkBuilder.linkTo(SellhanRestController.class).slash("/admin/" +id).withRel("update");
		Link delete = ControllerLinkBuilder.linkTo(SellhanRestController.class).slash("/admin/" +id).withRel("delete");
		Resource<Admin> resource = new Resource<Admin>(admin,self,create,update,delete);
		return ResponseEntity.ok(admin);
		} catch(AdminNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	*/
	
	
	@RequestMapping(method=RequestMethod.GET,value="/admin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id")Long id){
		try {
		Admin admin = sellhanService.findAdmins(id);
		return ResponseEntity.ok(admin);
		} catch(AdminNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
