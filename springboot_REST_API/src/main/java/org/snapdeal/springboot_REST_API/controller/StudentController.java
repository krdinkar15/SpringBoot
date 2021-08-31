package org.snapdeal.springboot_REST_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller for MVC 
@RestController
public class StudentController {
	
	@RequestMapping("home")
	public String home()
	{
		return "Home Page "+new java.util.Date();
	}
	
	//@RequestMapping(value="search/{roll}",method=RequestMethod.GET)
	@GetMapping(value="search/{roll}")
	public String search(@PathVariable int roll)
	{
		return "You have entered roll no using pathvariable = "+roll;
	}
	
	@RequestMapping(value="find")
	public String find(@RequestParam(value="roll") int roll)
	{
		return "You have entered roll no using Request Param= "+roll;
	}
	
	@PostMapping(value="checkName")
	public String checkName(@RequestBody String name)
	{
		System.out.println(name);
		return "Using request Body name = "+name;
	}
}
