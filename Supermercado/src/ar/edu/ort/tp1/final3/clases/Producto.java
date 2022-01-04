package ar.edu.ort.tp1.final3.clases;

public class Producto {

	private String nombre;
	private double precio;

	public Producto(String nombre, double precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	

}
