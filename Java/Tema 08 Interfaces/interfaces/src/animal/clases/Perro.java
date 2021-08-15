package animal.clases;

import animal.interfaces.Mamifero;
import animal.principal.Animal;

public class Perro implements Animal, Mamifero {
	String nombre;

	public Perro() {
		this.nombre = "Chucho";
	}

	public Perro(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String hablar() {
		return "Guau guau";
	}

	@Override
	public String darDeComer(String alimento) {
		return "Ñam ñam";
	}

	public String toString() {
		return "Soy un Perro y me llaman " + nombre;
	}

	@Override
	public String nacer() {
		return "Ha nacido un perrete";
	}
}