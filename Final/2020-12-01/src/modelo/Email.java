package modelo;

public class Email extends Mensaje{
    private String origen;
    private String destino;
    private String asunto;
    private String cuerpo;
    private Boolean recibido;


    public Email(String origen, String destino, String asunto, String cuerpo, Boolean recibido) throws Exception {
        this.origen = origen;
        setDestino(destino);
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.recibido = recibido;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) throws Exception {
        //Se tiene que lanzar una excepción en caso de que no contenga un arroba
        if(!(destino.contains("@"))){
            throw new Exception("El Email de Destino es Incorrecto");
        }
        this.destino = destino;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Boolean isRecibido() {
        return this.recibido;
    }

    public Boolean getRecibido() {
        return this.recibido;
    }

    public void setRecibido(Boolean recibido) {
        this.recibido = recibido;
    }

    @Override
    public String toString() {
        return "{" +
            " origen='" + getOrigen() + "'" +
            ", destino='" + getDestino() + "'" +
            ", asunto='" + getAsunto() + "'" +
            ", cuerpo='" + getCuerpo() + "'" +
            ", recibido='" + isRecibido() + "'" +
            "}";
    }

    @Override
    public Boolean cambiarDeEstado(Boolean estadoNuevo) {
        // Guardar el valor recibido en estadoNuevo en el atributo recibido.
        return this.recibido = estadoNuevo;
    }

    
}
