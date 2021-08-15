package animal.principal;

import java.util.Locale;
import java.util.Scanner;

import animal.clases.Gato;
import animal.clases.Perro;
import animal.clases.Tigre;

public class Main {
	// Clase encargada de la entrada y salida del teclado
	static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		int operacion;
		boolean salir = false;

		// CREAR OBJETOS
		Gato gat = new Gato();
		Perro per = new Perro();
		Tigre tig = new Tigre();

		while (!salir) {
			System.out.println("\nElige el tipo de animal: ");
			System.out.println(" 1 - Perro / 2 - Gato / 3 - Tigre / 4 - Salir");
			// Permite capturar lo que se escribe por teclado.
			operacion = entrada.nextInt();
			switch (operacion) {
			case 1:
				System.out.println(per.toString());
				System.out.println(per.hablar());
				System.out.println(darDeComer(per));
				break;
			case 2:
				System.out.println(gat.toString());
				System.out.println(gat.hablar());
				System.out.println(darDeComer(gat));
				break;
			case 3:
				System.out.println(tig.toString());
				System.out.println(tig.hablar());
				System.out.println(darDeComer(tig));
				break;
			case 4:
				System.out.println("Bye bye");
				salir = true;
				break;
			default:
				System.out.println("Seleccione otra operación");
			}
		}
	}

	public static String darDeComer(Animal ani) {
		boolean salir = false;
		String alimento = null;

		do {
			System.out.println("\n¿Qué le damos de comer?");
			System.out.println(" 1 - Carne / 2 - Pescado / 3 - Basura");
			int opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				alimento = "carne";
				salir = true;
				break;
			case 2:
				alimento = "pescado";
				salir = true;
				break;
			case 3:
				alimento = "basura";
				salir = true;
				break;
			default:
				System.out.println("Elija una de las opciones anteriores");
			}
		} while (!salir);

		return ani.darDeComer(alimento);
	}
}
