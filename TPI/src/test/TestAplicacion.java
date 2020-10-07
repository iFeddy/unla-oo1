package test;

import java.time.LocalTime;

import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestAplicacion {

	public static void main(String[] args) {
    	try {
    		// COMERCIO CON SU CONTACTO Y UBICACION . 
    		System.out.println("Almacen Granate");
            System.out.println("--------------------------------------------------\n");
    		Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);	
    		Comercio almacenGranate = new Comercio(1,contacto,"Almacen Granate", 20353242343L, 20, 10, 3,10, 5);
    		
    		// AGREGANDO DIAS DE RETIRO
    		
    		almacenGranate.agregarDiaRetiro(1,LocalTime.of(8,0), LocalTime.of(9,0), 15); 
    		almacenGranate.agregarDiaRetiro(3,LocalTime.of(8,0), LocalTime.of(9,0), 15);
    		almacenGranate.agregarDiaRetiro(4,LocalTime.of(8,0), LocalTime.of(9,0), 30);
    		
    		// AGREGANDO ARTICULOS AL COMERCION
    		
    		almacenGranate.agregarArticulo("Coca Cola 2Lts","1234567876788",100);
    		almacenGranate.agregarArticulo("Pepsi Cola 2Lts","5678987654322",90);
    		almacenGranate.agregarArticulo("Agua Mineral 1Lts","3333333333338",80);
    		almacenGranate.agregarArticulo("Galletitas Pepas","4444444444444",50);
    		almacenGranate.agregarArticulo("Sachet de leche","9999999999994",50);
    		
    		
    		System.out.println(almacenGranate);  
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		

	}

}
