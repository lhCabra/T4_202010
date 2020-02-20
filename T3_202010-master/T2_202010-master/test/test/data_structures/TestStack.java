package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Stack;

public class TestStack {

	Stack<Integer> stack;
	@Before
	public void setUp1()
	{
		stack=new Stack<Integer>();
		
	}
	
	public void setUp2()
	{
		stack= new Stack<Integer>();
		for(Integer i=0 ; i<20;i++)
		{
			stack.push(i);
		}
	}
	
	@Test
	public void TestDarTamano()
	{
		assertTrue("Error al dar tamaño del stack vacío",stack.darTamano()==0 );
		setUp2();
		assertTrue("Error al dar tamaño del stack con elementos", stack.darTamano()==20);
	}
	
	@Test
	public void TestDarTope()
	{
		assertTrue("Error al dar tope del stack vacío",stack.darTope()==null );
		setUp2();
		assertTrue("Error al dar tope del stack con elementos",stack.darTope()==19 );
	}
	@Test
	public void TestPush()
	{
		stack.push(1);
		assertTrue("Error al push en el stack vacío",stack.darTamano()==1 && stack.darTope()==1);
		setUp2();
		stack.push(1);
		assertTrue("Error al push en el stack con elementos", stack.darTamano()==21 && stack.darTope()==1);
	}
	@Test
	public void TestPop()
	{
		assertTrue("Error al pop en el stack vacío",stack.pop()==null);
		setUp2();
		assertTrue("Error al pop en el stack con elementos", stack.pop()==19 && stack.darTamano()==19 && stack.darTope()==18);
	}
}
