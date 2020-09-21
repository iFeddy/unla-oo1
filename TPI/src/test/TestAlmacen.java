package test;

import modelo.Carrito;
import modelo.Comercio;

public class TestAlmacen {

	public static void main(String[] args) {

		Comercio almacenGranate = new Comercio();
		
		// Escenario 1 , AGREGANDO ARTICULOS sin forzar la excepción. 
		try {
			System.out.println("LISTA DE ARTICULOS : ");
			almacenGranate.agregarArticulo("Cuarto Producto", "1234567876788", 50);
			almacenGranate.agregarArticulo("Quinto Producto", "5678987654322", 40);
			System.out.println(almacenGranate.getLstArticulo());
		
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		// Escenario 2 , AGREGANDO ARTICULOS forzando excepción , mismo codigo de Barras. 
		try {
			almacenGranate.agregarArticulo("Cuarto Producto", "1234567876788", 50);
			System.out.println(almacenGranate.getLstArticulo());
		
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		// Escenario 1 , AGREGANDO ITEMS A CARRITO
		try {
			System.out.println("");
			System.out.println("AGREGANDO ITEMS A CARRITO : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(0),3);
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(1),4);
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(1),3);
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(1),3);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("ELIMINANDO ITEMS : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(0),3);
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(1),4);
			carrito1.agregarItem(almacenGranate.getLstArticulo().get(1),3);
			carrito1.eliminarItem(almacenGranate.getLstArticulo().get(0), 3);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
	}

}
