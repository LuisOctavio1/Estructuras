package pruebas;
import estructuraslineales.ListaDinamicaDoble;

public class PruebaListaDinamicaDoble {
    public static void main(String[] args) {
        ListaDinamicaDoble lista = new ListaDinamicaDoble();
        lista.agregar(3);
        lista.agregar(4);
        lista.imprimirOI();
        lista.agregar(7);
        lista.agregar(1);
        lista.agregar(6);
        lista.imprimir();
        lista.eliminar(1);
        lista.imprimir();
        lista.invertir();
        lista.agregarInicio(10);
        lista.imprimir();
        lista.eliminarInicio();
        lista.imprimir();
    }
}