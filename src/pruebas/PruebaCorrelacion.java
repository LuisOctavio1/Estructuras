package pruebas;

import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaDinamicaDoble;
import herramientas.graficaicon.Grafica;
import herramientas.matematicas.Correlacion;

public class PruebaCorrelacion {
    public static void main(String[] args){
        ListaDinamicaDoble datosX = ArchivoTexto.leerListaDinamica("src/herramientas/matematicas/x.txt");
        ListaDinamicaDoble datosY = ArchivoTexto.leerListaDinamica("src/herramientas/matematicas/y.txt");
        Double correlacion =  Correlacion.coeficienteMuestral(datosX,datosY);
        SalidaPorDefecto.consola(correlacion + "\n");
        double correlacionPoblacional = Correlacion.coeficientePoblacional(datosX,datosY);
        SalidaPorDefecto.consola(correlacionPoblacional + "\n");
        SalidaPorDefecto.consola(tipoRelacion(correlacion) + "\n");
        Grafica grafica = new Grafica(datosX,datosY);
        grafica.crearGraficaDispersion("Precio por habitacion","Habitacion","Precio");
    }

    /**
     * Metodo que indica que tipo de correlacion tienes.
     * @param relacion La correlacion.
     * @return un string indicando el tipo de correlacion.
     */
    private static String tipoRelacion(double relacion){
        if(relacion == 0){
            return "Ninguna correlacion";
        }
        if(relacion ==1){
            return "Relacion positiva perfecta";
        }
        if(relacion < 1 && relacion > 0){
            return "Relacion positiva";
        }
        if(relacion ==-1){
            return "Relacion negativa perfecta";
        }
        if(relacion <0 && relacion  >-1){
            return "Relacion positiva";
        }
        return "Calculo incorrecto, no esta entre 1 y -1";
    }

}
