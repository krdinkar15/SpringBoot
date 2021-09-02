package org.snapdeal.spring_boot_CRUD.controller;

import java.util.List;

import org.snapdeal.spring_boot_CRUD.entity.StudentEntity;
import org.snapdeal.spring_boot_CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/home")
	public String home()
	{
		return "this is my home page";
	}
	
	@RequestMapping(value="/search/{roll}",method=RequestMethod.GET)
	public String search(@PathVariable int roll)
	{
		return "You have entered roll = "+roll;
	}
	
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public String findByName(@RequestBody String name)
	{
		return "You have entered name = "+name;
	}
	@RequestMapping("/all")
	public List<StudentEntity> getStudents()
	{
		return studentService.getStudents(null);
	}
	@PostMapping("/add")
	public String addStudent(@RequestBody StudentEntity studentEntity)
	{
		return studentService.addStudent(studentEntity);
	}
	
	@PostMapping("/bulkAdd")
	public String addStudents(@RequestBody List<StudentEntity> studentEntities)
	{
		return studentService.addStudents(studentEntities);
	}
	
	@DeleteMapping("/del/{roll}")
	public String deleteStudent(@PathVariable int roll)
	{
		return studentService.deleteStudent(roll);
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody StudentEntity studentEntity)
	{
		return studentService.updateStudent(studentEntity);
	}
	
	@RequestMapping("/get/{roll}")
	public StudentEntity getStudent(@PathVariable int roll)
	{
		return studentService.getStudent(roll);
	}
}
