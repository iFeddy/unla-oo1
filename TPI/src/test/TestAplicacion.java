package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Entrega;
import modelo.Envio;
import modelo.Ubicacion;

public class TestAplicacion {

	public static void main(String[] args) {
    	try {
    		// COMERCIO CON SU CONTACTO Y UBICACION . 
    		System.out.println("Almacen Granate");
            System.out.println("--------------------------------------------------\n");
    		Ubicacion ubicacion = new Ubicacion(-30,-50);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);	
    		Comercio almacenGranate = new Comercio(1,contacto,"Almacen Granate", 20353242343L, 20, 10, 3,10, 5);
    		
    		// AGREGANDO DIAS DE RETIRO
    		
    		almacenGranate.agregarDiaRetiro(1,LocalTime.of(8,0), LocalTime.of(9,0), 15); 
    		almacenGranate.agregarDiaRetiro(3,LocalTime.of(8,0), LocalTime.of(9,0), 15);
    		almacenGranate.agregarDiaRetiro(4,LocalTime.of(8,0), LocalTime.of(9,0), 30);
    		
    		// AGREGANDO ARTICULOS AL COMERCIO
    		
    		almacenGranate.agregarArticulo("Coca Cola 2Lts","1234567876788",100);
    		almacenGranate.agregarArticulo("Pepsi Cola 2Lts","5678987654322",90);
    		almacenGranate.agregarArticulo("Agua Mineral 1Lts","3333333333338",80);
    		almacenGranate.agregarArticulo("Galletitas Pepas","4444444444444",50);
    		almacenGranate.agregarArticulo("Sachet de leche","9999999999994",50);
    		
			// AGREGANDO UN CARRITO (CLIENTE)
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(3), 1);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);
			
			// TURNOS
			System.out.println("[Turnos] Miercoles 7-10-2020 \n" + almacenGranate.generarTurnosLibres(LocalDate.of(2020, 10, 7)));

    		//System.out.println(almacenGranate);  
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		

	}

}
