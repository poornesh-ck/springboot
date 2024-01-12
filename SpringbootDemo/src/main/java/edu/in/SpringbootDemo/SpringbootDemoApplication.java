package edu.in.SpringbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringbootDemoApplication.class, args);
		
		Employee e= context.getBean(Employee.class);
		
		
		
		e.setEid(101);
		e.setEname("abc");
		e.setSalary(1000);
		e.setDepartment(context.getBean(HRDept.class));
		System.out.println(e);
		
		Employee e1= context.getBean(Employee.class);
		
		
		e1.setEid(102);
		e1.setEname("xyz");
		e1.setSalary(10000);
		e1.setDepartment(context.getBean(ITDept.class));
		System.out.println(e1);

		Employee e2= context.getBean(Employee.class);
		
		
		e2.setEid(103);
		e2.setEname("mno");
		e2.setSalary(10000);
		e2.setDepartment(context.getBean(ITDept.class));
		
		
		
		System.out.println(e2);
		
		
		
		
		
		
		
		
		
		
	}
		
		

}
