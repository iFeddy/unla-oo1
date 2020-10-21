package modelo;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    private String gastronomia;
    private Double precio;
    private int diaSemDesc;

    public Gastronomia(String gastronomia, Double precio, int diaSemDesc) {
        super();
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return this.gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return this.diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public String toString() {
        return "\n{" + " codServicio='" + getCodServicio() + "'" + ", gastronomia='" + getGastronomia() + "'" + ", precio='" + getPrecio() + "'" + ", diaSemDesc='"
                + getDiaSemDesc() + "'" + "}";
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.getPrecio();
        if(dia.getDayOfWeek().getValue() == this.getDiaSemDesc()){    
            //Si el Dia = al diaSemDesc        
            precioFinal = this.getPrecio() - (this.getPrecio() * (this.getPorcentajeDescuento() / 100));
        }
        return precioFinal;
    }

}
