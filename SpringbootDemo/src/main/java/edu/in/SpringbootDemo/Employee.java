package edu.in.SpringbootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private int Eid;
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	private String Ename;
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", salary=" + salary + ", department=" + department + "]";
	}
	private int salary;
	public Employee(int eid, String ename, int salary, Departments department) {
		super();
		Eid = eid;
		Ename = ename;
		this.salary = salary;
		this.department = department;
	}
	@Autowired
	private Departments department;
	public Employee() {
		super();
	}
	
	
	
	

}
