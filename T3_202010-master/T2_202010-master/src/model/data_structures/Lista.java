package model.data_structures;

public class Lista  <T extends Comparable<T>> implements ILista<T>{

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	public Lista()
	{
		primero=null; 
		ultimo=null;
	}
	

	@Override
	public int darTamano() {
		
		// TODO Auto-generated method stub
		if(primero==null)
			return 0;
		return primero.tamano();
	}

	@Override
	public T darElemento(int i) {
		// TODO Auto-generated method stub
		if(primero==null)
		{
			return null;
		}
		else
		{
			return primero.darElementoEnPos(i);
		}
	}
	@Override
	public void agregar(T dato) {
		// TODO Auto-generated method stub
		if(primero!=null)
		{
			ultimo=ultimo.agregar(dato);
		}
		else
		{
			primero= new Nodo<T>(dato);
			ultimo=primero;
		}
		
	}

	@Override
	public T buscar(T dato) {
		// TODO Auto-generated method stub
		if(primero != null)
		{
			return primero.buscarA(dato);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public T eliminar(T dato) {
		// TODO Auto-generated method stub
		if (primero!=null)
		{
			if(primero.darElemento().compareTo(dato)==0)
			{
				T resp=primero.darElemento();
				primero=primero.darSiguiente();
			}
			else
			{
			return primero.eliminar(dato);
			}
		}
		return null;
	}

	@Override
	public T darSiguiente() {
		// TODO Auto-generated method stub
		if(primero==null || primero.darSiguiente()!=null)
		{
		return null;
		}
		return primero.darSiguiente().darElemento();
	}

	
	
	public Nodo<T> darPrimero()
	{
		return primero;
	}


}
