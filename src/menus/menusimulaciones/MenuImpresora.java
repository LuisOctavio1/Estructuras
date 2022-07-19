package menus.menusimulaciones;

import entradasalida.SalidaPorDefecto;

/**
 * Clase menu de la simulacion de la impresora
 */
public class MenuImpresora {
    /**
     * Metodo que imprime los objetos impresos.
     * @param objeto El objeto que se imprimio.
     */
    public static void imprimirObjetoImpreso(Object objeto){
        if(objeto != null){
            SalidaPorDefecto.consola("Se imprimio: " + objeto+"\n");
        }else{
            SalidaPorDefecto.consola("No queda nada en la cola para imprimir\n");
        }
    }

    /**
     * Metodo que imprime cuando se agrega una impresion.
     * @param agregado Boleano que que procede del metodo agregar de la clase que indica si se pudo o no.
     */
    public static void imprimirAgregarObjeto(boolean agregado){
        if(agregado == true){
            SalidaPorDefecto.consola("Se agrego a la cola\n");
        }else{
            SalidaPorDefecto.consola("La cola de la impresora esta llena\n");
        }
    }
}
