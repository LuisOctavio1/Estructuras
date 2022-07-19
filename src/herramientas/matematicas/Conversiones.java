package herramientas.matematicas;

import estructuraslineales.ListaDinamicaClave;

/**
 * Clase que se encargara de las conversiones.
 */
public class Conversiones {
    private static ListaDinamicaClave listaDecimal(){
        ListaDinamicaClave hexadecimal = new ListaDinamicaClave();
        hexadecimal.agregar(0,0);
        hexadecimal.agregar(1,1);
        hexadecimal.agregar(2,2);
        hexadecimal.agregar(3,3);
        hexadecimal.agregar(4,4);
        hexadecimal.agregar(5,5);
        hexadecimal.agregar(6,6);
        hexadecimal.agregar(7,7);
        hexadecimal.agregar(8,8);
        hexadecimal.agregar(9,9);
        hexadecimal.agregar(10,"A");
        hexadecimal.agregar(11,"B");
        hexadecimal.agregar(12,"C");
        hexadecimal.agregar(13,"D");
        hexadecimal.agregar(14,"E");
        hexadecimal.agregar(15,"F");
        return hexadecimal;
    }

    /**
     * Metodo que convierte un numero decimal a hexadecimal.
     * @param decimal El numero que queremos convertir.
     * @return El numero decimal en forma hexadecimal.
     */
    public static String aHexadecimal(int decimal){
        ListaDinamicaClave claves = listaDecimal();
        String hexadecimal = "";
        int division = decimal / 16;
        int modulo = decimal %16;
        if( division < 1){
            return hexadecimal +claves.obtener(modulo) ;
        }else{
            return  aHexadecimal(division) +claves.obtener(modulo);
        }
    }

    /**
     * Metodo que indica si un numero es bianrio o no.
     * @param binario El numero que comprobaremos si es binario
     * @return true si es binario, false en caso contrario.
     */
    public static boolean esBinario(long binario){
        String numBinario = binario+ "";
        return esBinario(numBinario,numBinario.length()-1);
    }

    /**
     * Metodo auxilar y recursivo que indica si un numero es binario.
     * @param binario El numero binario convertido en cadena.
     * @param tamanio El tamanio de la cadena.
     * @return true si es binario, false en caso contrario.
     */
    private static boolean esBinario(String binario,int tamanio){
        if(tamanio <0){
            return true;
        }else{
            if(binario.charAt(tamanio) != '1' && binario.charAt(tamanio) != '0'){
                return false;
            }else{
                return esBinario(binario,tamanio-1);
            }
        }
    }

    /**
     * Metodo que convierte un numero decimal a binario.
     * @param decimal El numero decimal a convertir.
     * @return EL numero convertido a binario.
     */
    public static long decimalABinario(int decimal){
        String binario = "";
        if(decimal == 1){
            return Long.parseLong ( binario + "1");
        }else{
            if(decimal%2 == 0){
                return Long.parseLong(decimalABinario(decimal/2) +"0") ;
            }else{
                return Long.parseLong(decimalABinario((decimal-1)/2) +"1");
            }
        }
    }
}
