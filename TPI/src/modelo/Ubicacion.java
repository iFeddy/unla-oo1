package modelo;

public class Ubicacion {
	private double latitud;
	private double longitud;
	
	public Ubicacion(double latitud, double longitud)throws Exception {
		super();
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud)throws Exception {
		if(latitud < -90 || latitud > 90){
			throw new Exception("Error: Objeto Ubicacion inv�lido, Latitud debe estar entre -90 y 90 grados");
		}
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) throws Exception{
		if(longitud < -180 || longitud > 180){
			throw new Exception("Error: Objeto Ubicacion inv�lido, Longitud debe estar entre -180 y 180 grados");
		}
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Latitud: " + latitud + " - Longitud: " + longitud + "";
	}
	
	// TRAER OBJETO UBUCACION
	public Ubicacion traerUbicacion(){
		return this;
	}

}
