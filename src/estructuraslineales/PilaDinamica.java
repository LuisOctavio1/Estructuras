package estructuraslineales;


/**
 * Clase que maneja las pilas dinamicas
 */
public class PilaDinamica implements LoteAlmacenamiento{

    ListaDinamica pila;
    /**
     * Constructor de la pila.
     */
    public PilaDinamica(){
        pila=new ListaDinamica();
    }

    /**
     * Metodo que confirma si la pila esta vacia.
     * @return treu en casi de que si, false en caso contrario.
     */

    public boolean vacio(){
        return pila.vacia();
    }

    @Override
    public boolean lleno() {
        if(pila.agregar(1) == -1){
            return true;
        }else{
            pila.eliminar();
            return false;
        }
    }


    /**
     * Metodo para poner un objeto a la cola.
     * @param valor El objeto que queremos meter.
     * @return true si se pudo, false en caso contrario
     */

    public boolean poner(Object valor){
        int valorRetorno=pila.agregar(valor);
        if(valorRetorno != -1){
            return true;
        }else{
            return false;
        }

    }

    /**
     * Metodo para quitar un elemento de la pila.
     * @return True si se pudo, false en cso contrario.
     */

    public Object quitar(){
        return pila.eliminar();
    }

    /**
     * Metodo para imprimir la pila.
     */

    public void imprimir(){
        pila.imprimir();
    }

    /**
     * Metodo para ver el ultimo elemento de la pila.
     * @return El ultimo elemento.
     */

    public Object verUltimo(){
        return pila.verUltimo();
    }
}
