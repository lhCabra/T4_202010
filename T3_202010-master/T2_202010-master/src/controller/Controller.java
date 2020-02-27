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
		Comparable<Comparendo>[] a=null;
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();

				long start = System.currentTimeMillis();

				Queue<Comparendo> queue = modelo.cargarDatosQ();

				long end = System.currentTimeMillis();

				view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0);
				view.printMessage("Datos cargados Queue: " + queue.darTamano() + "\n");
				view.printMessage("Primer dato queue: " + queue.darPrincipio().toString() + "\n");
				break;

			case 2:
				if(modelo!=null)
				{try
				{
					long s1=System.currentTimeMillis();
					Comparable [] copia= modelo.copiarComparendos();
					long f1=System.currentTimeMillis();
					view.printMessage("Tiempo copia :"+(f1-s1)/1000.0);
					view.printMessage("Tamaño copia :"+copia.length);
					s1=System.currentTimeMillis();
					modelo.shellSort(copia);
					f1=System.currentTimeMillis();
					view.printMessage("Tiempo Shell Sort (seg):"+(f1-s1)/1000.0);
					for(int i=0;i<10 && copia[i]!=null;i++)
					{
						view.printMessage(copia[i].toString());
					}
					for(int i=copia.length-1;i>copia.length-10;i--)
					{
						view.printMessage(copia[i].toString());
					}
				}
				catch(Exception e)
				{
					
				}
				}
				break;
			case 3:
				if(modelo!=null)
				{	try
				{
					long s1=System.currentTimeMillis();
					Comparable [] copia= modelo.copiarComparendos();
					long f1=System.currentTimeMillis();
					view.printMessage("Tiempo copia :"+(f1-s1)/1000.0);
					view.printMessage("Tamaño copia :"+copia.length);
					s1=System.currentTimeMillis();
					modelo.mergeSort(copia);
					f1=System.currentTimeMillis();
					view.printMessage("Tiempo Merge Sort (seg):"+(f1-s1)/1000.0);
					for(int i=0;i<10 && copia[i]!=null;i++)
					{
						view.printMessage(copia[i].toString());
					}
					for(int i=copia.length-1;i>copia.length-10;i--)
					{
						view.printMessage(copia[i].toString());
					}
				}
				catch(Exception e)
				{

				}
				}

				break;
			case 4:
				if(modelo!=null)
				{
					try
					{
						long s1=System.currentTimeMillis();
						Comparable [] copia= modelo.copiarComparendos();
						long f1=System.currentTimeMillis();
						view.printMessage("Tiempo copia :"+(f1-s1)/1000.0);
						view.printMessage("Tamaño copia :"+copia.length);
						s1=System.currentTimeMillis();
						Modelo.quickSort(copia, 0,copia.length-1);
						f1=System.currentTimeMillis();
						view.printMessage("Tiempo Quick Sort (seg):"+(f1-s1)/1000.0);
						for(int i=0;i<10 && copia[i]!=null;i++)
						{
							view.printMessage(copia[i].toString());
						}
						for(int i=copia.length-1;i>copia.length-10;i--)
						{
							view.printMessage(copia[i].toString());
						}
					}
					catch(Exception e)
					{

					}
				}
				break;
			case 5:

				fin=true;
				break;
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
