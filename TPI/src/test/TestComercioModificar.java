package test;

import modelo.Articulo;
import modelo.Comercio;

public class TestComercioModificar {

	public static void main(String[] args) {

		Comercio almacenGranate = new Comercio();
		
		// Escenario 1 , AGREGANDO ARTICULOS sin forzar la excepci�n. 
		try {
			System.out.println("LISTA DE ARTICULOS : ");
			almacenGranate.agregarArticulo("Pure de Tomates", "1234567876788", 50);
			almacenGranate.agregarArticulo("Leche Entera", "5678987654322",60);
			almacenGranate.agregarArticulo("Cerveza de Lata", "3333333333338", 60);
			almacenGranate.agregarArticulo("Fideos Tallarines", "4444444444444", 80);
			System.out.println(almacenGranate.getLstArticulo());
		
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}		
		
		// Escenario 1, MODIFICANDO ARTICULOS: NOMBRE Y PRECIO
		try {
			System.out.println("");
			System.out.println("MODIFICANDO ARTICULOS: ");
			Articulo articulo1 = new Articulo();	
			articulo1=almacenGranate.traerArticuloNombre("Pure de Tomates");
			System.out.println(articulo1);
			almacenGranate.modificarArticulo(articulo1.getId(),"Pur� de Tomates", articulo1.getCodBarras(), 40);
			System.out.println(almacenGranate.getLstArticulo());
			articulo1=almacenGranate.traerArticuloNombre("Leche Entera");
			System.out.println(articulo1);
			almacenGranate.modificarArticulo(articulo1.getId(),"Leche Entera Larga Vida", articulo1.getCodBarras(),70);
			System.out.println(almacenGranate.getLstArticulo());
			
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		// Escenario 2, MODIFICANDO ARTICULO: NO PERTENECIENTE A LA LISTA
		try {
			System.out.println("");
			System.out.println("MODIFICANDO ARTICULOS: ");
			Articulo articulo1 = new Articulo();	
			articulo1=almacenGranate.traerArticuloNombre("Tomates Enlatados");		
			System.out.println("Articulo: "+articulo1);
			almacenGranate.modificarArticulo(articulo1.getId(),"Pur� de Tomates", articulo1.getCodBarras(), 40);
			System.out.println(almacenGranate.getLstArticulo());
					
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage()); //devuelve null porque no hay nada en getId ni en getCodigoBarras
		}		

	}

}
