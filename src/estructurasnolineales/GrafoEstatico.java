package estructurasnolineales;

import entradasalida.SalidaPorDefecto;

import estructuraslineales.ColaEstatica;
import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;
import estructuraslineales.ListaDinamicaDoble;
import estructurasnolineales.auxiliares.Vertice;
import herramientas.generales.EtiquetaGrafo;
import utiles.TipoOrden;

public class GrafoEstatico {
    //Dónde guardar los vértices
    protected ListaEstatica vertices;
    //Dónde guardar las aristas
    protected Matriz2 aristas;
    //Definimos el orden para trabjar con grafos ponderados
    protected TipoOrden orden;

    public GrafoEstatico(int cantidadVertices){
        vertices=new ListaEstatica(cantidadVertices);
        aristas=new Matriz2(cantidadVertices,cantidadVertices,0.0);
    }

    public GrafoEstatico(int cantidadVertices, TipoOrden orden){
        vertices=new ListaEstatica(cantidadVertices);
        this.orden=orden;
        //asignar por defecto los valores infinitos
        if(this.orden==TipoOrden.DEC){ //decremental
            aristas=new Matriz2(cantidadVertices,cantidadVertices,Double.MAX_VALUE); //+inifnito
        }else{  //incremental
            aristas=new Matriz2(cantidadVertices,cantidadVertices,Double.MIN_VALUE); //-infinito
        }
        aristas.matrizDiagonal(0.0);//diagonal con ceros
    }


    public boolean agregarVertice(Object contenido){
        //Al momento de agregar vértices es oportuno checar que no se registren contenidos duplicados.
        //Buscar la existencia del vértice
        Integer indiceVertice=(Integer)vertices.buscar(contenido);

        if(indiceVertice==null){ //no existe
            //Crear un vértice
            Vertice nuevoVertice=new Vertice();

            //Le colocamos su atributos
            nuevoVertice.setContenido(contenido);
            nuevoVertice.setNumVertice(vertices.numeroElementos()); // el número de vértice lo obtenemos de la cantidad de vértices

            int retornoOperacion=vertices.agregar(nuevoVertice);
            if(retornoOperacion>=0){ //si se pudo agregar
                return true;
            }else{ //no se pudo agregar
                return false;
            }
        }else{ //si existe
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino){ // V1 -> V2
        return agregarArista(origen,destino,1.0);
    }

    public boolean agregarArista(Object origen, Object destino, double peso){ // V1 -> V2
        //Verificar que existan
        Integer indiceOrigen=(Integer)vertices.buscar(origen);
        Integer indiceDestino=(Integer)vertices.buscar(destino);

        if(indiceOrigen!=null && indiceDestino!=null){ //si existen ambos
            //creamos la arista
            return aristas.cambiar(indiceOrigen,indiceDestino,peso);
        }else{ //uno u otro no existe
            return false;
        }
    }

    public void imprimir(){
        SalidaPorDefecto.consola("Vértices:\n");
        vertices.imprimir();

        SalidaPorDefecto.consola("Aristas:\n");
        aristas.imprimirXRenglones();
    }

    //método axuliar de paso 1 de OT
    private int gradoDeEntradaXVertice(int cadaDestino){
        int gradodeEntradaVertice=0;
        //recorrer todos los renglones (origenes) hacia el vertice destino
        for(int cadaOrigen=0; cadaOrigen< aristas.obtenerRenglones(); cadaOrigen++){
            //usando la matriz obtenemos esa flecha
            Double flecha=(Double)aristas.obtener(cadaOrigen,cadaDestino);
            if(flecha!=null && flecha>0){ //hay una flecha del orgien a ese destino
                gradodeEntradaVertice++;
            }
        }
        return gradodeEntradaVertice;
    }

    //paso 1 de OT
    private void inicializarGradosEntrada(ListaEstatica gradosEntrada){
        //recorrer todos los posibles vèrtices o procesos (destinos en la matriz), para calcular en cada uno de ellos
        //la cantidad de flechas o aristas que les llega (grados de entrada).
        for(int cadaDestino=0; cadaDestino< aristas.obtenerColumnas(); cadaDestino++){
            //para cada uno de estos destinos posibles, calculemos los grados de entrada o flechas que le llegan a èl.
            //es decir los renglones (origenes) que llegan a este destino
            int gradosEntradaXVerticeDestino=gradoDeEntradaXVertice(cadaDestino);
            gradosEntrada.agregar(gradosEntradaXVerticeDestino); // el grado de entrada se guarda en  la misma posición
            //que el vertice destino
        }
    }

    //paso 2 y 5 de OT
    private void encolarYMarcarVerticesGrado0(ListaEstatica gradosEntrada, ListaEstatica marcados, ColaEstatica colaProcesamiento){
        //recorrer todos los vèrtices para determinar lo que se requiere
        for(int cadaVertice=0;cadaVertice<gradosEntrada.numeroElementos();cadaVertice++){
            //si no esta marcado y tiene grado de E 0, encolamos y marcamos
            if((int)gradosEntrada.obtener(cadaVertice)==0 && (boolean)marcados.obtener(cadaVertice)==false){
                colaProcesamiento.poner(cadaVertice); //encolamos
                marcados.cambiar(cadaVertice,true); //marcamos
            }
        }
    }

    //paso 4 de OT
    private void recalcularGradosEntradaVertices(ListaEstatica gradosEntrada, ListaEstatica marcados, int indiceVerticeActual){
        for(int cadaDestino=0; cadaDestino< aristas.obtenerColumnas(); cadaDestino++){
            //recorremos los destinos posibles provinientes del verticeActual y si tiene flecha, le afectaba
            //y que no estuviera marcado.

            //saber si desde origen a ese destino hay flecha
            Double flecha=(Double)aristas.obtener(indiceVerticeActual,cadaDestino);
            if(flecha!=null && flecha>0 && (boolean)marcados.obtener(cadaDestino)==false){ //hay flecha hacia ese destino
                //actualizamos la incidencia o grado de entrada, es decir, se resta en 1
                int gradoEntradaVerticeDestino=(int)gradosEntrada.obtener(cadaDestino);
                gradosEntrada.cambiar(cadaDestino,gradoEntradaVerticeDestino - 1);
            }
        }
    }

    //mètodo principal de OT
    public ListaDinamica ordenacionTopologica(){
        ListaDinamica ordenProcesos=new ListaDinamica(); // es el resultado de la ordenación topológica
        ColaEstatica colaProcesamiento=new ColaEstatica(vertices.numeroElementos());
        ListaEstatica gradosEntrada=new ListaEstatica(vertices.numeroElementos());
        ListaEstatica marcados=new ListaEstatica(vertices.numeroElementos());

        //0.-En otro módulo o función deberá llevarse a cabo una verificación de no existencia de ciclos.
        for (int indice = 0; indice < vertices.numeroElementos(); indice++){
            if(hayRuta(vertices.obtener(indice),vertices.obtener(indice))){
                return ordenProcesos;
            }
        }
        //1.- Inicializar las incidencias (grados de entrada de los vértices).
        inicializarGradosEntrada(gradosEntrada);

        //2.- Los procesos (vértices) con grados de entrada en 0 (no marcados)
        // se colocan en una cola de procesamiento y se marcan como ya analizados.

        //inicializar los mrcados como false
        marcados.rellenar(false,vertices.numeroElementos());
        //invocar al mètodo que determina el paso 2 como tal
        encolarYMarcarVerticesGrado0(gradosEntrada, marcados, colaProcesamiento);

        while(colaProcesamiento.vacio()==false) { //mientras no esté vacía
            //3.- Sacar un proceso (vértice) de la cola de procesamiento y
            // lo ejecutamos (mientras haya datos en la cola).
            int indiceVerticeActual=(int)colaProcesamiento.quitar();
            Vertice verticeActual=(Vertice)vertices.obtener(indiceVerticeActual);
            ordenProcesos.agregar(verticeActual.getContenido());

            //4.- Recalcular grados de entrada dado el paso 3.
            recalcularGradosEntradaVertices(gradosEntrada, marcados, indiceVerticeActual);

            //5.- Los procesos (vértices) con grado de entrada 0 (no marcados) se colocan
            // en la cola de procesamiento y se marcan como ya analizados.
            encolarYMarcarVerticesGrado0(gradosEntrada, marcados, colaProcesamiento);
        }
        return ordenProcesos;
    }

    //paso 3 de recorrido en profundidad
    private void enpilarYMarcarVerticesAdyacentes(int indiceVerticeActual, PilaEstatica pila, ListaEstatica marcados){
        for(int cadaDestino=0;cadaDestino<aristas.obtenerColumnas(); cadaDestino++){
            //recorremos a todos los destinos posibles a partir de lvértice actual (origen)
            Double flecha=(Double)aristas.obtener(indiceVerticeActual,cadaDestino);
            //hay flecha si hay adyacencia y no están marcados
            if(flecha!=null && flecha>0 && (boolean)marcados.obtener(cadaDestino)==false){
                //enpilamos
                pila.poner(cadaDestino);
                //marcamos
                marcados.cambiar(cadaDestino,true);
            }
        }
    }

    //Recorrido en profundidad
    public ListaDinamica recorridoProfunidad(Object origen){
        ListaDinamica recorridoP=new ListaDinamica();
        PilaEstatica pila=new PilaEstatica(vertices.numeroElementos());
        ListaEstatica marcados=new ListaEstatica(vertices.numeroElementos());

        //Pasos:

        //0. Validar la existencia del origen.
        Integer indiceOrigen=(Integer)vertices.buscar(origen);
        if(indiceOrigen!=null){ //existe
            //1.- Partir de un vértice origen. Este vértice se marca y se mete en una pila.
            //Llenar el arreglo de marcados con falsos.
            marcados.rellenar(false,vertices.numeroElementos());
            //marcamos este vértice origen
            marcados.cambiar(indiceOrigen,true);
            //meter el origen en la pila
            pila.poner(indiceOrigen);

            while(pila.vacio()==false) {
                //2.- Mientras existan vértices en la pila, se van a extraer (de uno por uno) y se procesarán (imprimir).
                int indiceVerticeActual=(int)pila.quitar(); //sacamos de pila
                Vertice verticeActual=(Vertice)vertices.obtener(indiceVerticeActual); //obtenemos el objeto vértice
                recorridoP.agregar(verticeActual.getContenido());//agregamos en la salida el contenido del vértice

                //3.- Los vértices adyacentes (vecinos directos) no marcados y que están enlazados al nodo que actualmente
                // se procesa (el paso 2) se marcan y se meten en la pila.
                enpilarYMarcarVerticesAdyacentes(indiceVerticeActual, pila, marcados);
            }
        }else{ //no existe
            return null;
        }

        return recorridoP;
    }


    ///////////////////////////////////////////////////DIJKSTRA

    // Paso 1
    private void inicializarEtiquetasGrafo(ListaEstatica etiquetasOptimas, int indiceVerticeOrigen, double metricaIndiceOrigen,
                                           double metricaVertices, int verticeAnterior){
        for(int cadaVertice=0; cadaVertice<vertices.numeroElementos(); cadaVertice++){
            EtiquetaGrafo etiqueta=new EtiquetaGrafo();
            etiqueta.setMetricaAcumulada(metricaVertices); // en este caso en nuestro ejemplo era infinito....
            etiqueta.setVerticeAnterior(verticeAnterior); // por ejemplo en nuestro caso - (-1)
            etiqueta.setInteracion(0);
            etiquetasOptimas.agregar(etiqueta);//agregarla a nuestro arreglo de de etiquetas
        }
        //en particular falta cambiar el valor e la métrica en el vértice origen -> 0
        EtiquetaGrafo etiquetaVerticeOrigen=(EtiquetaGrafo) etiquetasOptimas.obtener(indiceVerticeOrigen);
        etiquetaVerticeOrigen.setMetricaAcumulada(metricaIndiceOrigen); // por ejemplo con 0.0
    }

    // Paso 2
    private void actualizarMetricaAcumuladaEtiquetas(int verticeActual, ListaEstatica etiquetasOptimas, ListaEstatica permanentes, int iteracion,
                                                     double infinito){

        //recorrer todos los vértices
        for(int cadaPosibleVecino=0; cadaPosibleVecino<aristas.obtenerColumnas();cadaPosibleVecino++){
            //checar cuáles son vecinos no marcados
            Double flechaMetricaOrigenActualDestino=(Double)aristas.obtener(verticeActual, cadaPosibleVecino);
            if(flechaMetricaOrigenActualDestino!=null && flechaMetricaOrigenActualDestino!=0 && flechaMetricaOrigenActualDestino!=infinito &&
                    (boolean)permanentes.obtener(cadaPosibleVecino)==false){
                //calcularemos las métricas acumuladas desde el vértice actual a este cada vecino adyacente y si resulta mejor la métrica
                //se actualizará en la etiqueta

                //sacar la métrica acumulada del vértice actual
                EtiquetaGrafo etiquetaVerticeActual=(EtiquetaGrafo) etiquetasOptimas.obtener(verticeActual);
                double metricaAcumuladaVerticeActual=etiquetaVerticeActual.getMetricaAcumulada();
                //sumar la métrica acumulada del vértice actual +  la métrica del vértice actual hacia el vecino
                double metricaAcumuladaVerticeActualDestino= metricaAcumuladaVerticeActual + flechaMetricaOrigenActualDestino;

                //sacar la métrica acumulada del vecino
                EtiquetaGrafo etiquetaVerticeDestino=(EtiquetaGrafo) etiquetasOptimas.obtener(cadaPosibleVecino);
                double metricaVerticeDestino=etiquetaVerticeDestino.getMetricaAcumulada();

                //comparar si es mejor la métrica acumulada hacia un vecino desde el origen actual
                //no olvidad si es DEC y INC
                boolean banderaActualizarEtiqueta=false;
                if(orden==TipoOrden.DEC){ //más chico es mejor
                    if(metricaAcumuladaVerticeActualDestino<metricaVerticeDestino){ //si es mejor, actualizar
                        banderaActualizarEtiqueta=true;
                    }
                }else{ //INC, más grande es mejor
                    if(metricaAcumuladaVerticeActualDestino>metricaVerticeDestino){ //si es mejor, actualizar
                        banderaActualizarEtiqueta=true;
                    }
                } //if
                if(banderaActualizarEtiqueta==true){ //cambiar los valores de la etiqueta
                    etiquetaVerticeDestino.setInteracion(iteracion);
                    etiquetaVerticeDestino.setMetricaAcumulada(metricaAcumuladaVerticeActualDestino);
                    etiquetaVerticeDestino.setVerticeAnterior(verticeActual);
                }
            }//if vecino
        } //for
    }

    // Etiquetas de Dijkstra

    public ListaEstatica etiquetasOptimasDijkstra(Object origen){
        ListaEstatica etiquetasOptimas=new ListaEstatica(vertices.numeroElementos()); //arreglo paralelo para las etiquetas
        ListaEstatica permanentes=new ListaEstatica(vertices.numeroElementos()); //arreglo paralelo para los marcados como permanentes
        //definimos el infinito
        double infinito=0;
        if(orden==TipoOrden.DEC){ //decremental, más chico es mejor,  +infinito
            infinito=Double.MAX_VALUE;
        }else{ //incremental, más grande es mejor, -infinito
            infinito=Double.MIN_VALUE;
        }

        //Pasos:

        //0.- Validar que el oirgen exista
        Integer indiceVerticeOrigen=(Integer)vertices.buscar(origen);
        if(indiceVerticeOrigen!=null) { //si existe el origen

            //1.- Inicializar etiquetas partiendo de un nodo origen, marcándolo como permanente.
            inicializarEtiquetasGrafo(etiquetasOptimas, indiceVerticeOrigen, 0.0, infinito, -1);
            //marcar el vértice origen como permanente
            permanentes.rellenar(false, vertices.numeroElementos());//rellenado con falsos
            permanentes.cambiar(indiceVerticeOrigen,true); //marcamos el origen

            //indicar que el vértice origen es el vértice Actual, para la primera itreración
            int verticeActual=indiceVerticeOrigen;
            for(int iteracion=1; iteracion< vertices.numeroElementos(); iteracion++) { // el último vértice no se necesita procesar en el paso 2 y 3
                //2.- Calcular los nuevos valores de las etiquetas de los vértices a partir de las métricas acumuladas hacia
                //    los vecinos (adyacentes) no marcados como permanentes; todo esto partiendo del vértice acrtual. si se mejora
                //    la métrica, se actualiza la etiqueta de ese vértice.
                actualizarMetricaAcumuladaEtiquetas(verticeActual, etiquetasOptimas, permanentes,iteracion, infinito);

                //3.- Elegir el vértice con la mejor métrica acumulada (óptima), tomando en cuenta vértices no marcados como permanentes.
                //    entonces ese vértice elegido se marca y se convierte en el vértice actual.
            }
            return etiquetasOptimas;
        }else{ //no existe el origen
            return null;
        }
    }

    // Métria Origen -> Destino
    public double obtenerMetricaOptimaDijkstra(Object origen, Object destino){
        return 0.0;
    }

    // Ruta de Origen -> Destino
    public ListaDinamica obtenerRutaOptimaDijkstra(Object origen, Object destino){
        return null;
    }

    /**
     * Metodo que elimina un vertice del grafo
     * @param vertice El vertice a eliminar
     * @return El vertice eliminado, en caso de que no se elimine nada null.
     */
    public Object eliminarVertica(Object vertice){
        Integer pos = (Integer) vertices.buscar(vertice);
        if(pos != null){
            for(int fila = 0; fila < aristas.renglones; fila++){
                for(int col = 0; col < aristas.columnas;col++){
                    if(col == pos){
                        aristas.cambiar(fila,col,0.0);
                    }
                    if(fila == pos){
                        aristas.cambiar(fila,col,0.0);
                    }
                }
            }
            acomodarAristas(pos);
            Object eliminado = vertices.eliminar(vertice);;
            vertices.redimensionar(vertices.maximo()-1);
            return eliminado;
        }
        return null;
    }

    /**
     * Metodo auxiliar que acomoda la matriz de aristas al eliminar un vertice
     * @param pos La posicion del vertice eliminado.
     */
    private void acomodarAristas(int pos){
        for(int fila = 0; fila < aristas.renglones; fila++){
            for(int col = 0; col < aristas.columnas;col++){
                    if(fila >= pos){
                        aristas.cambiar(fila,col,aristas.obtener(fila+1,col));
                    }
            }
        }
        for(int col = 0; col < aristas.columnas; col++){
            for(int fila = 0; fila < aristas.renglones;fila++) {
                if(col >= pos){
                    aristas.cambiar(fila,col,aristas.obtener(fila,col+1));
                }

            }
        }
        for(int indice = 0; indice < aristas.columnas; indice++){
            aristas.cambiar(aristas.renglones-1,indice,0.0);
            aristas.cambiar(indice,aristas.columnas-1,0.0);
        }
    }

    /**
     * Metodo que indica si dos vertices son adyacentes.
     * @param origen El vertice inicial
     * @param destino El vertice final
     * @return true si lo es, false en caso contrario
     */
    public boolean esAdyacente(Object origen, Object destino){
        Integer posOrigen = (Integer) vertices.buscar(origen);
        Integer posDestino = (Integer) vertices.buscar(destino);
        ListaDinamicaDoble listaOrigen = new ListaDinamicaDoble();
        ListaDinamicaDoble listaDestino = new ListaDinamicaDoble();
        if(posDestino!= null && posOrigen != null){
            for(int indice = 0; indice < aristas.renglones; indice++){
                if(aristas.obtener(posOrigen,indice) != null){
                    listaOrigen.agregar(aristas.obtener(posOrigen,indice));
                }
                if(aristas.obtener(posDestino,indice) != null){
                    listaDestino.agregar(aristas.obtener(posDestino,indice));
                }
            }
            listaOrigen.inicializarIteradorIzquierdo();
            while (listaOrigen.hayNodosIzquierdo()){
                if(listaDestino.buscar(listaOrigen.obtenerNodo()) != null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que elimina una arista de el grafoi
     * @param origen El vertice origen de la arista.
     * @param destino El vertice destino.
     * @return true en caso de que se haya eliminado, false en caso contrario.
     */
    public boolean eliminarArista(Object origen, Object destino){
        Integer posOrigen = (Integer) vertices.buscar(origen);
        Integer posDestino = (Integer) vertices.buscar(destino);
        if(posDestino!= null && posOrigen != null){
            return aristas.cambiar(posOrigen,posDestino,0.0);
        }
        return false;
    }

    /**
     * Metodo que busca un vertice e imprime todos los datos.
     * @param vertice El vertice a buscar
     * @return los datos del vertice
     */
    public String buscarVertice(Object vertice){
        Integer pos = (Integer)vertices.buscar(vertice);
        if(pos != null){
            Vertice vertice1 = (Vertice) vertices.obtener(pos);
            if(vertice != null){
                return vertice1.getContenido().toString();
            }
        }
        return null;
    }

    /**
     * Metodo que indica si el grafpo es unpsudo grafo
     * @return true si lo es, false en caso contrario
     */
    public boolean esPseudografo(){
        for(int indice = 0; indice < aristas.columnas; indice++){
            if((Integer)aristas.obtener(indice,indice) != 0.0){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que indica si el grafo es multi grafo.
     * @return true si lo es, false en caso contrario
     */
    public boolean esMultiGrafo(){
        for(int fila =0; fila < aristas.renglones; fila++){
            for(int col = 0; col < aristas.columnas; col++){
                if((double)aristas.obtener(fila,col) != 0.0 && (double)aristas.obtener(fila,col) != 0.0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que indica el grado del vertice(cuantas aristas tiene).
     * @param vertice El vertice que buscaremos
     * @return El grado del vertice.
     */
    public int gradoVertice(Object vertice){
        Integer pos = (Integer) vertices.buscar(vertice);
        int cantidad = 0;
        if(pos != null){
            for(int fila= 0; fila < aristas.renglones; fila++){
                if((double)aristas.obtener(fila,pos) != 0.0){
                    cantidad++;
                }
            }
            for(int col =0; col < aristas.columnas; col++){
                if((double)aristas.obtener(pos,col) != 0.0 && col != pos){
                    cantidad++;
                }
            }
            return cantidad;
        }
        return 0;
    }

    /**
     * Metodo que indica si hay una ruta entre dos vertices.
     * @param origen El origen del camino
     * @param destino El final del camino
     * @return true si lo hay, false en caso contrario.
     */
    public boolean hayRuta(Object origen, Object destino){
        Integer pos = (Integer) vertices.buscar(origen);
        Integer posActual = pos;
        PilaEstatica pila = new PilaEstatica(vertices.numeroElementos());
        ListaDinamica lista = new ListaDinamica();
        if(pos!= null){
            pila.poner(vertices.obtener(pos));
            while (!pila.vacio()){
                posActual = (Integer) vertices.buscar(pila.verUltimo());
                Vertice vertice = (Vertice) pila.quitar();
                for(int col =0; col < aristas.columnas; col++){
                    boolean valido = (double)aristas.obtener(posActual,col) != 0.0;
                    if(vertice.toString() == destino.toString() && valido){
                        return true;
                    }else{
                        if(valido && lista.buscar(col) == null){
                            lista.agregar(col);
                            pila.poner(vertices.obtener(col));
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metodo que indica si el grafo es conexo
     * @return true si lo es, false en caso contrario
     */
    public boolean esConexo(){
        for(int indice = 0; indice < vertices.numeroElementos(); indice++){
            ListaDinamica lista = recorridoProfunidad(vertices.obtener(indice));
            for(int pos = 0; pos < vertices.numeroElementos(); pos++) {
                if (lista.buscar(vertices.obtener(pos).toString()) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que indica si hay un camino cerrado(si hay ciclos)
     * @param origen El origen donde se intentara ahcer el ciclo.
     * @return tru si lo hay, false en caso contrario.
     */
    public boolean hayCaminoCerrado(Object origen){
        Integer pos = (Integer) vertices.buscar(origen);
        Integer posActual = pos;
        PilaEstatica pila = new PilaEstatica(vertices.numeroElementos());
        ListaDinamica lista = new ListaDinamica();
        if(pos!= null){
            pila.poner(vertices.obtener(pos));
            while (!pila.vacio()){
                posActual = (Integer) vertices.buscar(pila.verUltimo());
                Vertice vertice = (Vertice) pila.quitar();
                for(int col =0; col < aristas.columnas; col++){
                    boolean valido = (double)aristas.obtener(posActual,col) != 0.0;
                    if(vertice.toString() == origen.toString() && valido && posActual != col){
                        return true;
                    }else{
                        if(valido && lista.buscar(col) == null){
                            lista.agregar(col);
                            pila.poner(vertices.obtener(col));
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metodo que indica si hay un camino simple entre dos vertices.
     * @param origen El origen del camino.
     * @param destino EL fin del camino.
     * @return true en caso de que haya, false en caso contrario.
     */
    public boolean esCaminoSimple(Object origen, Object destino){
        ListaDinamicaDoble  lista = new ListaDinamicaDoble();
        lista.agregarLista(ordenacionTopologica());
        lista.inicializarIteradorIzquierdo();
        return hayRuta(origen, destino);
    }

    /**
     * Metodo que indica si el grafo es dirigido.
     * @return true en caso de que lo sea, false en caso contrario.
     */
    public boolean esDirigido(){
        boolean valido = false;
        for(int fila = 0; fila < aristas.renglones; fila++){
            for (int col = 0; col < aristas.columnas; col++){
                if(((double)aristas.obtener(fila,col) != 0.0 && (double)aristas.obtener(col,fila) != 0.0) ||((double)aristas.obtener(fila,col) == 0.0 && (double)aristas.obtener(col,fila) == 0.0)){

                    valido = false;
                }else{
                    return true;
                }

            }

        }
        return valido;
    }

    /**
     * Metodo que imprime todas las aristas en formato (origen,destino,peso)
     */
    public void listarAristas(){
        SalidaPorDefecto.consola("[ ");
        for(int fila = 0; fila < aristas.renglones; fila++) {
            for (int col = 0; col < aristas.columnas; col++) {
                if((double)aristas.obtener(fila,col) != 0.0){
                    SalidaPorDefecto.consola("(" +vertices.obtener(fila) + ","+vertices.obtener(col)+","+aristas.obtener(fila,col) + ") ");
                }

            }
        }
        SalidaPorDefecto.consola("]");
    }

    public ListaEstatica obtenerPadres(Object vertice){
        Integer posVertice = (Integer) vertices.buscar(vertice);
        if(posVertice != null){
            int cantPadres = gradoDeEntradaXVertice(posVertice);
            ListaEstatica padres = new ListaEstatica(cantPadres);
            for(int fila = 0; fila < aristas.columnas; fila++){
                if((double)aristas.obtener(fila,posVertice) != 0.0){
                    padres.agregar(vertices.obtener(fila));
                }
            }
            return padres;
        }
        return null;
    }

    /**
     * Metodo que imprime todas las aristas de un vertice en formato (origen,destino,peso)
     * @param vertice El vertice del que se imprimiras las aristas.
     */
    public void listarAristas(Object vertice){
        SalidaPorDefecto.consola("[ ");
        Integer posVertice = (Integer) vertices.buscar(vertice);
        if(posVertice != null){
            for(int col = 0; col < aristas.columnas; col++){
                if((double)aristas.obtener(posVertice,col) != 0.0){
                    SalidaPorDefecto.consola("(" +vertices.obtener(posVertice) + ","+vertices.obtener(col)+","+aristas.obtener(posVertice,col) + ") ");
                }
            }
        }
        SalidaPorDefecto.consola("]");
    }

    /**
     * Metodo que imprime los vertices.
     */
    public void listarVertices(){
        vertices.imprimir();
    }

    /**
     * Metodo que regresa todos los componentes conexos del grafo.
     * @return Lista con estos.
     */
    public ListaDinamicaDoble componentesConexoNoDirigido(){
        if(!esDirigido()){
            if(!vertices.vacia()){
                ListaDinamica recorridoProfunidad = recorridoProfunidad(vertices.obtener(0));
                ListaDinamicaDoble recorridos = new ListaDinamicaDoble();
                recorridos.agregar(recorridoProfunidad);
                ListaEstatica marcados =new ListaEstatica(vertices.numeroElementos());
                for(int indice =0; indice < vertices.numeroElementos(); indice++){
                    if(marcados.buscar(vertices.obtener(indice)) != null){
                        ListaDinamica recorrido = recorridoProfunidad(vertices.obtener(indice));
                        recorridos.agregar(recorrido);
                        recorrido.inicializarIterador();
                        while (recorrido.hayNodos()){
                            Object objeto = recorrido.obtenerNodo();
                            if(marcados.buscar(objeto) == null){
                                marcados.agregar(objeto);
                            }

                        }
                    }
                }
                return recorridos;

            }
        }
        return null;
    }

    /**
     * Metodo que indica si el grafo es conexo no dirigido, esto llamando al metodo anterior y comprobando que solo tenga un elemento en su interior.
     * @return true si solo tiene uno, false en caso contrario.
     */
    public boolean esConexoNoDirigido(){
        ListaDinamicaDoble conexos = componentesConexoNoDirigido();
        if(conexos != null){
            return conexos.numeroElementos() == 1;
        }
        return false;
    }

    /**
     * Metodo que imprime todos los componentes conexos.
     */
    public void imprimirComponentesConexo(){
        ListaDinamicaDoble conexos = componentesConexoNoDirigido();
        if(conexos != null){
            conexos.inicializarIteradorIzquierdo();
            while (conexos.hayNodosIzquierdo()){
                ListaDinamica recorridos = (ListaDinamica) conexos.obtenerNodo();
                recorridos.imprimir();
                SalidaPorDefecto.consola("\n");
            }
        }
    }

    /**
     * Metodo que regresa los componentes conexo del grafdo si este es dirigido.
     * @return Una lista con todos los componentes.
     */
    public ListaDinamica componentesConexoDirigido(){
        if(esDirigido()){
            ListaEstatica marcados = new ListaEstatica(vertices.numeroElementos());
            ListaDinamica recorridos = new ListaDinamica();
            int inicio = 0;
            while (!marcados.llena()){
                ListaDinamica recorridoProf = recorridoProfunidad(vertices.obtener(inicio));
                ListaDinamica recorridoProfInve = conexoDeGrafoInvertido(inicio);
                recorridoProf.inicializarIterador();
                ListaDinamica conexoActual = new ListaDinamica();
                while (recorridoProf.hayNodos()){
                    Object vertice = recorridoProf.obtenerNodo();
                    if(recorridoProfInve.buscar(vertice) != null ){
                        marcados.agregar(vertice);
                        conexoActual.agregar(vertice);
                    }

                }
                for(int indice = 0; indice < vertices.numeroElementos(); indice++){
                    if(marcados.buscar(vertices.obtener(indice).toString()) == null){
                        inicio = indice;
                    }
                }
                recorridos.agregar(conexoActual);
            }
            return recorridos;
        }
        return null;
    }

    /**
     * Metodo que indica si el grafo es fuertemente conexo.
     * @return true si lo es, false en caso contrario.
     */
    public boolean esGrafoFuertementeConexo(){
        ListaDinamica conexos = componentesConexoDirigido();
        if(conexos != null){
            return conexos.numeroElementos() == 1;
        }
        return false;
    }

    /**
     * Metodo que imprime los componentes conexo si nuestro grafo es dirigido.
     */
    public void imprimirComponentesConexoDirigido(){
        ListaDinamica conexos = componentesConexoDirigido();
        if(conexos != null){
            conexos.inicializarIterador();
            while (conexos.hayNodos()){
                ListaDinamica recorridos = (ListaDinamica) conexos.obtenerNodo();
                recorridos.imprimir();
                SalidaPorDefecto.consola("\n");
            }
        }
    }

    /**
     * Metodo auxiliar que crea un grafo con las fleachas al contrario (si hay un A apuntando a z, en este grafo seria un z apuntando a A)
     * @param inicio El indice del vertice por el que comenzaremos.
     * @return El recorrido en profundidad del grafo generado.
     */
    private ListaDinamica conexoDeGrafoInvertido(int inicio){
        GrafoEstatico grafo = new GrafoEstatico(vertices.maximo());
        grafo.vertices.copiarLista(vertices);
        for(int fila = 0; fila < aristas.renglones; fila++) {
            for (int col = 0; col < aristas.columnas; col++) {
                grafo.aristas.cambiar(col,fila,aristas.obtener(fila,col));
            }
        }
        return grafo.recorridoProfunidad(vertices.obtener(inicio));
    }

    public double obtenerPeso(Object inicio, Object destino){
        Integer nodoInicial =  (Integer) vertices.buscar(inicio);
        Integer nodoDestino =  (Integer) vertices.buscar(destino);
        if(nodoInicial != null && nodoDestino != null){
            return (double) aristas.obtener(nodoInicial,nodoDestino);
        }else{
            return 0.0;
        }
    }
}
