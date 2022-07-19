package pruebas;

import estructuraslineales.PilaDinamica;

public class PruebaPilaDinamica {
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();
        pila.poner(3);
        pila.poner(5);
        pila.poner(6);
        pila.imprimir();
        pila.quitar();
        pila.quitar();
        pila.imprimir();
    }


}
