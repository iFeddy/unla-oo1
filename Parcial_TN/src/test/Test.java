package test;

import modelo.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("Licenciatura en Sistemas - Orientación a Objetos 1 - ​Parcial ​2020");

        Sistema sistema = new Sistema();

        System.out.println("1.1)");
        try {
            if(sistema.agregarServicio("718392", "Mantenimiento hidrolavadora", 2700.0, 10.0, true)){
                //si devuelve true se agrego
                System.out.println("El Servicio se Agrego Correctamente");
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.2)");
        try {
            if(sistema.agregarServicio("7183921", "Mantenimiento hidrolavadora", 2700.0, 10.0, true)){
                //si devuelve true se agrego
                System.out.println("El Servicio se Agrego Correctamente");
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.3)");
        try {
            if(sistema.agregarProducto("782951", "Diyuntor", 4500.0, 25.0, true)){
                //si devuelve true se agrego
                System.out.println("El Producto se Agrego Correctamente");
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1.4)");
        try {
            if(sistema.agregarProducto("7829512", "Diyuntor", 4500.0, 25.0, true)){
                //si devuelve true se agrego
                System.out.println("El Producto se Agrego Correctamente");
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2.1)");

        Mercancia mercancia = sistema.traerMercancia("7183921");
        System.out.println("$ " + mercancia.calcularPrecioFinal());

        System.out.println("2.2)");

        Mercancia mercancia2 = sistema.traerMercancia("7829512");
        System.out.println("$ " + mercancia2.calcularPrecioFinal());


        System.out.println("3.1)");
        int agregados = 0;
        try{
            if(sistema.agregarProducto("3780173", "Lampara led 9W", 330.0, 10.0, true)){
                agregados++;
            }
            if(sistema.agregarServicio("1973851", "Mantenimiento de martillo neumático", 3500.0, 10.0, true)){
                agregados++;
            }
            if(sistema.agregarProducto("4897183", "Lampara led 11W", 450.0, 10.0, false)){
                agregados++;
            }
            if(sistema.agregarServicio("2891728", "Mantenimiento aire acondicionado", 2250.0, 10.0, false)){
                agregados++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Agregadas " + agregados + " Tipos de Mercancias Nuevas");

        System.out.println("3.2)");
        try {
            if(sistema.agregarServicio("2891728", "Mantenimiento aire acondicionado", 2250.0, 10.0, false)){
                System.out.println("El Servicio se Agrego Correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3.3)");
        try {
            if(sistema.agregarProducto("3780173", "Lampara led 9W", 330.0, 10.0, true)){
                System.out.println("El Producto se Agrego Correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("4.1)");
        System.out.println(sistema.traerMercancia(true));

        System.out.println("x) Impresion de Sistema Completo");
        System.out.println(sistema);
    }    
}