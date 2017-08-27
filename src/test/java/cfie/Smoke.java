package cfie;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Smoke {
  
	@Test(groups = {"Smoke"})
	public void f() {
		
		Assert.assertFalse(false);
		System.out.println("Smoke");
		
	}
}
