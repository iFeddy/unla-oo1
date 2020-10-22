package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Mercancia> lstMercancia;

    public Sistema() {
        this.lstMercancia = new ArrayList<Mercancia>();
    }

    public Sistema(List<Mercancia> lstMercancia) {
        this.lstMercancia = lstMercancia;
    }
    
    public Mercancia traerMercancia(String codMercancia){
        int i = 0;
        Mercancia mercancia = null;
        while(mercancia == null && i < this.lstMercancia.size()){
            Mercancia bMercancia = this.lstMercancia.get(i);
            if(bMercancia.getCodMercancia() == codMercancia){
                mercancia = bMercancia;
            }
            i++;
        }
        return mercancia;
    }

    public List<Mercancia> traerMercancia(boolean enOferta){
        int i = 0;
        List<Mercancia> newMercancias = new ArrayList<Mercancia>();
        while(i < this.lstMercancia.size()){
            Mercancia bMercancia = this.lstMercancia.get(i);
            if(bMercancia.estaEnOferta() == enOferta){
                newMercancias.add(bMercancia);
            }
            i++;
        }
        return newMercancias;
    }

    public boolean agregarProducto(String codMercancia, String producto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad)
            throws Exception {
        Mercancia mercancia = new Producto(producto, precioProducto, porcentajeDescuento, esDescuentoEn2daUnidad);
        mercancia.setCodMercancia(codMercancia);

        //Si el nuevo Mercancia existe y son iguales
        Mercancia buscarMercancia = this.traerMercancia(codMercancia);
        if(buscarMercancia != null){
            throw new Exception("La Mercancia de tipo Producto ya fue dada de alta. [Cod:" + codMercancia + "]");
        }
        return this.lstMercancia.add(mercancia);
    }

    public boolean agregarServicio (String codMercancia, String servicio, double presupuesto, double porcentajeDescuento, boolean enPromocion)
            throws Exception {

        Mercancia mercancia = new Servicio(servicio, presupuesto, porcentajeDescuento, enPromocion);
        mercancia.setCodMercancia(codMercancia);
       
        //Si el nuevo Mercancia existe y son iguales
        Mercancia buscarMercancia = this.traerMercancia(codMercancia);
                
        if(buscarMercancia != null){
            throw new Exception("La Mercancia de tipo Servicio ya fue dada de alta. [Cod:" + codMercancia + "]");
        }
        return this.lstMercancia.add(mercancia);
    }

    public List<Mercancia> getlstMercancia() {
        return this.lstMercancia;
    }

    @Override
    public String toString() {
        return "{" +
            " lstMercancia='" + getlstMercancia() + "'" +
            "}";
    }

}
