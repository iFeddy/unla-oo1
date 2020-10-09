package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.RetiroLocal;
import modelo.Cliente;
import modelo.Carrito;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Entrega;
import modelo.Envio;
import modelo.Ubicacion;

public class TestAplicacion {

	public static void main(String[] args) {
		LocalDate fecha = LocalDate.of(2020, 9, 29);// fecha dia martes utilizada en diferentes partes del test
		LocalTime horaDesde = LocalTime.of(10, 00);
		LocalTime horaHasta = LocalTime.of(17, 00);
		
		LocalDate fecha1 = LocalDate.of(2020, 9, 29);// 
		LocalTime horaDesde1 = LocalTime.of(11, 00);
		LocalTime horaHasta1 = LocalTime.of(17, 00);
		
		try {
    
    		// COMERCIO CON SU CONTACTO Y UBICACION . 
			System.out.println("------------------------------------------------------------------------------------------------------------");
    		System.out.println("                                             ALMACEN GRANATE");
            System.out.println("------------------------------------------------------------------------------------------------------------");
    		Ubicacion ubicacion = new Ubicacion(-30,-50);
			Contacto contacto = new Contacto("AlmacenGranate@gmail.com", "+5491122334455", ubicacion);	
    		Comercio almacenGranate = new Comercio(1,contacto,"Almacen Granate", 20353242343L, 20, 10, 3,5, 10);    	
    		   		    	    	
    		//AGREGANDO DIAS DE RETIRO    		
    		almacenGranate.agregarDiaRetiro(1,horaDesde, horaHasta, 20); 
    		almacenGranate.agregarDiaRetiro(2,horaDesde, horaHasta, 20);
    		almacenGranate.agregarDiaRetiro(3,LocalTime.of(8,0), LocalTime.of(18,0), 30);
    		almacenGranate.agregarDiaRetiro(4,LocalTime.of(8,0), LocalTime.of(17,0), 30);
    		
    		// AGREGAMOS CLIENTES 
    		Ubicacion ubicacionContacto1 = new Ubicacion(-40, -60);
    		Contacto contactoSejas= new Contacto("Sejas@gmail.com", "1137400798", ubicacionContacto1);

    		Ubicacion ubicacionContacto2 = new Ubicacion(38, -59.385312);
    		Contacto contactoPerez = new Contacto("Perez@gmail.com", "1132547698", ubicacionContacto2);

    		Ubicacion ubicacionContacto3 = new Ubicacion(-40, -58.368515);
    		Contacto contactoPiñeyro = new Contacto("Pineyro@gmail.com", "1111223344", ubicacionContacto3);
    		
    		Cliente cliente1 = new Cliente(2, contactoSejas, "Sejas", "Diego", 35007121L, 'H');
			Cliente cliente2 = new Cliente(3, contactoPerez, "Perez", "Federico", 40500720L, 'H');
			Cliente cliente3 = new Cliente(4, contactoPiñeyro, "Cario", "Piñeyro", 41926641L, 'H');
			
    		// AGREGANDO ARTICULOS AL COMERCIO 
    		System.out.println(almacenGranate);    		
    		System.out.println("");
    		System.out.println("LISTA ARTICULOS : ");
    		almacenGranate.agregarArticulo("Coca Cola 2Lts","1234567876788",100);
    		almacenGranate.agregarArticulo("Pepsi Cola 2Lts","5678987654322",90);
    		almacenGranate.agregarArticulo("Agua Mineral 1Lts","3333333333338",80);
    		almacenGranate.agregarArticulo("Galletitas Pepas","4444444444444",50);
    		almacenGranate.agregarArticulo("Pure de Tomates","6666667777774",60);
    		almacenGranate.agregarArticulo("Aceite 1Lts","4444444443331",200);
    		almacenGranate.agregarArticulo("Yogur Entero","4444444444468",100);    		    		
    		System.out.println(almacenGranate.getLstArticulo());
    					    	
			// AGREGANDO ITEMS A CARRITO 1
			Carrito carrito1 = new Carrito();
			carrito1.agregarItem(almacenGranate.traerArticulo(1), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(2), 3);
			carrito1.agregarItem(almacenGranate.traerArticulo(3), 1);
			carrito1.agregarItem(almacenGranate.traerArticulo(4), 5);
			carrito1.agregarItem(almacenGranate.traerArticulo(5), 6);
			System.out.println(almacenGranate.traerCarrito(1));

			// AGREGANDO ITEMS A CARRITO 2
			Carrito carrito2 = new Carrito();
			carrito2.agregarItem(almacenGranate.traerArticulo(1),3);
			carrito2.agregarItem(almacenGranate.traerArticulo(2),2);
			carrito2.agregarItem(almacenGranate.traerArticulo(3),1);
			carrito2.agregarItem(almacenGranate.traerArticulo(3),2);
			
			// AGREGANDO ITEMS A CARRITO 3
			Carrito carrito3 = new Carrito();
			carrito3.agregarItem(almacenGranate.traerArticulo(5), 3);
			carrito3.agregarItem(almacenGranate.traerArticulo(6), 2);
			carrito3.agregarItem(almacenGranate.traerArticulo(7), 1);
			
			// creo la entrega por retiroLocal con la primer hora disponible de la fecha
			Entrega entregaLocal = new RetiroLocal(1, fecha, true, almacenGranate.traerHoraRetiro(fecha));
			Entrega entregaLocal1 = new RetiroLocal(2, fecha1, true, almacenGranate.traerHoraRetiro(fecha1));
			
			// creo la entrega por Envio
			Entrega entregaEnvio = new Envio(2, fecha, false, horaDesde, horaHasta, almacenGranate.getContacto().getUbicacion(),
					almacenGranate.getCostoFijo(), almacenGranate.getCostoPorKm(), cliente2.getContacto().getUbicacion());

			// agrego la entrega a los carritos
			carrito1.setEntrega(entregaLocal);
			carrito2.setEntrega(entregaEnvio);
			carrito3.setEntrega(entregaLocal1);				

			// cierro los carritos
			carrito1.setCerrado(true);
			almacenGranate.addLstCarrito(carrito1);
			carrito2.setCerrado(true);
			almacenGranate.addLstCarrito(carrito2);
			carrito3.setCerrado(true);
			almacenGranate.addLstCarrito(carrito3);
			
			
			
			// AGREGAMOS LOS TRES CARRITOS
			almacenGranate.agregarCarrito(LocalDate.now(),LocalTime.of(12, 40), false, 23D, cliente1, carrito1.mostrarItem(carrito1));
			almacenGranate.agregarCarrito(LocalDate.now(),LocalTime.of(8, 50), false, 23D, cliente2, carrito2.mostrarItem(carrito2));
			almacenGranate.agregarCarrito(LocalDate.now(),LocalTime.of(9, 30), false, 23D, cliente3, carrito3.mostrarItem(carrito3));
	
			/* ESTARIA FALTANDO EL DESCUENTO EN EFECTIVO O DEL DIA , APLICA EL MAYOR . 
			 * Calculo de descuentos si es que corresponde. calcularDescuentoDia y
			 * calcularDescuentoEfectivo estan implementados en calcularDescuentoCarrito
			 
			carrito2.calcularDescuentoCarrito(carrito2.getFecha().getDayOfWeek().getValue(),
			almacenGranate.getPorcentajeDescuentoDia(), almacenGranate.getPorcentajeDescuentoEfectivo());*/
			
			
    		System.out.println("");
    		System.out.println("CARRITOS: ");
    		System.out.println("------------------------------------------------------------------------------------------------------------");    		
			System.out.println(almacenGranate.traerCarrito(1));
			//Calculo los totales e imprimo
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("\nSubTotal Carrito : $" + almacenGranate.getLstCarrito().get(0).calcularTotalCarrito());
			System.out.print("Descuento : $");
			System.out.println(carrito1.calcularTotalCarrito() - carrito1.totalAPagarCarrito());
			System.out.println("Total con Descuentos : $" + almacenGranate.getLstCarrito().get(0).totalAPagarCarrito());
			System.out.println("Entrega : " + almacenGranate.getLstCarrito().get(0).getEntrega());
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------------------------------------"); 		
			System.out.println(almacenGranate.traerCarrito(2));
			//Calculo los totales e imprimo
			//System.out.println(almacenGranate.getLstCarrito().get(0).getLstItemCarrito());
			System.out.println("\nSubTotal Carrito : $" + almacenGranate.getLstCarrito().get(1).calcularTotalCarrito());
			System.out.print("Descuento = $");
			System.out.println(carrito2.calcularTotalCarrito() - carrito2.totalAPagarCarrito());
			System.out.println("Total con Descuentos : $" + almacenGranate.getLstCarrito().get(1).totalAPagarCarrito());
			System.out.println("Entrega : " + almacenGranate.getLstCarrito().get(1).getEntrega());
			
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------------------------------------");  		
			System.out.println(almacenGranate.traerCarrito(3));
			//Calculo los totales e imprimo
			//System.out.println(almacenGranate.getLstCarrito().get(0).getLstItemCarrito());
			System.out.println("\nSubTotal Carrito : $" + almacenGranate.getLstCarrito().get(2).calcularTotalCarrito());			
			System.out.print("Descuento = $");
			System.out.println(carrito3.calcularTotalCarrito() - carrito3.totalAPagarCarrito());
			System.out.println("Total con Descuentos : $" + almacenGranate.getLstCarrito().get(2).totalAPagarCarrito());
			System.out.println("Entrega : " + almacenGranate.getLstCarrito().get(2).getEntrega());
			
			System.out.println("------------------------------------------------------------------------------------------------------------");
			
			// imprimo la agenda
			System.out.println("Agenda de la fecha: "+ almacenGranate.generarAgenda(fecha));
			System.out.println("\n");// saltos de linea
			System.out.println("Turnos ocupados: "+ almacenGranate.traerTurnosOcupados(fecha));
			System.out.println("\n");// saltos de linea
			System.out.println("Turnos disponibles: "+ almacenGranate.generarTurnosLibres(fecha));
			// TURNOS
			//System.out.println("[Turnos] Miercoles 7-10-2020 \n" + almacenGranate.generarTurnosLibres(LocalDate.of(2020, 10, 7)));

    		 // V. 4.1
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

		

	}

}
