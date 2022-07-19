package menus.menusimulaciones;

import entradasalida.SalidaPorDefecto;

/**
 * Clase menu de la simulacion de descargas
 */
public class MenuDescargas {
    /**
     * Metodo que imprime los objetos desccrgados.
     * @param objeto El objeto que se descargo.
     */
    public static void imprimirObjetoDescargado(Object objeto){
        if(objeto != null){
            SalidaPorDefecto.consola("Se descargo: " + objeto+"\n");
        }else{
            SalidaPorDefecto.consola("No queda nada en la cola para descargas\n");
        }
    }

    /**
     * Metodo que imprime cuando se agrega una descarga.
     * @param agregado Boleano que que procede del metodo agregar de la clase que indica si se pudo o no.
     */
    public static void imprimirAgregarDescarga(boolean agregado){
        if(agregado == true){
            SalidaPorDefecto.consola("Se agrego a la cola\n");
        }else{
            SalidaPorDefecto.consola("La cola de descargas esta llena\n");
        }
    }
}
