package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaPorPrecio extends ListaOrdenadaNodos<Integer,Compra>{

	@Override
	public double compare(Compra c1, Compra c2) {
		return c1.getPrecio() - c2.getPrecio();
	}

	@Override
	public int compareByKey(Integer clave, Compra c) {
		return  clave-c.getId();
	}

}
