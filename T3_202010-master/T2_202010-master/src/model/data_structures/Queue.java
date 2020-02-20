package model.data_structures;

public class Queue <T extends Comparable<T>> implements IQueue<T>
{
	NodoQ<T> primero=null;
	NodoQ<T> ultimo=null;
	public int darTamano() {
		if(primero==null)
			return 0;
		int contador=0;
		for(NodoQ actual=primero;actual.darSiguiente()!=null;actual=actual.darSiguiente())
		{
			contador++;
		}
		return contador+1;
	}


	public T darPrincipio() {
		if(primero==null)
			return null;
		return primero.darElemento();
	}


	public boolean estaVacia() {
		if(primero!=null)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}


	public void enqueue(T dato)
	{
		NodoQ n= new NodoQ(dato);
		if( primero== null)
		{
			primero=n;
			ultimo=n;
		}
		else
		{
			ultimo.cambiarSiguiente(n);
			ultimo=n;
		}
	}


	public T dequeue() 
	{
		if(primero==null)
			return null;
		T resp=primero.darElemento();
		primero=primero.darSiguiente();
		return resp;
	}

}
