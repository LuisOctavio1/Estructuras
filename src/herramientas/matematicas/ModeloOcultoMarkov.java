package herramientas.matematicas;

import estructuraslineales.ListaEstatica;
import estructurasnolineales.GrafoEstatico;
import herramientas.generales.ActividadesMarkov;

public class ModeloOcultoMarkov {
    public GrafoEstatico modelo;
    public int estados;
    public ListaEstatica probabilidadesIniciales;
    public ListaEstatica actividades;
    public ListaEstatica probabilidadesActividades;

    /**
     * Constructor de la clase
     * @param estados Cantidad de estados del modelo
     * @param actividades Cantidad de actividades.
     */
    public ModeloOcultoMarkov(int estados, int actividades){
        this.estados = estados;
        modelo = new GrafoEstatico(estados);
        probabilidadesIniciales = new ListaEstatica(estados);
        probabilidadesActividades = new ListaEstatica(estados);
        this.actividades = new ListaEstatica(actividades);
    }

    /**
     * Metodo que agrega una actividad a la lista.
     * @param actividad Nombre de la actividad.
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarActividad(String actividad){
        return actividades.agregar(actividad) > 0;
    }

    /**
     * Metodo para agregar una probabilidad a una actividad.
     * @param estado El estado al que le agregaremos la probabilidad de la actividad.
     * @param actividad El nombre de la actividad.
     * @param probabilidad La probabilidad de la actividad.
     * @return true si se agreaga, false en caso contrario.
     */
    public boolean agregarProbabilidadActivbidad(Object estado,String actividad, double probabilidad){
        if(actividades.buscar(actividad) != null && modelo.buscarVertice(estado) != null){
            for(int indice = 0; indice < probabilidadesActividades.numeroElementos(); indice++){
                ListaEstatica probabilidades = (ListaEstatica) probabilidadesActividades.obtener(indice);
                if(probabilidades != null && probabilidades.buscar(estado) != null){
                    ActividadesMarkov nuevaProbabilidad = new ActividadesMarkov(actividad,probabilidad);
                    probabilidades.agregar(nuevaProbabilidad);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que obtiene la probabilidad de una actividad en un estado.
     * @param estado El estado
     * @param actividad El nombre de la actividad.
     * @return La probabilida, en caso de no encontrarla 0.0.
     */
    public double obtenerProbabilidadActivbidad(Object estado,String actividad){
        if(actividades.buscar(actividad) != null && modelo.buscarVertice(estado) != null){
            for(int indice = 0; indice < probabilidadesActividades.numeroElementos(); indice++){
                ListaEstatica probabilidades = (ListaEstatica) probabilidadesActividades.obtener(indice);
                if(probabilidades != null && probabilidades.buscar(estado) != null){
                    Integer pos = (Integer) probabilidades.buscar(actividad);
                    return ((ActividadesMarkov)probabilidades.obtener(pos)).getProbabilidad();

                }
            }
        }
        return 0.0;
    }

    /**
     * Metodo que agrega un estado a nuestro grafo.
     * @param estado El estado que queremos agregar.
     * @param probabilidadInicial La probabilidad de que este estado sea el primero.
     * @return true si se puede agregarm false en caso contrario.
     */
    public boolean agregarEstado(Object estado, double probabilidadInicial){
        if(modelo.agregarVertice(estado)){
            ListaEstatica lista = new ListaEstatica(2);
            lista.agregar(estado);
            lista.agregar(probabilidadInicial);
            probabilidadesIniciales.agregar(lista);
            ListaEstatica actividadEstado = new ListaEstatica(actividades.maximo()+1);
            actividadEstado.agregar(estado);
            probabilidadesActividades.agregar(actividadEstado);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que agrega una dependencia entre dos estados
     * @param inicio El estado inicial
     * @param destino El estado destino
     * @param probabilidad La probabilidad
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarDependencia(Object inicio, Object destino, double probabilidad){
        return modelo.agregarArista(inicio, destino, probabilidad);
    }

    /**
     * Metodo que obtiene la probabilidad entre dos estados.
     * @param estadoActual
     * @param estadoDestino
     * @return
     */
    public double obtenerProbabilidad(Object estadoActual, Object estadoDestino){
        return modelo.obtenerPeso(estadoActual,estadoDestino);
    }

    /**
     * Metodo para obtener la prbabilidad inicial de un estado
     * @param estado El estado a buscar
     * @return La probabilidad, en casod e que no sen encuentre 0.
     */
    public double obtenerProbabilidadInicial(Object estado) {
        for (int indice = 0; indice < probabilidadesIniciales.numeroElementos(); indice++) {
            ListaEstatica lista = (ListaEstatica) probabilidadesIniciales.obtener(indice);
            if (lista.buscar(estado) != null) {
                return (double) lista.obtener(1);
            }
        }
        return 0.0;
    }
}
