package model.data_structures;

public class NodoQ <T extends Comparable<T>>
{
	private NodoQ<T> siguiente;
	private NodoQ<T> anterior;
	private T elemento;
	private int tamano;
	
	public NodoQ(T elem)
	{
		siguiente=null;
		anterior=null;
		elemento=elem;
		tamano=1;
	}
	
	public NodoQ<T> darSiguiente()
	{
		return siguiente;
	}
	public NodoQ<T> darAnterior()
	{
		return anterior;
	}
	
	public void cambiarAnterior(NodoQ<T> cam)
	{
		anterior=cam;
	}
	
	public T darElemento()
	{
		return elemento;
	}
	
	public NodoQ<T> agregar(T dato)
	{
		if(siguiente!=null)
		{
			return siguiente.agregar(dato);
		}
		else if(siguiente==null)
		{
			siguiente= new NodoQ<T>(dato);
			siguiente.cambiarAnterior(this);
			return siguiente;
		}	
		else
		{
			return null;
		}
		
	}
	
	public void cambiarSiguiente(NodoQ<T> nodo)
	{
		siguiente= nodo;
	}
	
	public int tamano()
	{
		if(siguiente!=null)
			return tamano+siguiente.tamano();
		else
			return tamano;
	}
	
	public T buscarA(T b)
	{
		if(this.elemento.compareTo(b)==0)
		{
			return this.elemento;
		}
		else if(siguiente==null )
		{
			return null;
		}
		else
		{
			return siguiente.buscarA(b);
		}
		
	}

	public T darElementoEnPos(int i)
	{
		if(i==0)
		{
			return this.darElemento();
		}
		else if(siguiente!=null)
			return siguiente.darElementoEnPos(i-1);
		else
			return null;
		
	}
}
