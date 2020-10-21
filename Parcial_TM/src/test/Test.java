package test;

import java.time.LocalDate;

import modelo.*;

public class Test {

    public static void main(String[] args) {

        System.out.println("1.1)");

        Sistema sistema = new Sistema();
        try {
            if(sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4)){
                System.out.println("Agregado Correctamente");
            }              
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      

        System.out.println("1.2)");

        try{
            if(sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4)){
                System.out.println("Agregado Correctamente");
            }     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      

        System.out.println("1.3)");

        try{
            if(sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0)){
                System.out.println("Agregado Correctamente");
            }     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   

        System.out.println("1.4)");

        try{
            if(sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0)){
                System.out.println("Agregado Correctamente");
            }     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   

        System.out.println("2.1)");
        LocalDate dia = LocalDate.of(2020, 10, 28); 
        Servicio servicio = sistema.traerServicio("489235");
        System.out.println("$ " + servicio.calcularPrecioFinal(dia));

        System.out.println("2.2)");
        LocalDate dia2 = LocalDate.of(2020, 10, 27); 
        Servicio servicio2 = sistema.traerServicio("287282");
        System.out.println("$ " + servicio2.calcularPrecioFinal(dia2));

        System.out.println("3)");
        int agregados = 0;
        try{
            if(sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3)){
                agregados++;
            }
            if(sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0)){
                agregados++;
            }
            if(sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3)){
                agregados++;
            }
            if(sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0)){
                agregados++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Agregados " + agregados + " Servicios Nuevos");
        System.out.println("Lista: " + sistema);

        System.out.println("4.1)");
        System.out.println(sistema.traerServicio(true));

        System.out.println("4.2)");
        LocalDate dia4 = LocalDate.of(2020, 10, 28); 
        System.out.println(sistema.traerServicio(true, dia4));
    }    
}
