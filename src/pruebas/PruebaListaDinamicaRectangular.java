package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaDinamicaRectangular;

public class PruebaListaDinamicaRectangular {
    public static void main(String[] args) {
        ListaDinamicaRectangular lista = new ListaDinamicaRectangular();
        lista.insertarPrimero(2);
        lista.insertarPrimero(4);
        lista.insertarPrimero(3);
        lista.insertarPrimero(7);
        lista.insertarPrimero(9);
        lista.insertarUltimo(10);
        lista.insertarUltimo(21);
        lista.insertarUltimo(15);
        lista.insertarUltimo(56);
        lista.insertarUltimo(76);
        lista.imprimir();
        lista.eliminarFinal();
        lista.eliminarFinal();
        lista.eliminarInicio();
        lista.eliminarInicio();
        lista.insertarUltimo(18);
        lista.insertarPrimero(22);
        lista.insertarPrimero(30);
        SalidaPorDefecto.consola(lista.buscar(4) + "\n");
        lista.eliminar(2);
        lista.imprimir();
    }
}
