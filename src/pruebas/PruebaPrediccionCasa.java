package pruebas;

import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import herramientas.matematicas.RegresionLineal;
import menus.MenuPrediccion;

/**
 * Pruebas de la regresion lineal
 */
public class PruebaPrediccionCasa {
    public static void main(String[] args) {
        ListaEstatica valores = RegresionLineal.regresionLineal(ArchivoTexto.leer("estructuras/src/herramientas/matematicas/x.txt"),ArchivoTexto.leer("estructuras/src/herramientas/matematicas/y.txt"));
        MenuPrediccion.imprimirValoresYPrecio(valores);
    }

}
