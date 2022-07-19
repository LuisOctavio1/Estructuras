package utiles;

public enum TipoOrden {
    INC("INCREMENTAL",1),DEC("DECREMENTAL",2);

    private String nombre;
    private int valor;

    private TipoOrden(String nombre, int valor) {
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
