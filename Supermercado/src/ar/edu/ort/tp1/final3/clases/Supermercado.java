package ar.edu.ort.tp1.final3.clases;

import java.util.ArrayList;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class Supermercado {

	private static final String TIPO_CLIENTE_NO_ENCONTRADO = "El tipo de cliente que ha ingresado no se encuentra disponible";
	//private static final String CLIENTE_INEXISTENTE = "Cliente inexistente";
	private static final String CANCELAR_COMPRA = "La compra no se puede realizar";
	private ArrayList<Cliente> clientes;
	private Cola<Cliente> colaDeClientes;
	private ListaPorPrecio comprasPorPrecio;
	
	
	public Supermercado() {
		this.clientes = new ArrayList<>();
		this.colaDeClientes = new ColaNodos<>();
		this.comprasPorPrecio = new ListaPorPrecio();
	}

	public Cliente crearCliente(Clientes tipo, String nombre, int edad, double dinero) {
		
		boolean hayError;
		Cliente buscado = buscarCliente(nombre);
		
		try {
			if(tipo != Clientes.DIAMANTE && buscado == null) {
				hayError=false;
				try {
					buscado = agregarCliente(nombre, edad, dinero, tipo);
					
				}catch	(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}else {
				throw new IllegalArgumentException(TIPO_CLIENTE_NO_ENCONTRADO);
			}
		} catch (IllegalArgumentException e) {
			hayError=true;
			System.out.println(e.getMessage());
		}
		
		return buscado;
	}
	
	private Cliente agregarCliente(String nombre, int edad, double dinero, Clientes tipo) {
		Cliente c;
		if (tipo == Clientes.COBRE) {
			c = new Cobre(nombre, edad, dinero, tipo);
		} else if (tipo == Clientes.PLATA) {
			c = new Plata(nombre, edad, dinero, tipo);
		} else {
			c = new Oro(nombre, edad, dinero, tipo);
		}
		this.clientes.add(c);
		return c;
	}
	
	private Cliente buscarCliente(String nombre) {
		Cliente buscado = null;
		int i = 0;
		Cliente cAct;
		
		while(i<this.clientes.size() && buscado == null) {
			cAct = this.clientes.get(i);
			//System.out.println(cAct);
			if(cAct.getNombre().equalsIgnoreCase(nombre)) {
				buscado = this.clientes.get(i);
			}i++;
		}
		
		return buscado;
	}

	public void agregarAlCarrito(Cliente cliente, Producto producto) {
		//System.out.println(cliente.getNombre());
		if(cliente!= null) {
			try {
				cliente.agregarProducto(producto);	
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	public void agregarAFila(Cliente cliente) {
		if(cliente!= null) {
			this.colaDeClientes.add(cliente);
			System.out.println("Cliente agregado a la fila: " + cliente.getNombre());
		}
	}

	public void atenderCaja() {
		Cliente cent = new Cobre("@",30,1.0,Clientes.COBRE);
		Cliente aux;
	
		this.colaDeClientes.add(cent);
		aux = this.colaDeClientes.remove();

		while(aux!=cent) {
			if(aux!= null) {
				realizarCompra(aux);
			}
			aux = this.colaDeClientes.remove();
		}
	}

	public void realizarCompra(Cliente cliente) {
		Pila<Producto> carrito = cliente.getProductos();
		double precio = verPrecioCarrito(carrito);
		boolean hayError;
		
		try {
			if(cliente.puedeComprar(precio)==true) {
				hayError = false;
				agregarCompra(precio,cliente);
			}else {
				throw new IllegalArgumentException(CANCELAR_COMPRA);
			}
		} catch (IllegalArgumentException e) {
			hayError=true;
			System.out.println(e.getMessage());
		}	
		
	}
	
	private void agregarCompra(double precio, Cliente cliente) {
		double precioConDescuento = 0;
		if(cliente instanceof Cobre) {
			if(cliente.tieneDescuento(precio)) {
				precioConDescuento = cliente.realizarDescuento(precio);
			}else {
				precioConDescuento = precio;
			}
		}else if(cliente instanceof Plata) {
			if(cliente.tieneDescuento(precio)) {
				precioConDescuento = cliente.realizarDescuento(precio);
			}else {
				precioConDescuento = precio;
			}
		}else {
			if(cliente.tieneDescuento(precio)) {
				precioConDescuento = cliente.realizarDescuento(precio);
			}else {
				precioConDescuento = precio;
			}
		}
		this.comprasPorPrecio.add(new Compra(precioConDescuento,cliente,cliente.tieneDescuento(precio)));
	}

	public double verPrecioCarrito(Pila<Producto> carrito) {
		
		double total = 0;
		Pila<Producto> pilaAux = new PilaNodos<>();
		Producto p = null;
		
		while(!carrito.isEmpty()) {
			p = carrito.pop();
			pilaAux.push(p);
			if(p!=null) {
				total += p.getPrecio();
				
			}
			
		}
		return total;
	}

	public void mostrarCompras() {
		
		for (Compra c : this.comprasPorPrecio) {
			c.mostrarTicket();
		}
		
	}

}
