package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Utils.PatenteGenerator;

public class SistemaDeAtencionInterfaz {
	public static SistemaDeAtencion clientes;
	
	public static void prepareStuff(String msg) {
		prn(msg);
		PatenteGenerator.main(new String[0]);
		clientes = new SistemaDeAtencion("Patentes.csv");
		prn("Done");
		prn("");
	}
	
	private static void header() {
		prn(String.format("%-20s","Sistema de Atención al Cliente"));
		prn(String.format("%-20s","------------------------------"));
		prn("");
	}
	
	private static void menu() {
		prn("Seleccionar una opción:");
		prn("1.- Listado alfabetico de clientes (Segun patente)");
		prn("2.- Listar clientes segun frecuencia de visita");
		prn("3.- Listar descuentos realizados por dia");
		prn("4.- Configurar/Generar archivo de datos de entrada");
		prn("5.- Salir");
		prn("");
	}
	
	private static void menuArchivoDePatentes() {
		Set<Integer> opcionesValidas  = new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
		
		prn("1.- Indicar archivo de datos pregenerado");
		prn("2.- Generar un nuevo archivo de datos aleatorio");
		prn("3.- Volver");
		
		
	}
	
	private static void prn(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		BufferedReader lector;
		String linea = null;
		Set<Integer> opcionesValidas  = new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
		int opcion = -1;
		
		prepareStuff("Preparando un conjunto de patentes inicial");
		header();
		menu();
		
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
					break;
			case 2: clientes.printOrdenPorFrecuencia();
					break;
			case 3: clientes.printDescuentosPorDia();
					break;
			case 4: 
			
		}
		
		/*
		int cantidad = 100;
		
		String[] patentes = PatenteGenerator.generar(cantidad);
		
		for (int i = 0; i < patentes.length; i++)
		{
			System.out.println(patentes[i].toString());
		}
		*/
	}

}
