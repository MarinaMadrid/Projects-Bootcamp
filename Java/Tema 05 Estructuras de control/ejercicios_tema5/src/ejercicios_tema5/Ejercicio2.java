package ejercicios_tema5;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {
	// Clase encargada de la entrada y salida del teclado
	static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		System.out.println("EJERCICIO 2");
		System.out.println("Selecciona un mes: ");
		System.out.println("1 - Enero / 2 - Febrero / 3 - Marzo / 4 - Abril / "
		 + "Mayo / 6 - Junio / 7 - Julio / 8 - Agosto / 9 - Septiembre /"
		 + " 10 - Octubre / 11 - Noviembre / 12 - Diciembre");

		// Permite capturar lo que se escribe por teclado
		int mes = entrada.nextInt();
		
		switch (mes) {
		  case 2: 
		    System.out.println("28 días");
		    break;
		  case 4:
		  case 6:
		  case 9:
		  case 11:
		    System.out.println("30 días");
		    break;
		  default:
		    System.out.println("31 días");
		}
		
		entrada.close();
	}

}
