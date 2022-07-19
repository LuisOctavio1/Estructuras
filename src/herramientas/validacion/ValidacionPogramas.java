package herramientas.validacion;

import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;
import java.util.Objects;

/**
 * Clase que validara los signos de apertura de un archivo que contenga una clase de java.f
 */
public class ValidacionPogramas {

    /**
     * Metodo que llaman las demas clases que validara el archivo de texto.
     * @param programa La lista que contiene las lineas del archivo.
     * @return Una pila que en caso de estar vacia es porque el archivo esta bien, en caso contrario el ultimo elemento que tenga la pila no se cerro.
     */
    public static PilaEstatica validarPrograma(ListaEstatica programa){
        PilaEstatica pila = new PilaEstatica(programa.numeroElementos());
        for(int indice = 0; indice < programa.numeroElementos(); indice++){
            String linea = (String) programa.obtener(indice);
            for(int posicion =0; posicion < linea.length(); posicion++){
                char caracter = linea.charAt(posicion);
                char caracterSiguiente = ' ';
                if(posicion != linea.length()-1){
                    caracterSiguiente = linea.charAt(posicion+1);
                }
                String comentario = String.valueOf(caracter);
                String comentario2 = String.valueOf(caracterSiguiente);
                if(esCaracterDeApertura(caracter,caracterSiguiente)){
                    pila.poner(crearListaCaracterIndice(comentario+comentario2,indice+1,posicion));
                }else if(esCaracterDeCierre(caracter,caracterSiguiente)){
                    if(!validarCierre(caracter, pila,caracterSiguiente)){
                        pila.imprimir();
                        return pila;
                    }else{
                        pila.quitar();
                    }
                }
            }
        }
        return pila;
    }

    /**
     * Metodo que indica si un caracter es caracter de apertura.
     * @param caracter El caracter (o cadena en caso de que sea /*) a verificar.
     * @param caracterSiguiente El caracter siguiente que verificara si un / es para /* o es otro signo
     * @return true en caso de que sea de apertura, false en caso contrario
     */
    private static boolean esCaracterDeApertura(char caracter,char caracterSiguiente){
        String comentario = String.valueOf(caracter);
        String comentario2 = String.valueOf(caracterSiguiente);
        if(caracter == '{' || caracter == '(' || (comentario + comentario2).equals("/*")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Verifica si un caracter es de cierre
     * @param caracter El caracter a verificar
     * @param caracterSiguiente El siguiente caracter para formar * / en caso de que lo sea
     * @return
     */
    private static boolean esCaracterDeCierre(char caracter,char caracterSiguiente){
        String comentario = String.valueOf(caracter);
        String comentario2 = String.valueOf(caracterSiguiente);
        if(caracter == '}' || caracter == ')' || (comentario + comentario2).equals("*/")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que valida el cierre de una apertura.
     * @param caracter El caracter de cierre.
     * @param pila La pila que contiene los caracteres de apertura.
     * @param caracterSiguiente El siguiente caracter de la linea para verificar si es * /
     * @return true en caso de que esa cierre correcto, false en caso contrario.
     */
    private static boolean validarCierre(char caracter, PilaEstatica pila, char caracterSiguiente){
        if(((ListaEstatica) pila.verUltimo()).obtener(0) instanceof String comentario){
            String comentarioCierre = String.valueOf(caracter);
            String comentarioCierre2 = String.valueOf(caracterSiguiente);
            if(Objects.equals(comentario, "/*") && !(comentarioCierre + comentarioCierre2).equals("*/")){
                return false;
            }else{
                return true;
            }
        }
        char caracterApertura = (char)((ListaEstatica)pila.verUltimo()).obtener(0);
        if(caracterApertura== '{' && caracter != '}'){
            return false;
        }else if(caracterApertura == '(' && caracter != ')'){
            return false;
        }
        return true;
    }

    /**
     * Metodo que crea la lista con el caracter, numero de linea e indice de caracter.
     * @param caracter el caracter que vamos a meter a la lista.
     * @param linea El numero de linea
     * @param numeroCaracter El indice de la linea donde esta.
     * @return La listaEstatica formada.
     */
    private static ListaEstatica crearListaCaracterIndice(String caracter, int linea, int numeroCaracter){
        ListaEstatica caracterYnumeroLinea = new ListaEstatica(3);
        if(caracter.charAt(1) == ' '){
            caracterYnumeroLinea.agregar(caracter.charAt(0));
        }else{
            caracterYnumeroLinea.agregar(caracter);
        }
        caracterYnumeroLinea.agregar(linea);
        caracterYnumeroLinea.agregar(numeroCaracter);
        return caracterYnumeroLinea;
    }
}
