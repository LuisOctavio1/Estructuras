package pruebas;

import estructuraslineales.ListaDinamica;
import estructurasnolineales.GrafoDinamico;

public class PruebaPrim {
    public static void main(String[] args) {
        GrafoDinamico grafo = new GrafoDinamico();
        grafo.agregarVertice("1");
        grafo.agregarVertice("2");
        grafo.agregarVertice("3");
        grafo.agregarVertice("4");
        grafo.agregarVertice("5");
        grafo.agregarArista("1","2",1);
        grafo.agregarArista("2","3",3);
        grafo.agregarArista("3","4",4);
        grafo.agregarArista("3","5",2);
        grafo.agregarArista("4","5",5);
        grafo.agregarArista("1","3",4);
        grafo.agregarArista("2","4",6);
        //grafo.imprimir();
        ListaDinamica datos =  grafo.arbolDeCostoMinimo();
        grafo.imprimirArbolMinimo();

    }


}
