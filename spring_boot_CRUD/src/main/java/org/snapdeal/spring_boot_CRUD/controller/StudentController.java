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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
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
