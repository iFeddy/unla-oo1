package modelo;

public class Producto extends Mercancia {
    private String producto;
    private double precioProducto;
    private double porcentajeDescuento;
    private boolean esDescuentoEn2daUnidad;

    public Producto(String producto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad) {
        this.producto = producto;
        this.precioProducto = precioProducto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEsDescuentoEn2daUnidad() {
        return this.esDescuentoEn2daUnidad;
    }

    public boolean getEsDescuentoEn2daUnidad() {
        return this.esDescuentoEn2daUnidad;
    }

    public void setEsDescuentoEn2daUnidad(boolean esDescuentoEn2daUnidad) {
        this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
    }

    

    @Override
    public String toString() {
        return "\n{" +
            " codMercancia='" + getCodMercancia() + "'" +
            ", producto='" + getProducto() + "'" +
            ", precioProducto='" + getPrecioProducto() + "'" +
            ", porcentajeDescuento='" + getPorcentajeDescuento() + "'" +
            ", esDescuentoEn2daUnidad='" + isEsDescuentoEn2daUnidad() + "'" +
            "}";
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.getPrecioProducto();
        if(this.getEsDescuentoEn2daUnidad()){
            //Si tiene descuento2unidad (true) aplica la mitad de porcentajeDescuento
            precioFinal = this.getPrecioProducto() - ((this.getPrecioProducto() /2) * (this.getPorcentajeDescuento() / 100));
        }
        return precioFinal;
    }

    @Override
    public boolean estaEnOferta() {
        return this.getEsDescuentoEn2daUnidad();  
    }

}
