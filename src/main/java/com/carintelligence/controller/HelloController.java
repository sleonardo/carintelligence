package com.carintelligence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 08/3/17.
 **/
@Controller
public class HelloController {

	@RequestMapping(value ="/greeting")
	public String sayHello (Model model) {
		
		model.addAttribute("greeting", "Hello World");
		
		return "hello";
	}
	
}
