package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz2Numerica;
import utiles.TipoColumna;

public class PruebaMatriz2 {
    public static void main(String[] args) {
        /*
        Matriz2 matriz = new Matriz2(2,2,1);
        matriz.cambiar(0,0,3);
        matriz.cambiar(0,1,4);
        matriz.cambiar(1,0,5);
        matriz.cambiar(1,1,6);
        matriz.imprimirXColumnas();
        SalidaPorDefecto.consola("------------------------\n");
        matriz.transpuesta();
        matriz.imprimirXColumnas();
        SalidaPorDefecto.consola("------------------------\n");
        Matriz2 clon = matriz.clonar();
        clon.imprimirXColumnas();
        SalidaPorDefecto.consola("------------------------\n");
        SalidaPorDefecto.consola(matriz.esIgual(clon)+"\n");
        SalidaPorDefecto.consola("------------------------\n");
        clon.transpuesta();
        matriz.agregarMatrizXColumna(clon);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("------------------------\n");
        clon.transpuesta();
        matriz.agregarMatrizXRenglon(clon);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("------------------------\n");
        Matriz2 vectorColumna = matriz.aVectorColumna();
        vectorColumna.imprimirXRenglones();
        SalidaPorDefecto.consola("------------------------\n");
        Matriz2 vectorRenglon = matriz.aVectorRenglon();
        vectorRenglon.imprimirXRenglones();
        SalidaPorDefecto.consola("------------------------\n");
        matriz.quitarColumna(TipoColumna.IZQ);
        matriz.imprimirXRenglones();

         */
        Matriz2Numerica matriz2Numerica = new Matriz2Numerica(4,7,1.0);
        matriz2Numerica.imprimirXRenglones();
        //matriz2Numerica.doblarRenglones();
        matriz2Numerica.doblarColumnas();
        matriz2Numerica.imprimirXRenglones();
    }


}
