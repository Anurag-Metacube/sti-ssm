package com.sti.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sti.ssm.annotation.SAMLUser;
import com.sti.ssm.config.security.SAMLUserDetails;

@Controller
public class IndexController extends BaseController {


	@RequestMapping("/index")
	public String index() {
		return "index";
	}

    @RequestMapping("/home")
    public ModelAndView home(@SAMLUser SAMLUserDetails user) {
        ModelAndView homeView = new ModelAndView("home");
        homeView.addObject("userId", user.getUsername());
        homeView.addObject("samlAttributes", user.getAttributes());
        return homeView;
    }
	
}
