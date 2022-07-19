package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaDinamicaClave;
import estructurasnolineales.Matriz2;

public class PruebaListaDinamicaClave {
    public static void main(String[] args) {
        ListaDinamicaClave lista = new ListaDinamicaClave();
        lista.agregar(1,10);
        lista.agregar(2,35);
        lista.agregar(3,6);
        lista.agregar(4,10);
        lista.agregar(5,11);
        lista.imprimir();
        lista.imprimirClaves();
        lista.imprimirContenido();
        SalidaPorDefecto.consola(lista.buscar(1) + "\n");
        SalidaPorDefecto.consola(lista.buscarContenido(10) + "\n");
        SalidaPorDefecto.consola(lista.eliminar(2) + "\n");
        lista.imprimir();
        ListaDinamicaClave lista2 = new ListaDinamicaClave();
        lista2.agregar(6,7);
        lista2.agregar(1,78);
        lista.agregarLista(lista2);
        lista.eliminar(1);
        lista.eliminar(2);
        lista.eliminar(3);
        lista.eliminar(4);
        ListaDinamica claves = new ListaDinamica();
        claves.agregar(7);
        claves.agregar(8);
        ListaDinamica valores = new ListaDinamica();
        valores.agregar(1);
        valores.agregar(2);
        lista.agregarListasDinamicas(claves,valores);
        lista.imprimir();
        lista.eliminar(5);
        lista.eliminar(6);
        lista.eliminar(7);
        lista.eliminar(8);
        Matriz2 matriz2 = new Matriz2(2,2);
        matriz2.cambiar(0,0,9);
        matriz2.cambiar(0,1,15);
        matriz2.cambiar(1,0,10);
        matriz2.cambiar(1,1,2);
        lista.agregarMatriz2(matriz2);
        lista.imprimir();
    }
}
