package org.snapdeal.spring_boot_CRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_record")
public class StudentEntity {
	@Id
	private int roll;
	@Column
	private String name;
	@Column
	private String city;
	
	public StudentEntity() {}
	
	public StudentEntity(int roll, String name, String city) {
		super();
		this.roll = roll;
		this.name = name;
		this.city = city;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
