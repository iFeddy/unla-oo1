package modelo;

public class SMS extends Mensaje {
    int numeroOrigen;
    int numeroDestino;
    String texto;
    boolean visto;
    OperadorMovil operadorOrigen;
    OperadorMovil operadorDestino;

    public SMS(int numeroOrigen, int numeroDestino, String texto, boolean visto, OperadorMovil operadorOrigen, OperadorMovil operadorDestino)
            throws Exception {
        super();
        this.numeroOrigen = numeroOrigen;
        setNumeroDestino(numeroDestino);
        this.texto = texto;
        this.visto = visto;
        this.operadorOrigen = operadorOrigen;
        this.operadorDestino = operadorDestino;
    }

    public int getNumeroOrigen() {
        return this.numeroOrigen;
    }

    public void setNumeroOrigen(int numeroOrigen) {        
        this.numeroOrigen = numeroOrigen;
    }

    public int getNumeroDestino() {        
        return this.numeroDestino;
    }

    public void setNumeroDestino(int numeroDestino) throws Exception {
        //Se tiene que lanzar una excepción en caso de que no tenga una longitud de 10 números.
        if(String.valueOf(numeroDestino).length() != 10){
            throw new Exception("El Numero de Destino es Incorrecto");
        }
        this.numeroDestino = numeroDestino;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isVisto() {
        return this.visto;
    }

    public boolean getVisto() {
        return this.visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public OperadorMovil getOperadorOrigen() {
        return this.operadorOrigen;
    }

    public void setOperadorOrigen(OperadorMovil operadorOrigen) {
        this.operadorOrigen = operadorOrigen;
    }

    public OperadorMovil getOperadorDestino() {
        return this.operadorDestino;
    }

    public void setOperadorDestino(OperadorMovil operadorDestino) {
        this.operadorDestino = operadorDestino;
    }

    @Override
    public String toString() {
        return "{" +
            " numeroOrigen='" + getNumeroOrigen() + "'" +
            ", numeroDestino='" + getNumeroDestino() + "'" +
            ", texto='" + getTexto() + "'" +
            ", visto='" + isVisto() + "'" +
            ", operadorOrigen='" + getOperadorOrigen() + "'" +
            ", operadorDestino='" + getOperadorDestino() + "'" +
            "}";
    }

    @Override
    public Boolean cambiarDeEstado(Boolean estadoNuevo) {
        // Guardar el valor recibido en estadoNuevo en el atributo visto.
        return this.visto = estadoNuevo;
    }

}
