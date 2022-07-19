package estructuraslineales;

/**
 * Esta interfaz gestiona la funcionalidad de una lista de almacenamiento.
 * @author Clase ED.
 * @version 1.0
 */
public interface ListaAlmacenamiento {

    /**
     * Determina si una lista de almacenamiento esta vacia.
     * @return Regresa <b>true</b> si la lista esta vacia, <b>false</b> en caso contrario.
     */
    public boolean vacia();

    /**
     * Inserta al final de la lista el elemento especificados com oargumento.
     * @param valor Es el dato que se va a agregar en la lista.
     * @return Regresa la posicion en memoria(indice) en donde se agrega el valor, o -1 en caso que no se haya podido insertar.
     */
    public int agregar(Object valor);

    /**
     * Imprime la lista actual.
     * @return
     */
    public Object imprimir();

    /**
     * Imprime la lista actual en sentido inverso.
     */
    public void imprimirOI();

    /**
     * Busca un objeto en la lista.
     * @param valor El valor que queremos buscar
     * @return El indice donde se encuentra, en caso de que no se devuelve null
     */
    public Object buscar(Object valor);

    /**
     * Elimina un objeto de la lista
     * @param valor El objeto que queremos eliminar
     * @return El valor que eliminamos
     */
    public Object eliminar(Object valor);

    /**
     * Indica si la lista actual es igual a la lista que le daremos.
     * @param lista2 Lista con la que se comparara la lista actual
     * @return true en caso de que sea igual, false en caso contrario
     */
    public boolean esIgual(Object lista2);

    /**
     * Modifica el elemento viejo por el nuevo haciendo una busqueda
     * la cantidad de veces y modificando el numero de veces de ocurrencia indicado
     * por numVeces.
     * @param valorViejo El valor que queremos cambiar.
     * @param valorNuevo El valor al que queremos cambair.
     * @param numVeces La cantidad de veces que queremos buscar el valor que queremos cambiar.
     * @return True en caso de haber alguna modificacion, false en caso contrario
     */
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces);

    /**
     * Este metodo busca un valor en todo el arreglo y devuelve una lista con sus posiciones.
     * @param valor El valor que deseamos buscar.
     * @return El arreglo con los indices que coincidan con el valor.
     */
    public ListaEstatica buscarValores(Object valor);

    /**
     * Regresa el objetode la ultima posicion de la ListaEstatica
     * @return El ultimo objeto
     */
    public Object eliminar();

    /**
     * Este metodo quita todo el contenido del arreglo
     */
    public void vaciar();

    /**
     * Metodo que agrega al final de la lista actual el contenido de la lista2, se
     * debera validar que la lista sea estatica.
     * @param lista2 La lista que se desea agregar a nuestra lista actual
     * @return true en caso de que se pueda y la lista sea estatica, false en caso contrario
     */
    public boolean agregarLista(Object lista2);

    /**
     * Invierte los elementos de la lista actual.
     */
    public void invertir();

    /**
     * Este metodo cuenta la cantidad de veces que se encuentra el objeto que le demos como parametro.
     * @param valor El objeto que buscaremos en nuestra lista.
     * @return La cantidad de veces que se encontro.
     */
    public int contar(Object valor);

    /**
     * Elimina los elementos de la lista 2 que se encuentren en la lista actual.
     * @param lista2 La lista con los elementos que se quieren eliminar.
     * @return true en caso de que la lista2 sea una Lista estatica, false en caso contrario
     */
    public boolean eliminarLista(Object lista2);

    /**
     * Rellena todos los elementos indicados por cantidad del arreglo con el valor indicado, se debera comprobar si la lista es estatica
     * en caso de serlo se debera comprobar que la cantidad este dentro del tamanio correcto.
     * @param valor El valor con el que se colocara en la lista
     * @param cantidad La cantidad de veces que se colocara el valor.
     */
    public void rellenar(Object valor, int cantidad);

    /**
     * Este metodo regresa una copia del arreglo actual.
     * @return El arreglo que se copio
     */
    public Object clonar();

    /**
     * Este metodo regresa una lista con los elementos que dentro del rango establecido,
     * se deben de validar los subrangos.
     * @param indiceInicial El indice donde se comenzara la sublista.
     * @param indiceFinal El indice donde terminara la sublista.
     * @return Se regresara la sublista creada.
     */
    public Object sublista(int indiceInicial,int indiceFinal);

    /**
     * Metodo para rellenar una lista  ordenada con limite siendo el valor, y esta debera espetar el limite de esta
     * @param valor el limite del valor.
     */
    public void rellenar(Object valor);

    public boolean esSublista(ListaAlmacenamiento lista2);

    public boolean cambiarLista(ListaAlmacenamiento lista2, ListaAlmacenamiento lista2Nuevos);

    public boolean retenerLista(ListaAlmacenamiento lista2);

    public boolean insertar(int indice, Object valor);

    public boolean copiarLista(ListaAlmacenamiento lista2);

    public Object verUltimo();
}
