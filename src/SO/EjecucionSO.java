package SO;

import estructuraslineales.ColaEstaticaPrioridad;

/**
 * Clase que simula la cola de ejecucion de un sistema operativo.
 */
public class EjecucionSO {
    ColaEstaticaPrioridad programas;

    /**
     * Contructor de la clase que inicializa la cola.
     * @param maximo Maximo de la cola de prioridad.
     */
    public EjecucionSO(int maximo){
        programas = new ColaEstaticaPrioridad(maximo);
    }

    /**
     * Metodo que agrega un programa a la cola.
     * @param nombre El nombre del programa-proceso.
     * @param prioridad El numero de la prioridad, entre mayor es mas prioridad.
     * @return true si se pudo poner, false en caso contrario
     */
    public boolean agregarPrograma(String nombre, int prioridad){
        return programas.poner(nombre,prioridad);
    }

    /**
     * Metodo que imprime la cola de prioridad
     */
    public void imprimirColaProgramas(){
        programas.imprimir();
    }

    /**
     * Metodo que termina un programa-proceso (quita el ultimo elemento de la pila)
     * @return El objeto quitado, encaso de que no se haya quitado nada null.
     */
    public Object terminarEjecucion(){
        return programas.quitar();
    }

}
