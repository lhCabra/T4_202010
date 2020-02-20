package model.data_structures;

public class Stack <T extends Comparable<T>> implements IStack<T>
{
 NodoS<T> tope=null;
	
	public void push(T dato) 
	{
		NodoS n=new NodoS(dato);
		n.cambiarSiguiente(tope);
		if(tope!=null)
		tope.cambiarAnterior(n);
		tope=n;
		
		
	}

	
	public T pop() {
		if(tope==null)
			return null;
		T resp= tope.darElemento();
		tope=tope.darSiguiente();
		return resp;
		
	}

	
	public int darTamano() {
		
		if(tope==null)
			return 0;
		int contador=0;
		for(NodoS actual=tope;actual.darSiguiente()!=null;actual=actual.darSiguiente())
		{
			contador++;
		}
		return contador+1;
	}


	public boolean estaVacia() {
		
		return tope==null;
	}


	public T darTope() 
	{
		if(tope==null)
			return null;
		return tope.darElemento();
	}

	public T darElementoEn(int i)
	{
		if(tope==null)
			return null;
		return tope.darElementoEnPos(i);
	}
}
