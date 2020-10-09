package modelo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funciones {

    public static boolean validarDNI(long dni){
        int length = String.valueOf(dni).length();
        //System.out.println(length);
		if(length == 8 || length == 7){
			return true;
		}else{
            return false;
        }        
    }    

    public static boolean validarCUIT(String cuit){
                
        cuit = cuit.replaceAll("[^\\d]", "");        
        if (cuit.length() != 11){
            return false;
        }        
        String[] cuitArray = cuit.split("");
        Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

        Integer aux = 0;
        //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el n煤mero en la misma posici贸n
        for (int i=0; i<10; i++){
            aux += Integer.valueOf(cuitArray[i]) * serie[i];
        }
        //Hacemos como se especifica: 11 menos el resto de la divisi贸n de la suma de productos anterior por 11
        aux = 11 - (aux % 11);
        //Si el resultado anterior es 11 el c贸digo es 0
        if (aux == 11){
            aux = 0;
        //o si el resultado anterior es 10 el c贸digo es 9
        } else if (aux == 10){
            aux = 9;
        }
        return Objects.equals(Integer.valueOf(cuitArray[10]), aux);
    }
    
    public static boolean validarEmail(String email){
    	// Patr髇 para validar el email
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
			Valor_dia = "Domingo";
		} else if (dia== 2) {
			Valor_dia = "Lunes";
		} else if (dia == 3) {
			Valor_dia = "Martes";
		} else if (dia== 4) {
			Valor_dia = "Miercoles";
		} else if (dia== 5) {
			Valor_dia = "Jueves";
		} else if (dia== 6) {
			Valor_dia = "Viernes";
		} else if (dia== 7) {
			Valor_dia = "Sabado";
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
       
}
