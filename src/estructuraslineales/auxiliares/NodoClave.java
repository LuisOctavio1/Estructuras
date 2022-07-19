package estructuraslineales.auxiliares;
/**
 * Clase encargada de los nodos claves.
 */
public class NodoClave {
    protected Object clave;
    protected Object contenido;
    protected NodoClave nodoDer;

    /**
     * Contructor del nodo clave.
     * @param valor El valor del nodo.
     * @param clave La clave del nodo.
     */
    public NodoClave(Object valor,Object clave){
        contenido=valor;
        nodoDer=null;
        this.clave = clave;
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
    public NodoClave getNodoDer() {
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
     * Metodo que regresa la clave.
     * @return La clave del nodo.
     */
    public Object getClave(){
        return clave;
    }

    /**
     * Metodo que establece el valor de la clave.
     * @param clave La nueva clave de nuestro nodo.
     */
    public void setClave(Object clave){
        this.clave = clave;
    }

    /**
     * Metodo que setea el valor del nodo derecho.
     * @param nodoDer El nodo derecho que le queremos dar.
     */
    public void setNodoDer(NodoClave nodoDer) {
        this.nodoDer = nodoDer;
    }

    @Override
    public String toString(){
        return contenido.toString();
    }
}
