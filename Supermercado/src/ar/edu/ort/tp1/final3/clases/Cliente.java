package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public abstract class Cliente implements ClienteDescontable {
	private static final String NOMBRE_INVALIDO = "El nombre no puede ser nulo ni vacio";
	private static final String MENOR_EDAD = "El cliente no puede ser menor de edad";
	private static final String SALDO_NEGATIVO = "El saldo no puede ser negativo";
	private static final String PRODUCTO_REPETIDO = "No se puede repetir un producto";
	private String nombre;
	private int edad;
	private double dineroIngresado;
	private Clientes tipo;
	private Pila<Producto> productos;
	
	
	
	public Cliente(String nombre, int edad, double dineroIngresado, Clientes tipo) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setDineroIngresado(dineroIngresado);
		this.setTipo(tipo);
		this.productos = new PilaNodos<>();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre.isEmpty() || nombre==null) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
		
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		if(edad<18) {
			throw new IllegalArgumentException(MENOR_EDAD);
		}
		this.edad = edad;
	}

	public double getDineroIngresado() {
		return dineroIngresado;
	}

	private void setDineroIngresado(double dineroIngresado) {
		if(dineroIngresado<0) {
			throw new IllegalArgumentException(SALDO_NEGATIVO);
		}
		this.dineroIngresado = dineroIngresado;
	}

	public Clientes getTipo() {
		return tipo;
	}

	private void setTipo(Clientes tipo) {
		this.tipo = tipo;
	}
	
	public Pila<Producto> getProductos() {
		return productos;
	}

	public void agregarProducto(Producto producto) {
		Producto p ;
		if(!this.productos.isEmpty()) {
			p = buscarProducto(producto);
			if(p == null) {
				this.productos.push(producto);
			}else {
				throw new IllegalArgumentException(PRODUCTO_REPETIDO);
			}
		}else {
			this.productos.push(producto);
		}
		
	}

	private Producto buscarProducto(Producto producto) {
		
		PilaNodos<Producto> pilaAux = new PilaNodos<>();
		Producto actual;
		Producto buscado = null;
		actual = this.productos.pop();
		pilaAux.push(actual);
		
		while(!this.productos.isEmpty() && buscado == null) {
			if(actual.equals(producto)) {
				buscado = actual;
			}
		}
		
		pasarElementos(pilaAux, productos);
		
		return buscado;
	}

	private void pasarElementos(PilaNodos<Producto> pilaAux, Pila<Producto> productos) {
		while(!pilaAux.isEmpty()) {
			productos.push(pilaAux.pop());
		}
	}

	public boolean puedeComprar(double total) {
		
		boolean puede = false;
		
		if(this.dineroIngresado>=total) {
			puede=true;
			this.setDineroIngresado(this.dineroIngresado - total);
		}
		
		return puede;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", edad=" + edad + ", dineroIngresado=" + dineroIngresado + ", tipo="
				+ tipo + "]";
	}
	
	

}
