package estructuraslineales;

/**
 * Clase que controla las colas dinamicas
 */
public class ColaDinamica implements LoteAlmacenamiento{
    ListaDinamica datos;

    /**
     * Constructor de la cola.
     */
    public ColaDinamica(){
        datos=new ListaDinamica();
    }

    /**
     * Metodo que indica si la cola esta vacia.
     * @return true en caso de que lo este, false en caso contrario.
     */
    public boolean vacio(){
        return datos.vacia();
    }

    /**
     * Metodo que indica si la cola esta llena.
     * @return true en caso de que lo este, false en caso contrario.
     */
    @Override
    public boolean lleno() {
        if(datos.agregar(1) == -1){
            return true;
        }else{
            datos.eliminar();
            return false;
        }
    }

    /**
     * Metodo para poner cosas en la cola.
     * @param valor El valor que queremos poner en la cola.
     * @return true en caso de se pueda meter, false en caso contrario.
     */
    public boolean poner(Object valor){
        int puesto = datos.agregar(valor);
        if(puesto ==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo para quitar datos de la cola.
     * @return El objeto eliminado.
     */
    public Object quitar(){
        return datos.eliminarInicio();
    }

    /**
     * Metodo para imprimir la cola.
     */
    public void imprimir(){
        datos.imprimir();
    }

    /**
     * Metodo para ver el ultimo elemento de la cola.
     * @return
     */
    public Object verUltimo(){
        return datos.verUltimo();
    }

    /**
     * Metodo para ver el primer elemento de la cola.
     * @return
     */
    public Object verPrimero(){
        return datos.verPrimero();
    }
}
