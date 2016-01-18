package simple;

import static org.junit.Assert.*;
public class simpleCalculator {

	public int add(int a, int b){
		return a+b;
	}
	
	
	@Test
	public void testAdd(){
		simpleCalculator calc = new simpleCalculator();
		int expected=8;
		int result=calc.add(6, 2);
		
		double expectedDouble=2.0;
		double resultDouble=2.0;
		assertEquals(expectedDouble,resultDouble,0.0001);
		
		assertEquals("Test if addition works", expected,result);
		//assert(expected==result);
	}
	
	@Test
	public void testSubtract(){
		fail("Notyet implemented");
	}
	
	public int subtract(int a,int b){
		return a-b;
	}
	
	@Test (expected=IllegalArgumentException.class)
	public int divide(int a, int b){
		if(b==0)
			throw new IllegalArgumentException("Division by zero");
		return a/b;
	}
}
