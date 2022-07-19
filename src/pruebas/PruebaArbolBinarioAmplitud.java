package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinarioBusqueda;

public class PruebaArbolBinarioAmplitud {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.agregar(8);
        arbol.agregar(3);
        arbol.agregar(1);
        arbol.agregar(6);
        arbol.agregar(4);
        arbol.agregar(7);
        arbol.agregar(10);
        arbol.agregar(14);
        arbol.agregar(13);
        arbol.eliminacionABB(1);
        arbol.eliminacionABB(14);
        arbol.eliminacionABB(8);
        arbol.postordenIterativo();
        SalidaPorDefecto.consola("\n");
        arbol.amplitud();
        SalidaPorDefecto.consola("\n");
        arbol.amplitudPila();

    }
}
