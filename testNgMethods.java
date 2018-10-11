package tests;

//import junit.framework.Assert;

import org.testng.annotations.Test;

public class testNgMethods {
	@Test
	public void sum()
	{
		System.out.println("sum");
		int a= 10;
		int b= 20;
		//Assert.assertEquals(30,a+b);
	}
	@Test
	public void sub()
	{
		System.out.println("sub");
		int a= 10;
		int b= 20;
		//Assert.assertEquals(10,b-a);
	}
}
