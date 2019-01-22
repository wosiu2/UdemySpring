package com.udemy.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		
		return "hello-world";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVer2")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		String theName=request.getParameter("studentName");
		
		
		String result="Yo! "+theName.toUpperCase();
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVer3")
	public String letsShoutDude2(@RequestParam("studentName") String studentName,
			Model model) {
		
		String result="Yo Yo! "+studentName.toUpperCase();
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
