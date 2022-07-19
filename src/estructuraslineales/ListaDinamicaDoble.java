package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliares.NodoDoble;

/**
 * Clase que controlara las listas dinamicas dobles.
 */
public class ListaDinamicaDoble implements ListaAlmacenamiento{
    protected NodoDoble primero;
    protected NodoDoble ultimo;
    protected NodoDoble iteradorDerecho;
    protected NodoDoble iteradorIzquierdo;

    /**
     * Constructor que inicializa los nodos en null.
     */
    public ListaDinamicaDoble(){
        primero=null;
        ultimo=null;
        iteradorDerecho = null;
        iteradorIzquierdo = null;
    }

    @Override
    public boolean vacia(){
        if(primero==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     *Metodo que agrega un elemento a la lista.
     * @param valor Es el dato que se va a agregar en la lista.
     * @return 0 si hay espacio en memoria, -1 en caso contrario.
     */
    @Override
    public int agregar(Object valor){
        NodoDoble nuevoNodo=new NodoDoble(valor); //paso 1
        if(nuevoNodo!=null){ //hay espacio
            if(vacia()==true){ //a)
                primero=nuevoNodo;//paso 2
                ultimo=nuevoNodo;
            }else{  //b)
                ultimo.setNodoDer(nuevoNodo);//paso 2
                nuevoNodo.setNodoIzq(ultimo);//paso 3
                ultimo=nuevoNodo;//paso 4
            }
            return 0;
        }else{  //no hay espacio
            return -1;
        }
    }

    @Override
    public Object imprimir(){
        if(vacia()==true){
            SalidaPorDefecto.consola("null");
        }else{
            NodoDoble temporal=primero;
            SalidaPorDefecto.consola("null <- ");
            while (temporal!=ultimo){
                SalidaPorDefecto.consola(temporal.getContenido()+ " <-> ");
                temporal=temporal.getNodoDer();
            }
            SalidaPorDefecto.consola(temporal.getContenido()+ " -> null\n");
        }
        return null;
    }

    @Override
    public void imprimirOI(){
        if(vacia()==true){
            SalidaPorDefecto.consola("null");
        }else{
            NodoDoble temporal=ultimo;
            SalidaPorDefecto.consola("null <- ");
            while (temporal!=primero){
                SalidaPorDefecto.consola(temporal.getContenido()+ " <-> ");
                temporal=temporal.getNodoIzq();
            }
            SalidaPorDefecto.consola(temporal.getContenido()+ " -> null\n");
        }
    }

    @Override
    public Object buscar(Object valor){
        NodoDoble siguiente = primero;
        while (siguiente!= null && siguiente.getContenido() != valor){
            siguiente = siguiente.getNodoDer();
        }
        if(siguiente == null){
            return null;
        }else{
            return siguiente.getContenido();
        }
    }

    @Override
    public Object eliminar(Object valor){
        if(vacia() == false){
            Object contenidoEliminado;
            NodoDoble temporal = primero;
            while (temporal != null && !temporal.getContenido().equals(valor)){
                temporal = temporal.getNodoDer();
            }
            if(temporal == null){
                return null;
            }else{
                NodoDoble siguinete = temporal.getNodoDer();
                if(primero == ultimo){
                    contenidoEliminado = temporal.getContenido();
                    primero = null;
                    ultimo = null;
                }else if(temporal == primero){
                    contenidoEliminado = temporal.getContenido();
                    primero = temporal.getNodoDer();
                    primero.setNodoIzq(null);
                }else if(temporal == ultimo){
                    contenidoEliminado = temporal.getContenido();
                    ultimo = temporal.getNodoIzq();
                    ultimo.setNodoDer(null);
                }else{
                    contenidoEliminado = temporal.getContenido();
                    temporal.getNodoIzq().setNodoDer(siguinete);
                    temporal.getNodoDer().setNodoIzq(temporal.getNodoIzq());
                }
                return contenidoEliminado;
            }
        }
        return null;
    }

    @Override
    public boolean esIgual(Object lista2) {
        NodoDoble nodoSiguiente = primero;
        if(lista2 instanceof ListaDinamicaDoble){
            NodoDoble nodoSiguiente2 = ((ListaDinamicaDoble) lista2).primero;
            while (nodoSiguiente != null && nodoSiguiente2 != null){
                if(nodoSiguiente.getContenido() != nodoSiguiente2.getContenido()){
                    return false;
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
                nodoSiguiente2 = nodoSiguiente2.getNodoDer();
            }
            if(nodoSiguiente == null && nodoSiguiente2 == null){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        int veces = 0;
        NodoDoble nodoSiguiente = primero;
        while (nodoSiguiente != null && veces < numVeces){
            if(nodoSiguiente.getContenido() == valorViejo){
                nodoSiguiente.setContenido(valorNuevo);
                veces++;
            }
        }
        return veces > 0;
    }

    @Override
    public ListaEstatica buscarValores(Object valor) {
        ListaEstatica indices = new ListaEstatica(1);
        int posicion =0;
        NodoDoble nodoSiguiente = primero;
        while (nodoSiguiente!= null){
            if(nodoSiguiente.getContenido() == valor){
                indices.agregar(posicion);
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            posicion++;
        }
        return indices;
    }

    @Override
    public Object eliminar(){
        if(vacia()==false){ //hay elementos
            Object contenidoEliminado=ultimo.getContenido();//paso 1
            if(primero==ultimo){   //b) único
                //Object contenidoEliminado=ultimo.getContenido();//paso 1
                primero=null;
                ultimo=null;//paso 2
            }else{    //c)  varios
                //Object contenidoEliminado=ultimo.getContenido();//paso 1
                ultimo=ultimo.getNodoIzq(); //paso 2
                ultimo.setNodoDer(null);//paso 3
            }
            return contenidoEliminado;
        }else {   //a)
            return null;
        }
    }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof  ListaDinamicaDoble){
            NodoDoble nodoSiguiente = ((ListaDinamicaDoble) lista2).primero;
            while (nodoSiguiente != null){
                agregar(nodoSiguiente.getContenido());
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    @Override
    public void invertir() {
        ListaDinamicaDoble listaDinamicaDoble = new ListaDinamicaDoble();
        NodoDoble siguiente = ultimo;
        while (siguiente != null){
            listaDinamicaDoble.agregar(siguiente.getContenido());
            siguiente = siguiente.getNodoIzq();
        }
        primero = listaDinamicaDoble.primero;
        ultimo = listaDinamicaDoble.ultimo;
    }

    @Override
    public int contar(Object valor) {
        NodoDoble nodoSiguiente = primero;
        int veces = 0;
        while (nodoSiguiente != null){
            if(nodoSiguiente.getContenido() == valor){
                veces++;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return veces;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if(lista2 instanceof ListaDinamicaDoble){
            NodoDoble nodoSiguiente = ((ListaDinamicaDoble) lista2).primero;
            while (nodoSiguiente != null){
                NodoDoble nodoSiguiente1 = primero;
                while (nodoSiguiente1 != null){
                    if(nodoSiguiente1.getContenido() == nodoSiguiente.getContenido()){
                        eliminar(nodoSiguiente.getContenido());
                    }
                    nodoSiguiente1 = nodoSiguiente1.getNodoDer();
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        for(int indice = 0; indice < cantidad; indice++){
            agregar(valor);
        }
    }

    @Override
    public Object clonar() {
        NodoDoble nodoSiguiente = primero;
        ListaDinamica lista = new ListaDinamica();
        while (nodoSiguiente != null){
            lista.agregar(nodoSiguiente.getContenido());
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return lista;
    }

    @Override
    public Object sublista(int indiceInicial, int indiceFinal) {
        ListaDinamicaDoble lista = new ListaDinamicaDoble();
        NodoDoble nodoSiguiente = primero;
        int indice = 0;
        while (nodoSiguiente != null && indice <= indiceFinal){
            if(indice >= indiceInicial){
                lista.agregar(nodoSiguiente.getContenido());
            }
            indice++;
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return lista;
    }

    @Override
    public void rellenar(Object valor) {
        NodoDoble nodoSiguiente = primero;
        while (nodoSiguiente != null ){
            nodoSiguiente.setContenido(valor);
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
    }

    @Override
    public boolean esSublista(ListaAlmacenamiento lista2) {
        NodoDoble nodoSiguiente = primero;
        boolean sublista = false;
        if(lista2 instanceof ListaDinamicaDoble){
            NodoDoble nodoSiguiente1 = ((ListaDinamicaDoble) lista2).primero;
            while (nodoSiguiente != null){
                if(nodoSiguiente1 != null ){
                    if(nodoSiguiente.getContenido() == nodoSiguiente1.getContenido()){
                        sublista = true;
                        nodoSiguiente1 = nodoSiguiente1.getNodoDer();
                    }else{
                        sublista = false;
                        nodoSiguiente1 = ((ListaDinamicaDoble) lista2).primero;
                    }
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            if(sublista == true && nodoSiguiente1 == null){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean cambiarLista(ListaAlmacenamiento lista2, ListaAlmacenamiento lista2Nuevos) {
        if(lista2 instanceof  ListaDinamicaDoble && lista2Nuevos instanceof ListaDinamicaDoble){
            NodoDoble nodoSiguiente = primero;
            while (nodoSiguiente != null){
                NodoDoble nodoSiguiente1 = ((ListaDinamicaDoble) lista2).primero;
                NodoDoble nodoSiguiente2 = ((ListaDinamicaDoble) lista2Nuevos).primero;
                while (nodoSiguiente1 != null){
                    if(nodoSiguiente.getContenido() == nodoSiguiente1.getContenido()){
                        nodoSiguiente.setContenido(nodoSiguiente2.getContenido());
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

    @Override
    public boolean retenerLista(ListaAlmacenamiento lista2) {
        if(lista2 instanceof  ListaDinamicaDoble){
            NodoDoble nodoSiguiente = primero;
            while (nodoSiguiente != null){
                if(lista2.buscar(nodoSiguiente.getContenido()) == null){
                    eliminar(nodoSiguiente.getContenido());
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean insertar(int indice, Object valor) {
        NodoDoble nodoSiguiente = primero;
        int posicion =0;
        while (nodoSiguiente != null){
            if(posicion == indice){
                nodoSiguiente.setContenido(valor);
                return true;
            }
            posicion++;
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return false;
    }

    @Override
    public boolean copiarLista(ListaAlmacenamiento lista2) {
        ListaDinamicaDoble listaCopia = new ListaDinamicaDoble();
        if(lista2 instanceof  ListaDinamicaDoble){
            NodoDoble nodoSiguiente = ((ListaDinamicaDoble) lista2).primero;
            while (nodoSiguiente != null){
                listaCopia.agregar(nodoSiguiente.getContenido());
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    @Override
    public Object verUltimo(){
        return ultimo.getContenido();
    }

    /**
     * Metodo que agrega un elemento al inicio de la lista.
     * @param valor El valo que queremos agregar a la lista.
     */
    public void agregarInicio(Object valor){
        NodoDoble nodo = new NodoDoble(valor);
        primero.setNodoIzq(nodo);
        nodo.setNodoDer(primero);
        primero = nodo;
    }

    /**
     * Metodo que elimina el primer elemento de la lista.
     * @return El objeto eliminado de la primera posicion
     */
    public Object eliminarInicio(){
        if(!vacia()){
            Object valorEliminado = primero.getContenido();
            if(primero == ultimo){
                primero =null;
                ultimo = null;
            }else{
                primero = primero.getNodoDer();
                primero.setNodoIzq(null);
            }
            return valorEliminado;
        }
        return null;
    }

    /**
     * Metodo que busca un elemento desde el final hasta el inicio de la lista.
     * @param valorBuscado El valor que queremos buscar.
     * @return El valor eliminado, en caso de que no se haya encontrado null.
     */
    public Object buscarDesdeFinal(Object valorBuscado){
        if(!vacia()){
            NodoDoble siguiente = ultimo;
            while (siguiente != null){
                if(siguiente.getContenido().equals(valorBuscado)){
                    return siguiente.getContenido();
                }
                siguiente = siguiente.getNodoIzq();
            }
        }
        return null;
    }

    /**
     * Metodo que inicializa el iterador derecho.
     */
    public void inicializarIteradorDerecho(){
        iteradorDerecho = ultimo;
    }

    /**
     * Metodo que inicializa el iterador izquierdo.
     */
    public void inicializarIteradorIzquierdo(){
        iteradorIzquierdo = primero;
    }

    /**
     * Metodo que retrocede el iterador derecho.
     * @param circular boolean que indicara si se retrocedera en forma circular.
     */
    public void retrocederIteradorDerecho(boolean circular){
        if(circular){
            if(iteradorDerecho.getNodoDer() !=null){
                iteradorDerecho = iteradorDerecho.getNodoDer();
            }else{
                iteradorDerecho = primero;
            }
        }else{
            if(iteradorDerecho.getNodoDer()!= null){
                iteradorDerecho = iteradorDerecho.getNodoDer();
            }
        }
    }

    public boolean hayNodosIzquierdo(){
        if(iteradorIzquierdo != null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que retrocede el iterador izquierdo.
     * @param circular boolean que indicara si se retrocedera en forma circular.
     */
    public void retrocederIteradorIzquierdo(boolean circular){
        if(circular){
            if(iteradorIzquierdo.getNodoIzq() !=null){
                iteradorIzquierdo = iteradorIzquierdo.getNodoIzq();
            }else{
                iteradorIzquierdo = ultimo;
            }
        }else{
            if(iteradorIzquierdo.getNodoIzq()!= null){
                iteradorIzquierdo = iteradorIzquierdo.getNodoIzq();
            }
        }
    }

    public Object obtenerNodo(){
        if(iteradorIzquierdo != null){
            Object contenidoNodo = iteradorIzquierdo.getContenido();
            iteradorIzquierdo = iteradorIzquierdo.getNodoDer();
            return contenidoNodo;
        }else{
            return null;
        }
    }

    public int numeroElementos(){
        int numeroElementos = 0;
        NodoDoble siguiente = primero;
        while (siguiente!= null){
            numeroElementos++;
            siguiente = siguiente.getNodoDer();
        }
        return numeroElementos;
    }
}
