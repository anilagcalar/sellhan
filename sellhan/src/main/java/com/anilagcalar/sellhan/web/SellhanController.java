package com.anilagcalar.sellhan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anilagcalar.sellhan.service.SellhanService;

@Controller
public class SellhanController {

	@Autowired
	private SellhanService sellhanService;
	
	@RequestMapping("/admins")
	public ModelAndView getAdmins() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("admins",sellhanService.findAdmins());
		mav.setViewName("admins");
		return mav;
	}
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		return"Welcome To Sellhan";
		
	}
}
