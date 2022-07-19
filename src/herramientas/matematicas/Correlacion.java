package herramientas.matematicas;

import estructuraslineales.ListaDinamicaDoble;

/**
 * Metodo encargado de la correlacion.
 */
public class Correlacion {
    /**
     * Metodo que calcula el coeficienteMuestral de dos lsitas.
     * @param datosX La lista doble con los datos x.
     * @param datosY La lista doble con los datos y
     * @return El calculo de el coeficiente muestral.
     */
    public static double coeficienteMuestral(ListaDinamicaDoble datosX, ListaDinamicaDoble datosY){
        int cantidad = datosX.numeroElementos();
        double sumatoriaX = calcularSumatoriaDatos(datosX,1);
        double sumatoriaY = calcularSumatoriaDatos(datosY,1);
        double sumatoriaXAlCuadrado = Math.pow(sumatoriaX,2);
        double sumatoriaYAlCuadrado = Math.pow(sumatoriaY,2);
        double sumatoriaXCuadrada = calcularSumatoriaDatos(datosX,2);
        double sumatoriaYCuadrada = calcularSumatoriaDatos(datosY,2);
        double sumatoriaXY = calcularSumatoriaXY(datosX,datosY);
        return (cantidad*sumatoriaXY-sumatoriaX*sumatoriaY)/Math.sqrt ((cantidad*sumatoriaXCuadrada-sumatoriaXAlCuadrado)*(cantidad*sumatoriaYCuadrada-sumatoriaYAlCuadrado));
    }

    /**
     * Metodo que calcula el coeficiente poblacional de dos lsitas.
     * @param datosX La lista doble con los datos x.
     * @param datosY La lista doble con los datos y
     * @return El calculo de el coeficiente poblacional.
     */
    public static double coeficientePoblacional(ListaDinamicaDoble datosX, ListaDinamicaDoble datosY){
        double promedioX = calcularPromedio(datosX);
        double promedioY = calcularPromedio(datosY);
        double covarianza = covarianciaMuestral(datosX,datosY,promedioX,promedioY);
        double desviacionX = calcularDesviacionPoblacional(datosX,promedioX);
        double desviacionY = calcularDesviacionPoblacional(datosY,promedioY);
        return covarianza/(desviacionX*desviacionY);
    }

    /**
     * Metodo que calcula la covariancia de dos conjuntos de datos.
     * @param datosX La lista con los datos x.
     * @param datosY La lista con los datos y.
     * @param promedioX El promedio de los datos x.
     * @param promedioY El promedio de los daots y.
     * @return El calculo de la covarianza muestral.
     */
    private static double covarianciaMuestral(ListaDinamicaDoble datosX, ListaDinamicaDoble datosY,double promedioX,double promedioY){
        datosX.inicializarIteradorIzquierdo();
        datosY.inicializarIteradorIzquierdo();
        double suma = 0;
        while (datosX.hayNodosIzquierdo()){
            suma = suma + (Double.parseDouble((String) datosX.obtenerNodo())  - promedioX) *(Double.parseDouble((String) datosY.obtenerNodo()) - promedioY);
        }
        return suma/(datosX.numeroElementos()-1);

    }

    /**
     * Metodo que calcula la sumatoria de un conjunto de datos.
     * @param datos Lista con los daots.
     * @param elevacion indica a que potencia se eleva el dato a x potencia
     * @return la sumatoria.
     */
    private static double calcularSumatoriaDatos(ListaDinamicaDoble datos,int elevacion){
        datos.inicializarIteradorIzquierdo();
        double suma = 0;
        while (datos.hayNodosIzquierdo()){
            suma = suma + Math.pow( Double.parseDouble((String) datos.obtenerNodo()),elevacion);
        }
        return suma;
    }

    /**
     * Metodo que calcula la sumatoria de el conjunto de datos x por el conjunto de datos y
     * @param datosX la lista con los datos x
     * @param datosY la lista con las datos y
     * @return la sumatoria dada.
     */
    private static double calcularSumatoriaXY(ListaDinamicaDoble datosX, ListaDinamicaDoble datosY){
        datosX.inicializarIteradorIzquierdo();
        datosY.inicializarIteradorIzquierdo();
        double suma = 0;
        while(datosY.hayNodosIzquierdo()){
            suma = suma + (Double.parseDouble((String) datosX.obtenerNodo())*Double.parseDouble((String)datosY.obtenerNodo()));
        }
        return suma;
    }

    /**
     * Metodo que calcula el promedio de un conjunto de datos.
     * @param datos La lista con los datos.
     * @return El promedio de los datos.
     */
    private static double calcularPromedio(ListaDinamicaDoble datos){
        datos.inicializarIteradorIzquierdo();
        double suma = 0;
        while (datos.hayNodosIzquierdo()){
            suma = suma + Double.parseDouble((String) datos.obtenerNodo());
        }
        return suma/datos.numeroElementos();
    }

    /**
     * Metodo que calcula la desviasion estandar poblacional de un conjunto de datos
     * @param datos La lista con los datos.
     * @param primedioDatos El promedio de los datos.
     * @return La desviasion poblacional.
     */
    private static double calcularDesviacionPoblacional(ListaDinamicaDoble datos, double primedioDatos){
        datos.inicializarIteradorIzquierdo();
        double suma = 0;
        while (datos.hayNodosIzquierdo()){
            suma = suma + Math.pow (Double.parseDouble((String) datos.obtenerNodo()) - primedioDatos,2);
        }
        return Math.sqrt(suma/datos.numeroElementos()) ;
    }

}
