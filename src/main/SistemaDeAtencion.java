package main;

import Utils.PatenteGenerator;

public class SistemaDeAtencion {

	public static void main(String[] args) {
		int cantidad = 1;
		String[] patentes = PatenteGenerator.generar(cantidad);
		
		for (int i = 0; i < cantidad; i++)
		{
			System.out.println(patentes[cantidad].toString());
		}
	}

}
