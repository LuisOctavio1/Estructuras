package herramientas.generales;

import estructuraslineales.ListaEstatica;

/**
 * Clase que maneja un objeto el cual tiene una lista con validacioens y el valor de la probabilidad de esas validaciones.
 */
public class TipoCaso {
    ListaEstatica validaciones;
    double valor;
    public TipoCaso( double valor){
        this.valor = valor;
    }

    public ListaEstatica getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ListaEstatica validaciones) {
        this.validaciones = validaciones;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
