package ejercicio;

import java.util.Locale;
import java.util.Scanner;

import ejercicio.figuras.Circulo;
import ejercicio.figuras.Rectangulo;
import ejercicio.figuras.Triangulo;

public class Main {

	// Clase encargada de la entrada y salida del teclado
	private static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

	private static String elegirColor = "Elige un color para la figura: ";
	private static String elegirBase = "Introduzca la base de la figura: ";
	private static String elegirAltura = "Introduzca la altura de la figura: ";
	private static String elegirRadio = "Introduzca el radio de la figura: ";

	public static void main(String[] args) {
		int operacion;
		boolean salir = false;
		Rectangulo rectUser = new Rectangulo();
		Triangulo triaUser = new Triangulo();
		Circulo circleUser = new Circulo();

		while (!salir) {
			System.out.print("Elige el tipo de figura que quieres consultar:");
			System.out.println("1 - Rectángulo / 2 - Círculo / 3 - Triángulo /" + " 4 - Comparar Rectángulo y Triángulo /"
					+ " 5 - Comparar Rectángulo y Límite/" +  " 6 - Salir");
			operacion = entrada.nextInt();
			switch (operacion) {
			case 1:
				System.out.println(elegirColor);
				String colorRectUser = entrada.next();
				float baseRectUser = baseRectangulo();
				float alturaRectUser = alturaRectangulo();
				
				rectUser = new Rectangulo(baseRectUser, alturaRectUser, 0, colorRectUser);
				double areaRectUser = rectUser.calcularArea();
				rectUser.setArea(areaRectUser);
				
				System.out.println(rectUser.toString());
				salir = true;
				break;
			case 2:		
				System.out.println(elegirColor);
				String colorCircleUser = entrada.next();
				float radioCircleUser = radioCirculo();
				
				circleUser = new Circulo(radioCircleUser, 0, colorCircleUser);
				double areaCircleUser = circleUser.calcularArea();
				circleUser.setArea(areaCircleUser);
								
				System.out.println(circleUser.toString());
				salir = true;
				break;
			case 3:
				System.out.println(elegirColor);
				String colorTriaUser = entrada.next();
				float baseTriaUser = baseTriangulo();
				float alturaTriaUser = alturaTriangulo();
				
				triaUser = new Triangulo(baseTriaUser, alturaTriaUser, 0, colorTriaUser);
				double areaTriaUser = triaUser.calcularArea();
				triaUser.setArea(areaTriaUser);
				
				System.out.println(triaUser.toString());
				salir = true;
				break;
			case 4:
				//Antes
				rectUser = new Rectangulo(3, 2, 6, "rojo");
				triaUser = new Triangulo(1, 2, 1, "rojo");
				
				//Después
				compararRectanguloTriangulo(rectUser, triaUser);
				System.out.println(rectUser.toString());
				salir = true;
				break;
			case 5:
				//Antes
				rectUser = new Rectangulo(3, 2, 6, "rojo");
				int lim = 3;
								
				//Después
				compararRectanguloConLimite(rectUser, lim);
				salir = true;
				break;
			case 6:
				System.out.println("Espero que le haya sido de utilidad el programa.");
				salir = true;
				break;
			default:
				System.out.println("Elige una opción entre 1-6");
			}
		}
		entrada.close();
	}

	// Base del rectángulo
	public static float baseRectangulo() {
		System.out.println(elegirBase);
		float baseRectUser = entrada.nextFloat();
		return baseRectUser;
	}

	// Altura del rectángulo
	public static float alturaRectangulo() {
		System.out.println(elegirAltura);
		float alturaRectUser = entrada.nextFloat();
		return alturaRectUser;
	}

	// Base del triángulo
	public static float baseTriangulo() {
		System.out.println(elegirBase);
		float baseTriaUser = entrada.nextInt();
		return baseTriaUser;
	}

	// Altura del triángulo
	public static float alturaTriangulo() {
		System.out.println(elegirAltura);
		float alturaTriaUser = entrada.nextInt();
		return alturaTriaUser;
	}

	// Radio del círculo
	public static float radioCirculo() {
		System.out.println(elegirRadio);
		float radioCircleUser = entrada.nextFloat();
		return radioCircleUser;
	}

	// Comparación del rectángulo con el triángulo
	public static boolean compararRectanguloTriangulo(Rectangulo rect, Triangulo tria) {
		System.out.println(rect.toString());
		rect.setBase(10);
		rect.setAltura(10);
		rect.setArea(100);
		return rect.getArea() > tria.getArea();
	}

	// Comparación del rectángulo con el límite
	public static boolean compararRectanguloConLimite(Rectangulo rectUser, int lim) {
		System.out.println("Variable lim fuera del método = " + lim);
		lim = lim + 2;
		System.out.println("Variable lim en el método = " + lim);
		return rectUser.getArea() > lim;
	}

}
