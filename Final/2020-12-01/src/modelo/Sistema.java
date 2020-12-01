package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Mensaje> listaMensajes;

    public Sistema(){
        this.listaMensajes = new ArrayList<Mensaje>();
    }

    public Sistema(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public List<Mensaje> getListaMensajes() {
        return this.listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    private int generarMensajeID(){
        int id = 1;
		if (listaMensajes.size() > 0) {
			Mensaje ultimoId = listaMensajes.get(listaMensajes.size() - 1);
			id = ultimoId.getIdMensaje() + 1;
        }
		return id;
    }
        
    public Mensaje imprimirUltimoMensaje(){
       
		if (listaMensajes.size() > 0) {
			Mensaje ultimoId = listaMensajes.get(listaMensajes.size() - 1);            
            return ultimoId;
		}
        return null;

    }

    public Mensaje traerMensaje(int idMensaje){
        int i = 0;
        Mensaje mensaje = null;
        //Buscamos el mensaje
        while(mensaje == null && i < this.listaMensajes.size()){
            Mensaje bMensaje = this.listaMensajes.get(i);
            if(bMensaje.getIdMensaje() == idMensaje){
                mensaje = bMensaje;
            }
            i++;
        }
        mensaje.cambiarDeEstado(true);
        //Devuelve mensaje
        return mensaje;
    }

    public List<Mensaje> traerMensaje(String nombreCompania){
        int i = 0;        
        List<Mensaje> listado = new ArrayList<Mensaje>();        
        while(i < this.listaMensajes.size()){
            Mensaje bMensaje = this.listaMensajes.get(i);
            //System.out.println(bMensaje);
            if (bMensaje instanceof SMS) {                              
                SMS sms = (SMS) bMensaje;
                OperadorMovil om = sms.operadorOrigen;
                String compania = om.getCompaniaMovil();               
                if(compania.equals(nombreCompania)){
                    listado.add(bMensaje);
                }
            }
            i++;
        }
        return listado;
    }

    public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta){
        int i = 0;
        List<Mensaje> listado = new ArrayList<Mensaje>();        
        while(i < this.listaMensajes.size()){
            Mensaje bMensaje = this.listaMensajes.get(i);
            LocalDate fechaComparar = bMensaje.getFechaEnvio();
            LocalTime hora = bMensaje.getHoraEnvio();
            if(fecha.isEqual(fechaComparar) && hora.isAfter(horaDesde) && hora.isBefore(horaHasta)){
                listado.add(bMensaje);
            }
            i++;
        }
        return listado;
    }

    public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String codigoCompania){
        int i = 0;
        List<Mensaje> listado = new ArrayList<Mensaje>();
        while(i < this.listaMensajes.size()){
            Mensaje bMensaje = this.listaMensajes.get(i);
            LocalDate fechaComparar = bMensaje.getFechaEnvio();
            LocalTime hora = bMensaje.getHoraEnvio();
            if(fecha.isEqual(fechaComparar) && hora.isAfter(horaDesde) && hora.isBefore(horaHasta)){
                if (bMensaje instanceof SMS) {                
                    SMS sms = (SMS) bMensaje;
                    OperadorMovil om = sms.operadorOrigen;
                    if(om.getCompaniaMovil() == codigoCompania){
                        listado.add(bMensaje);
                    }
                }
            }  
            i++;         
        }
        return listado;
    }

    @Override
    public String toString() {
        return "{" +
            " listaMensajes='" + getListaMensajes() + "'" +
            "}";
    }

    public Boolean agregarEmail(LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto, String cuerpo)
            throws Exception {
        //recibido falso
        Mensaje mensaje = new Email(origen, destino, asunto, cuerpo, false);
        mensaje.setFechaEnvio(fechaEnvio);
        mensaje.setHoraEnvio(horaEnvio);
        mensaje.setIdMensaje(this.generarMensajeID());
        return listaMensajes.add(mensaje);
    }

    public Boolean agregarSMS(LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino, String texto, OperadorMovil operadorOrigen, OperadorMovil operadorDestino)
            throws Exception {
        //visto falso
        Mensaje mensaje = new SMS(numeroDestino, numeroDestino, texto, false, operadorOrigen, operadorDestino);
        mensaje.setFechaEnvio(fechaEnvio);
        mensaje.setHoraEnvio(horaEnvio);
        mensaje.setIdMensaje(this.generarMensajeID());
        return listaMensajes.add(mensaje);
    }

}
