package utiles;

/**
 * enumerado que indica si la colimna a eliminar es arriba o abajo.
 */
public enum TipoRenglon {

    SUP("ARRIBA",1),INF("ABAJO",2);

    private  String nombre;
    private int valor;

    private TipoRenglon(String nombre, int valor){
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
