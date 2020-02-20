package model.data_structures;

public class Nodo <T extends Comparable<T>>{
	
	
	private Nodo<T> siguiente;
	private Nodo<T> anterior;
	private T elemento;
	private int tamano;
	
	public Nodo(T elem)
	{
		siguiente=null;
		anterior=null;
		elemento=elem;
		tamano=1;
	}
	
	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	public Nodo<T> darAnterior()
	{
		return anterior;
	}
	
	public void cambiarAnterior(Nodo<T> cam)
	{
		anterior=cam;
	}
	
	public T darElemento()
	{
		return elemento;
	}
	
	public Nodo<T> agregar(T dato)
	{
		if(siguiente!=null)
		{
			return siguiente.agregar(dato);
		}
		else if(siguiente==null)
		{
			siguiente= new Nodo<T>(dato);
			siguiente.cambiarAnterior(this);;
			return siguiente;
		}	
		else
		{
			return null;
		}
		
	}
	
	public T eliminar(T dato)
	{
		T elim=null;
		if(siguiente==null)
		{
			return null;
		}
		else
		{		
			if(siguiente.darElemento().compareTo(dato)==0)
			{
				elim=siguiente.darElemento();
				this.cambiarSiguiente(siguiente.darSiguiente());
				return elim;
			}
			else
			{
				return siguiente.eliminar(dato);
				
			}
		}	
	}
	
	public void cambiarSiguiente(Nodo<T> nodo)
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
