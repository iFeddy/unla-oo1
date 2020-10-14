package modelo;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funciones {
    
    public static boolean validarEmail(String email){
    	// Patr�n para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    } 
    
    public static String diaSemana (int dia){
		String Valor_dia = null;			
		if (dia== 1) {
			Valor_dia = "Lunes";
		} else if (dia== 2) {
			Valor_dia = "Martes";
		} else if (dia == 3) {
			Valor_dia = "Miercoles";
		} else if (dia== 4) {
			Valor_dia = "Jueves";
		} else if (dia== 5) {
			Valor_dia = "Viernes";
		} else if (dia== 6) {
			Valor_dia = "Sabado";
		} else if (dia== 7) {
			Valor_dia = "Domingo";
		} else
			Valor_dia = "Dia Incorrecto";
		return Valor_dia;
	}
    
    public static String ocupado(boolean cerrado){
    	String ocupado = null;
    	if(cerrado == true){
    		ocupado = " OCUPADO";
    	}else
    		ocupado = " LIBRE";  
    	 return ocupado;
    }
    
    public static String fechaCadena(LocalDate fecha){
    
    	String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	    String DIA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
	    String cadena = "" + DIA[fecha.getDayOfWeek().getValue()] + " " + fecha.getDayOfMonth() + " "+MES[fecha.getMonthValue()-1]+" del " + fecha.getYear();
    	return cadena;
    }
       
}
