package test;

import java.time.LocalDate;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestComercio {
    public static void main(final String[] args) throws Exception {
    	
    	try {
    		System.out.println("COMERCIO ");
    		Comercio almacenGranate = new Comercio("Almacen Granate", 20353242343L, 20, 10, 3,10, 5, null, null, null);
    		System.out.println(almacenGranate);    		
    		System.out.println("");
    		System.out.println("LISTA ARTICULOS : ");
    		almacenGranate.agregarArticulo("Coca Cola 2Lts", "1234567876788",100);
    		almacenGranate.agregarArticulo("Pepsi Cola 2Lts", "5678987654322",90);
    		almacenGranate.agregarArticulo("Agua Mineral 1Lts", "3333333333338",80);
    		almacenGranate.agregarArticulo("Galletitas Pepas", "4444444444444",50);
    		System.out.println(almacenGranate.getLstArticulo());
    		
    		Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			Cliente cliente = new Cliente(0, contacto, "Perez", "Federico", 30123456, 'M');
			System.out.println("AGREGANDO ITEMS A CARRITO : ");
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2),2);
			carrito1.agregarItem(almacenGranate.traerArticulo(3),1);
			carrito1.agregarItem(almacenGranate.traerArticulo(3),2);
						
    		almacenGranate.agregarCarrito(1, LocalDate.now(), true, 23D, cliente, carrito1.mostrarItem(carrito1), null);
    		System.out.println(carrito1.mostrarItem(carrito1));
    		System.out.println("");
    		System.out.println("CARRITO : ");
    		System.out.println(almacenGranate.traerCarrito(1));
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		//c.setCuit(20353242343L); // CUIT de la UNLA    
    }

}
