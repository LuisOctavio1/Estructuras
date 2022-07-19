package herramientas.matematicas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import estructurasnolineales.GrafoEstatico;
import herramientas.generales.TipoCaso;

/**
 * Clase que maneja las redes Bayesianas
 */
public class RedesBayesianas {
    int numNodos;
    GrafoEstatico nodos;
    ListaEstatica listaTablas;

    /**
     * Constructor de las redes bayesianas
     * @param numNodos Numero de nodos
     */
    public RedesBayesianas(int numNodos){
        this.numNodos = numNodos;
        nodos = new GrafoEstatico(numNodos);
        listaTablas = new ListaEstatica(numNodos);
    }

    /**
     * Metodo que agrega un nodo al grafo.
     * @param nodo El nodo que agregramos.
     * @return true si se agrego, false en caso contrario.
     */
    public boolean agregarNodo(Object nodo){
        return nodos.agregarVertice(nodo);
    }

    /**
     * Metodo que agrega una arista (dependensia)
     * @param salida El padre de la dependencia.
     * @param destino El destino
     * @return true si se pudo, false en caso contratrio.
     */
    public boolean agregarRelacion(Object salida, Object destino){
        return nodos.agregarArista(salida,destino);
    }

    /**
     * Este metodo genera una lista con el numero de espacio dependiendo de la cantidad de padres qeu tenga.
     * @param nodo El nodo del que haremos la lista.
     */
    public void generarLista(Object nodo){
        String vertice = nodos.buscarVertice(nodo);
        int aristas = nodos.obtenerPadres(vertice).numeroElementos();
        ListaEstatica lista = new ListaEstatica((int) Math.pow(2,aristas)+1);
        lista.agregar(vertice);
        listaTablas.agregar(lista);
    }

    /**
     * Metodo que da el indice de la taba de valores en la lista de tablas.
     * @param nodo El nodo que queremos obtener la tabla
     * @return L aposicion de la tabla
     */
    private int obtenerTabla(Object nodo){
        for(int indice = 0; indice < listaTablas.numeroElementos(); indice++){
            Integer pos = (Integer) ((ListaEstatica)listaTablas.obtener(indice)).buscar(nodo.toString());
            if(pos != null){
                return indice;
            }
        }
        return -1;
    }

    /**
     * Metodo que agrega una probabilidad a la tabla.
     * @param nodo El nodo donde agregaremos la probabilidad.
     * @param valor El valor de la probabilidad.
     * @param casos Lista con el caso, por ejemplo(true, false)
     * @return true si se pudo agregar, false en caso contrario.
     */
    public boolean agregarProbabilidad(Object nodo, double valor,ListaEstatica casos){
        Integer posicionTabla = obtenerTabla(nodo);
        TipoCaso caso = new TipoCaso(valor);
        caso.setValidaciones(casos);
        if(posicionTabla != null){
            if(((ListaEstatica)listaTablas.obtener(posicionTabla)).agregar(caso) >=0){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

    /**
     * Metodo para encontrar una probabilidad.
     * @param nodo El padre de la tabla que queremos buscar
     * @param casos Lista con el caso, por ejemplo(true, false)
     * @param opcion opcion que eligira el usuario para saber si le da la probabilidad de que pase o de que no pase.
     * @return La probabilidad.
     */
    public double encontrarProbabilidad(Object nodo,ListaEstatica casos,int opcion){
        int posicionTabla = obtenerTabla(nodo);
        if(posicionTabla >= 0){
            ListaEstatica tabla =  ((ListaEstatica)listaTablas.obtener(posicionTabla));
            for(int indice = 1; indice < tabla.numeroElementos(); indice++){
                TipoCaso caso = (TipoCaso) tabla.obtener(indice);
                ListaEstatica listaValidaciones = caso.getValidaciones();
                if(listaValidaciones.esIgual(casos)){
                    if(opcion == 1){
                        return caso.getValor();
                    }else{
                        return 1-caso.getValor();
                    }

                }
            }
        }
        return -1.0;
    }

    /**
     * Metodo que pide al usuario las validaciones de los nodos
     * @param nodo El nodo del que queremos obtener probabilidad
     * @return La probabilidad, si no se encuentra -1
     */
    public double pedirValidaciones(Object nodo){
        ListaEstatica nombres = nodos.obtenerPadres(nodo);
        if(nombres != null){
            ListaEstatica validaciones = new ListaEstatica(nombres.numeroElementos());
            for(int indice = 0; indice < nombres.numeroElementos(); indice++){
                SalidaPorDefecto.consola("Tienes/Haz " + nombres.obtener(indice)+ "\n" +
                        "Ingresa s si lo haz tenido, n si no\n");
                String eleccion =  EntradaPorDefecto.consolaCadenas();
                if(eleccion.equals("s")){
                    validaciones.agregar(true);
                }else{
                    validaciones.agregar(false);
                }
            }
            if(nodos.buscarVertice(nodo) != null && validaciones.numeroElementos() == 0){
                validaciones = new ListaEstatica(1);
                validaciones.agregar(true);
            }
            SalidaPorDefecto.consola("Ingresa 1 si quieres la probabilidad de que pase, 2 de que no pase\n");
            double opcion  = EntradaPorDefecto.consolaDouble();
            return encontrarProbabilidad(nodo,validaciones,(int)opcion);
        }
        return -1.0;
    }

    /**
     * Metodo que calcula la probabilidad conjunta de dos o mas nodos.
     * @param nodos Lista con los nombres de los nodos
     * @return La probilidad, en caso de que no se encuentre -1.
     */
    public double probabilidadConjunta(ListaEstatica nodos){
        double probabilidadCombianda = 1.0;
        boolean entro = false;
        for(int indice = 0; indice < nodos.numeroElementos(); indice++){
            double probabilidad = pedirValidaciones(nodos.obtener(indice));
            if(probabilidad >=0){
                entro = true;
                probabilidadCombianda *= probabilidad;
            }
        }
        if(entro){
            return probabilidadCombianda;
        }else{
            return  -1.0;
        }
    }


}
