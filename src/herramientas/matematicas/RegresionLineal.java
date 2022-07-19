package herramientas.matematicas;

import estructuraslineales.ListaEstatica;

/**
 * Clase que calcula la regresion lineal de dos listas.
 */
public class RegresionLineal {
    /**
     * Meodo que calculadara los valores de b y p para predicciones con regresion lineal.
     * @param x Lista estatica con los valores de x para caluclar la regresion Lineal.
     * @param y Lista estatica con los valores de y para calcular la regresion Lineal.
     * @return Una lista estatica con los valores de p y b.
     */
    public static ListaEstatica regresionLineal(ListaEstatica x, ListaEstatica y){
        ListaEstatica valores = new ListaEstatica(2);
        double alfa = 0.009;
        double p = 0;
        double b = 0;
        for(int indice = 0; indice < 100000; indice++){
            ListaEstatica sumatorias = regresarSumatoriasDeDerivadas(x,y,p,b);
            p = p - alfa*(double)sumatorias.obtener(0);
            b = b - alfa*(double)sumatorias.obtener(1);
        }
        valores.agregar(p);
        valores.agregar(b);
        return  valores;
    }

    /**
     * Calcula las sumatorias de las derivadas parciales respecto de theta0 y theta1
     * @param x Lista con los valores x
     * @param y Lista con los valores de y
     * @param p Valor de p
     * @param b Valor de b
     * @return Lista con las dos sumatorias de las derivadas
     */
    private  static ListaEstatica regresarSumatoriasDeDerivadas(ListaEstatica x, ListaEstatica y,double p , double b){
        double sum0 = 0.0;
        double sum1 = 0.0;
        for(int posicion = 0; posicion < x.numeroElementos(); posicion++){
            double x1 = Double.parseDouble((String) x.obtener(posicion));
            double y1 = Double.parseDouble((String) y.obtener(posicion));
            sum0 = sum0 +(1.0/x.numeroElementos()/2.0)*(p+b*x1-y1);
            sum1 = sum1 +((x1*(p+b*x1-y1)))/x.numeroElementos()/2;
        }
        ListaEstatica lista = new ListaEstatica(2);
        lista.agregar(sum0);
        lista.agregar(sum1);
        return lista;
    }
}
