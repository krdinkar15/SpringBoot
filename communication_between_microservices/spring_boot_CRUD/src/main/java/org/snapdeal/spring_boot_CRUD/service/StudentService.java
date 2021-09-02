package org.snapdeal.spring_boot_CRUD.service;

import java.util.List;

import org.snapdeal.spring_boot_CRUD.dao.StudentDAO;
import org.snapdeal.spring_boot_CRUD.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO dao;
	public String addStudent(StudentEntity studentEntity)
	{
		dao.save(studentEntity);
		return "New Student added having roll No = "+studentEntity.getRoll(); 
	}
	
	public String addStudents(List<StudentEntity> studentEntity)
	{
		dao.saveAll(studentEntity);
		return "All New Student added "; 
	}
	public List<StudentEntity> getStudents(List<StudentEntity> studentEntity)
	{
		return dao.findAll();
	}
	public String deleteStudent(int roll)
	{
		StudentEntity studentEntity=dao.getById(roll);
		dao.delete(studentEntity);
		return "Roll Number " +roll+" is deleted"; 
	}
	
	public String updateStudent(StudentEntity studentEntity)
	{
		dao.save(studentEntity);
		return "updated " + studentEntity.getRoll();
	}
	
	public StudentEntity getStudent(int roll)
	{
		return dao.findById(roll).get();
	}

}
