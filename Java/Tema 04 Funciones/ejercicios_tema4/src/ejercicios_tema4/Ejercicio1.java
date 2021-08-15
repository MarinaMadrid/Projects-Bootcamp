package ejercicios_tema4;

import java.util.Scanner;

public class Ejercicio1 {
	public static Scanner Entrada;

	public static int sumarNumeros(int numero1, int numero2) {
		int total = numero1 + numero2;
		return total;
	}

	public static int restarNumeros(int numero1, int numero2) {
		int total = numero1 - numero2;
		return total;
	}

	public static int multiplicarNumeros(int numero1, int numero2) {
		int total = numero1 * numero2;
		return total;
	}

	public static boolean dividirValidacion(int numero1, int numero2) {
		if (numero2 == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static int dividirNumeros(int numero1, int numero2) {
		int total = numero1 / numero2;
		return total;
	}

	public static void main(String[] ARGUMENTOS) {
		Entrada = new Scanner(System.in);
		System.out.print("Introduce el primer número: ");
		int numero1 = Entrada.nextInt();

		System.out.print("Introduce el segundo número: ");
		int numero2 = Entrada.nextInt();

		System.out.println("El resultado de sumar los números es: " + sumarNumeros(numero1, numero2));
		System.out.println("El resultado de restar los números es: " + restarNumeros(numero1, numero2));
		System.out.println("El resultado de multiplicar los números es: " + multiplicarNumeros(numero1, numero2));
		if (dividirValidacion(numero1, numero2) == false) {
			System.out.println("No se puede dividir entre 0.");
		} else {
			System.out.println("El resultado de dividir los números es: " + dividirNumeros(numero1, numero2));
		}

		Entrada.close();
	}
}