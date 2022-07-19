package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.ListaEstaticaNumerica;

public class PruebaListaNumerica {
    public static void main(String[] args) {

        ListaEstaticaNumerica lista = new ListaEstaticaNumerica(3);
        lista.agregar(8.0);
        lista.agregar(7.0);
        lista.agregar(9.0);
        ListaEstaticaNumerica lista2 = new ListaEstaticaNumerica(3);
        lista2.agregar(4.0);
        lista2.agregar(1.0);
        lista2.agregar(5.0);
        ListaEstaticaNumerica potencia = new ListaEstaticaNumerica(3);
        potencia.agregar(2.0);
        potencia.agregar(5.0);
        potencia.agregar(6.0);

        ListaEstaticaNumerica indices = new ListaEstaticaNumerica(3);
        indices.agregar(1.0);
        indices.agregar(2.0);
        indices.agregar(0.0);

        ListaEstaticaNumerica lista3 = new ListaEstaticaNumerica(3);
        lista2.agregar(-6.0);
        lista2.agregar(3.0);
        lista2.agregar(8.0);

        ListaEstatica listas = new ListaEstatica(3);
        listas.agregar(indices);
        listas.agregar(potencia);
        lista.porEscalar(2.0);
        lista.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        lista.sumarEscalar(1.0);
        lista.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        lista.sumar(lista2);
        lista.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        lista.multiplicar(lista2);
        lista.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        lista2.aplicarPotencia(1.0);
        lista2.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        lista2.aplicarPotencia(potencia);
        lista2.imprimir();
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola( ""+lista.productoEscalar(potencia)+"\n");
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola(""+lista.norma()+"\n");
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola(""+lista.normaEuclidiana(indices)+"\n");
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola(""+lista.sumarIndices(indices)+"\n");
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola(""+lista.sonLinealmenteIndependientes(listas)+"\n");
        SalidaPorDefecto.consola("--------------------------\n" );
        SalidaPorDefecto.consola(""+lista.esOrtogonal(lista3)+"\n");
        SalidaPorDefecto.consola(""+lista.esOrtonormal(lista2)+"\n");
    }
}
