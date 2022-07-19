package utiles;

public enum TipoTabla {
    FILA("FILA",1),COLUMNA("COLUMNA",2);

    private  String nombre;
    private int valor;

    private TipoTabla(String nombre, int valor){
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
