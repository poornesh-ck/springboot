package edu.in.SpringbootDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HRDept implements Departments {
	
	
	
	@Override
	public String toString() {
		return "HRDept";
	}

	public void details()
	{
		System.out.println("HR");
	}
}
