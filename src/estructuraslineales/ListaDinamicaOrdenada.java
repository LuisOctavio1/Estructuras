package estructuraslineales;

import estructuraslineales.auxiliares.Nodo;
import estructurasnolineales.Matriz2;
import utiles.Comparaciones;
import utiles.TipoOrden;
import utiles.TipoTabla;

/**
 * Clase que controla las listas dinamicas ordenadas.
 */
public class ListaDinamicaOrdenada extends ListaDinamica{
    protected TipoOrden orden;

    /**
     * Constructor que inicializa la lista dinamica ordenada.
     * @param orden Enumerado que indicara si la lista se ordenara decresientemento o crecientemente.
     */
    public ListaDinamicaOrdenada (TipoOrden orden){
        super();
        this.orden = orden;
    }

    /**
     * Metodo que agrega un valor de tal manera que la lista queda ordenada.
     * @param valor Es el dato que se va a agregar en la lista.
     * @return 0 si se pudo agregar, -1 si no.
     */
    @Override
    public int agregar(Object valor) {
        Nodo nuevoNodo=new Nodo(valor); //paso 1
        if(nuevoNodo!=null){ //hay espacio
            if(vacia()==true){  //a)
                primero=nuevoNodo; //paso 2
                ultimo=nuevoNodo;
            }else{ //b) y c)
                Nodo atras = buscarNodo(valor);
                if(atras == ultimo){
                    ultimo.setNodoDer(nuevoNodo);
                    ultimo = nuevoNodo;
                }else{
                    if(atras == null){
                        nuevoNodo.setNodoDer(primero);
                        primero = nuevoNodo;
                        return 0;
                    }
                    Nodo siguiente = atras.getNodoDer();
                    nuevoNodo.setNodoDer(siguiente);
                    atras.setNodoDer(nuevoNodo);
                }
            }
            return 0;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Metodo que busca un nodo y lo regresa
     * @param valor El valor que queremos buscar.
     * @return El nodo en cuestion
     */
    private Nodo buscarNodo(Object valor){
        if(orden.getValor() ==1 ){
            return buscarIncremental(valor);
        }else{
            return buscarDecremental(valor);
        }
    }

    /**
     * Metodo que busaca de forma incremental
     * @param valor El valor que buscamos.
     * @return El nodo encontrado.
     */
    private Nodo buscarIncremental(Object valor){
        Nodo siguiente = primero;
        Nodo atras = primero;
        while (siguiente != null && !Comparaciones.compararMenor(valor,siguiente.getContenido())){
            atras = siguiente;
            siguiente = siguiente.getNodoDer();
        }
        if(siguiente == atras){
            return null;
        }
        return atras;
    }

    /**
     * Metodo que busca de forma decremental.
     * @param valor El valor que buscamos.
     * @return El nodo con el valor.
     */
    private Nodo buscarDecremental(Object valor){
        Nodo siguiente = primero;
        Nodo atras = primero;
        while (siguiente != null && !Comparaciones.compararMayor(valor,siguiente.getContenido())){
            atras = siguiente;
            siguiente = siguiente.getNodoDer();
        }
        if(siguiente == atras){
            return null;
        }
        return atras;
    }

    /**
     * Metodo que inserta un valor al final.
     * @param valor El valor que se desea insertar.
     * @return true si se puedo(dependiendo del orden que tengamos), false en caso contrario.
     */
    public boolean insertarFinal(Object valor){
        if(orden.getValor() ==1){
            if(Comparaciones.compararMayor(valor,ultimo.getContenido())){
                agregar(valor);
                return true;
            }
            return false;
        }else{
            if(!Comparaciones.compararMenor(valor,ultimo.getContenido())){
                agregar(valor);
                return true;
            }
            return false;
        }
    }

    /**
     * Metodo que agrega una lista a nuestra lista manteniendo el orden.
     * @param lista2 La lista que se desea agregar a nuestra lista actual.
     * @return true si se pudo(se paso una lista), false en caso contrario.
     */
    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica ){
            for(int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++ ){
                agregar(((ListaEstatica) lista2).obtener(indice));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param tabla La matriz 2d que agregaremos.
     * @param enumTipoTabla Enumerado que definira si agregaremos la tabla columna por fila o fila por columna
     * @return
     */
    @Override
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla enumTipoTabla) {
        if(enumTipoTabla.getValor() == 1){
            for(int renglones = 0; renglones < tabla.obtenerRenglones(); renglones++){
                for(int col = 0; col < tabla.obtenerColumnas(); col++){
                    agregar(tabla.obtener(renglones,col));
                }
            }
            return true;
        }else{
            for(int col = 0; col < tabla.obtenerColumnas(); col++){
                for (int renglones = 0; renglones < tabla.obtenerRenglones(); renglones++){
                    agregar((tabla.obtener(renglones,col)));
                }
            }
            return true;
        }
    }

    /**
     * Metodo que cambia el indice indicado por el valor nuevo, manteniendo el orden.
     * @param indice El indice del elemento a cambiar.
     * @param valor El nuevo valor.
     * @return true si el indice esta en los rangos, false en caso contrario.
     */
    @Override
    public boolean cambiar(int indice, Object valor) {
        int lugar = 0;
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente != null && lugar <=indice){
            if(lugar == indice){
                eliminar(lugar);
                agregar(valor);
                return true;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            lugar++;
        }
        return false;
    }

    /**
     * Metodo que agrega al inicio un valor.
     * @param valor El valor a agregar.
     * @return 0 si se puedo(el valor hace que siga ordenado), -1 en caso contrario.
     */
    @Override
    public int agregarInicio(Object valor) {
        if(orden.getValor() ==1){
            if(!Comparaciones.compararMayor(valor,primero.getContenido())){
                agregar(valor);
                return 0;
            }
            return -1;
        }else{
            if(Comparaciones.compararMenor(valor,ultimo.getContenido())){
                agregar(valor);
                return 0;
            }
            return -1;
        }
    }

    /**
     * Metodo que cambia el valor viejo por el nuevo el numero de veces indicada(o que se pueda dentro de ese rango).
     * @param valorViejo El valor que queremos cambiar.
     * @param valorNuevo El valor al que queremos cambair.
     * @param numVeces La cantidad de veces que queremos buscar el valor que queremos cambiar.
     * @return true si hubo un cambio, false en caso contrario.
     */
    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        int veces = 0;
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente != null && veces < numVeces){
            if(nodoSiguiente.getContenido().equals(valorViejo) ){
                eliminar(valorViejo);
                agregar(valorNuevo);
                veces++;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return veces > 0;
    }

    /**
     * Metodo que invierte la lista, ademas de cambiar el tipo de orden para mantener el orden
     */
    @Override
    public void invertir() {
        if(orden.getValor() == 1){
            orden = TipoOrden.DEC;
        }else{
            orden = TipoOrden.INC;
        }
        super.invertir();
    }

    /**
     * Metodo que agrega una lista a nuestra lista de forma ordenada.
     * @param listaDatos2 La lista con los datos a agregar.
     * @return true si lo que se pasa es una lista, false en caso contrario
     */
    @Override
    public boolean agregarLista(ListaAlmacenamiento listaDatos2) {
        if(listaDatos2 instanceof ListaDinamica){
            Nodo siguiente = ((ListaDinamica) listaDatos2).primero;
            while (siguiente != null){
                agregar(siguiente.getContenido());
                siguiente = siguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que inserta cambia el indice indicado por el valor dado, pero manteniendo el orden.
     * @param indice El indice que se reemplazara.
     * @param valor El nuevo valor.
     * @return true si el indice esta en rangos correctos, false en caso contrario.
     */
    @Override
    public boolean insertar(int indice, Object valor) {
        if(eliminar(indice) != null){
            agregar(valor);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Metodo que cambia los elementos de la lista2 que sen encuentren en nustra lista por el respectivo en lista2Nuevos
     * @param lista2 La lista con los posibles elementos a encontrar.
     * @param lista2Nuevos La con los elementos nuevos.
     * @return true si las listas son lista dinamicas, false en caso contrario.
     */
    @Override
    public boolean cambiarLista(ListaAlmacenamiento lista2, ListaAlmacenamiento lista2Nuevos) {
        if(lista2 instanceof  ListaDinamica && lista2Nuevos instanceof ListaDinamica){
            int posicion = 0;
            Nodo nodoSiguiente = primero;
            while (nodoSiguiente != null){
                Nodo nodoSiguiente1 = ((ListaDinamica) lista2).primero;
                Nodo nodoSiguiente2 = ((ListaDinamica) lista2Nuevos).primero;
                while (nodoSiguiente1 != null){
                    if(nodoSiguiente.getContenido() == nodoSiguiente1.getContenido()){
                        eliminar(nodoSiguiente.getContenido());
                        agregar(nodoSiguiente2.getContenido());
                    }
                    nodoSiguiente1 = nodoSiguiente1.getNodoDer();
                    nodoSiguiente2 = nodoSiguiente2.getNodoDer();
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }
}
