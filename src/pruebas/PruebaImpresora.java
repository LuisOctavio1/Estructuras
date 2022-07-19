package pruebas;

import impresora.Impresora;
import menus.menusimulaciones.MenuImpresora;

public class PruebaImpresora {
    public static void main(String[] args) {
        Impresora impresora = new Impresora(10);
        MenuImpresora.imprimirAgregarObjeto(impresora.agregarImpresion("Trabajo.txt",6));
        MenuImpresora.imprimirAgregarObjeto(impresora.agregarImpresion("Imagen.png",1));
        MenuImpresora.imprimirAgregarObjeto(impresora.agregarImpresion("TrabajoFinal.txt",10));
        impresora.imprimirColaImpresora();
        MenuImpresora.imprimirObjetoImpreso(impresora.imprimir());
        MenuImpresora.imprimirObjetoImpreso(impresora.imprimir());
        MenuImpresora.imprimirObjetoImpreso(impresora.imprimir());
        MenuImpresora.imprimirObjetoImpreso(impresora.imprimir());
    }
}
