package pruebas;

import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaDinamicaDoble;
import herramientas.matematicas.Estadistica;

public class PruebaDistribucion {
    public static void main(String[] args) {
        ListaDinamicaDoble x = ArchivoTexto.leerListaDinamica("src/x.txt");
        x.imprimir();
        ListaDinamicaDoble fX = Estadistica.distribucionNormal(x,2.066433025,1.513452918);
        fX.imprimir();
        ArchivoTexto.escribirListaDinamica(fX,"f(x).txt");
        ListaDinamicaDoble Z = Estadistica.calculoZ(x,2.066433025,1.513452918);
        Z.imprimir();
        ArchivoTexto.escribirListaDinamica(Z,"Z.txt");
        ListaDinamicaDoble fZ = Estadistica.distribucionNormal(Z,0.000000000163,1.0067832);
        fZ.imprimir();
        ArchivoTexto.escribirListaDinamica(fZ,"f(Z).txt");
    }
}
