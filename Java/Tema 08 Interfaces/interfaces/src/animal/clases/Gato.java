package animal.clases;

import animal.interfaces.Felino;
import animal.interfaces.Mamifero;
import animal.principal.Animal;

public class Gato implements Animal, Mamifero, Felino {
	String nombre;

	public Gato() {
		this.nombre = "Missi";
	}

	public Gato(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String hablar() {
		return "Miauuuuu";
	}

	@Override
	public String darDeComer(String alimento) {
		if (alimento.equals("pescado")) {
			return "Ñam Ñam";
		} else {
			return "No me gusta";
		}
	}

	public String toString() {
		return "Soy un Gato y me llaman " + nombre;
	}

	@Override
	public String aranar() {
		return "El gato te ha arañado";
	}

	@Override
	public String nacer() {
		return "Ha nacido un gatete";
	}
}