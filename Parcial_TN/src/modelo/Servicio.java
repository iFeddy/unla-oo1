package modelo;

public class Servicio extends Mercancia{
    private String servicio;
    private double presupuesto;
    private double porcentajeDescuento;
    private boolean enPromocion;


    public Servicio(String servicio, double presupuesto, double porcentajeDescuento, boolean enPromocion) {
        this.servicio = servicio;
        this.presupuesto = presupuesto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getPresupuesto() {
        return this.presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
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

    @Override
    public String toString() {
        return "\n{" +
            " codMercancia='" + getCodMercancia() + "'" +
            ", servicio='" + getServicio() + "'" +
            ", presupuesto='" + getPresupuesto() + "'" +
            ", porcentajeDescuento='" + getPorcentajeDescuento() + "'" +
            ", enPromocion='" + isEnPromocion() + "'" +
            "}";
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.getPresupuesto();
        if(this.getEnPromocion()){
            precioFinal = this.getPresupuesto() - (this.getPresupuesto() * (this.getPorcentajeDescuento() / 100));
        }
        return precioFinal;
    }

    @Override
    public boolean estaEnOferta() {
        return this.getEnPromocion();  
    }

}
