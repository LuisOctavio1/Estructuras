package estructuraslineales.auxiliares;

public class NodoRectangular {
    protected NodoRectangular nodoVertical;
    protected Object contenido;
    protected NodoRectangular nodoDer;

    public NodoRectangular(Object valor){
        this.contenido=valor;
        nodoVertical =null;
        nodoDer=null;
    }

    public NodoRectangular getNodoVertical() {
        return nodoVertical;
    }

    public void setNodoVertical(NodoRectangular nodoVertical) {
        this.nodoVertical = nodoVertical;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public NodoRectangular getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoRectangular nodoDer) {
        this.nodoDer = nodoDer;
    }

    @Override
    public String toString(){
        return contenido.toString();
    }
}
