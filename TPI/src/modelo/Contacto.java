package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
	private String email;
	private String celular; //String???
	private Ubicacion ubicacion;
	
	public Contacto(String email, String celular, Ubicacion ubicacion)throws Exception {
		super();
		this.setEmail(email);
		this.celular = celular;
		this.ubicacion = ubicacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if(this.validarEmail(email)){
			this.email = email;
		}else{
			throw new Exception("Error: El EMAIL no es correcto");
		}		
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	// VALIDAR EMAIL
	private boolean validarEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	} 
	
	@Override
	public String toString() {
		return "\nEmail: " + email + " - Tel. Celular: " + celular
				+ " - Ubicacion: " + ubicacion + " ";
	}
	
	

}
