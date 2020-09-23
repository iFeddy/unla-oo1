package test;

import modelo.Cliente;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestCliente {
	public static void main(String[] args) throws Exception {
		
		/*UBICACION 
		  Escenario 1 , TREYENDO UBICACION */ 
		try {
			Ubicacion u = new Ubicacion(30,20);
			System.out.println("Mi ubicacion es : " + u.traerUbicacion());			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}		
		// Escenario 2 , TRAYENDO UBICACION forzando excepción longitud y latitud incorrrectos .		
		try {
			Ubicacion u = new Ubicacion(30, 400);
			System.out.println("Mi ubicacion es  : " + u.traerUbicacion());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		Ubicacion u = new Ubicacion(20,30);
		Contacto c = new Contacto("email@hotmail.com", "+5491122334455", u);
		Cliente cl = new Cliente(0, c, "Perez", "Federico", 30123456, 'M');
		System.out.println(cl);
		System.out.println(c);
		
		
		
	}
}
