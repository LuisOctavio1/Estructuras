package utiles;

/**
 * Clase que dira de que tipo de logaritmo se obtendar.
 */
public enum TipoLogaritmo {
    BASE10("BASE10",10.0),BASE2("BASE2",2.0),NATURAL("NATURAL",2.718);

    private String nombre;
    private double valor;

    private TipoLogaritmo(String nombre, double valor) {
        this.nombre=nombre;
        this.valor=valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }
}
