package Utils;

import java.util.HashSet;
import java.util.Random;

public class PatenteGenerator
{

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
}
