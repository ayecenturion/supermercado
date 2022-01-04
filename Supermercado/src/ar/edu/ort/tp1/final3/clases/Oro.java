package ar.edu.ort.tp1.final3.clases;

public class Oro extends Cliente{
	
	private static double DESCUENTO = 0.50;
	
	public Oro(String nombre, int edad, double dineroIngresado, Clientes tipo) {
		super(nombre, edad, dineroIngresado, tipo);
	}

	@Override
	public double realizarDescuento(double precio) {
		double conDescuento = 0;
		
		double desc = precio*DESCUENTO;
		conDescuento = precio - desc;
		
		return conDescuento;
	}

	@Override
	public boolean tieneDescuento(double precio) {
		return true;
	}

}
