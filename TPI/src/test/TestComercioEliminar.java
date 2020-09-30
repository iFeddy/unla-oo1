package Test;

import modelo.Carrito;
import modelo.Comercio;

public class TestComercioEliminar {

	public static void main(String[] args) {

		Comercio almacenGranate = new Comercio();
		
		// Escenario 1 , AGREGANDO ARTICULOS sin forzar la excepción. 
		try {
			System.out.println("LISTA DE ARTICULOS : ");
			almacenGranate.agregarArticulo("Primer Producto", "1234567876788", 50);
			almacenGranate.agregarArticulo("Segundo Producto", "5678987654322",40);
			almacenGranate.agregarArticulo("Tercer Producto", "3333333333338", 60);
			almacenGranate.agregarArticulo("Cuarto Producto", "4444444444444", 70);
			
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
			carrito1.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),4);
			carrito1.agregarItem(almacenGranate.traerArticulo(3),5);
			carrito1.agregarItem(almacenGranate.traerArticulo(4),6);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		//Escenario 1: ELIMINANDO ITEMS: MISMA CANTIDAD DE ARTICULOS
		try {
			System.out.println("");
			System.out.println("AGREGANDO ITEMS : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),4);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),3);
			System.out.println("ELIMINANDO ITEMS : ");
			carrito1.eliminarItem(almacenGranate.traerArticulo(1),3);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		//Escenario 2: ELIMINANDO ITEMS: RESTANDO CANTIDAD DE ARTICULOS
		try {
			System.out.println("");
			System.out.println("AGREGANDO ITEMS : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),4);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),3);
			System.out.println("ELIMINANDO ITEMS : ");	
			carrito1.eliminarItem(almacenGranate.traerArticulo(1),1);//resta 1 al producto 1
			carrito1.eliminarItem(almacenGranate.traerArticulo(2),2);//resta 2 al producto 2
			System.out.println(carrito1.mostrarItem(carrito1));
		} 
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
	}

}

