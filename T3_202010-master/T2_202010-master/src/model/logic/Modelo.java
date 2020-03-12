package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.Comparendo;
import model.data_structures.ArregloDinamico;
import model.data_structures.Lista;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	public static String PATH1 = "./T3_202010-master/T2_202010-master/data/Comparendos_DEI_2018_Bogotá_D.C_small.geojson";
	public static String PATH = "./data/comparendos_dei_2018.geojson";

	private Queue<Comparendo> queue;
	private Stack<Comparendo> stack;
	private MaxHeapCP<Comparendo> heap;
	private MaxColaCP<Comparendo> cola;

	public Stack<Comparendo> cargarDatos() {

		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		Stack<Comparendo> datos = new Stack();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);

				datos.push(c);

			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		stack=datos;
		return datos;	

	}

	public Queue<Comparendo> cargarDatosQ() {

		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		Queue<Comparendo> datos = new Queue();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH1));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO" ).getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);

				datos.enqueue(c);

			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		queue=datos;
		return datos;	

	}
	public MaxColaCP<Comparendo> cargarDatosC() {

		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		MaxColaCP<Comparendo> datos = new MaxColaCP();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);

				datos.agregar(c);

			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		cola=datos;
		return datos;	

	}
	public MaxHeapCP<Comparendo> cargarDatosH() {

		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		MaxHeapCP<Comparendo> datos = new MaxHeapCP(10000000);

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);

				datos.agregar(c);

			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		heap=datos;
		return datos;	

	}
	
	public Comparable[] copiarComparendos() {
		// TODO Auto-generated method stub
		if(queue==null)
			return null;
		Comparable<Comparendo>[] resp= new Comparable[queue.darTamano()];
		Queue<Comparendo> q=new Queue<Comparendo>();
		int i=0;
		while(!queue.estaVacia())
		{
			Comparendo c=queue.dequeue();
			resp[i++]=c;
			q.enqueue(c);
		}
		queue=q;
		return resp;
	}

	public int[] posAleatorias(int pTamano)
	{	
		int [] resp=new int[pTamano];
		Comparable<Comparendo>[] aux= (Comparable<Comparendo>[])copiarComparendos();
		for(int i=0 ; i<pTamano;i++)
		{
			int pos = (int) Math.floor(Math.random()*aux.length);
			if(aux[pos]!=null)
			{
				resp[i]=pos;
				aux[pos]=null;
			}
			else
			{
				i--;
			}

		}
		return resp;
	}
	public MaxColaCP<Comparendo> crearMaxColaCP(int[] pPos)
	{
		cola= new MaxColaCP<>();
		Comparable<Comparendo>[] aux= (Comparable<Comparendo>[])copiarComparendos();
		for(int i=0 ; i<pPos.length;i++)
		{
			cola.agregar((Comparendo)aux[pPos[i]]);
		}
		return cola;
	}
	public MaxHeapCP<Comparendo> crearMaxHeapCP(int[] pPos)
	{
		MaxHeapCP<Comparendo> respuesta= new MaxHeapCP<>(pPos.length);
		Comparendo[] aux= (Comparendo[])copiarComparendos();
		for(int i=0 ; i<pPos.length;i++)
		{
			respuesta.agregar(aux[pPos[i]]);
		}
		return respuesta;
	}
	
	public MaxColaCP<Comparendo> darNAlNorte(int n, String tipos)	
	{
		
		String[] tipo =tipos.split(","); 
		MaxColaCP<Comparendo> resp= new MaxColaCP<Comparendo>();

		int contador=0;
		Queue<Comparendo> aux=new Queue<Comparendo>();
		while(cola.darNumElementos()!=0&&contador<=n)
		{
			int j=0;
			boolean ya=false;
			while(j<tipo.length&&!ya)
			{
				if(cola.darMax().darClase().equalsIgnoreCase(tipo[j]))
				{
					resp.agregar(cola.darMax());
					ya=true;
					contador++;
				}
				j++;
			}
			if(!ya)
				aux.enqueue(cola.darMax());
			cola.sacarMax();

		}
		while(!aux.estaVacia())
			cola.agregar(aux.dequeue());
		return resp;
	}
	public ArregloDinamico<Comparendo> darNNorte(int n, String tipos)	
	{
		String[] tipo =tipos.split(","); 
		ArregloDinamico<Comparendo> resp= new ArregloDinamico(100);

		int contador=0;

		while(heap.darNumElementos()!=0&&contador<=n)
		{
			int j=0;
			boolean ya=false;
			while(j<tipo.length&&!ya)
			{
				if(heap.darMax().darClase().equalsIgnoreCase(tipo[j]))
				{
					resp.agregar(heap.darMax());
					ya=true;
					contador++;
				}
				j++;
			}
			heap.sacarMax();

		}
		return resp;
	}
}
