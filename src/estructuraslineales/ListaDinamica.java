package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliares.Nodo;
import estructurasnolineales.Matriz2;
import utiles.TipoTabla;

/**
 * Clase que manejara las listas dinamicas.
 */
public class ListaDinamica implements ListaAlmacenamiento{
    protected Nodo primero;
    protected Nodo ultimo;
    protected Nodo iteradorIzquierdo;

    /**
     * Constructor que inicializa la lista
     */
    public ListaDinamica(){
        primero=null;
        ultimo=null;
    }

    /**
     * Metodo que indica si la lista esta vacia.
     * @return true en caso de que sea verdad, false en caso contrario.
     */
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
        Nodo nuevoNodo=new Nodo(valor); //paso 1
        if(nuevoNodo!=null){ //hay espacio
            if(vacia()==true){  //a)
                primero=nuevoNodo; //paso 2
                ultimo=nuevoNodo;
            }else{ //b) y c)
                ultimo.setNodoDer(nuevoNodo); //paso 2
                ultimo=nuevoNodo; //paso 3
            }
            return 0;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Metodo que agrega un elemento al inicio de la lista.
     * @param valor El valor a agregar.
     * @return o si se puedo, -1 en caso contrario.
     */
    public int agregarInicio(Object valor){
        Nodo nuevoNodo=new Nodo(valor); //paso 1
        if(nuevoNodo!=null){ //hay esapcio
            if(vacia()==true){ //a)
                primero=nuevoNodo; //paso 2
                ultimo=nuevoNodo;
            }else{  //b)
                nuevoNodo.setNodoDer(primero); //paso 2
                primero=nuevoNodo; //paso 3
            }
            return 0;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Metodo que imprime la lista
     * @return
     */
    @Override
    public Object Wr(){
        Nodo iterador=primero; //paso inicial
        
        while(iterador!=null){
            Object contenido=iterador.getContenido(); //paso 1
            SalidaPorDefecto.consola(contenido+" -> ");//paso 2
            iterador=iterador.getNodoDer();//paso 3
        }
        SalidaPorDefecto.consola("null\n");
        return null;
    }

    /**
     * Metodo que imprime la lista en sentido inverso
     */
    @Override
    public void imprimirOI(){
        Nodo iterador = primero;
        PilaDinamica pila = new PilaDinamica();
        while (iterador!=null){
            pila.poner(iterador.getContenido());
            iterador=iterador.getNodoDer();
        }

        SalidaPorDefecto.consola("null");
        while (pila.vacio() == false){
            SalidaPorDefecto.consola(" <- " +pila.quitar());
        }
        SalidaPorDefecto.consola("\n");

    }

    /**
     * Metodo que busca un objeto.
     * @param valor El valor que queremos buscar.
     * @return El objeto en caso de que lo encontremos, si no null.
     */
    @Override
    public Object buscar(Object valor){
        Nodo nodoBuscado = primero;
        while (nodoBuscado!= null && !nodoBuscado.getContenido().equals(valor)){
            nodoBuscado = nodoBuscado.getNodoDer();
        }
        if(nodoBuscado == null){
            return null;
        }else{
            return nodoBuscado.getContenido();
        }
    }

    /**
     * Metodo que elimina el elemento del inicio.
     * @return El valor eliminado, en caso de que la lista estuviera vacia null.
     */
    public Object eliminarInicio(){
        if(vacia()==false){ //hay algo
            Object contenidoEliminado=primero.getContenido(); //paso 1
            if(primero==ultimo){ //b
                primero=null;//paso 2
                ultimo=null;
            }else{ //c
                primero=primero.getNodoDer();//paso 2
            }
            return contenidoEliminado;
        }else{ //vacía a)
            return null;
        }
    }

    /**
     * Metodo que elimia el valor indicado(el primero que se encuentre).
     * @param valor El objeto que queremos eliminar.
     * @return El valor eliminado, en caso de que no se haya eliminado nada null.
     */
    @Override
    public Object eliminar(Object valor){
        if(vacia() == false){
            Object contenidoEliminado;
            Nodo anterior = primero;
            Nodo nodoBusacado = primero;
            while (nodoBusacado != null && !nodoBusacado.getContenido().equals(valor)){
                anterior = nodoBusacado;
                nodoBusacado = nodoBusacado.getNodoDer();
            }
            if(nodoBusacado == null){
                return null;
            }else{
                Nodo siguinete = nodoBusacado.getNodoDer();
                if(primero == ultimo){
                    contenidoEliminado = nodoBusacado.getContenido();
                    primero = null;
                    ultimo = null;
                }else if(nodoBusacado == primero){
                    contenidoEliminado = nodoBusacado.getContenido();
                    primero = siguinete;
                }else if(nodoBusacado == ultimo){
                    contenidoEliminado = nodoBusacado.getContenido();
                    ultimo = anterior;
                    ultimo.setNodoDer(null);
                }else{
                    contenidoEliminado = nodoBusacado.getContenido();
                    anterior.setNodoDer(siguinete);
                }
                return contenidoEliminado;
            }
        }
        return null;
    }

    /**
     * Metodo que indica si la lista que se de sea igual a la nuestra.
     * @param lista2 Lista con la que se comparara la lista actual.
     * @return true ne caso de que lo sea, false en caso contrario.
     */
    @Override
    public boolean esIgual(Object lista2) {
        Nodo nodoSiguiente = primero;
        if(lista2 instanceof ListaDinamica){
            Nodo nodoSiguiente2 = ((ListaDinamica) lista2).primero;
            while (nodoSiguiente != null || nodoSiguiente2 != null){
                if(nodoSiguiente.getContenido() != nodoSiguiente2.getContenido()){
                    return false;
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
                nodoSiguiente2 = nodoSiguiente2.getNodoDer();
            }
            return true;
        }else if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++){
                if(nodoSiguiente.getContenido() != ((ListaEstatica) lista2).obtener(indice)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que cambia los valores que se encuentren por el valor nuevo que se de.
     * @param valorViejo El valor que queremos cambiar.
     * @param valorNuevo El valor al que queremos cambair.
     * @param numVeces La cantidad de veces que queremos buscar el valor que queremos cambiar.
     * @return true si se hizo algun cambio, false en caso contrario
     */
    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        int veces = 0;
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente != null && veces < numVeces){
            if(nodoSiguiente.getContenido() == valorViejo){
                nodoSiguiente.setContenido(valorNuevo);
                veces++;
            }
        }
        return veces > 0;
    }

    /**
     * Metodo que regresa los indices donde se encuentre el valor.
     * @param valor El valor que deseamos buscar.
     * @return La lista estatica que se genero.
     */
    @Override
    public ListaEstatica buscarValores(Object valor) {
        ListaEstatica indices = new ListaEstatica(1);
        int posicion =0;
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente!= null){
            if(nodoSiguiente.getContenido() == valor){
                indices.agregar(posicion);
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            posicion++;
        }
        return indices;
    }

    /**
     *
     * Metodo que elimina el ultimo valor de la lista.
     * @return El objeto eliminado, en caso de no haber eliminado nada null.
     */
    @Override
    public Object eliminar(){
        if(vacia()==false){ //hay datos
            Object contenidoEliminado=ultimo.getContenido();//paso 1
            if(primero==ultimo){  //b)
                //contenidoEliminado=ultimo.getContenido();//paso 1
                primero=null; //paso 2
                ultimo=null;
            }else{ //c)
                //contenidoEliminado=ultimo.getContenido();//paso 1
                //buscar a penultimo
                Nodo penultimo=primero;
                while(penultimo.getNodoDer()!=ultimo){
                    penultimo=penultimo.getNodoDer(); //i=i+1
                }
                ultimo=penultimo; //paso 2
                ultimo.setNodoDer(null);//paso 3
            }
            return contenidoEliminado;
        }else { //a)
            return null;
        }
    }

    /**
     * Metodo que vacia la lista.
     */
    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
    }

    /**
     * Metodo que agrega una lista a nuestra lista dinamica.
     * @param lista2 La lista que se desea agregar a nuestra lista actual.
     * @return true si se puedo, false en caso contrario.
     */
    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++){
                agregar(((ListaEstatica) lista2).obtener(indice));
            }
            return true;
        }
        if(lista2 instanceof  ListaDinamica){
            Nodo nodoSiguiente = ((ListaDinamica) lista2).primero;
            while (nodoSiguiente != null){
                agregar(nodoSiguiente.getContenido());
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que invierte la lista actual.
     */
    @Override
    public void invertir() {
        Nodo iterador = primero;
        PilaDinamica pila = new PilaDinamica();
        while (iterador!=null){
            pila.poner(iterador.getContenido());
            iterador=iterador.getNodoDer();
        }
        primero = null;
        ultimo= null;
        while (!pila.vacio()){
            agregar(pila.quitar());
        }

    }

    /**
     * Metodo que cuenta cuantas veces se encuentra el valor dado.
     * @param valor El objeto que buscaremos en nuestra lista.
     * @return La ccantidad de veces que se encontro el valor.
     */
    @Override
    public int contar(Object valor) {
        Nodo nodoSiguiente = primero;
        int veces = 0;
        while (nodoSiguiente != null){
            if(nodoSiguiente.getContenido() == valor){
                veces++;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return veces;
    }

    /**
     * Metodo que elimila todos los elementos de nuestra lista que esten en la lista 2
     * @param lista2 La lista con los elementos que se quieren eliminar.
     * @return true si se pudo, false en caso contrario
     */
    @Override
    public boolean eliminarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++){
                Nodo nodoSiguiente = primero;
                while (nodoSiguiente != null){
                    if(nodoSiguiente.getContenido() == ((ListaEstatica) lista2).obtener(indice)){
                        eliminar(((ListaEstatica) lista2).obtener(indice));
                    }
                    nodoSiguiente = nodoSiguiente.getNodoDer();
                }
            }
            return true;
        }
        if(lista2 instanceof ListaDinamica){
            Nodo nodoSiguiente = ((ListaDinamica) lista2).primero;
            while (nodoSiguiente != null){
                Nodo nodoSiguiente1 = primero;
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

    /**
     * @param valor El valor con el que se colocara en la lista
     * @param cantidad La cantidad de veces que se colocara el valor.
     */
    @Override
    public void rellenar(Object valor, int cantidad) {
        for(int indice = 0; indice < cantidad; indice++){
            agregar(valor);
        }
    }

    /**
     * Metodo que clona nuestra lista.
     * @return La lista clonada
     */
    @Override
    public Object clonar() {
        Nodo nodoSiguiente = primero;
        ListaDinamica lista = new ListaDinamica();
        while (nodoSiguiente != null){
            lista.agregar(nodoSiguiente.getContenido());
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return lista;
    }

    /**
     * Metodo que regresara una sublista dada por los indices dados.
     * @param indiceInicial El indice donde se comenzara la sublista.
     * @param indiceFinal El indice donde terminara la sublista.
     * @return La lista generada.
     */
    @Override
    public Object sublista(int indiceInicial, int indiceFinal) {
        ListaDinamica lista = new ListaDinamica();
        Nodo nodoSiguiente = primero;
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

    /**
     * Metodo que rellena toda la lista con el valor dado.
     * @param valor el limite del valor.
     */
    @Override
    public void rellenar(Object valor) {
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente != null ){
            nodoSiguiente.setContenido(valor);
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
    }

    /**
     * Metodo que indica si la lista que le damos por argumento es sublista de la nuestra.
     * @param lista2 la lista que comprobaremos.
     * @return treu en caso de que lo sea, false en caso contrario.
     */
    @Override
    public boolean esSublista(ListaAlmacenamiento lista2) {
        Nodo nodoSiguiente = primero;
        boolean sublista = false;
        if(lista2 instanceof ListaDinamica){
            Nodo nodoSiguiente1 = ((ListaDinamica) lista2).primero;
            while (nodoSiguiente != null){
                if(nodoSiguiente1 != null ){
                    if(nodoSiguiente.getContenido() == nodoSiguiente1.getContenido()){
                        sublista = true;
                        nodoSiguiente1 = nodoSiguiente1.getNodoDer();
                    }else{
                        sublista = false;
                        nodoSiguiente1 = ((ListaDinamica) lista2).primero;
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

    /**
     * Metodo que si encuentra un elemento de la lista2 lo cambia por el elemento respectivo de lista2Nuevos.
     * @param lista2 La lista con los posibles elementos a encontrar.
     * @param lista2Nuevos La con los elementos nuevos.
     * @return true si se puede, false en caso contrario
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
                        cambiar(posicion,nodoSiguiente2.getContenido());
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

    /**
     * Metodo que elimina todos los elementos que no esten en la lista2
     * @param lista2 lista con los elementos a conservar.
     * @return true si se pudo, false en caso contrario
     */
    @Override
    public boolean retenerLista(ListaAlmacenamiento lista2) {
        if(lista2 instanceof  ListaDinamica){
            Nodo nodoSiguiente = primero;
            int indice = 0;
            while (nodoSiguiente != null){
                if(lista2.buscar(nodoSiguiente.getContenido()) == null){
                    eliminar(indice);
                }
                nodoSiguiente = nodoSiguiente.getNodoDer();
                indice++;
            }

            return true;
        }
        return false;
    }

    /**
     * Metodo que inserta un valor en el indice indicado, reemplazando el valor actual.
     * @param indice El indice que se reemplazara.
     * @param valor El nuevo valor.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    @Override
    public boolean insertar(int indice, Object valor) {
        Nodo nodoSiguiente = primero;
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

    /**
     * Metodo que copia la lista passada a la lista actual
     * @param lista2 La lista que copiaremos.
     * @return true si se pudo, alse en caso contrario.
     */
    @Override
    public boolean copiarLista(ListaAlmacenamiento lista2) {
        ListaDinamica listaCopia = new ListaDinamica();
        if(lista2 instanceof  ListaDinamica){
            Nodo nodoSiguiente = ((ListaDinamica) lista2).primero;
            while (nodoSiguiente != null){
                listaCopia.agregar(nodoSiguiente.getContenido());
                nodoSiguiente = nodoSiguiente.getNodoDer();
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que ensena el ultimo elemento de la lista.
     * @return El valor del ultimo elemento.
     */
    @Override
    public Object verUltimo(){
        return ultimo.getContenido();
    }

    /**
     * Metodo que ensena el primer elemento de la lista.
     * @return El valor del ultimo elemento.
     */
    public Object verPrimero(){return primero.getContenido();}

    /**
     * Metodo que genera una lista estatica a partir de nuestra lista dinamica.
     * @return La lista estatica generada.
     */
    public ListaEstatica aListaEstatica(){
        Nodo nodoSiguiente = primero;
        if(vacia()){
            return null;
        }
        ListaEstatica lista = new ListaEstatica(1);
        while(nodoSiguiente != null){
            if(lista.llena()){
                lista.redimensionar(lista.MAXIMO+1);
                lista.agregar(nodoSiguiente.getContenido());
            }else{
                lista.agregar(nodoSiguiente.getContenido());
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return lista;
    }

    /**
     * Metodo que genera una lista estatica sin los elementos de la lista elementosADescartar.
     * @param elementosADescartar Lista con los elementos que no agregaremos
     * @return La lista estatica generada
     */
    public ListaEstatica aListaEstatica(ListaEstatica elementosADescartar){
        Nodo nodoSiguiente = primero;
        if(vacia()){
            return null;
        }
        ListaEstatica lista = new ListaEstatica(1);
        while(nodoSiguiente != null){
            if(lista.llena()){
                if(elementosADescartar.buscar(nodoSiguiente.getContenido()) == null){
                    lista.redimensionar(lista.MAXIMO+1);
                    lista.agregar(nodoSiguiente.getContenido());
                }

            }else{
                if(elementosADescartar.buscar(nodoSiguiente.getContenido()) == null){
                    lista.agregar(nodoSiguiente.getContenido());
                }
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
        }
        return lista;
    }

    /**
     * Metodo que genera una matriz 2d a partir de nuestra lista.
     * @param filas El numero de filas de la matriz que generaremos.
     * @param columnas El numero de columnas de la matriz que generaremos.
     * @return La matriz con los elementos de nuestra lista
     */
    public Matriz2 aMatriz2(int filas, int columnas){
        Nodo nodoSiguiente = primero;
        Matriz2 matriz = new Matriz2(filas,columnas);
        for(int indice = 0; indice < filas; indice++){
            for(int posicion = 0; posicion < columnas; posicion++){
                if(nodoSiguiente != null){
                    matriz.cambiar(indice,posicion,nodoSiguiente.getContenido());
                    nodoSiguiente = nodoSiguiente.getNodoDer();
                }else{
                    return matriz;
                }
            }
        }
        return matriz;
    }

    /**
     * Metodo que agrega una lista al final de nuestra lista
     * @param listaDatos2 La lista con los datos a agregar
     * @return true si se pudo, false en caso contrario.
     */
    public boolean agregarLista(ListaAlmacenamiento listaDatos2){
        if(listaDatos2 instanceof ListaDinamica){
            Nodo nodoSiguiente =  ((ListaDinamica) listaDatos2).primero;
            while (nodoSiguiente != null){
                agregar(nodoSiguiente.getContenido());
            }
            return true;
        }else if(listaDatos2 instanceof ListaEstatica){
            for(int indice =0; indice < ((ListaEstatica) listaDatos2).numeroElementos(); indice++){
                agregar(((ListaEstatica) listaDatos2).obtener(indice));
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que agrega una matriz 2d a nuestra lista.
     * @param tabla La matriz 2d que agregaremos.
     * @param enumTipoTabla Enumerado que definira si agregaremos la tabla columna por fila o fila por columna
     * @return true si se puto, false en caso contrario.
     */
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla enumTipoTabla){
        if(enumTipoTabla.getValor() == 1){
            for(int fila = 0; fila < tabla.obtenerRenglones(); fila++){
                for(int col =0; col < tabla.obtenerColumnas(); col++){
                    agregar(tabla.obtener(fila,col));
                }
            }
            return true;
        }else{
            for(int col = 0; col < tabla.obtenerColumnas(); col++){
                for(int fila = 0; fila < tabla.obtenerRenglones(); fila++){
                    agregar(tabla.obtener(fila,col));
                }
            }
            return true;
        }
    }



    /**
     * Metodo que cambia un elemento.
     * @param indice El indice del elemento a cambiar.
     * @param valor El nuevo valor.
     * @return true si se pudo, false en caso contrario.
     */
    public boolean cambiar(int indice, Object valor){
        int lugar = 0;
        Nodo nodoSiguiente = primero;
        while (nodoSiguiente != null && lugar <=indice){
            if(lugar == indice){
                nodoSiguiente.setContenido(valor);
                return true;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            lugar++;
        }
        return false;
    }

    /**
     * Metodo que obtiene el valor de algo en el indice dado.
     * @param indice El indice del objeto que queremos saber.
     * @return El objeto en caso de que haya en ese indice este entre los valores de nuestra lista, null en caso contrario.
     */
    public Object obtener(int indice){
        Nodo nodoSiguiente = primero;
        int posicion = 0;
        while (nodoSiguiente != null){
            if(posicion == indice){
                return nodoSiguiente.getContenido();
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            posicion++;
        }
        return null;
    }

    /**
     * Metodo para saber si una lista dada es igual que la nuestra.
     * @param listaDatos2 La lista con la que vamos a comprar nuesta lista.
     * @return true si es igual, false en caso contrario.
     */
    public boolean esIgual(ListaAlmacenamiento listaDatos2){
        Nodo nodoSiguiente = primero;
        if(listaDatos2 instanceof ListaDinamica){
            Nodo nodoSiguiente2 = ((ListaDinamica) listaDatos2).primero;
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
            return false;
        }else if(listaDatos2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) listaDatos2).numeroElementos(); indice++){
                if(nodoSiguiente.getContenido() != ((ListaEstatica) listaDatos2).obtener(indice)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que redimenciona nuestra matriz, si se pide menos se eliminaran los datos, si se piden mas se agregaran nulls
     * @param maximo El nuevo maximo
     * @return Un null
     */
    public Object redimensionar(int maximo){
        Nodo nodoSiguiente = primero;
        int indice = 0;
        while ( nodoSiguiente != null){
            if(indice == maximo-1) {
                ultimo = nodoSiguiente;
                ultimo.setNodoDer(null);
                return null;
            }
            nodoSiguiente = nodoSiguiente.getNodoDer();
            indice++;
        }
        if(indice < maximo){
            while (indice < maximo){
                agregar(null);
                indice++;
            }
        }
        return null;
    }

    /**
     * Metodo que elimina un objeto con su indice.
     * @param indice Indice del objeto a eliminar
     * @return El objeto eliminado, null en caso de que no se haya eliminado nada.
     */
    public Object eliminar(int indice){
        if(vacia() == false){
            int posicion = 0;
            Object contenidoEliminado;
            Nodo anterior = primero;
            Nodo nodoBusacado = primero;
            while (nodoBusacado != null && posicion < indice){
                anterior = nodoBusacado;
                nodoBusacado = nodoBusacado.getNodoDer();
                posicion++;
            }
            if(posicion < indice){
                return null;
            }

            if(nodoBusacado == null){
                return null;
            }else{
                Nodo siguinete = nodoBusacado.getNodoDer();
                if(primero == ultimo){
                    contenidoEliminado = nodoBusacado.getContenido();
                    primero = null;
                    ultimo = null;
                }else if(nodoBusacado == primero){
                    contenidoEliminado = nodoBusacado.getContenido();
                    primero = siguinete;
                }else if(nodoBusacado == ultimo){
                    contenidoEliminado = nodoBusacado.getContenido();
                    ultimo = anterior;
                    ultimo.setNodoDer(null);
                }else{
                    contenidoEliminado = nodoBusacado.getContenido();
                    anterior.setNodoDer(siguinete);
                }
                return contenidoEliminado;
            }
        }
        return null;
    }
    public boolean hayNodos(){
        if(iteradorIzquierdo != null){
            return true;
        }else{
            return false;
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

    public void inicializarIterador(){
        iteradorIzquierdo = primero;
    }

    public int numeroElementos(){
        int numeroElementos = 0;
        Nodo siguiente = primero;
        while (siguiente!= null){
            numeroElementos++;
            siguiente = siguiente.getNodoDer();
        }
        return numeroElementos;
    }

}
