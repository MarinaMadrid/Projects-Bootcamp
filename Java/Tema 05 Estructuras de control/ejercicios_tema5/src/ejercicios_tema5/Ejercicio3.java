package ejercicios_tema5;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 {
	// Clase encargada de la entrada y salida del teclado
		static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		System.out.println("EJERCICIO 3");
		System.out.println("Escribe un número: ");
		int num1 = entrada.nextInt();
		System.out.println("Escribe otro número: ");
		int num2 = entrada.nextInt();
		int repiticion = 0;
		int resultado = 0;
		
		do {
			resultado =  resultado + num1;
		    ++repiticion;
		} while (repiticion != num2);

		System.out.println("El resultado es: "+ resultado);
		
		entrada.close();
	}

}
