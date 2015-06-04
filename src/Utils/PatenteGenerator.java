package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

/**
 * Clase usada para crear las patentes 
 * Puede utilizarse como un standalone
 * Usage:
 * PatenteGenerator <Cant. de autos a generar> <Cantidad de Meses a Procesar> <Cantidad de autos por dia>
 *
 */

public class PatenteGenerator
{
	
	public static void main (String args[] ) {
		int[] argumentos = null;
		
		if ((args.length > 0) && (args.length < 3)) {
			System.out.println("Cantidad de argumentos invalida");
			System.out.println("Usage:");
			System.out.println("PatenteGenerator <Cant. de autos a generar> <Cantidad de Meses a Procesar> <Cantidad de autos por dia>");
		}
		else if (args.length == 0)
			shuffle(PatenteGenerator.generar(10),6,4);
		else {
			
			try {
				argumentos = new int[3];
				argumentos[0] = Integer.parseInt(args[0]);
				argumentos[1] = Integer.parseInt(args[1]);
				argumentos[2] = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			shuffle(PatenteGenerator.generar(argumentos[0]), argumentos[1], argumentos[2]);
		}
	}
	
	/**
     * Devuelve un array de patentes
     * @param int cantidad
     * @return String[]
     */
	public static String[] generar(int cantidad)
	{
		Random rnd = new Random();
		int i = 0;
		int j;
		String valor = "";
		HashSet<String> conjunto = new HashSet<String>();
		while (i < cantidad)
		{
			for (j = 0; j < 3; j++)
			{
				valor += String
						.valueOf(Character.toChars(rnd.nextInt(26) + 65));
			}

			for (j = 0; j < 3; j++)
			{
				valor += ((Integer) rnd.nextInt(10)).toString();
			}

			if (!conjunto.contains(valor))
			{
				conjunto.add(valor);
				i++;
			}
			valor = "";

		}
		return conjunto.toArray(new String[conjunto.size()]);
	}
	
	public static void shuffle (String[] patentes, int cantidadDeMeses, int autosPorDia) {
		String seleccionado = null;
		String fecha = null;
		PrintWriter output = null;
		int dia;
		int mes;
		
		try {
			output = new PrintWriter(new FileWriter("Patentes.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i <= cantidadDeMeses; i++){
			mes = i;
			
			for (int j = 1; j <= 30; j++) {
				dia = j;
				
				for (int k = 0; k < autosPorDia; k++) {
					seleccionado = patentes[((int) (Math.random() * (patentes.length * ((int) (Math.random() * 11))))) % patentes.length ];
					fecha = dia  + "-" + mes + "-2015";
					
					output.println(seleccionado + "," + fecha);
				}
			}
		}
		output.close();
	}
}
