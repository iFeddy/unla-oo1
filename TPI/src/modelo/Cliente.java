package modelo;

public class Cliente extends Actor{
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;
	
	public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni, char sexo) throws Exception {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.setDni(dni);
		this.sexo = sexo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception {
		if(Funciones.validarDNI(dni)){
			this.dni = dni;
		}else{
			throw new Exception("Error: El DNI no es correcto");
		}		
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Apellido : " + apellido + ", Nombre : " + nombre
				+ ", DNI : " + dni + ", Sexo : " + sexo + ", ";
	}
	

}
