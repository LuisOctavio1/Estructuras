package pruebas;

import estructuraslineales.ColaDinamica;

public class PruebaColaDinamica {
    public static void main(String[] args) {
        ColaDinamica cola = new ColaDinamica();
        cola.poner(7);
        cola.poner(6);
        cola.poner(5);
        cola.imprimir();
        cola.quitar();
        cola.imprimir();
    }
}
