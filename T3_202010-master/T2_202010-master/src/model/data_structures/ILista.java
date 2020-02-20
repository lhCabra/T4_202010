package model.data_structures;

public interface ILista <T extends Comparable<T>>{

	int darTamano( );
	
	T darElemento( int i );

	public void agregar( T dato );
		
	T buscar(T dato);
	
	T eliminar( T dato );
	
	T darSiguiente();
	

}
