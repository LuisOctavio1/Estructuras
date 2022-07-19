package utiles;

/**
 * Ennumerado que indica si se eliminara columna de arriba o abajo.
 */
public enum TipoColumna {
    IZQ("IZQUIERDA",1),DER("DERECHA",2);

    private  String nombre;
    private int valor;

    private TipoColumna(String nombre, int valor){
        this.nombre=nombre;
        this.valor=valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
}
