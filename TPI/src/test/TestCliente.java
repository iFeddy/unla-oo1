package test;

import modelo.Cliente;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestCliente {
	public static void main(String[] args) throws Exception {

		/* UBICACION */
		System.out.println("ESCENARIO 1: TRAYENDO UBICACION VALIDA");
		try {
			System.out.println("UBICACION: ");
			Ubicacion u = new Ubicacion(30, 20);
			System.out.println("Ubicacion ingresada : " + u.traerUbicacion());
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println("\nESCENARIO 2: TRAYENDO UBICACION FORZANDO EXCEPCIóN LONGITUD Y LATITUD CORRECTOS");
		try {
			System.out.println("");
			System.out.println("UBICACION , VALIDANDO LONGITUD Y LATITUD : ");
			Ubicacion u = new Ubicacion(30, 400);
			System.out.println("Mi ubicacion es  : " + u.traerUbicacion());

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		/* CONTACTO */
		System.out.println("\nESCENARIO 1: TRAYENDO CONTACTO");
		try {
			System.out.println("");
			System.out.println("CONTACTO : ");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			System.out.println(contacto);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		/* CONTACTO */
		System.out.println("\nESCENARIO 2: TRAYENDO CONTACTO VALIDANDO DIRECCI�N DE EMAIL");
		try {
			System.out.println("");
			System.out.println("CONTACTO , VALIDANDO EMAIL : ");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("email@gmail", "+5491122334455", ubicacion);
			System.out.println(contacto);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		/* CLIENTE */
		System.out.println("\nESCENARIO 1: TRAYENDO CLIENTE");
		try {
			System.out.println("");
			System.out.println("CLIENTE : ");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			Cliente cliente = new Cliente(0, contacto, "Perez", "Federico", 30123456, 'M');
			System.out.println(cliente);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		/* CLIENTE */
		System.out.println("\nESCENARIO 2: TRAYENDO CONTACTO VALIDANDO DNI");
		try {
			System.out.println("");
			System.out.println("CLIENTE , VALIDANDO DNI : ");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("email@gmail.com", "+5491122334455", ubicacion);
			Cliente cliente = new Cliente(0, contacto, "Perez", "Federico", 301234567, 'M');
			System.out.println(cliente);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}
}
