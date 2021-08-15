package ejercicios_tema5;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1 {
	// Clase encargada de la entrada y salida del teclado
		static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {	
		System.out.println("EJERCICIO 1");
		System.out.println("¿Está lloviendo?: ");
		System.out.println("1 - Si / 2 - No");
		// Permite capturar lo que se escribe por teclado
		int llueve = entrada.nextInt();
		System.out.println("¿Tienes un paraguas?: ");
		System.out.println("1 - Si / 2 - No");
		// Permite capturar lo que se escribe por teclado
		int paraguas = entrada.nextInt();
		
		if (llueve == 1 && paraguas == 1) {
			System.out.println("Coge el paraguas.");
		} else if (llueve == 1 && paraguas == 2) {
			System.out.println("Compra un paraguas.");
		} else {
			System.out.println("Vamos a la playa.");
		}
		
		entrada.close();
	}

}
