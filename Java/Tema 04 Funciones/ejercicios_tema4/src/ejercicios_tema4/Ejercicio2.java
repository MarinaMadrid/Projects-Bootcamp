package ejercicios_tema4;

import java.util.Scanner;

public class Ejercicio2 {
	public static Scanner Entrada;

	public static double calcularVolumenEsfera(double radio) {
		double resultado = (4.0 / 3) * Math.PI * Math.pow(radio, 3);
		return resultado;
	}

	public static void main(String[] args) {
		Entrada = new Scanner(System.in);
		double radio;
		System.out.print("Introduzca radio de la esfera: ");
		radio = Entrada.nextDouble();
		System.out.println("El volumen de la esfera con radio " + radio + " es " + calcularVolumenEsfera(radio));
		
		Entrada.close();
	}
	
}
