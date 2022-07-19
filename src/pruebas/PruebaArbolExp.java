package pruebas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolExpAritm;

public class PruebaArbolExp {
    public static void main(String[] args) {
        ArbolExpAritm arbol = new ArbolExpAritm();
        SalidaPorDefecto.consola("Ingresa la expresion en parentesis: \n");
        String expresion =  EntradaPorDefecto.consolaCadenas();
        arbol.generarArbolParentesis(expresion);
        arbol.inorden();
        SalidaPorDefecto.consola("\n");
        arbol.preorden();
        SalidaPorDefecto.consola("\n");
        arbol.postorden();
    }
}
