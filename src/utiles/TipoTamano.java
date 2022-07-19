package utiles;

/**
 * enum que dira cuanto aumentara o disminuira la imagen.
 */
public enum TipoTamano {
    DOBLE("DOBLE",2),TRIPLE("TRIPLE",3),CUADRUPLE("CADURPLE",4),MITAD("MITAD",.5),CUARTA("CUARTA",.25);

    private String nombre;
    private double valor;

    private TipoTamano(String nombre, double valor) {
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
