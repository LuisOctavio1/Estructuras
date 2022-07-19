package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.PilaEstatica;

public class PruebaPila {
    public  static  void main(String [] argumentos){
        PilaEstatica pila=new PilaEstatica(6);

        pila.poner("G");
        pila.poner("H");
        pila.poner("Z");
        pila.poner("A");

        pila.imprimir();
        SalidaPorDefecto.consola("\n");

        SalidaPorDefecto.consola("Eliminando el último: " + pila.quitar()+ "\n");
        SalidaPorDefecto.consola("Eliminando el último: " + pila.quitar()+ "\n");

        pila.imprimir();
        SalidaPorDefecto.consola("\n");
    }
}
