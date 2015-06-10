package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import estructuras.BinaryTree;
import Utils.PatenteGenerator;

public class SistemaDeAtencionInterfaz {
	public static SistemaDeAtencion clientes;
	
	public static void prepareStuff(String msg) {
		prn(msg);
		prn("");
		
		if (!new File("Patentes.csv").isFile())
			PatenteGenerator.main(new String[0]);
		
		clientes = new SistemaDeAtencion("Patentes.csv");
		prn("Done");
		prn("");
	}
	
	private static void header() {
		prn("Sistema de Atención al Cliente");
		prn("------------------------------");
	}
	
	private static void menu() {
		BufferedReader lector;
		String linea = null;
		Set<Integer> opcionesValidas  = new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
		int opcion = -1;
		
		while (opcion != 5) {
			prn("");
			prn("Seleccionar una opción:");
			prn("1.- Listado alfabetico de clientes (Segun patente)");
			prn("2.- Listado de clientes segun frecuencia de visita");
			prn("3.- Listado de descuentos realizados por dia");
			prn("4.- Configurar/Generar archivo de datos de entrada");
			prn("5.- Salir");
			prn("");
			
			while (!opcionesValidas.contains(opcion)){
				
				System.out.print("Seleccionar Opcion: ");
				
				try {
					lector = new BufferedReader(new InputStreamReader(System.in));
					linea = lector.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					opcion = Integer.parseInt(linea);
				} catch (NumberFormatException e) {
					System.out.println("Ingreso Inválido");
					opcion = -1;
				}
			}
			
			switch(opcion) {
				case 1:	clientes.printOrdenAlfabetico();
						opcion = -1;
						break;
				case 2: clientes.printOrdenPorFrecuencia();
						opcion = -1;
						break;
				case 3: clientes.printDescuentosPorDia();
						opcion = -1;
						break;
				case 4: menuArchivoDePatentes();
						opcion = -1;
						break;
			}
		}
	}
	
	private static void menuArchivoDePatentes() {
		BufferedReader lector;
		String linea = null;
		int opcion = -1;
		Set<Integer> opcionesValidas  = new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,3}));
		
		while (opcion != 3) {
			prn("1.- Indicar archivo de datos pregenerado");
			prn("2.- Generar un nuevo archivo de datos aleatorio");
			prn("3.- Volver");
			prn("");
			
			while (!opcionesValidas.contains(opcion)){
				
				System.out.print("Seleccionar Opcion: ");
				
				try {
					lector = new BufferedReader(new InputStreamReader(System.in));
					linea = lector.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					opcion = Integer.parseInt(linea);
				} catch (NumberFormatException e) {
					System.out.println("Ingreso Inválido");
					opcion = -1;
				}
			}
			
			switch(opcion) {
				case 1:	archivoDePatentesExterno();
						opcion = -1;
						break;
				case 2: generarNuevoArchivo();
						opcion = -1;
						break;
			}
		}
	}
	
	private static void archivoDePatentesExterno() {
		BufferedReader file = null; 
		BufferedReader lector = null;
		String linea = null;
		
		prn("");
		prn("Ingresar ruta completa del archivo (Ej.: C:\\Archivos de Patentes\\archivo.txt)");
		
		try {
			lector = new BufferedReader(new InputStreamReader(System.in));
			linea = lector.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			file = new BufferedReader(new FileReader(linea));
		} catch (IOException e) {
			prn("No se puede abrir el archivo");
		}
		
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clientes = new SistemaDeAtencion(linea);
		prn("Done");
		prn("");
		
	}
	
	public static void generarNuevoArchivo() {
		BufferedReader lector = null;
		String linea = null;
		int autos = -1;
		int meses = -1;
		int autosPD = -1;
		
		while (autos == -1) {	
			prn("");
			prn("Cantidad de Autos a Generar:");
			
			try {
				lector = new BufferedReader(new InputStreamReader(System.in));
				linea = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				autos = Integer.parseInt(linea);
			} catch (NumberFormatException e) {
				System.out.println("NaN");
			}
			
			if (autos < 1) {
				prn("La cantidad debe ser >= 1");
				autos = -1;
			}
		}
		
		while (meses == -1) {
			prn("");
			prn("Cantidad de meses a simular:");
						
			try {
				lector = new BufferedReader(new InputStreamReader(System.in));
				linea = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				meses = Integer.parseInt(linea);
			} catch (NumberFormatException e) {
				prn("NaN");
			}
			
			if ((meses < 1) && (meses > 12)) {
				prn("La cantidad de meses debe estar entre 1 y 12");
				meses = -1;
			}	
		}
		
		while (autosPD == -1) {	
			prn("");
			prn("Cantidad de Autos por dia:");
			
			try {
				lector = new BufferedReader(new InputStreamReader(System.in));
				linea = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				autosPD = Integer.parseInt(linea);
			} catch (NumberFormatException e) {
				prn("NaN");
			}
			
			if (autosPD < 1) {
				prn("La cantidad debe ser >= 1");
				autosPD = -1;
			}
		}
		
		if (new File("Patentes.csv").isFile()) {
			linea = "";
			while ((!linea.equals("s")) && (!linea.equals("n"))) {
				prn ("");
				prn ("Sobreescribir archivo de patentes? (s/n)");
				
				try {
					lector = new BufferedReader(new InputStreamReader(System.in));
					linea = lector.readLine().toLowerCase().trim();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
			 
		if (linea.equals("s")) {
			PatenteGenerator.shuffle(PatenteGenerator.generar(autos),meses,autosPD);
			clientes = new SistemaDeAtencion("Patentes.csv");
			prn("Done");
			prn("");
		}
		
	}
	
	private static void prn(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		
		prepareStuff("Preparando el conjunto de patentes inicial");
		header();
		menu();
		
	}

}
