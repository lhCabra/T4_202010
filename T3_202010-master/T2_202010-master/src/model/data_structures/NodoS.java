package model.data_structures;

public class NodoS <T extends Comparable<T>>
{
	private NodoS<T> siguiente;
	private NodoS<T> anterior;
	private T elemento;
	private int tamano;
	
	public NodoS(T elem)
	{
		siguiente=null;
		anterior=null;
		elemento=elem;
		tamano=1;
	}
	
	public NodoS<T> darSiguiente()
	{
		return siguiente;
	}
	public NodoS<T> darAnterior()
	{
		return anterior;
	}
	
	public void cambiarAnterior(NodoS<T> cam)
	{
		anterior=cam;
	}
	
	public T darElemento()
	{
		return elemento;
	}
	
	public NodoS<T> agregar(T dato)//cambie todos los siguientes por anterior
	{
		if(anterior!=null)
		{
			return anterior.agregar(dato);
		}
		else if(anterior==null)
		{
			anterior= new NodoS<T>(dato);
			anterior.cambiarSiguiente(this);;
			return anterior;
		}	
		else
		{
			return null;
		}
		
	}
	
	public void cambiarSiguiente(NodoS<T> nodo)
	{
		siguiente= nodo;
	}
	
	public int tamano()
	{
		if(siguiente!=null)
			return 1+siguiente.tamano();
		else
			return 1;
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
