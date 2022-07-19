package estructuraslineales.auxiliares;

/**
 * Clase que controla los nodos para las listas dinamicas.
 */
public class Nodo {
    protected Object contenido;
    protected Nodo nodoDer;

    public Nodo(Object valor){
        contenido=valor;
        nodoDer=null;
    }

    /**
     * Metodo que devuelve el contenido
     * @return El contenido
     */
    public Object getContenido() {
        return contenido;
    }

    /**
     * Metodo que da el nodo derecho
     * @return El nodo derecho
     */
    public Nodo getNodoDer() {
        return nodoDer;
    }

    /**
     * Metodo que setea el contenido.
     * @param contenido EL contenido que le queremos dar.
     */
    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    /**
     * Metodo que setea el valor del nodo derecho.
     * @param nodoDer El nodo derecho que le queremos dar.
     */
    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }

    @Override
    public String toString(){
        return contenido.toString();
    }
}
