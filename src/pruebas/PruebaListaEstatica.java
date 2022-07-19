package pruebas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.ListaEstaticaOrdenada;
import utiles.TipoOrden;

public class PruebaListaEstatica {
    public static void main(String argumentos[]){
        /*
        ListaEstatica lista=new ListaEstatica(6);

        lista.agregar("F");
        lista.agregar("D");
        lista.agregar("A");
        lista.agregar("S");
        lista.agregar("G");

        lista.imprimir();

        SalidaPorDefecto.consola("\n");

        lista.imprimirOI();

        SalidaPorDefecto.consola("\n");

        SalidaPorDefecto.consola("Buscando el valor: D ->" + lista.buscar("D")+ "\n");
        SalidaPorDefecto.consola("Buscando el valor: H ->" + lista.buscar("H")+ "\n");

        SalidaPorDefecto.consola("Eliminando A: "+lista.eliminar("A")+ "\n");
        SalidaPorDefecto.consola("Eliminando Z: "+lista.eliminar("Z")+ "\n");

        lista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");

        SalidaPorDefecto.consola("Prueba de entrada: ");
        String cadenaEntrada=EntradaPorDefecto.consolaCadenas();
        SalidaPorDefecto.consola("Tecleaste: "+cadenaEntrada);


        lista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");

        lista.invertir();
        lista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");
        lista.redimensionar(3);
        lista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");
        lista.redimensionar(8);
        lista.agregar(7);
        lista.agregar(9);
        lista.agregar("A");
        lista.imprimir();

        SalidaPorDefecto.consola("---------------------\n");
        lista.cambiar(0,"w");
        lista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");
        ListaEstatica sublista = (ListaEstatica) lista.sublista(0,3);
        sublista.imprimir();
        SalidaPorDefecto.consola("---------------------\n");
        lista.agregarLista(sublista);
        lista.imprimir();

        if (lista.llena()){
            SalidaPorDefecto.consola("La lista esta llena \n" );
        }
        lista.eliminar(7);
        if (lista.llena()){
            SalidaPorDefecto.consola("La lista esta llena \n" );
        }else{
            SalidaPorDefecto.consola("La lista no esta llena \n");
        }
        lista.imprimir();

        SalidaPorDefecto.consola("---------------------\n");
        lista.agregarLista(sublista);

        lista.imprimir();
        lista.eliminarLista(sublista);
        SalidaPorDefecto.consola("---------------------\n");
        lista.imprimir();
        */
        ListaEstaticaOrdenada lista = new ListaEstaticaOrdenada(16, TipoOrden.INC);
        lista.agregar("Z");
        lista.agregar("M");
        lista.agregar("N");

        //lista.cambiar(4,3,1);
        lista.agregar("K");
        lista.agregar("U");
        lista.agregar("O");
        lista.imprimir();
        /*

        lista.imprimir();
        Integer valor = 2;
        lista.eliminar(valor);
        lista.imprimir();
        lista.cambiar(2,9);
        lista.imprimir();

        /*
        ListaEstaticaOrdenada nueva = new ListaEstaticaOrdenada(4,TipoOrden.INC);
        nueva.agregar(20);
        nueva.agregar(25);
        nueva.agregar(10);
        lista.agregarLista(nueva);
        lista.imprimir();


         */

        //lista.invertir();
        /*
        lista.imprimir();
        ListaEstaticaOrdenada listo = new ListaEstaticaOrdenada(3,TipoOrden.DEC);
        listo.agregar("A");
        listo.agregar("B");
        listo.agregar("C");
        listo.imprimir();
        //System.out.println(lista.esSublista(listo));

         */
        /*
        ListaEstaticaOrdenada listaxd = new ListaEstaticaOrdenada(2,TipoOrden.INC);
        ListaEstaticaOrdenada listax = new ListaEstaticaOrdenada(2,TipoOrden.INC);
        listaxd.agregar("A");
        listaxd.agregar("C");
        listax.agregar("P");
        listax.agregar("H");
        //lista.cambiarLista(listaxd,listax);
        lista.imprimir();
        lista.imprimir();
        lista.insertar(1,"I");
        lista.imprimir();

         */



        //System.out.println(lista.buscar(3));

    }
}
