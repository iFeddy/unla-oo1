package modelo;

public class OperadorMovil {
    int codigoMovil;
    String companiaMovil;

    public OperadorMovil(int codigoMovil, String companiaMovil) {
        this.codigoMovil = codigoMovil;
        this.companiaMovil = companiaMovil;
    }

    public int getCodigoMovil() {
        return this.codigoMovil;
    }

    public void setCodigoMovil(int codigoMovil) {
        this.codigoMovil = codigoMovil;
    }

    public String getCompaniaMovil() {
        return this.companiaMovil;
    }

    public void setCompaniaMovil(String companiaMovil) {
        this.companiaMovil = companiaMovil;
    }

    @Override
    public String toString() {
        return "{" +
            " codigoMovil='" + codigoMovil + "'" +
            ", companiaMovil='" + companiaMovil + "'" +
            "}";
    }

}
