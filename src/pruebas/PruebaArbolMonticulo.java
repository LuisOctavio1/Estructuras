package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinarioMonticulo;
import utiles.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        ArbolBinarioMonticulo arbol = new ArbolBinarioMonticulo(TipoOrden.INC);
        arbol.agregar(6.0);
        arbol.agregar(7.0);
        arbol.agregar(1.0);
        arbol.agregar(3.0);
        arbol.agregar(10.0);
        arbol.inorden();
        arbol.agregar(8.0);
        arbol.agregar(9.0);
        arbol.eliminar();
        SalidaPorDefecto.consola("\n");
        arbol.inorden();
    }
}
