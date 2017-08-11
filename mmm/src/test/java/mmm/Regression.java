package mmm;

import org.testng.annotations.Test;

public class Regression {
  
	@Test(groups = {"Regression"})
	public void f() {
		
		System.out.println("Regression");
		
	}
	
	@Test
	public void f1() {
		
		System.out.println("Functional");
		
	}
}
