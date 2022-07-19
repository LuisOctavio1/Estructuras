package estructuraslineales.auxiliares;

public class NodoBusquedaArbol  {
    protected NodoDoble nodoIzq;
    protected Object indice;
    protected Object direccion;
    protected NodoDoble nodoDer;

    public NodoBusquedaArbol(Object indice, Object direccion){
        this.indice=indice;
        this.direccion = direccion;
        nodoIzq=null;
        nodoDer=null;
    }

    public NodoDoble getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoDoble nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public Object getIndice() {
        return indice;
    }

    public void setIndice(Object indice) {
        this.indice = indice;
    }

    public Object getDireccion() {
        return direccion;
    }

    public void setDireccion(Object direccion) {
        this.direccion = direccion;
    }

    public NodoDoble getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoDoble nodoDer) {
        this.nodoDer = nodoDer;
    }

    @Override
    public String toString(){
        return indice.toString();
    }
}
