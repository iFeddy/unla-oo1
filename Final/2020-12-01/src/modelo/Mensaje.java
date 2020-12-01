package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Mensaje {
    private int idMensaje; //automatico    
    private LocalDate fechaEnvio;
    private LocalTime horaEnvio;    

    public Mensaje() {
	}

    public Mensaje(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio) {
        this.idMensaje = idMensaje;
        this.fechaEnvio = fechaEnvio;
        this.horaEnvio = horaEnvio;
    }

	public int getIdMensaje() {
        return this.idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public LocalDate getFechaEnvio() {
        return this.fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalTime getHoraEnvio() {
        return this.horaEnvio;
    }

    public void setHoraEnvio(LocalTime horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    @Override
    public String toString() {
        return "{" +
            " idMensaje='" + getIdMensaje() + "'" +
            ", fechaEnvio='" + getFechaEnvio() + "'" +
            ", horaEnvio='" + getHoraEnvio() + "'" +
            "}";
    }

    public abstract Boolean cambiarDeEstado(Boolean estadoNuevo);

}
