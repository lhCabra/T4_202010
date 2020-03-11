package model.data_structures;

public class MaxColaCP <T extends Comparable<T>>
{
	NodoQ<T> primero=null;
	//	NodoQ<T> ultimo=null;
	int tamano=0;
	public MaxColaCP()
	{
		
	}
	public int darNumElementos() {
		if(primero==null)
			return 0;
		int contador=0;
		for(NodoQ actual=primero;actual.darSiguiente()!=null;actual=actual.darSiguiente())
		{
			contador++;
		}
		tamano=contador+1;
		return contador+1;
	}

	public void agregar(T elemento)
	{
		NodoQ<T> n= new NodoQ<T>(elemento);
		if( primero== null)
		{
			primero=n;
			//			ultimo=n;
		}
		else
		{
			NodoQ<T> actual=primero;
			boolean encontro=false;
			while(actual.darSiguiente()==null&&!encontro)
			{
				if(elemento.compareTo((T) actual.darElemento())>0)
				{
					if(actual.darAnterior()!=null)
					{
						actual.darAnterior().cambiarSiguiente(n);

					}
					actual.cambiarAnterior(n);
					encontro=true;
				}
				actual=actual.darSiguiente();
			}

		}
	}
	public T sacarMax () 
	{
		T resp=primero.darElemento();
		primero=primero.darSiguiente();
		return resp;
	}
	public T darMax() 
	{
		return primero.darElemento();
	}
	public boolean esVacia ()
	{
		return tamano==0;
	}
}
