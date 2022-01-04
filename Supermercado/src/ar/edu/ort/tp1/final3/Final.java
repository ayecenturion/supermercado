package ar.edu.ort.tp1.final3;

import ar.edu.ort.tp1.final3.clases.*;

public class Final {

	public static void main(String[] args) {

		System.out.println("Final 3 TP1");

		Supermercado supermercado = new Supermercado();

		// Creo datos de prueba
		Producto producto1 = new Producto("Coca-cola", 80);
		Producto producto2 = new Producto("Chocolate", 50);
		Producto producto3 = new Producto("Cerveza", 30);
		Producto producto4 = new Producto("Manteca", 20);
		Producto producto5 = new Producto("Asado", 500);
		Producto producto6 = new Producto("Caramelo", 5);

		// Pruebas de Errores
		Cliente cliente1 = supermercado.crearCliente(Clientes.COBRE, "Mateo", 18, 1);
		Cliente cliente2 = supermercado.crearCliente(Clientes.COBRE, "Juan", 1, 100);
		Cliente cliente3 = supermercado.crearCliente(Clientes.COBRE, "Pedro", 68, -1);
		Cliente cliente4 = supermercado.crearCliente(Clientes.COBRE, "", 21, 500);
		Cliente cliente5 = supermercado.crearCliente(Clientes.DIAMANTE, "Bob", 32, 6800);

		supermercado.agregarAlCarrito(cliente1, producto1);
		supermercado.agregarAlCarrito(cliente1, producto1);
		// Prueba de limite alcanzado
		supermercado.agregarAlCarrito(cliente1, producto1);

		supermercado.agregarAlCarrito(cliente2, producto1);
		supermercado.agregarAlCarrito(cliente3, producto1);
		supermercado.agregarAlCarrito(cliente4, producto1);
		supermercado.agregarAlCarrito(cliente5, producto1);

		supermercado.agregarAFila(cliente1);
		supermercado.agregarAFila(cliente2);
		supermercado.agregarAFila(cliente3);
		supermercado.agregarAFila(cliente4);
		supermercado.agregarAFila(cliente5);

		//supermercado.atenderCaja();
		// en esta instancia no se debe haber generado ninguna compra

		System.out.println("-------------------------");
		// Pruebas de Exitos
		Cliente cliente6 = supermercado.crearCliente(Clientes.COBRE, "Donal", 18, 500);
		Cliente cliente7 = supermercado.crearCliente(Clientes.PLATA, "Scooby", 32, 1000);
		Cliente cliente8 = supermercado.crearCliente(Clientes.ORO, "Shaggy", 67, 700);
		Cliente cliente9 = supermercado.crearCliente(Clientes.COBRE, "Brian", 83, 850);
		Cliente cliente10 = supermercado.crearCliente(Clientes.PLATA, "Kevin", 26, 1050);
		Cliente cliente11 = supermercado.crearCliente(Clientes.ORO, "Patricio", 27, 876);
		
		
		
		supermercado.agregarAlCarrito(cliente6, producto3);
		supermercado.agregarAlCarrito(cliente6, producto4);
		supermercado.agregarAlCarrito(cliente7, producto5);
		supermercado.agregarAlCarrito(cliente7, producto6);
		supermercado.agregarAlCarrito(cliente8, producto2);
		supermercado.agregarAlCarrito(cliente9, producto3);
		supermercado.agregarAlCarrito(cliente10, producto4);
		supermercado.agregarAlCarrito(cliente11, producto5);

		supermercado.agregarAFila(cliente6);
		supermercado.agregarAFila(cliente7);
		supermercado.agregarAFila(cliente8);
		supermercado.agregarAFila(cliente9);
		supermercado.agregarAFila(cliente10);
		supermercado.agregarAFila(cliente11);

		supermercado.atenderCaja();

		supermercado.mostrarCompras();

	}

}

