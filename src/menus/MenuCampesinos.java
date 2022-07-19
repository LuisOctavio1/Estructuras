
package menus;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import reporte.campo.Campesino;
import reporte.campo.ReporteCampesinos;

import java.io.IOException;

/**
 * Clase que controla el menu de los campesinos
 */
public class MenuCampesinos {
    /**
     * Metodo que imprime el menu principal
     */
    public  void imprimirMenu(){
        SalidaPorDefecto.consola("Bienvenido, ingresa el numero de la opcion que deseas ingresar\n" +
                "1. El promedio anual de toneladas por campesino.\n" +
                "2. ¿Cuántos meses tuvieron toneladas menores al promedio anual del campesino X?\n" +
                "3. ¿Cuál fue el mes que obtuvo más toneladas por cada año del campesino X?\n" +
                "4. ¿Cuántas toneladas se obtuvieron el último mes de cada año del campesino X?\n" +
                "5. ¿Cuántas toneladas se obtuvieron en el primer trimestre de cada año del campesino X? \n" +
                "6. ¿Qué campesino ha realizado mejor su trabajo en cada año?\n" +
                "7. ¿Qué mes es el que produce mejores dividendos a los campesinos?\n" +
                "8. ¿Qué época del año (primavera, verano, otoño o invierno) genera mayor ganancia en producción?\n" +
                "9. Salir.");
    }

    /**
     * Metodo que pide los datos del campesino
     * @param reporte El reporte donde se agregaran los campesinos
     * @throws IOException El error para imprimir
     */
    public  void pedirDatosCampesino(ReporteCampesinos reporte) throws IOException {
        SalidaPorDefecto.consola("Ingresa el identificador del campesino\n");
        int identificador = (EntradaPorDefecto.consolaDouble()).intValue() ;
        SalidaPorDefecto.consola("Ingresa el nombre del archivo del campesino\n");
        String nombre = EntradaPorDefecto.consolaCadenas();
        Campesino campesino = new Campesino(identificador,nombre);
        reporte.agregarCampesino(campesino);
    }

    /**
     * Metodo para imprimir el promedio por campesino
     * @param reporte El reporte con los campesinos.
     */
    public  void imprimirPromedio(ReporteCampesinos reporte){
        ListaEstatica promedios = reporte.promedioPorCampesino();
        ListaEstatica campesinos = reporte.getCampesinos();
        for(int indice = 0; indice <promedios.numeroElementos(); indice++){
            SalidaPorDefecto.consola("El promedio de "+ campesinos.obtener(indice).toString()
                    + "es de " + promedios.obtener(indice)+"\n");
        }
    }

    /**
     * Metodo que regresa el mes en nombre
     * @param mes El indice del mes
     * @param reporteCampesinos El reporte.
     * @return El mes que se necesita en string.
     */
    public String regresarMes(int mes,ReporteCampesinos reporteCampesinos){
        ListaEstatica meses = reporteCampesinos.getNombreMeses();
        return (String)meses.obtener(mes);
    }

    /**
     * Imprime los meses con mayor ganacia de cada anio.
     * @param meses Lista de los meses con mayor ganancia
     * @param reporte El reporte con los campesinos.
     */
    public void imprimirMayorMes(ListaEstatica meses, ReporteCampesinos reporte){
        SalidaPorDefecto.consola("El mes del primer anio es " + regresarMes((int)meses.obtener(0),reporte) + "\n");
        SalidaPorDefecto.consola("El mes del segundo anio es " + regresarMes((int)meses.obtener(1),reporte)+ "\n");
        SalidaPorDefecto.consola("El mes del tercer anio es " + regresarMes((int)meses.obtener(2),reporte)+ "\n");
        SalidaPorDefecto.consola("El mes del cuarto anio es " + regresarMes((int)meses.obtener(3),reporte)+ "\n");
    }

    /**
     *Impreme las toneladas del ultimo mes de un campesino.
     * @param meses Lista con las toneladas del ultimo mes.
     */
    public void imprimirUltimoMes(ListaEstatica meses){
        SalidaPorDefecto.consola("Las toneladas del ultimo mes del primer anio son: " + meses.obtener(0) + "\n");
        SalidaPorDefecto.consola("Las toneladas del ultimo mes del segundo anio son: " + meses.obtener(1) + "\n");
        SalidaPorDefecto.consola("Las toneladas del ultimo mes del tercer anio son: " + meses.obtener(2) + "\n");
        SalidaPorDefecto.consola("Las toneladas del ultimo mes del cuarto anio son: " + meses.obtener(3) + "\n");
    }

    /**
     * Meotodo que imprime las toneladas del primer trimestre de cada anio de un campesino.
     * @param meses Lista con las toneladas.
     */
    public void imprimirPrimerTrimestre(ListaEstatica meses){
        SalidaPorDefecto.consola("Las toneladas del primer trimestre del primer anio son: " + meses.obtener(0) + "\n");
        SalidaPorDefecto.consola("Las toneladas del primer trimestre del segundo anio son: " + meses.obtener(1) + "\n");
        SalidaPorDefecto.consola("Las toneladas del primer trimestre del tercer anio son: " + meses.obtener(2) + "\n");
        SalidaPorDefecto.consola("Las toneladas del primer trimestre del cuarto anio son: " + meses.obtener(3) + "\n");
    }

    /**
     * Metodo para imprimir el mejor campesino de cada anio.
     * @param campesinos Lista con los campesinos.
     */
    public void mejorCampesinoAlAnio(ListaEstatica campesinos){
        for(int indice = 0; indice <campesinos.numeroElementos(); indice++){
            SalidaPorDefecto.consola("El mejor campesino del anio " + indice+1 + "es: " + campesinos.obtener(indice) + "\n");
        }
    }

    /**
     * Metodo para imprimir el mes con mas dividendo de todos los campesinos.
     * @param indice Indice de el mes.
     * @param reporte Reporte donde estan los campesinos.
     */
    public void imprimirMejorMes(int indice,ReporteCampesinos reporte){
        ListaEstatica meses = reporte.getNombreMeses();
        SalidaPorDefecto.consola("El mes con mejor dividendo es " + meses.obtener(indice) + "\n");
    }

    /**
     * Metodo para imprimir la mejor temporada de todos los campesinos.
     * @param temporada Indice de la temporada.
     * @param reporte Reporte con los campesinos.
     */
    public void imprimirMejorEpoca(int temporada,ReporteCampesinos reporte){
        ListaEstatica temporeda = reporte.getTemporadas();
        SalidaPorDefecto.consola("La mejor temporada para los campesinos fue "+ temporeda.obtener(temporada)+ "\n");
    }



}
