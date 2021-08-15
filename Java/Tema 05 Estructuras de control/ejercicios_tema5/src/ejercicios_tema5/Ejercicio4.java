package ejercicios_tema5;

import java.util.Locale;
import java.util.Scanner;


public class Ejercicio4 {
	// Clase encargada de la entrada y salida del teclado
	static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);
	
	public static void main(String[] args) {	
		System.out.println("EJERCICIO 1");
		System.out.println("¿Quieres salir del bucle?");
		int salir = entrada.nextInt();
		if (salir == 1) {
			System.out.println("Ya has salido del bucle.");
		} else {
			do {
				System.out.println("¿Quieres salir del bucle?");
				salir = entrada.nextInt();
			} while (salir != 1);
			System.out.println("Ya has salido del bucle.");
		}
		
		entrada.close();
	}
}
