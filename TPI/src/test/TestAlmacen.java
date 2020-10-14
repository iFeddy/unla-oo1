package test;

import modelo.Carrito;
import modelo.Comercio;

public class TestAlmacen {

	public static void main(String[] args) {

		Comercio almacenGranate = new Comercio();

		System.out.println("ESCENARIO 1: AGREGANDO ARTICULOS SIN FORZAR EXCEPCION");
		try {

			System.out.println("LISTA DE ARTICULOS : ");
			almacenGranate.agregarArticulo("Primer Producto", "1234567876788", 50);
			almacenGranate.agregarArticulo("Segundo Producto", "5678987654322", 40);
			almacenGranate.agregarArticulo("Tercer Producto", "3333333333338", 60);
			almacenGranate.agregarArticulo("Cuarto Producto", "4444444444444", 70);
			almacenGranate.agregarArticulo("Quinto Producto", "9999999999994", 50);

			System.out.println(almacenGranate.getLstArticulo());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 2: AGREGANDO ARTICULOS FORZANDO EXCEPCION MISMO CODIGO DE BARRAS");
		try {
			System.out.println("\nAGREGANDO ARTICULO MISMO COD.BARRAS:");
			almacenGranate.agregarArticulo("Cuarto Producto", "1234567876788", 50);
			System.out.println(almacenGranate.getLstArticulo());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 1: MODIFICANDO ARTICULO SIN FORZAR EXCEPCION");
		try {
			System.out.println("");
			System.out.println("MODIFICANDO ARTICULO :");
			almacenGranate.modificarArticulo(1, "Primer Articulo", "1234567876788", 60);
			System.out.println(almacenGranate.getLstArticulo());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 2: MODIFICANDO ARTICULOS FORZAR EXCEPCION ID INEXISTENTE");
		try {
			System.out.println("");
			System.out.println("MODIFICANDO ARTICULO INEXISTENTE " + ":");
			almacenGranate.modificarArticulo(9, "Ultimo Articulo", "1234567876788", 60);
			System.out.println(almacenGranate.getLstArticulo());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 1: ELIMINANDO ARTICULO SIN FORZAR EXCEPCION");
		try {
			System.out.println("");
			System.out.println("ELIMINANDO ARTICULO :");
			almacenGranate.eliminarArticulo(3);
			System.out.println(almacenGranate.getLstArticulo());
			System.out.println("AGREGANDO ARTICULO , luego de eliminar probando ultimo ID");
			almacenGranate.agregarArticulo("Ultimo Articulo", "2323232323234", 70);
			System.out.println(almacenGranate.getLstArticulo());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		// ACA
		System.out.println("\nESCENARIO 1: AGREGANDO ITEMS A CARRITO");
		try {
			System.out.println("");
			System.out.println("AGREGANDO ITEMS A CARRITO : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 4);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 2: AGREGANDO ITEMS A CARRITO, forzando excepcion Articulo de Item Inexistente");
		try {
			System.out.println("");
			System.out.println("AGREGANDO ITEMS A CARRITO : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 4);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);
			carrito1.agregarItem(almacenGranate.traerArticulo(33), 10); // Entra null no hay que comparar nada
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 1: ELIMINANDO ITEMS DEL CARRITO");
		try {
			System.out.println("\nELIMINANDO ITEMS: SI LA CANTIDAD ES LA MISMA ELIMINA TODO EL ITEM ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 4);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);

			carrito1.eliminarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.eliminarItem(almacenGranate.traerArticulo(2), 5);
			carrito1.eliminarItem(almacenGranate.traerArticulo(4), 1);
			carrito1.eliminarItem(almacenGranate.traerArticulo(5), 2);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println("\nESCENARIO 2: ELIMINANDO ITEMS DEL CARRITO , forzando excepcion Item Inexistente");
		try {
			System.out.println("\nELIMINANDO ITEMS:");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 4);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);

			carrito1.eliminarItem(almacenGranate.traerArticulo(55), 2);
			System.out.println(carrito1.mostrarItem(carrito1));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
