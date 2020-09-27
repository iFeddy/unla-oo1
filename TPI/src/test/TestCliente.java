package test;

import modelo.Cliente;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestCliente {
	public static void main(String[] args) throws Exception {
		
		/*UBICACION 
		  Escenario 1 , TREYENDO UBICACION */ 
		try {
			System.out.println("UBICACION: ");
			Ubicacion u = new Ubicacion(30,20);
			System.out.println("Ubicacion ingresada : " + u.traerUbicacion());			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}		
		// Escenario 2 , TRAYENDO UBICACION forzando excepci�n longitud y latitud incorrrectos .		
		try {
			Ubicacion u = new Ubicacion(30, 400);
			System.out.println("Mi ubicacion es  : " + u.traerUbicacion());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		/*CONTACTO
		  Escenario 1 , TRAYENDO CONTACTO */
		try {
			System.out.println("");
			System.out.println("CONTACTO : ");
			Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			System.out.println(contacto);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		/*CONTACTO
		  Escenario 2 , TRAYENDO CONTACTO , validando direccion de email */
		try {
			Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("email@gmail", "+5491122334455", ubicacion);
			System.out.println(contacto);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		/*CLIENTE
		  Escenario 1 , TRAYENDO CLIENTE */
		try {
			System.out.println("");
			System.out.println("CLIENTE : ");
			Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			Cliente cliente = new Cliente(0, contacto, "Perez", "Federico", 30123456, 'M');
			System.out.println(cliente);			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		/*CLIENTE
		  Escenario 2 , TRAYENDO CLIENTE , validando DNI */
		try {
			Ubicacion ubicacion = new Ubicacion(30,20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			Cliente cliente = new Cliente(0, contacto, "Perez", "Federico", 301234567, 'M');
			System.out.println(cliente);			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}					
	}
}
