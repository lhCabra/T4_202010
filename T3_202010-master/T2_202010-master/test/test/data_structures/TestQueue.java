package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;

public class TestQueue {

	private Queue<Integer> queue;
	
	@Before
	public void setUp1()
	{
		queue=new Queue<Integer>();
	}
	public void setUp2()
	{
		queue=new Queue<Integer>();
		for(Integer i=0 ;i<20 ;i++)
		{
			queue.enqueue(i);
		}
	}
	@Test
	public void testDarPrincipio()
	{
		assertTrue("Error al dar principio de una cola vacía",queue.darPrincipio()==null);
		setUp2();
		assertTrue("Error al dar principio de una cola con elementos", queue.darPrincipio()==0);
	}
	@Test
	public void testDarTamano()
	{
		assertTrue("Error al dar tamaño de una cola vacía",queue.darTamano()==0);
		setUp2();
		assertTrue("Error al dar tamaño de una cola con elementos", queue.darTamano()==20);
	}
	@Test
	public void testEstaVacia()
	{
		assertTrue("Error al dar estado de una cola vacía",queue.estaVacia());
		setUp2();
		assertTrue("Error al dar estado de una cola con elementos", queue.estaVacia()==false);
	}
	@Test
	public void testDequeue()
	{
		assertTrue("Error al sacar elemento de una cola vacía",queue.dequeue()==null);
		setUp2();
		assertTrue("Error al sacar elemento de una cola con elementos", queue.dequeue()==0);
	}
	
	@Test
	public void testEnqueue()
	{
		queue.enqueue(1);
		assertTrue("Error al ingresar elemento de una cola vacía",queue.darPrincipio()==1 && queue.darTamano()==1);
		setUp2();
		queue.enqueue(1);
		assertTrue("Error al ingresar elemento de una cola con elementos", queue.darPrincipio()==0 && queue.darTamano()==21);
	}
}
