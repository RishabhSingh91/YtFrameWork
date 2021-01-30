package org.testing.Assertions;

public class Assertion {
	
	public static void assertion1(String Expected, String Actual)
	{
		if(Expected.equals(Actual))
		{
			System.out.println("The test case is pass");
		}
		else {
			System.out.println("The test case is fail");
		}
	}

}
