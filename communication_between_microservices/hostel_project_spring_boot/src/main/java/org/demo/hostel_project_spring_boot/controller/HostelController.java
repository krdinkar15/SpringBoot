package org.demo.hostel_project_spring_boot.controller;

import org.demo.hostel_project_spring_boot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HostelController {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;
	
	static final String STUDENT_URL_MS="http://localhost:8085/";
	
	@GetMapping("/find/{roll}")
	public String fetchStudent(@PathVariable int roll)
	{
		ResponseEntity<Student> student=restTemplate.exchange(STUDENT_URL_MS+"get/"+roll,HttpMethod.GET,null,Student.class);
		System.out.println("Student from Student Report Project "+student);
		//return restTemplate.exchange(STUDENT_URL_MS+"get/"+roll, HttpMethod.GET,null,String.class).getBody();
		return restTemplate.getForObject(STUDENT_URL_MS+"get/"+roll,String.class);
	}
	
	@GetMapping("/findAll")
	public String fetchStudent()
	{
		return restTemplate.exchange(STUDENT_URL_MS+"all",HttpMethod.GET,null,String.class).getBody();
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student)
	{
		return restTemplate.postForObject(STUDENT_URL_MS+"add", student, String.class);
	}
	
	//localhost:8085/get/1111
	
}
