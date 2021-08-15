package ejercicio.figuras;

public class Circulo {
	// CAMPOS
	float radio;
	double area;
	String color;

	// CONSTRUCTORES
	public Circulo() {}

	public Circulo(float radio, double area, String color) {
		this.radio = radio;
		this.area = area;
		this.color = color;
	}

	// get and set
	public float getRadio() {
		return radio;
	}

	public double getArea() {
		return area;
	}

	public String getColor() {
		return color;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", area=" + area + ", color=" + color + "]";
	}

	// OTROS METODOS DE LA CLASE
	public double calcularArea() {
		float resultado = (float) (Math.PI * radio * radio);
		double redondeo = Math.round(resultado*100.0)/100.0;
		return redondeo;
	}
}