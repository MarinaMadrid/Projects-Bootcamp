package animal.clases;

import animal.interfaces.Felino;
import animal.interfaces.Mamifero;
import animal.principal.Animal;

public class Tigre implements Animal, Mamifero, Felino {
	String nombre;

	public Tigre() {
		this.nombre = "Simba";
	}

	public Tigre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String hablar() {
		return "Grooaarrrhhhh";
	}

	@Override
	public String darDeComer(String alimento) {
		if (alimento.equals("carne")) {
			return "Ñam Ñam";
		} else {
			return "No me gusta";
		}
	}

	public String toString() {
		return "Soy un Tigre y me llaman " + nombre;
	}

	@Override
	public String aranar() {
		return "El tigre te ha arañado";
	}

	@Override
	public String nacer() {
		return "Ha nacido un tigre";
	}
}