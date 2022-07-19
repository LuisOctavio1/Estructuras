package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.TablaHashEncadenamiento;
import estructuraslineales.TablaHashReasigniacion;

public class PruebaHash {
    public static void main(String[] args) {

        TablaHashReasigniacion hash = new TablaHashReasigniacion(23);
        hash.insertar(5);
        hash.insertar(28);
        hash.insertar("hola");
        hash.imprimir();
        SalidaPorDefecto.consola(hash.buscar(28).toString() + " Buscando el 28 \n");
        SalidaPorDefecto.consola(hash.eliminar(28).toString() + " Eliminando el 28 \n");
        hash.imprimir();
        SalidaPorDefecto.consola("------------------------------ \n");


        TablaHashEncadenamiento hashEncadenamiento = new TablaHashEncadenamiento(23);

        hashEncadenamiento.insertar(5);
        hashEncadenamiento.insertar(28);
        hashEncadenamiento.insertar("hola");
        hashEncadenamiento.imprimir();
        SalidaPorDefecto.consola(hashEncadenamiento.buscar(28).toString() + " Buscando el 28 \n");
        SalidaPorDefecto.consola(hashEncadenamiento.eliminar(28).toString() + " Eliminando el 28 \n");
        hashEncadenamiento.imprimir();

    }
}
