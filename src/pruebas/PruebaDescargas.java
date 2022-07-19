package pruebas;

import descargas.Descargas;
import menus.menusimulaciones.MenuDescargas;

public class PruebaDescargas {
    public static void main(String[] args) {
        Descargas descargas = new Descargas(5);
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("Apex",10));
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("Archivo.pdf",1));
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("video.mp4",3));
        descargas.imprimirColaDescargas();
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("peli.mp4",2));
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("programaMasImportante.exe",100));
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("imagen.png",4));
        MenuDescargas.imprimirAgregarDescarga(descargas.agregarDescarga("archivo.pdf",1));
        descargas.imprimirColaDescargas();
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
        MenuDescargas.imprimirObjetoDescargado(descargas.terminarDescarga());
    }

}
