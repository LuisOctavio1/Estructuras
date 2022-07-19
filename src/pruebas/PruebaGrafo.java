package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.GrafoEstatico;

public class PruebaGrafo {
    public static void main(String[] args) {
        GrafoEstatico grafo1=new GrafoEstatico(4);

        grafo1.agregarVertice("Z");
        grafo1.agregarVertice("M");
        grafo1.agregarVertice("S");
        grafo1.agregarVertice("T");

        grafo1.agregarArista("Z","S");
        grafo1.agregarArista("M","S");
        grafo1.agregarArista("Z","M");
        grafo1.agregarArista("M","T");//
        grafo1.agregarArista("T","Z");
        grafo1.agregarArista("Z","T");
        grafo1.agregarArista("T","S");//
        grafo1.imprimir();
        grafo1.eliminarVertica("S");
        //grafo1.eliminarVertica("M");

        //grafo1.eliminarVertica("Z");
        grafo1.imprimir();
        SalidaPorDefecto.consola(grafo1.esAdyacente("T","Z") + "\n");
        SalidaPorDefecto.consola(grafo1.buscarVertice("Z") + "\n");
        SalidaPorDefecto.consola(grafo1.agregarArista("Z","Z") + " \n");
        SalidaPorDefecto.consola(grafo1.esMultiGrafo() + "\n");
        SalidaPorDefecto.consola(grafo1.gradoVertice("Z") + "\n");
        SalidaPorDefecto.consola(grafo1.hayRuta("Z","M") + "\n"  );
        SalidaPorDefecto.consola(grafo1.esConexo() + "\n");

        grafo1.listarAristas();
        SalidaPorDefecto.consola("\n");
        grafo1.listarAristas("Z");
        SalidaPorDefecto.consola("\n");
        grafo1.listarVertices();
    }


}
