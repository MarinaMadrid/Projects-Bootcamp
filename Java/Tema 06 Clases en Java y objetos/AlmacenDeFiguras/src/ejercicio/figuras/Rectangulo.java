package ejercicio.figuras;

public class Rectangulo {
	// CAMPOS
	float base, altura;
	double area;
	String color;

	// CONSTRUCTORES
	public Rectangulo() {}
	
	public Rectangulo(float base, float altura, double area, String color) {
		this.base = base;
		this.altura = altura;
		this.area = area;
		this.color = color;
	}

	// get and set
	public float getBase() {
		return base;
	}

	public float getAltura() {
		return altura;
	}

	public double getArea() {
		return area;
	}

	public String getColor() {
		return color;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + ", area=" + area + ", color=" + color + "]";
	}

	// OTROS METODOS DE LA CLASE
	public double calcularArea() {
		float resultado = base * altura;
		double redondeo = Math.round(resultado*100.0)/100.0;
		return redondeo;
	}

}