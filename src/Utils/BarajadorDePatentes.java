package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BarajadorDePatentes {
	
	public static void main (String args[] ) {
		
		
		shuffle(PatenteGenerator.generar(50));
	}
	
	public static void shuffle (String[] patentes) {
		String seleccionado = null;
		String fecha = null;
		PrintWriter output = null;
		int cantidadDeMeses = 3;
		int autosPorDia = 4;
		int dia;
		int mes;
		
		try {
			output = new PrintWriter(new FileWriter("Patentes.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//3 meses
		for (int i = 1; i <= (cantidadDeMeses * 30); i++){
			//4 autos por dia
			if (i > 60)
				dia = i - 60;
			else if (i > 30)
				dia = i - 30;
			else
				dia = i;
			
			if (dia >= 30)
				mes = i / 30;
			else
				mes = (i / 30) + 1;
			
			for (int j = 0; j < autosPorDia; j++) {
				seleccionado = patentes[((int) (Math.random() * (patentes.length * ((int) (Math.random() * 11))))) % patentes.length ];
				fecha = dia  + "-" + mes + "-2015";
				
				output.println(seleccionado + "," + fecha);
				
			}
		}
		output.close();
	}
}
