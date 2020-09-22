package test;

import modelo.Cliente;
import modelo.Contacto;
import modelo.Ubicacion;

public class TestCliente {
    public static void main(String[] args) throws Exception {
        Ubicacion u = new Ubicacion(0, 0);
        Contacto c = new Contacto("email@hotmail.com", "+5491122334455", u);
        Cliente cl = new Cliente(0, c, "Perez", "Federico", 12345678, 'M');
        System.out.println(cl.toString());
    }
}
