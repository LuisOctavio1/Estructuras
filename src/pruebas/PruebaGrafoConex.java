package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.GrafoEstatico;

public class PruebaGrafoConex {
    public static void main(String[] args) {
        GrafoEstatico grafo1=new GrafoEstatico(4);
        grafo1.agregarVertice("Z");
        grafo1.agregarVertice("M");
        grafo1.agregarVertice("S");
        grafo1.agregarVertice("T");

        grafo1.agregarArista("Z","S");
        grafo1.agregarArista("Z","M");
        grafo1.agregarArista("M","T");//
        grafo1.agregarArista("T","Z");
        grafo1.agregarArista("T","S");//

        grafo1.imprimirComponentesConexoDirigido();
        SalidaPorDefecto.consola(grafo1.esGrafoFuertementeConexo() + "\n");

        GrafoEstatico grafo2 =new GrafoEstatico(4);
        grafo2.agregarVertice("Z");
        grafo2.agregarVertice("M");
        grafo2.agregarVertice("S");
        grafo2.agregarVertice("T");

        grafo2.agregarArista("Z","S");
        grafo2.agregarArista("S","Z");
        grafo2.agregarArista("Z","M");
        grafo2.agregarArista("M","Z");//
        grafo2.agregarArista("T","Z");
        grafo2.agregarArista("Z","T");
        grafo2.agregarArista("T","S");//
        grafo2.agregarArista("S","T");//

        grafo2.imprimirComponentesConexo();
        SalidaPorDefecto.consola(grafo2.esConexoNoDirigido() + "\n");
    }
}
