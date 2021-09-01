package org.snapdeal.spring_boot_CRUD.dao;

import org.snapdeal.spring_boot_CRUD.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentEntity,Integer>
{
	
}
