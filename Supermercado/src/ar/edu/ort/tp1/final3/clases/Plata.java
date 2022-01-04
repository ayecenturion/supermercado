package ar.edu.ort.tp1.final3.clases;

public class Plata extends Cliente{
	
	private static double DESCUENTO = 0.20;
	private static double PR_MAX = 300;

	public Plata(String nombre, int edad, double dineroIngresado, Clientes tipo) {
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
		boolean tiene = false;
		
		if(precio>=PR_MAX) {
			tiene = true;
		}
		
		return tiene;
	}

}
