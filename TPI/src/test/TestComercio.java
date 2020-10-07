package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestComercio {
    public static void main(final String[] args) throws Exception {
    	
    	System.out.println("ESCENARIO 1: ");
    	try {
    		System.out.println("COMERCIO VALIDANDO CUIT FORZANDO EXCEPCION ");
    		Ubicacion ubicacionComercio = new Ubicacion(30,20);
			Contacto contactoComercio = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacionComercio);			
    		Comercio almacenGranate = new Comercio(0,contactoComercio,"Almacen Granate", 30353242343L, 20, 10, 3,10, 5);
    		System.out.println(almacenGranate);
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
    	System.out.println("\nESCENARIO 2: GENERANDO COMERCIO , ARTICULOS , ITEMS  ");
    	try {
    		System.out.println("");
    		System.out.println("COMERCIO ");
    		Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);	
    		Comercio almacenGranate = new Comercio(1,contacto,"Almacen Granate", 20353242343L, 20, 10, 3,10, 5);
    		
    		almacenGranate.agregarDiaRetiro(1,LocalTime.of(8,0), LocalTime.of(9,0), 15); 
    		almacenGranate.agregarDiaRetiro(3,LocalTime.of(8,0), LocalTime.of(9,0), 15);
    		
    		System.out.println(almacenGranate);    		
    		System.out.println("");
    		System.out.println("LISTA ARTICULOS : ");
    		almacenGranate.agregarArticulo("Coca Cola 2Lts", "1234567876788",100);
    		almacenGranate.agregarArticulo("Pepsi Cola 2Lts", "5678987654322",90);
    		almacenGranate.agregarArticulo("Agua Mineral 1Lts", "3333333333338",80);
    		almacenGranate.agregarArticulo("Galletitas Pepas", "4444444444444",50);
    		System.out.println(almacenGranate.getLstArticulo());
    		
    		Ubicacion ubicacionCliente = new Ubicacion(30,20);
			Contacto contactoCliente = new Contacto("email@gmail.com", "+5491122334455", ubicacionCliente);
			Cliente cliente = new Cliente(0, contactoCliente, "Perez", "Federico", 30123456, 'M');
			System.out.println("AGREGANDO ITEMS A CARRITO: ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),2);
			carrito1.agregarItem(almacenGranate.traerArticulo(3),1);
			carrito1.agregarItem(almacenGranate.traerArticulo(3),2);
			System.out.println(carrito1.mostrarItem(carrito1));
			
			Carrito carrito2 = new Carrito();
			carrito2.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito2.agregarItem(almacenGranate.traerArticulo(2),2);
			carrito2.agregarItem(almacenGranate.traerArticulo(3),1);
			carrito2.agregarItem(almacenGranate.traerArticulo(3),2);			
			
			almacenGranate.agregarCarrito(LocalDate.now(), false, 23D, cliente, carrito1.mostrarItem(carrito1), null);
			almacenGranate.agregarCarrito(LocalDate.now(), true, 23D, cliente, carrito1.mostrarItem(carrito2), null);
			
    		//System.out.println(carrito1.mostrarItem(carrito1));
    		System.out.println("");
    		System.out.println("CARRITO: ");
			System.out.println(almacenGranate.traerCarrito(1));
			System.out.println("");
			System.out.println(almacenGranate.traerCarrito(2));
			
			System.out.println("TOTAL: ");
			System.out.print("Subtotal Item 3: ");
			System.out.println(carrito2.calcularSubTotalItem(almacenGranate.traerArticulo(3)));
			
			//Mostrar total
			System.out.print("Total Carrito 2: ");
			System.out.println(carrito2.calcularTotalCarrito());

			//Descuento Efectivo
			System.out.print("Total Descuento Efecivo: ");
			System.out.println(carrito2.calcularDescuentoDia(30));

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
    	
		// Ultima Version 3.0  
    
    }

}
