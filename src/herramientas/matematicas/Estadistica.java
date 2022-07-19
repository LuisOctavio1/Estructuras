package herramientas.matematicas;

import estructuraslineales.ListaDinamicaDoble;

/**
 * Clase que controlara calculos estadisticos
 */
public class Estadistica {
    /**
     * Metodo que calcula la distribucion normal
     * @param x Lista con los datos.
     * @param media La media de los datos.
     * @param desviasionTipica La desviasion tipica de los datos
     * @return Lista can la distribucion normal de cada elemento
     */
    public static ListaDinamicaDoble distribucionNormal(ListaDinamicaDoble x,double media, double desviasionTipica){
        ListaDinamicaDoble datos = new ListaDinamicaDoble();
        x.inicializarIteradorIzquierdo();
        datos = distribucion(datos,x,media,desviasionTipica);
        return datos;
    }

    /**
     * Metodo que calcula la distribucion de manera recursiva, este es el que genera los calculos del metodo de arriba.
     * @param vacia La lista donde meteremos los nuevos datos
     * @param x La lista con los datos normales
     * @param media la media de los datos
     * @param desviasionTipica La desviasion de los datos
     * @return Lista con la distribucion normal.
     */
    private static ListaDinamicaDoble distribucion(ListaDinamicaDoble vacia, ListaDinamicaDoble x,double media, double desviasionTipica){
        if(!x.hayNodosIzquierdo()){
            return vacia;
        }else{
            double datoooo = Double.parseDouble(x.obtenerNodo().toString()) ;
            double nuevoValor = (1.0/(desviasionTipica*Math.sqrt(2.0*3.1416)))*Math.pow(2.718,(-1*(1.0/(2.0*Math.pow(desviasionTipica,2.0)))*Math.pow(datoooo -media,2.0))) ;
            vacia.agregar(nuevoValor);
            return distribucion(vacia,x,media,desviasionTipica);
        }
    }

    /**
     * Metodo que calcula el valor de z, llama a un metod recursivo que realmente es el que hace los calculos
     * @param x los datos de la lista
     * @param media la media de los datos
     * @param desviasionTipica La desviasion de los datos.
     * @return La lista con los datos de z.
     */
    public static ListaDinamicaDoble calculoZ(ListaDinamicaDoble x, double media, double desviasionTipica){
        ListaDinamicaDoble nuevosDatos = new ListaDinamicaDoble();
        x.inicializarIteradorIzquierdo();
        return calculoZ(nuevosDatos,x,media,desviasionTipica);
    }

    /**
     * Metodo que hace los calculos recursivamente, este lo llama el metodo que llaman las demas clases
     * @param nuevosDatos La lista donde agregaremos los datos
     * @param x Lista con los datos originales
     * @param media media de los datos
     * @param desviasionTipica desviasion de los datos
     * @return La lista con los datos
     */
    private static ListaDinamicaDoble calculoZ(ListaDinamicaDoble nuevosDatos, ListaDinamicaDoble x,double media, double desviasionTipica){
        if(!x.hayNodosIzquierdo()){
            return nuevosDatos;
        }else{
            nuevosDatos.agregar((Double.parseDouble(x.obtenerNodo().toString()) - media)/desviasionTipica);
            return calculoZ(nuevosDatos,x,media,desviasionTipica);
        }
    }
}
