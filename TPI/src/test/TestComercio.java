package test;

import java.time.LocalTime;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestComercio {
	public static void main(final String[] args) throws Exception {

		System.out.println("ESCENARIO 1: ");
		try {
			System.out.println("COMERCIO VALIDANDO CUIT FORZANDO EXCEPCION ");
			Ubicacion ubicacionComercio = new Ubicacion(30, 20);
			Contacto contactoComercio = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacionComercio);
			Comercio almacenGranate = new Comercio(0, contactoComercio, "Almacen Granate", 30353242343L, 20, 10, 3, 10,
					5);
			System.out.println(almacenGranate);

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println("\nESCENARIO 1: AGREGANDO COMERCIO Y DIAS DE RETIRO, SIN FORZAR EXCEPCION   ");
		try {
			System.out.println("");
			System.out.println("COMERCIO ");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);
			Comercio almacenGranate = new Comercio(1, contacto, "Almacen Granate", 20353242343L, 20, 10, 3, 10, 5);
			// dias de retiro
			almacenGranate.agregarDiaRetiro(1, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			almacenGranate.agregarDiaRetiro(3, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			almacenGranate.agregarDiaRetiro(4, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			System.out.println(almacenGranate);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println("\nESCENARIO 2: AGREGANDO DIA DE RETIRO EXISTENTE , FORZANDO EXCEPCION");
		try {
			System.out.println("");
			Ubicacion ubicacion = new Ubicacion(30, 20);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);
			Comercio almacenGranate = new Comercio(1, contacto, "Almacen Granate", 20353242343L, 20, 10, 3, 10, 5);

			almacenGranate.agregarDiaRetiro(1, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(8, 0), LocalTime.of(9, 0), 15);

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		// Ultima Version 4.0

	}

}
