package modelo;

import java.time.LocalDate;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;    

    public Servicio(){

    }

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getCodServicio() {
        return this.codServicio;
    }

    public void setCodServicio(String codServicio) throws Exception {
        if(codServicio.length() != 6){
            throw new Exception("El C\u00f3digo de Servicio es Incorrecto");
        }
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return this.enPromocion;
    }

    public boolean getEnPromocion() {
        return this.enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);

    @Override
    public String toString() {
        return "{" +
            " codServicio='" + getCodServicio() + "'" +
            ", porcentajeDescuento='" + getPorcentajeDescuento() + "'" +
            ", enPromocion='" + isEnPromocion() + "'" +
            "}";
    }

}