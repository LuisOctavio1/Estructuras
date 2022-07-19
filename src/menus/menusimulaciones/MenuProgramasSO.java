package menus.menusimulaciones;

import entradasalida.SalidaPorDefecto;

/**
 * Clase menu de simulacion SO
 */
public class MenuProgramasSO{
    /**
     * Metodo que imprime los objetos terminados.
     * @param objeto El objeto que se termino de ejecutar.
     */
    public static void imprimirProgramaTerminado(Object objeto){
        if(objeto != null){
            SalidaPorDefecto.consola("Se termino de ejecutar el programa: " + objeto+"\n");
        }else{
            SalidaPorDefecto.consola("No queda nada en la cola para terminar de ejecutar\n");
        }
    }

    /**
     * Metodo que imprime cuando se agrega un proceso.
     * @param agregado Boleano que que procede del metodo agregar de la clase que indica si se pudo o no.
     */
    public static void imprimirAgregarObjeto(boolean agregado){
        if(agregado == true){
            SalidaPorDefecto.consola("Se agrego a la cola\n");
        }else{
            SalidaPorDefecto.consola("La cola del SO esta llena\n");
        }
    }
}
