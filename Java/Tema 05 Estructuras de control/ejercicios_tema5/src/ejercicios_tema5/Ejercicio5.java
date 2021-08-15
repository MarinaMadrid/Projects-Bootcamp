package ejercicios_tema5;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio5 {
	// Clase encargada de la entrada y salida del teclado
	static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		int numero;
		int respuesta;
		boolean correcto = false;

		System.out.println("Generando número");
		// Genera un número aleatorio
		numero = (int) (Math.random() * 100);

		// Número del usuario
		System.out.println("¿Serás capaz de averiguarlo?");
		System.out.println("Introduzca un número: ");
		respuesta = entrada.nextInt();

		if (numero == respuesta) {
			correcto = true;
			ganador(correcto);
		} else {
			do {
				if (numero < respuesta) {
					System.out.println("El número es más pequeño");
					respuesta = entrada.nextInt();
				} else {
					System.out.println("El número es más grande");
					respuesta = entrada.nextInt();
				}
			} while (numero != respuesta);
			correcto = true;
			ganador(correcto);
		}
		
		entrada.close();
		
		}
		
	public static void ganador(boolean correcto){
		if (correcto == true) {
			System.out.println("Correcto!! Acertaste");
		} 
		
		
	}
}
