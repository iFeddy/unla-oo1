package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<Servicio>();
    }

    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }
    
    public Servicio traerServicio(String codServicio){
        int i = 0;
        Servicio servicio = null;
        while(servicio == null && i < this.lstServicio.size()){
            Servicio bServicio = this.lstServicio.get(i);
            if(bServicio.getCodServicio() == codServicio){
                servicio = bServicio;
            }
            i++;
        }
        return servicio;
    }

    public List<Servicio> traerServicio(boolean enPromocion){
        int i = 0;
        List<Servicio> newServicios = new ArrayList<Servicio>();
        while(i < this.lstServicio.size()){
            Servicio bServicio = this.lstServicio.get(i);
            if(bServicio.getEnPromocion() == enPromocion){
                newServicios.add(bServicio);
            }

            i++;
        }
        return newServicios;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia){
        int i = 0;
        List<Servicio> newServicios = new ArrayList<Servicio>();
        while(i < this.lstServicio.size()){
            Servicio bServicio = this.lstServicio.get(i);
            if (bServicio instanceof Gastronomia) {                
                Gastronomia gastronomia = (Gastronomia) bServicio;
                if(gastronomia.getEnPromocion() == enPromocion & dia.getDayOfWeek().getValue() == gastronomia.getDiaSemDesc()){
                    newServicios.add(bServicio);
                }
            }
            i++;
        }
        return newServicios;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia,  double precio, int diaSemDesc)
            throws Exception {
        Servicio servicio = new Gastronomia(gastronomia, precio, diaSemDesc);
        servicio.setCodServicio(codServicio);
        servicio.setPorcentajeDescuento(porcentajeDescuento);
        servicio.setEnPromocion(enPromocion);
        //Si el nuevo Servicio existe y son iguales
        Servicio buscarServicio = this.traerServicio(codServicio);
        if(buscarServicio != null){
            throw new Exception("El Servicio de Gastronom\u00eda ya fue dado de alta. [Cod:" + codServicio + "]");
        }
        return this.lstServicio.add(servicio);
    }

    public boolean agregarHospedaje (String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje,double precioPorNoche)
            throws Exception {
        Servicio servicio = new Hospedaje(hospedaje, precioPorNoche);
        servicio.setCodServicio(codServicio);
        servicio.setPorcentajeDescuento(porcentajeDescuento);
        servicio.setEnPromocion(enPromocion);
        //Si el nuevo Servicio existe y son iguales
        Servicio buscarServicio = this.traerServicio(codServicio);
        if(buscarServicio != null && buscarServicio.equals(servicio)){
            throw new Exception("El Servicio de Hospedaje ya fue dado de alta. [Cod:" + codServicio + "]");
        }
        return this.lstServicio.add(servicio);
    }

    public List<Servicio> getLstServicio() {
        return this.lstServicio;
    }

    @Override
    public String toString() {
        return "{" +
            " lstServicio='" + getLstServicio() + "'" +
            "}";
    }

}
