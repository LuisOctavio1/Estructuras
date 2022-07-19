package herramientas.matematicas;


/**
 * Clase que calcula expresiones
 */
public class Calculadora {
    private String exprecion;

    /**
     * Contructor de la calculadora
     * @param exprecion Expresion que se evaluara
     */
    public Calculadora(String exprecion){
        this.exprecion = exprecion;
    }

    /**
     * Metodo que calcula el resultado de la expresion de la calculadora.
     * @return El resultado de la operacion.
     */
    public Double calcularExpresion(){
        String postfija = ExpresionesAritmeticas.infijaAPostfija(ExpresionesAritmeticas.buscarVariables(exprecion));
        return ExpresionesAritmeticas.evaluarPostfija(postfija);
    }

    public String getExprecion() {
        return exprecion;
    }

    public void setExprecion(String exprecion) {
        this.exprecion = exprecion;
    }
}
