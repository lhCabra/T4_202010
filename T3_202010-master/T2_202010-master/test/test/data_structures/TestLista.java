package test.data_structures;

import model.data_structures.Lista;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLista {
	
	private Lista<Integer> lista;
	
	public void setUp1()
	{
		lista=new Lista<Integer>();
	}
	
	public void setUp2()
	{
		lista=new Lista();
		for(Integer i=0;i<20;i++)
		lista.agregar(i);
	}
	@Test
	public void testDarTamano()
	{
		
		setUp1();
		assertTrue("Error en el tamaño de la lista vacia",lista.darTamano()==0);
		setUp2();
		assertTrue("Error en el tamaño de la lista con elementos",lista.darTamano()==20);	
	}
	
	@Test
	public void testDarElemento()
	{
		setUp1();
		assertTrue("Error en dar elemento de una lista vacía", lista.darElemento(0)==null);
		setUp2();
		assertTrue("Error en dar elemento de una lista con elementos", lista.darElemento(19).equals(19));
	}
	@Test
	public void testAgregar()
	{
		setUp1();
		lista.agregar(11);
		assertTrue("Error en agregar elemento en una lista vacía",lista.darElemento(0).equals(11));
		setUp2();
		lista.agregar(2);
		assertTrue("Error en agregar elemento en una lista con elementos",lista.darElemento(lista.darTamano()-1).equals(2));
	}
	@Test
	public void testDarPrimero()
	{
		setUp1();
		assertTrue("Error en dar primero de una lista vacía",lista.darPrimero()==null);
		setUp2();
		assertTrue("Error en dar primero de una lista con elementos",lista.darPrimero().darElemento()==0);
	}
	
	@Test
	public void testEliminar()
	{
		setUp1();
		assertTrue("Error en eliminar de una lista vacía.",lista.eliminar(1)==null);
		setUp2();
		assertTrue("Error en eliminar de una lista con elementos",lista.eliminar(1).equals(1)&& lista.darTamano()==19);
	}
}
