package estructuraslineales;

/**
 * Esta interfaz gestiona la funcionalidad de un vectorLista.
 * @author Luis Octavio.
 * @version 1.0
 */
public interface VectorLista extends ListaAlmacenamiento{
    /**
     * Indica si la lista esta llena.
     * @return True en caso de que si, false en caso contrario.
     */
    public boolean llena();

    /**
     * En este metodo se devolvera el tamano maximo de la lista.
     * @return Numero maximo de la lista.
     */
    int maximo();

    /**
     * Este metodo dara el numero de elementos de la lista.
     * @return Numero de elementos en la lista.
     */
    int numeroElementos();

    /**
     * Metodo que nos dejara obtener un objeto deseado de una lista.
     * @param indice Indice de el objeto que queremos obtener.
     * @return El objeto obtenido, en caso de no encontrarse se devolvera null.
     */
    public Object obtener(int indice);

    /**
     * Modifica el elemento del indice indicado por el objeto que le demos.
     * @param indice La posicion que queremos cambiar.
     * @param valor El nuevo objeto que queremos introducir.
     * @return true en caso de hacer cambios, false en caso contrario.
     */
    public boolean cambiar(int indice, Object valor);

    /**
     * Modifica los elementos que estan en los indices de busqueda, por los valores nuevos.
     * @param indicesBusqueda Los indices que deberan ser cambiados.
     * @param valoresNuevos Los nuevos valores que se ingresaran.
     * @return true en caso de que se puedan cambiar, false en caos contrario.
     */
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica valoresNuevos);

    /**
     * Elimina un elemento especifico que se indique con el indice.
     * @param indice Lugar donde se desea eliminar el objeto.
     * @return En caso de que se pueda eliminar se devolvera el objeto, en caso contrario se devolvera null
     */
    public Object eliminar(int indice);

    /**
     * Este metodo cambiara el tanio del arreglo, si es menor debera elimiar los elementos sobrantes,
     * si es mayor simplemente los nuevos espacios deben estar vacios
     * @param maximo El nuevo tamanio del arreglo
     * @return Regresa el arreglo redimensionado
     */
    public Object redimensionar(int maximo);

}
