package estructuraslineales;

import entradasalida.SalidaPorDefecto;

/**
 * Clase encargada de manegar las Listas Estaticas.
 */
public class ListaEstatica implements VectorLista{
    protected int MAXIMO;
    protected int ultimo;
    protected Object datos[];

    /**
     * Constructor para la Lista
     * @param maximo Tamnio maximo de la lista
     */
    public ListaEstatica(int maximo){
        MAXIMO=maximo;
        datos=new Object[MAXIMO];
        ultimo=-1;
    }

    /**
     * Metodo que indica si esta vacio la lista.
     * @returnTrue en caso de estar vacia, false en caso contrario
     */
    @Override
    public boolean vacia() {
        if(ultimo==-1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que indica si la lista esta llena.
     * @return true en caso de que este llena, false en caso contrario
     */
    @Override
    public boolean llena() {
        if(ultimo== (MAXIMO-1)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Regresa el tamanio maximo de la lista.
     * @return El maximo de la lista.
     */
    @Override
    public int maximo() {
        return MAXIMO;
    }

    /**
     * Metodo que indica el numero de elementos.
     * @return La cantidad de elementos.
     */
    @Override
    public int numeroElementos() {
        return ultimo+1;
    }

    /**
     *  Metodo para obtener un valor de la lista.
     * @param indice Indice de el objeto que queremos obtener.
     * @return El objeto de la lista
     */
    @Override
    public Object obtener(int indice) {
        if(indice < MAXIMO){
            return datos[indice];
        }else{
            return null;
        }
    }

    /**
     * Metodo para cambiar objetos en un punto especifico.
     * @param indice La posicion que queremos cambiar.
     * @param valor El nuevo objeto que queremos introducir.
     * @return true en caso de poderse cambiar, false si no.
     */
    @Override
    public boolean cambiar(int indice, Object valor) {
        if(indice <= ultimo){
            datos[indice] = valor;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que cambia la lista actual con indices dados por un parametro y valores dados por otro
     * @param indicesBusqueda Los indices que deberan ser cambiados.
     * @param valoresNuevos Los nuevos valores que se ingresaran.
     * @return true en caso de que se pudiera cambiar, false si no.
     */
    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica valoresNuevos) {
        for(int recorrido =0 ;recorrido == indicesBusqueda.numeroElementos()-1;recorrido++){
            if(!((Integer) indicesBusqueda.obtener(recorrido) <= ultimo) || valoresNuevos.numeroElementos() != indicesBusqueda.numeroElementos()){
                return false;
            }
        }
        for(int recorrido = 0; recorrido < indicesBusqueda.numeroElementos()-1;recorrido++){
            datos[(Integer) indicesBusqueda.obtener(recorrido)] = valoresNuevos.obtener(recorrido);
        }
        return true;
    }

    /**
     * Metodo para eliminar un objeto mediante su indice.
     * @param indice Lugar donde se desea eliminar el objeto.
     * @return el objeto eliminado, en caso de que no haya se regresa null.
     */
    @Override
    public Object eliminar(int indice) {
        if(indice <= ultimo){
            ultimo--;
            Object eliminado = datos[indice];
            for(int movimiento=indice;movimiento<=ultimo;movimiento++){
                datos[movimiento]=datos[movimiento+1];
            }
            return eliminado;
        }
        return null;
    }

    /**
     * Cambia el tamanio del arreglo por uno nuevo.
     * @param maximo El nuevo tamanio del arreglo
     * @return
     */
    @Override
    public Object redimensionar(int maximo) {
        if(maximo == MAXIMO){
            return null;
        }
        Object [] auxiliar = datos;
        datos = new Object[maximo];
        if(maximo > MAXIMO){
            for (int posicion = 0; posicion < MAXIMO;posicion++){
                datos[posicion] = auxiliar[posicion];
            }
            MAXIMO= maximo;
        }else{
            MAXIMO= maximo;
            for (int posicion = 0; posicion < MAXIMO;posicion++){
                datos[posicion] = auxiliar[posicion];
            }
            if(ultimo >= MAXIMO){
                ultimo = MAXIMO-1;
            }
        }
        return null;
    }

    /**
     * Metodo que agrega valores si es posible
     * @param valor Es el dato que se va a agregar en la lista.
     * @return Devulve ultimo si hay espacio, si no -1
     */
    @Override
    public int agregar(Object valor) {
        if(llena()==false){ //hay espacio
            ultimo=ultimo+1;
            datos[ultimo]=valor;
            return ultimo;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Metodo para imprimir la lista
     * @return
     */
    @Override
    public Object imprimir() {
        for(int posicion=ultimo;posicion>=0;posicion--){
            SalidaPorDefecto.consola(datos[posicion]+ "\n");
        }
        return null;
    }

    /**
     * Metodo para imprimir la lista de forma inversa
     */
    @Override
    public void imprimirOI() {
        for(int posicion=0;posicion<=ultimo;posicion++){
            SalidaPorDefecto.consola(datos[posicion]+ "\n");
        }
    }

    /**
     * Metodo para buscar un objeto en la lista.
     * @param valor El valor que queremos buscar.
     * @returnSi se encuetra se regresa la posicion, en caso contrario null.
     */
    @Override
    public Object buscar(Object valor) {
        int posicion=0;
        //buscamos mientras haya donde buscar y mientras no lo encontremos
        while(posicion< numeroElementos()){
            if(datos[posicion] != null){
                if(valor.toString().equalsIgnoreCase(datos[posicion].toString())){
                    return posicion;
                }
            }
            posicion=posicion+1;
        }
        if(posicion>ultimo){ //no loencontramos
            return null;
        }else{  //si lo encontramos
            return posicion;
        }
    }

    /**
     * Metodo para eliminar un objeto en especifico.
     * @param valor El objeto que queremos eliminar.
     * @return El objeto eliminado en caso de no haber eliminado nada null.
     */
    @Override
    public Object eliminar(Object valor) {
        Integer posicion=(Integer)buscar(valor);
        if(posicion!=null){ //si lo encontramos
            Object valorEliminado=datos[posicion];
            ultimo--;
            for(int movimiento=posicion;movimiento<=ultimo;movimiento++){
                datos[movimiento]=datos[movimiento+1];
            }
            return valorEliminado;
        }else{  //no lo encontramos
            return null;
        }
    }

    /**
     * Metodo para comparar dos listas y saber si son iguales.
     * @param lista2 Lista con la que se comparara la lista actual.
     * @return Si son iguales se devuelve true, en caso contrario false.
     */
    @Override
    public boolean esIgual(Object lista2) {
        boolean igual = false;
        if(lista2 instanceof ListaEstatica){
            if(ultimo == ((ListaEstatica) lista2).numeroElementos()-1){
                for(int indice = 0; indice <= ultimo; indice++){
                    if(datos[indice]!= ((ListaEstatica) lista2).obtener(indice)){
                        igual =  false;
                        break;
                    }else{
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

    /**
     * Metodo para cambiar valores de la lista cierta cantidad de veces.
     * @param valorViejo El valor que queremos cambiar.
     * @param valorNuevo El valor al que queremos cambair.
     * @param numVeces La cantidad de veces que queremos buscar el valor que queremos cambiar.
     * @return true en caso de que se pueda, false en caso contrario
     */
    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        boolean cambio = false;
        for(int veces = 0; veces == numVeces; veces++ ){
            if((Integer)(buscar(valorViejo)) != null){
                datos[(Integer)(buscar(valorViejo))] = valorNuevo;
                cambio = true;
            }
        }
        return cambio;
    }

    /**
     * Metodo que busca los indices de donde se encuentre el valor que buscamos
     * @param valor El valor que deseamos buscar.
     * @return La lista con los indices
     */
    @Override
    public ListaEstatica buscarValores(Object valor) {
        ListaEstatica lista = new ListaEstatica(ultimo);
        for (int indice = 0; indice == ultimo; indice++){
            if(datos[indice] == valor){
                lista.agregar(indice);
            }
        }
        return lista;
    }

    /**
     * Devulve El ultimo objeto de la lista.
     * @return El objeto.
     */
    @Override
    public Object eliminar() {
        return eliminar(ultimo);
    }

    /**
     * Metodo que vacia la lista
     */
    @Override
    public void vaciar() {
        ultimo = -1;
    }

    /**
     * Meotdo que agrega una lista en nuestra lista.
     * @param lista2 La lista que se desea agregar a nuestra lista actual.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica){
            redimensionar((ultimo+1) + ((ListaEstatica) lista2).numeroElementos());

            int indiceLista = 0;
            for(int indice = ultimo; indice < MAXIMO; indice++){

                agregar(((ListaEstatica) lista2).obtener(indiceLista));
                indiceLista++;
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
        int ind = ultimo;
        Object auxiliar[] = datos;
        datos = new Object[MAXIMO];
        for(int indice = 0; indice <=ultimo; indice++){
            datos[indice] = auxiliar[ind];
            ind--;

        }
    }

    /**
     * Cuenta la cantidad de veces que se encuentra un objeta en la lista
     * @param valor El objeto que buscaremos en nuestra lista.
     * @return La cantida de veces que estuvo.
     */
    @Override
    public int contar(Object valor) {
        int cuenta = 0;
        for(int indice = 0;indice<=ultimo;indice++){
            if(datos[indice] == valor){
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Metodo para eliminar los elementos que se encuentren de la lista2 en nuestra lista
     * @param lista2 La lista con los elementos que se quieren eliminar.
     * @return true en caso de que haya habido un cambio, false en caso contrario.
     */
    @Override
    public boolean eliminarLista(Object lista2) {

        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).maximo();indice++){
                for(int ind = 0;ind<=ultimo;ind++){
                        eliminar(((ListaEstatica) lista2).obtener(indice));
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo para rellenar la lista con un valor la cantidad de veces indicada.
     * @param valor El valor con el que se colocara en la lista
     * @param cantidad La cantidad de veces que se colocara el valor.
     */
    @Override
    public void rellenar(Object valor, int cantidad){
        int maximo=(cantidad>MAXIMO ? MAXIMO : cantidad );
        for(int pos=0;pos<maximo;pos++){
            agregar(valor);
        }
    }

    /**
     * Copia la lista en otra.
     * @return La lista copiada.
     */
    @Override
    public Object clonar() {
        ListaEstatica copia = new ListaEstatica(MAXIMO);
        copia.agregarLista(this);
        return copia;
    }

    /**
     * Metodo que genera una sublista a partir de nuestra lista con un valor incial y un final
     * @param indiceInicial El indice donde se comenzara la sublista.
     * @param indiceFinal El indice donde terminara la sublista.
     * @return regresa la sublista generada o null en caso de que los valores esten fuera de rango.
     */
    @Override
    public Object sublista(int indiceInicial, int indiceFinal) {
        if(indiceInicial >=0 && indiceFinal < MAXIMO ){
            ListaEstatica sublista = new ListaEstatica(indiceFinal);
            for(int indice = indiceInicial; indice <=indiceFinal; indice++){
                sublista.agregar(datos[indice]);
            }
            return sublista;
        }
        return null;
    }

    @Override
    public void rellenar(Object valor) {

    }

    @Override
    public boolean esSublista(ListaAlmacenamiento lista2) {
        return false;
    }

    @Override
    public boolean cambiarLista(ListaAlmacenamiento lista2, ListaAlmacenamiento lista2Nuevos) {
        return false;
    }

    @Override
    public boolean retenerLista(ListaAlmacenamiento lista2) {
        return false;
    }

    /**
     * Inserta el valor en el indice correspondiente
     * @param indice El indice donde queremos ingresar el valor.
     * @param valor El valor a ingresar.
     * @return
     */
    @Override
    public boolean insertar(int indice, Object valor) {

        if(numeroElementos() == maximo()){
            eliminar(numeroElementos()-1);
            ultimo--;
        }
        Object valorViejo = datos[numeroElementos()-1];
        for(int poscision = numeroElementos()-1; poscision >indice; poscision--){
            datos[poscision] = datos[poscision-1];
        }
        datos[indice] = valor;
        datos[numeroElementos()] = valorViejo;
        ultimo++;
        return false;
    }

    public boolean insertarValor(int indice, Object valor){
        if(indice < numeroElementos()){
            datos[indice] = valor;
            return true;
        }else{
            return false;
        }

    }

    /**
     * Metodo para copiar la lista2 en nuestro arreglo
     * @param lista2 La lista que queremos copiar a nuestro arreglo.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    @Override
    public boolean copiarLista(ListaAlmacenamiento lista2) {
        if(((ListaEstatica) lista2).numeroElementos() <= maximo()){
            for( int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++){
                datos[indice] = ((ListaEstatica) lista2).obtener(indice);
            }
            ultimo = ((ListaEstatica) lista2).numeroElementos()-1;
            return true;
        }
        return false;
    }

    /**
     * Llena una sublista con los indices indicados.
     * @param listaIndices La lista con los indices.
     * @param sublista La lista a regresar .
     * @return La lista generada.
     */
    public ListaAlmacenamiento llenarSublista(ListaEstaticaNumerica listaIndices, ListaAlmacenamiento sublista){
        for(int indice = 0; indice < listaIndices.numeroElementos(); indice++){
            if(indicesValidos((double)listaIndices.obtener(indice))){
                sublista.agregar(datos[(int)listaIndices.obtener(indice)]);
            }
        }
        return sublista;
    }

    /**
     * Regresa una lista numerica con los indices indicados.
     * @param listaIndices La lista con los indices a agregar a la lista nueva.
     * @return La lista generado con los indices
     */
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices){
        ListaEstatica sublista = new ListaEstatica(listaIndices.numeroElementos());
        sublista = (ListaEstatica) llenarSublista(listaIndices,sublista);
        return sublista;
    }

    /**
     * Comprueba que nuestro indice sea valido.
     * @param indice El indice a comprobar.
     * @return True en caso de que sea correcto, en caso contrario false.
     */
    public boolean indicesValidos(double indice){
        return indice <numeroElementos() && indice>=0;
    }

    /**
     * Guarda un buffer en el arreglo actual.
     * @param buffer El buffer a copiar.
     */
    public void guardarBuffer(double [] buffer){
        datos = new Object[buffer.length];
        for(int indice = 0; indice <buffer.length; indice++){
            datos[indice] = buffer[indice];
        }
        ultimo = datos.length-1;
        MAXIMO = buffer.length;
    }

    /**
     * Lee el arreglo actual y genera una copia.
     * @return El arreglo copiado
     */

    public Object[] leerArreglo(){
        Object [] buffer = new Object[numeroElementos()];
        for(int indice=0; indice < numeroElementos(); indice++){
            buffer[indice] = datos[indice];
        }
        return buffer;
    }

    @Override
    public Object verUltimo(){
        if (vacia()==false){
            return datos[ultimo];
        }else{
            return  null;
        }
    }
}
