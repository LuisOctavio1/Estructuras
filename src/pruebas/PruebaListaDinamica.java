package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaEstatica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.agregar(3);
        lista.agregar(5);
        lista.agregar(8);
        lista.imprimir();
        lista.imprimirOI();
        ListaEstatica listaEstatica = lista.aListaEstatica();
        listaEstatica.imprimir();
        lista.eliminar(1);
        lista.imprimir();
        lista.aMatriz2(4,4).imprimirXRenglones();
        lista.agregarLista(listaEstatica);
        lista.imprimir();
        lista.cambiar(2,10);
        lista.imprimir();
        SalidaPorDefecto.consola(lista.obtener(2) + "\n");
        ListaDinamica lista2 = new ListaDinamica();
        lista2.agregarLista(3);
        lista2.agregarLista(8);
        lista2.agregarLista(10);
        SalidaPorDefecto.consola(lista.esIgual(lista2) + "\n");
        lista.redimensionar(2);
        lista.imprimir();
        SalidaPorDefecto.consola(lista.contar(3) + "\n");

    }
}
