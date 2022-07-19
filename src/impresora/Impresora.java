package impresora;

import estructuraslineales.ColaEstaticaPrioridad;

/**
 * Clase que simula la cola de ejecucion de una impresora.
 */
public class Impresora {
    ColaEstaticaPrioridad impresora;

    /**
     * Contructor de la clase que inicializa la cola.
     * @param maximo Maximo de la cola de prioridad.
     */
    public Impresora(int maximo){
        impresora = new ColaEstaticaPrioridad(maximo);
    }

    /**
     * Metodo que agrega una impresion a la cola.
     * @param nombre El nombre del archivo.
     * @param prioridad El numero de la prioridad, entre mayor es mas prioridad.
     * @return true si se pudo poner, false en caso contrario
     */
    public boolean agregarImpresion(String nombre, int prioridad){
        return impresora.poner(nombre,prioridad);
    }

    /**
     * Metodo que imprime la cola de prioridad
     */
    public void imprimirColaImpresora(){
        impresora.imprimir();
    }

    /**
     * Metodo que termina una impresion (quita el ultimo elemento de la pila)
     * @return El objeto quitado, encaso de que no se haya quitado nada null.
     */
    public Object imprimir(){
        return impresora.quitar();
    }

}
