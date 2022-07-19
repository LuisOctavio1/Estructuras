package herramientas.generales;

import estructuraslineales.ListaEstatica;

/**
 * Clase para dar las listas de validacxiones mas facil
 */
public class ListaValidaciones {
    ListaEstatica validaciones;

    public ListaValidaciones(boolean validacion){
        validaciones = new ListaEstatica(1);
        validaciones.agregar(validacion);
    }
    public ListaValidaciones(boolean validacion,boolean validacion2){
        validaciones = new ListaEstatica(2);
        validaciones.agregar(validacion);
        validaciones.agregar(validacion2);
    }
    public ListaValidaciones(boolean validacion,boolean validacion2,boolean validacion3){
        validaciones = new ListaEstatica(3);
        validaciones.agregar(validacion);
        validaciones.agregar(validacion2);
        validaciones.agregar(validacion3);
    }

    public ListaEstatica getValidaciones(){
        return validaciones;
    }
}
