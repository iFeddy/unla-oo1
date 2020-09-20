package test;

import modelo.Articulo;

public class TestAlmacen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Articulo art1 = new Articulo(1, "nada", "123456787678", 12);
		System.out.println(art1.isValidBarCodeEAN("0054321223457s"));
	}

}
