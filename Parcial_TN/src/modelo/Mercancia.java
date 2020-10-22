package modelo;

public abstract class Mercancia {
    protected String codMercancia;

    public Mercancia(){

    }

    public Mercancia(String codMercancia) {
        this.codMercancia = codMercancia;
    }

    public String getCodMercancia() {
        return this.codMercancia;
    }

    public void setCodMercancia(String codMercancia) throws Exception {
        if(codMercancia.length() != 7){
            throw new Exception("El C\u00f3digo de Mercancia es Incorrecto");
        }
        this.codMercancia = codMercancia;
    }

    public abstract double calcularPrecioFinal();

    public abstract boolean estaEnOferta();
    
    @Override
    public String toString() {
        return "{" +
            " codMercancia='" + getCodMercancia() + "'" +
            "}";
    }

}
