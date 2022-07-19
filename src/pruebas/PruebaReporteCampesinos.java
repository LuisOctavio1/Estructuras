package pruebas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import menus.MenuCampesinos;
import reporte.campo.ReporteCampesinos;

import java.io.IOException;

/**
 * Clase donde se prueba la funcinalidad.
 */
public class PruebaReporteCampesinos {
    /**
     * Metodo que pide el identificador.
     * @return
     */
    public static int pedirIdentificador(){
        SalidaPorDefecto.consola("Ingresa el numero del campesino que deseas\n");
        int identificador = EntradaPorDefecto.consolaDouble().intValue();
        return identificador;
    }


    /**
     * Metodo con el menu y funcionalidad
     *
     */
    public static void main(String[] args) {
        MenuCampesinos menuCampesinos = new MenuCampesinos();
        ReporteCampesinos reporte = new ReporteCampesinos(2);
        int opcion = 0;
        try {

            menuCampesinos.pedirDatosCampesino(reporte) ;
            SalidaPorDefecto.consola("Ahora el segundo campesino: \n");
            menuCampesinos.pedirDatosCampesino(reporte) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            int identificador;
            menuCampesinos.imprimirMenu();
            SalidaPorDefecto.consola( "\n"); ;
            opcion = EntradaPorDefecto.consolaDouble().intValue();
            switch (opcion){
                case 1:
                    menuCampesinos.imprimirPromedio(reporte);
                    break;
                case 2:
                    identificador = pedirIdentificador();
                    SalidaPorDefecto.consola("La cantadad de meses fueron " + reporte.mesesMenorAlPromedio(identificador) + "\n");
                    break;
                case 3:
                    identificador = pedirIdentificador();
                    ListaEstatica meses = reporte.mayorCantidadAnios(identificador);
                    menuCampesinos.imprimirMayorMes(meses,reporte);
                    break;
                case 4:
                    identificador = pedirIdentificador();
                    ListaEstatica ultima = reporte.obtenerToneladasEnMes(identificador,12);
                    menuCampesinos.imprimirUltimoMes(ultima);
                    break;
                case 5:
                    identificador = pedirIdentificador();
                    ListaEstatica primerTemporada = reporte.toneladasPrimerTrimestre(identificador);
                    menuCampesinos.imprimirPrimerTrimestre(primerTemporada);
                    break;
                case 6:
                    menuCampesinos.mejorCampesinoAlAnio(reporte.mejorAlAnio());
                    break;
                case 7:
                    menuCampesinos.imprimirMejorMes(reporte.dividendoMaximo(),reporte);
                    break;
                case 8:
                    menuCampesinos.imprimirMejorEpoca(reporte.gananciaTemporada(),reporte);
                    break;
            }
        }while (opcion != 9);

    }
}