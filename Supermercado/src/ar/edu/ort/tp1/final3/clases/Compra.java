package ar.edu.ort.tp1.final3.clases;

public class Compra {

	private static int cantidadCompras;
	private int id;
	private Cliente cliente;
	private double precio;
	private boolean descuento;

	public Compra(double precio, Cliente cliente, boolean descuento) {
		this.id = cantidadCompras;
		cantidadCompras = cantidadCompras + 1;
		this.setPrecio(precio);
		this.cliente=cliente;
		this.descuento=descuento;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	public void mostrarTicket() {
		System.out.println("Compra [id=" + id + ", cliente=" + cliente + ", precio=" + precio + ", descuento=" + descuento + "]");
	}

	
	
}
