package descargas;

import estructuraslineales.ColaEstaticaPrioridad;

/**
 * Clase que simula la cola de descargas.
 */
public class Descargas {
    ColaEstaticaPrioridad descargas;

    /**
     * Contructor de la clase que inicializa la cola.
     * @param maximo Maximo de la cola de prioridad.
     */
    public Descargas(int maximo){
        descargas = new ColaEstaticaPrioridad(maximo);
    }

    /**
     * Metodo que agrega una descarga a la cola.
     * @param nombre El nombre del archivo a descargar.
     * @param prioridad El numero de la prioridad, entre mayor es mas prioridad.
     * @return true si se pudo poner, false en caso contrario
     */
    public boolean agregarDescarga(String nombre, int prioridad){
        return descargas.poner(nombre,prioridad);
    }

    /**
     * Metodo que imprime la cola de prioridad
     */
    public void imprimirColaDescargas(){
        descargas.imprimir();
    }

    /**
     * Metodo que termina una descarga (quita el ultimo elemento de la pila).
     * @return El objeto quitado, encaso de que no se haya quitado nada null.
     */
    public Object terminarDescarga(){
        return descargas.quitar();
    }
}
