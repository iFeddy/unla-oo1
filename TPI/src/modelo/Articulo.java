package modelo;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	
	public Articulo(){
		
	}
	
	public Articulo(int id, String nombre, String codBarras, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public boolean equals(Object arti) {
		Articulo nombre = (Articulo)arti;
		  if (this.nombre.equals(nombre.getNombre())) {
		      return true;
		    }
		    return false;
	}

	@Override
	public String toString() {		
		return "\n " + id + "\t   " + nombre + "   \t       " + codBarras + "\t       " + precio + "";
	}
	
	// VALIDAR CODIGO DE BARRAS
	
	public boolean isValidBarCodeEAN(String codBarras) {
        int digit;
        int calculated;
        String ean;
        String checkSum = "131313131313";
        int sum = 0;

        if (codBarras.length() == 8 || codBarras.length() == 13) {
            digit = Integer.parseInt("" + codBarras.charAt(codBarras.length() - 1));            
            ean = codBarras.substring(0, codBarras.length() - 1);            
            for (int i = 0; i <= ean.length() - 1; i++) {
                sum += (Integer.parseInt("" + ean.charAt(i))) * (Integer.parseInt("" + checkSum.charAt(i)));
            }            
            calculated = 10 - (sum % 10);            
            return (digit == calculated);
        } else {
            return false;
        }
	}
		
}
