package com.sti.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {


	@RequestMapping(value = {"/", "/index", "/logged-in"})
	public String index() {
		return "logged-in";
	}

	
}
