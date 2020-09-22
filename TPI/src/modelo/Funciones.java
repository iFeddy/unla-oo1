package modelo;

import java.util.*;

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
        //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el número en la misma posición
        for (int i=0; i<10; i++){
            aux += Integer.valueOf(cuitArray[i]) * serie[i];
        }
        //Hacemos como se especifica: 11 menos el resto de la división de la suma de productos anterior por 11
        aux = 11 - (aux % 11);
        //Si el resultado anterior es 11 el código es 0
        if (aux == 11){
            aux = 0;
        //o si el resultado anterior es 10 el código es 9
        } else if (aux == 10){
            aux = 9;
        }
        return Objects.equals(Integer.valueOf(cuitArray[10]), aux);
    }
}
