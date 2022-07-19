package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaEstatica;
import estructuraslineales.ListaEstaticaOrdenada;
import estructuraslineales.PilaDinamica;
import estructurasnolineales.auxiliares.Vertice;
import utiles.TipoOrden;

public class GrafoDinamico {
    protected ListaDinamica listaAdyacencia; //guarda las listas secundarias (vértices orígenes hacia losdestinos).
    protected ListaDinamica listaPesos;

    public GrafoDinamico() {
        listaAdyacencia = new ListaDinamica();
        listaPesos = new ListaDinamica();
    }

    private ListaDinamica buscarVerticeListaAdyacencia(Object contenidoVertice) {
        //Recorrer la lista de Adycacencia para buscarlo solo en la primera posicion de cada sublista

        listaAdyacencia.inicializarIterador();

        while (listaAdyacencia.hayNodos() == true) { //recorremos la lista
            //sacamos un elemento de la lista, es decir una sublista
            ListaDinamica subListaCadaVertice = (ListaDinamica) listaAdyacencia.obtenerNodo();
            //checar si el primer elemento de cada sublista es igual al que nos dan como argumento
            Vertice primerVerticeCadasublista = (Vertice) subListaCadaVertice.verPrimero();
            //checo si este primero es igual al que me dan como argumento
            if (primerVerticeCadasublista.toString().equalsIgnoreCase(contenidoVertice.toString()) == true) { //sí está
                return subListaCadaVertice;
            }
        }
        //en caso que nunca entre el ciclo o al if, quiere decir que no lo encontramos
        return null;
    }

    private ListaDinamica buscarVerticeListaPesos(Object contenidoVertice) {
        //Recorrer la lista de Adycacencia para buscarlo solo en la primera posicion de cada sublista

        listaPesos.inicializarIterador();

        while (listaPesos.hayNodos() == true) { //recorremos la lista
            //sacamos un elemento de la lista, es decir una sublista
            ListaDinamica subListaCadaVertice = (ListaDinamica) listaPesos.obtenerNodo();
            //checar si el primer elemento de cada sublista es igual al que nos dan como argumento
            Vertice primerVerticeCadasublista = (Vertice) subListaCadaVertice.verPrimero();
            //checo si este primero es igual al que me dan como argumento
            if (primerVerticeCadasublista.toString().equalsIgnoreCase(contenidoVertice.toString()) == true) { //sí está
                return subListaCadaVertice;
            }
        }
        //en caso que nunca entre el ciclo o al if, quiere decir que no lo encontramos
        return null;
    }

    public boolean agregarVertice(Object contenido) {
        // Checar si existe o no ese vértice
        // Para esto debemos buscar en la primera posicion de cada sublista
        ListaDinamica sublistaVerticeAEncontrar = buscarVerticeListaAdyacencia(contenido);

        if (sublistaVerticeAEncontrar == null) { //no existe, podemos agregarlo
            ListaDinamica sublistaVerticeNuevo = new ListaDinamica();  //creamos la sublista del vértice nuevo
            ListaDinamica sublistaPeso = new ListaDinamica();
            Vertice verticeNuevo = new Vertice();  //creamos un nuevo vértice
            verticeNuevo.setContenido(contenido);
            sublistaVerticeNuevo.agregar(verticeNuevo); //agregamos el vértice nuevo a su propia sublista
            sublistaPeso.agregar(verticeNuevo);
            listaPesos.agregar(sublistaPeso);
            //agregamos la sublista a la lista de adycacencia
            if (listaAdyacencia.agregar(sublistaVerticeNuevo) == 0) { //si se pudo agregar
                return true;
            } else { //no se pudo agregar
                return false;
            }
        } else { //ya existe
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino, double peso) {
        //Se ocupa saber si el origen y el destino existen
        ListaDinamica subListaOrigen = buscarVerticeListaAdyacencia(origen);
        ListaDinamica subListaDestino = buscarVerticeListaAdyacencia(destino);

        //checar si son existentes
        if (subListaOrigen != null && subListaDestino != null) { //existen
            //sacamos el primer vértice de la sublista del destino
            ListaDinamica sublistaPesos = buscarVerticeListaPesos(origen);
            Vertice verticeDestino = (Vertice) subListaDestino.verPrimero();
            //agregar este vértice al final de la sublista del origen
            if (subListaOrigen.agregar(verticeDestino) == 0) { //si se pudo agregar
                sublistaPesos.agregar(peso);
                return true;
            } else { //no se pudo agregar
                return false;
            }
        } else { //no existen
            return false;
        }
    }


    public void imprimir() {
        //Recorrer la lista de adyacencia y sacar cada una de las sublistas
        listaAdyacencia.inicializarIterador();

        while (listaAdyacencia.hayNodos() == true) {
            ListaDinamica sublistaCadaVertice = (ListaDinamica) listaAdyacencia.obtenerNodo();
            //imprimir cada sublista
            sublistaCadaVertice.imprimir();
            SalidaPorDefecto.consola("\n");
        }
    }

    //paso 3 de recorrido en profundidad
    private void enpilarYMarcarVerticesAdyacentes(ListaDinamica sublistaVerticeActual, PilaDinamica pila, ListaDinamica marcados) {

        sublistaVerticeActual.inicializarIterador();
        sublistaVerticeActual.obtenerNodo(); //nos brincamos el primero, que es el vértice actual

        //empezaremos a partir del segundo, que son los vecinos del primero (vértice actual)
        while (sublistaVerticeActual.hayNodos() == true) {
            //obtener elemento de la sublista (vecino)
            Vertice verticeVecino = (Vertice) sublistaVerticeActual.obtenerNodo();
            //checar si está marcado, porque vecino si es
            if (marcados.buscar(verticeVecino.getContenido()) == null) { //no está, por lo tanto no está marcado
                //enpilamos
                pila.poner(verticeVecino);
                //marcamos
                marcados.agregar(verticeVecino);
            }
        }
    }

    //Recorrido en profundidad
    public ListaDinamica recorridoProfunidad(Object origen) {
        ListaDinamica recorridoP = new ListaDinamica();
        PilaDinamica pila = new PilaDinamica();
        ListaDinamica marcados = new ListaDinamica();

        //Pasos:

        //0. Validar la existencia del origen.
        ListaDinamica sublistaOrigen = buscarVerticeListaAdyacencia(origen);
        if (sublistaOrigen != null) { //existe
            //1.- Partir de un vértice origen. Este vértice se marca y se mete en una pila.
            //sacar el vértice Oirgen de la sublista
            Vertice verticeOrigen = (Vertice) sublistaOrigen.verPrimero();
            //marcamos este vértice origen
            marcados.agregar(verticeOrigen);
            //meter el origen en la pila
            pila.poner(verticeOrigen);

            while (pila.vacio() == false) {
                //2.- Mientras existan vértices en la pila, se van a extraer (de uno por uno) y se procesarán (imprimir).
                Vertice verticeActual = (Vertice) pila.quitar(); //sacamos de pila
                recorridoP.agregar(verticeActual.getContenido());//agregamos en la salida el contenido del vértice

                //3.- Los vértices adyacentes (vecinos directos) no marcados y que están enlazados al nodo que actualmente
                // se procesa (el paso 2) se marcan y se meten en la pila.
                //Obtener la sublista del vértice actual
                ListaDinamica subListaVerticeActual = buscarVerticeListaAdyacencia(verticeActual.getContenido());
                enpilarYMarcarVerticesAdyacentes(subListaVerticeActual, pila, marcados);
            }
        } else { //no existe
            return null;
        }
        return recorridoP;
    }

    /**
     * Metodo que calcula el arbol de costo minimo del grafo.
     * @return Lista con los vertices recorridos en orden.
     */
    public ListaDinamica arbolDeCostoMinimo() {
        ListaDinamica u = new ListaDinamica();
        ListaDinamica l = new ListaDinamica();
        u.agregar(listaAdyacencia.verPrimero());
        ListaDinamica verticesRecorridos = new ListaDinamica();
        verticesRecorridos.agregar(((ListaDinamica) listaAdyacencia.verPrimero()).verPrimero());
        while (listaAdyacencia.numeroElementos() != u.numeroElementos()) {
            ListaDinamica datos = aristaMenor((ListaDinamica) u.verUltimo(),u,verticesRecorridos);

            String arista =   ((ListaDinamica) datos.verPrimero()).verPrimero()+"";
            verticesRecorridos.agregar(arista+"");
            arista = ((ListaDinamica)u.verUltimo()).verUltimo() +"," + arista;
            l.agregar(arista);
            u.agregar(datos.verPrimero());
        }
        ListaDinamica datos = new ListaDinamica();
        datos.agregar(u);
        datos.agregar(l);
        return datos;
    }

    /**
     * Metodo que indica el vertice que sigue seleccionando la arista menor.
     * @param vertice El ultimo vertice de u
     * @param u Lisra con todos los vertices recorridos
     * @param verticesRecorridos Lista con todos los vertices recorridos (solo el contenido).
     * @return Lista que es el nuevo vertice.
     */
    private ListaDinamica aristaMenor(ListaDinamica vertice, ListaDinamica u,ListaDinamica verticesRecorridos){
        Object verticeActual = vertice.verPrimero();
        ListaDinamica pesos = buscarVerticeListaPesos(verticeActual);
        int ciclo = 1;
        double menor = 0;
        if(vertice.numeroElementos() > 1){
            menor = (double) pesos.obtener(1);
        }else{
            vertice = (ListaDinamica) u.obtener(u.numeroElementos()-2);
            pesos = buscarVerticeListaPesos(vertice.obtener(0));
            menor = (double) pesos.obtener(1);
            ciclo = 2;
        }

        while (ciclo < listaAdyacencia.numeroElementos()){
            ListaEstaticaOrdenada orden = new ListaEstaticaOrdenada(pesos.numeroElementos(), TipoOrden.INC);
            ListaEstatica listaAux = new ListaEstatica(vertice.numeroElementos());
            for(int posicion= 1; posicion < pesos.numeroElementos();posicion++){
                orden.agregar(pesos.obtener(posicion));
                listaAux.agregar(pesos.obtener(posicion));
            }
            Integer iteracionnnn = (Integer) listaAux.buscar(orden.obtener(0));
            ListaDinamica nuevoVertice = buscarVerticeListaAdyacencia(vertice.obtener(iteracionnnn+1));
            String nuevo = nuevoVertice.verPrimero()+"";
            if(verticesRecorridos.buscar(nuevo) == null){
                ListaDinamica nuevaLista = new ListaDinamica();
                nuevaLista.agregar(nuevoVertice);
                nuevaLista.agregar(menor);
                return nuevaLista;
            }else{
                ciclo++;
                vertice = (ListaDinamica) u.obtener(u.numeroElementos()-ciclo);
            }
        }


        return null;
    }

    /**
     * Meotodo que imprime el arbol minimo.
     */
    public void imprimirArbolMinimo(){
        ListaDinamica datos = arbolDeCostoMinimo();
        ListaDinamica vertices = (ListaDinamica) datos.obtener(0);
        vertices.inicializarIterador();
        SalidaPorDefecto.consola("Vertices\n");
        while (vertices.hayNodos()){
            ListaDinamica lista = (ListaDinamica)vertices.obtenerNodo();
            SalidaPorDefecto.consola(lista.verPrimero() + " -> ");
        }
        SalidaPorDefecto.consola("null");
    }
}
