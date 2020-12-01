//Federico Perez -> 35324234 -> src
package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;

public class Test {

    public static void main(String[] args) {

        LocalDate testDia;
        LocalTime testHora;
        LocalTime testHoraHasta;
        OperadorMovil operadorOrigen;
        OperadorMovil operadorDestino;

        System.out.println("1.1)");

        Sistema sistema = new Sistema();

        testDia = LocalDate.of(2020, 12, 11);
        testHora = LocalTime.of(17, 37, 0);

        operadorOrigen = new OperadorMovil(1, "Personal");
        operadorDestino = new OperadorMovil(2, "Claro");

        try {            
            if(sistema.agregarSMS(testDia, testHora, 1523456780, 156543210, "Voy a llegar más tarde", operadorOrigen,
                    operadorDestino)){
                        System.out.println("Agregado Correctamente");
                        System.out.println(sistema.imprimirUltimoMensaje());
                    }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.2)");

        testDia = LocalDate.of(2020, 12, 11);
        testHora = LocalTime.of(17, 37, 0);

        operadorOrigen = new OperadorMovil(1, "Personal");
        operadorDestino = new OperadorMovil(2, "Claro");

        try {
            if(sistema.agregarSMS(testDia, testHora, 1523456780, 1565432109, "Voy a llegar más tarde", operadorOrigen,
                    operadorDestino)){
                        System.out.println(sistema.imprimirUltimoMensaje());
                        System.out.println("Agregado Correctamente");
                    }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.3)");

        testDia = LocalDate.of(2020, 12, 13);
        testHora = LocalTime.of(15, 16, 0);

        try {
            if(sistema.agregarEmail(testDia, testHora, "informacion@unla.gob.ar", "alumno.com", "Información - UNLa", "Estimado alumno, le enviamos el protocolo para rendir el examen final virtual")){
                System.out.println("Agregado Correctamente");
                System.out.println(sistema.imprimirUltimoMensaje());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.4)");

        testDia = LocalDate.of(2020, 12, 13);
        testHora = LocalTime.of(15, 16, 0);

        try {
            if(sistema.agregarEmail(testDia, testHora, "informacion@unla.gob.ar", "alumno@gmail.com", "Información - UNLa", "Estimado alumno, le enviamos el protocolo para rendir el examen final virtual")){
                System.out.println("Agregado Correctamente");
                System.out.println(sistema.imprimirUltimoMensaje());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2.1)");

        System.out.println(sistema.traerMensaje(1));

        System.out.println("2.2)");
        System.out.println(sistema.traerMensaje(2));

        System.out.println("3)");

        //SMS (1)

        testDia = LocalDate.of(2020, 11, 15);
        testHora = LocalTime.of(12, 03, 0);

        operadorOrigen = new OperadorMovil(3, "Movistar");
        operadorDestino = new OperadorMovil(2, "Claro");

        try {            
            if(sistema.agregarSMS(testDia, testHora, 1523456780, 1598760883, "Recibido OK", operadorOrigen,
                    operadorDestino)){
                        System.out.println("SMS Agregado Correctamente");
                        //System.out.println(sistema.imprimirUltimoMensaje());
                    }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //SMS (2)

        testDia = LocalDate.of(2020, 11, 15);
        testHora = LocalTime.of(12, 03, 0);

        operadorOrigen = new OperadorMovil(1, "Personal");
        operadorDestino = new OperadorMovil(3, "Movistar");

        try {            
            if(sistema.agregarSMS(testDia, testHora, 1523456780, 1598768250, "Gracias", operadorOrigen,
                    operadorDestino)){
                        System.out.println("SMS Agregado Correctamente");
                        //System.out.println(sistema.imprimirUltimoMensaje());
                    }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //EMAIL (1)
        
        testDia = LocalDate.of(2020, 11, 8);
        testHora = LocalTime.of(17, 15, 0);

        try {
            if(sistema.agregarEmail(testDia, testHora, "oo1@unla.gob.ar", "alumno@gmail.com.ar", "Orientación a Objetos 1 - UNLa", "Se adjunta la grilla de inscripciones al final de Diciembre")){
                System.out.println("Email Agregado Correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //EMAIL (2)

        testDia = LocalDate.of(2020, 12, 10);
        testHora = LocalTime.of(8, 19, 0);

        try {
            if(sistema.agregarEmail(testDia, testHora, "informacion@gmail.com.ar", "cliente@gmail.com.ar", "Ofertas", "Aproveche nuestras Ofertas")){
                System.out.println("Email Agregado Correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("4-1)");

        System.out.println(sistema.traerMensaje("Personal"));

        
        System.out.println("4-2)");

        testDia = LocalDate.of(2020, 12, 10);
        testHora = LocalTime.of(8, 0, 0);
        testHoraHasta = LocalTime.of(14, 0, 0);

        System.out.println(sistema.traerMensaje(testDia, testHora, testHoraHasta));

        System.out.println("4-3)");

        testDia = LocalDate.of(2020, 12, 15);
        testHora = LocalTime.of(12, 0, 0);
        testHoraHasta = LocalTime.of(13, 0, 0);

        System.out.println(sistema.traerMensaje(testDia, testHora, testHoraHasta, "Movistar"));

        //No llegue con el tiempo a comprobar por que no imprime las listas, estan los metodos preparados
        
    }    
}
