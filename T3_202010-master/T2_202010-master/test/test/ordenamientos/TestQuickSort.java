package test.ordenamientos;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.logic.Modelo;

public class TestQuickSort {
private Comparable[] arreglo;
	
	@Before
	public void setUp1()
	{
		//Arreglo ordenado descendentemente
		arreglo=new Comparable[1000];
		for(Integer i=0;i<1000;i++)
		{
			arreglo[i]=i;
		}	
	}
	public void setUp2()
	{
		//Arreglo ordenado
		arreglo=new Comparable[1000];
		for(Integer i=999;0<=i;i--)
		{
			arreglo[i]=i;
		}	
	}
	
	public void setUp3()
	{
		int i=0;
		arreglo=new Comparable[1000];
		while(i<1000)
		{
			arreglo[i]=Math.random();
			i++;
		}
	}
	
	@Test
	public void quickSort()
	{
		boolean r=true;
		setUp1();
		
		Modelo.quickSort(arreglo, 0, arreglo.length-1);
		for(int i=0;i<arreglo.length-1;i++)
		{
			if(arreglo[i].compareTo(arreglo[i+1])>0)
			{
				assertTrue("Error al ordenar el arreglo que ya está ordenado", arreglo[i].compareTo(arreglo[i+1])>0);
				r=false;
			}
			
		}
		assertTrue("Error al ordenar el arreglo ordenado",r);
		
		arreglo=null;
		setUp2();
		r=true;
		Modelo.quickSort(arreglo, 0, arreglo.length-1);
		for(int i=0;i<arreglo.length-1;i++)
		{
			if(arreglo[i].compareTo(arreglo[i+1])>0)
			{
				assertTrue("Error al ordenar el arreglo que ya está ordenado descendentemente", arreglo[i].compareTo(arreglo[i+1])>0);
				
				r=false;
			}
			
		}
		assertTrue("Error al ordenar el arreglo ordenado descendentemente",r);
		
		arreglo=null;
		setUp3();
		r=true;
		Modelo.quickSort(arreglo, 0, arreglo.length-1);
		for(int i=0;i<arreglo.length-1;i++)
		{
			if(arreglo[i].compareTo(arreglo[i+1])>0)
			{
				assertTrue("Error al ordenar el arreglo no ordenado", arreglo[i].compareTo(arreglo[i+1])>0);
				r=false;
			}
			
		}
		assertTrue("Error al ordenar el arreglo no ordenado",r);
		
		
	}
	
}
