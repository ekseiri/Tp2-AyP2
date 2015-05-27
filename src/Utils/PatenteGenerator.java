package Utils;

import java.util.HashSet;
import java.util.Random;

public class PatenteGenerator
{

	public PatenteGenerator()
	{

	}

	public String[] generar(int cantidad)
	{
		Random rnd = new Random();
		int i;
		String valor = "";
		HashSet<String> conjunto = new HashSet<String>();
		while (cantidad < 10)
		{
			for (i = 0; i < 3; i++)
			{
				valor += String
						.valueOf(Character.toChars(rnd.nextInt(26) + 65));
			}

			for (i = 0; i < 3; i++)
			{
				valor += ((Integer) rnd.nextInt(10)).toString();
			}

			if (!conjunto.contains(valor))
			{
				conjunto.add(valor);
				cantidad++;
			}
			valor = "";

		}
		return (String[]) conjunto.toArray();
	}
}
