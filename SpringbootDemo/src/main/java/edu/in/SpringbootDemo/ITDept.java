package edu.in.SpringbootDemo;

import org.springframework.stereotype.Component;

@Component
public class ITDept implements Departments {
	
	
	
	@Override
	public String toString() {
		return "ITDept";
	}

	public void details()
	{
		System.out.println("IT");
	}

}
