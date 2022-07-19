package menus;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;

/**
 * Clase que controlara la peticion de numero de casas e impresion para el usuario.
 */
public class MenuPrediccion {
    /**
     * Metodo que pide al usuario el numero x para caluclar(numero de habitaciones).
     * @return El numero dado por el usuario.
     */
    private static Double pedirValorX(){
        SalidaPorDefecto.consola("Ingresa el valor de habitaciones de su casa para calcular el precio estimado\n");
        return EntradaPorDefecto.consolaDouble();
    }

    /**
     * Metodo que imprime los valores p y b ademas del precio calculado con el numero de habitaciones dadas.
     * @param valores Los valores p y b.
     */
    public static void imprimirValoresYPrecio(ListaEstatica valores){
        SalidaPorDefecto.consola(valores.obtener(0)+ "   " + valores.obtener(1)+"\n");
        double habitaciones =  pedirValorX();
        double precio = calcularPrecio(habitaciones,valores);
        SalidaPorDefecto.consola("El precio estimado de su casa es " + precio + " mil Dolares\n");
    }

    /**
     * Metodo que calcula el valor aproximado con la formula p + b*x
     * @param habitaciones El numero de habitaciones de la casa
     * @param valores La lista con los valores p y b
     * @return El calculo del precio.
     */
    private static double calcularPrecio(double habitaciones,ListaEstatica valores){
        return (double)valores.obtener(0) + (double)valores.obtener(1)*habitaciones;
    }
}
