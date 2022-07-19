package pruebas;

import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaDinamicaOrdenada;
import estructuraslineales.ListaEstatica;
import utiles.TipoOrden;

public class PruebaListaDinamicaOrdenada {
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada(TipoOrden.INC);
        lista.agregar(6);
        lista.agregar(7);
        lista.agregar(2);
        lista.agregar(3);
        lista.imprimir();
        Integer x = 3;
        lista.eliminar(x);
        lista.imprimir();
        lista.imprimirOI();
        lista.insertarFinal(9);
        lista.agregarInicio(1);
        lista.imprimir();
        lista.eliminarInicio();
        lista.imprimir();
        ListaEstatica lista1 = new ListaEstatica(3);
        lista1.agregar(2);
        lista1.agregar(6);
        lista.eliminarLista(lista1);
        lista.imprimir();
        lista.cambiar(0,8);
        lista.imprimir();
        lista.cambiar(8,6,3);
        lista.imprimir();
        lista.invertir();
        lista.imprimir();
        lista.rellenar(8,2);
        lista.imprimir();
        ListaDinamica lista2 = new ListaDinamica();
        lista2.agregar(8);
        lista2.agregar(6);
        ListaDinamica lista3 = new ListaDinamica();
        lista3.agregar(5);
        lista3.agregar(4);
        lista.cambiarLista(lista2,lista3);
        lista.imprimir();
        lista.insertar(0,3);
        lista.imprimir();
    }


}
