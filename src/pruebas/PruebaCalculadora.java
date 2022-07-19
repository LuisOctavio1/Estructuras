package pruebas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import herramientas.matematicas.Calculadora;

public class PruebaCalculadora {
    public static void main(String[] args) {
        SalidaPorDefecto.consola("Ingresa la expresion que deseas calcular: \n");
        String exprecion = EntradaPorDefecto.consolaCadenas();
        Calculadora calculadora = new Calculadora(exprecion);
        SalidaPorDefecto.consola(calculadora.calcularExpresion() +"");
    }


}
