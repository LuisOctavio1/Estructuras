package pruebas;

import entradasalida.SalidaPorDefecto;
import herramientas.matematicas.CalculosAritmeticos;
import herramientas.matematicas.Conversiones;

public class PruebaRecursion {
    public static void main(String[] args) {
        SalidaPorDefecto.consola(CalculosAritmeticos.multiplicacion(3,6) +"\n");
        SalidaPorDefecto.consola (CalculosAritmeticos.esNumeroPrimo(97) +"\n");
        SalidaPorDefecto.consola (Conversiones.esBinario(101011) +"\n");
        SalidaPorDefecto.consola (Conversiones.esBinario(123001)+"\n");
        SalidaPorDefecto.consola (Conversiones.aHexadecimal(65029)+"\n");
        SalidaPorDefecto.consola (CalculosAritmeticos.maximoComunDivisor(412,228)+"\n");
        SalidaPorDefecto.consola (Conversiones.decimalABinario(150)+"\n");
    }

}
