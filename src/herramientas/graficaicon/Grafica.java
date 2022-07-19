package herramientas.graficaicon;

import estructuraslineales.ListaDinamicaDoble;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

/**
 * Clase que se encarga de realizar graficas.
 */
public class Grafica extends JFrame {
    ListaDinamicaDoble datosX;
    ListaDinamicaDoble datosY;

    /**
     * Constructor que pide las listas con los datos.
     * @param datosX Lista x
     * @param datosY Lista y
     */
    public Grafica(ListaDinamicaDoble datosX, ListaDinamicaDoble datosY) {
        this.datosX = datosX;
        this.datosY = datosY;
    }

    /**
     * Metodo que crea una grafica de dispercion con los datos x e y
     * @param titulo El titulo de la grafica.
     * @param x El nombre de los datos x.
     * @param y El nombre de los datos y.
     */
    public void crearGraficaDispersion(String titulo, String x, String y){
        final XYSeries habitaciones = new XYSeries( "Precios por habitacion" );
        datosX.inicializarIteradorIzquierdo();
        datosY.inicializarIteradorIzquierdo();
        while (datosX.hayNodosIzquierdo()){
            habitaciones.add(Double.parseDouble((String)datosX.obtenerNodo()) ,Double.parseDouble((String)datosY.obtenerNodo()));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( habitaciones );


        JFreeChart chart = ChartFactory.createScatterPlot(titulo, x,
                y,  dataset, PlotOrientation.VERTICAL, true,
                true, false);

        // Creación del panel con el gráfico
        ChartPanel panel = new ChartPanel(chart);

        JFrame ventana = new JFrame("Grafica de dispersion");
        ventana.getContentPane().add(panel);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
