package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstaticaNumerica;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz2Numerica;
import utiles.TipoLogaritmo;

public class PruebaMatriz2Numerica {
    public static void main(String[] args) {
        Matriz2Numerica matriz = new Matriz2Numerica(4,4,1.0);
        Matriz2Numerica matriz2 = new Matriz2Numerica(4,4,2.0);
        Matriz2Numerica matriz3 = new Matriz2Numerica(4,4,3.0);
        Matriz2Numerica matriz4 = new Matriz2Numerica(4,4,4.0);

        matriz.porEscalar(2.0);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        matriz.sumarEscalar(1.0);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        ListaEstaticaNumerica listaEstaticaNumerica = new ListaEstaticaNumerica(4);
        listaEstaticaNumerica.agregar(1.0);
        listaEstaticaNumerica.agregar(2.0);
        listaEstaticaNumerica.agregar(3.0);
        listaEstaticaNumerica.agregar(4.0);
        matriz.sumarEscalares(listaEstaticaNumerica);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        matriz.multiplicar(matriz2);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        matriz.aplicarLogaritmo(TipoLogaritmo.BASE10);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        SalidaPorDefecto.consola(matriz.matrizDiagonlInferior()+"\n");
        SalidaPorDefecto.consola("--------------------------\n");
        matriz.matrizDiagonal(7.0);
        matriz.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        matriz3.doblarColumnas();
        matriz3.imprimirXRenglones();
        SalidaPorDefecto.consola("--------------------------\n");
        matriz4.doblarRenglones();
        matriz4.imprimirXRenglones();

    }
}
