package controller;

import java.util.List;
import java.util.Scanner;

import model.Comparendo;
import model.data_structures.ArregloDinamico;
import model.data_structures.Lista;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();

				long start = System.currentTimeMillis();
				Stack<Comparendo> stack = modelo.cargarDatos();
				Queue<Comparendo> queue = modelo.cargarDatosQ();

				long end = System.currentTimeMillis();

				view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0);
				view.printMessage("Datos cargados Stack: " + stack.darTamano()+"\n");
				view.printMessage("Datos cargados Queue: " + queue.darTamano() + "\n");
				view.printMessage("Primer dato stack: " + stack.darTope().toString() + "\n");
				view.printMessage("Primer dato queue: " + queue.darPrincipio().toString() + "\n");
				break;

			case 2:
				Queue<Comparendo> a;
				try {
					a = modelo.clusterMasGrande();
					while(!a.estaVacia())
					{
						view.printMessage(a.dequeue().respuesta());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					view.printMessage("No se han cargado los datos");
				}

				break;
			case 3:
				if(modelo!=null)
				{
					view.printMessage("N�mero de comparendos, Infracci�n:");
					option = lector.nextInt();
					view.printMessage("Infracci�n:");
					String option2 = lector.next();
					Queue<Comparendo> c;
					try {
						c = modelo.darNcomparendos(option,option2 );
						while(!c.estaVacia())
						{
							view.printMessage(c.dequeue().respuesta());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block

						view.printMessage("No se han cargado los datos");

					}


				}

				break;
			case 4:

				Comparable [] copia=modelo.copiarComparendos();
				Modelo.shellSort(copia);

			case 5:

				Comparable [] copia1=modelo.copiarComparendos();
				Modelo.mergeSort(copia1);
			case 6:

				Comparable [] copia2=modelo.copiarComparendos();
				Modelo.quickSort(copia2, 0,copia2.length);
			case 7:

				fin=true;
				break;
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
