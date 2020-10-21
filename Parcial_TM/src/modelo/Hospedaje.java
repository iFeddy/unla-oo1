package modelo;

import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private String hospedaje;
    private Double precioPorNoche;

    public Hospedaje(String hospedaje, Double precioPorNoche) {
        super();
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return this.hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public Double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public void setPrecioPorNoche(Double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "\n{" + " codServicio='" + getCodServicio() + "'" +" hospedaje='" + getHospedaje() + "'" + ", precioPorNoche='" + getPrecioPorNoche() + "'" + "}";
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.getPrecioPorNoche();
        //Lun (1)  - Vie (5)
        if(dia.getDayOfWeek().getValue() < 6){
            precioFinal = this.getPrecioPorNoche() - (this.getPrecioPorNoche() * (this.getPorcentajeDescuento() / 100));
        }
        return precioFinal;
    }

}
