package estructuraslineales;

/**
 * Clase encargadas de las pilas
 */
public class PilaEstatica implements LoteAlmacenamiento{
    protected ListaEstatica pila;

    /**
     * Constructor de la pila.
     * @param maximo El maximo de la pila.
     */
    public PilaEstatica(int maximo){
        pila=new ListaEstatica(maximo);
    }

    /**
     * Metodo que confirma si la pila esta vacia.
     * @return treu en casi de que si, false en caso contrario.
     */
    @Override
    public boolean vacio(){
        return pila.vacia();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean lleno(){
        return pila.llena();
    }

    /**
     * Metodo para poner un objeto a la cola.
     * @param valor El objeto que queremos meter.
     * @return true si se pudo, false en caso contrario
     */
    @Override
    public boolean poner(Object valor){
        int valorRetorno=pila.agregar(valor);
        if(valorRetorno>=0){
            return true;
        }else{ //retorna -1
            return false;
        }
    }

    /**
     * Metodo para quitar un elemento de la pila.
     * @return True si se pudo, false en cso contrario.
     */
    @Override
    public Object quitar(){
        return pila.eliminar();
    }

    /**
     * Metodo para imprimir la pila.
     */
    @Override
    public void imprimir(){
        pila.imprimir();
    }

    /**
     * Metodo para ver el ultimo elemento de la pila.
     * @return El ultimo elemento.
     */
    @Override
    public Object verUltimo(){
        return pila.verUltimo();
    }
}
