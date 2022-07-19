package reporte.campo;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;

import java.io.*;

/**
 * Clase que contendra todo lo que ocupa el campesino, las listas para los cuatro anios y el archivo de donde se obtendran las toneladas.
 */
public class Campesino {
    int identificador;
    File datos;
    ListaEstatica anio1 = new ListaEstatica(12);
    ListaEstatica anio2 = new ListaEstatica(12);
    ListaEstatica anio3= new ListaEstatica(12);
    ListaEstatica anio4=new ListaEstatica(12);;

    /**
     * Constructor del campesino.
     * @param identificador Es el valor numerico con el que se identificara, debera ser unico.
     * @param nombre Nombre del archivo donde se encuentran los datos de las toneladas al mes.
     */
    public Campesino(int identificador,String nombre) {
        this.identificador = identificador;
        this.datos = new File("estructuras/src/" + nombre);
        try {
            llenarAnios();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo para ovtener el identifiador
     * @return El identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Metodo para dar nuevo valor el identificador.
     * @param identificador El nuevo valor.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Metodo para obtener la lista del primer anio
     * @return La lista del primer anio
     */
    public ListaEstatica getAnio1() {
        return anio1;
    }

    public void setAnio1(ListaEstatica anio1) {
        this.anio1 = anio1;
    }

    /**
     * Metodo para obtener la lista del segundo anio
     * @return La lista del segundo anio
     */
    public ListaEstatica getAnio2() {
        return anio2;
    }

    /**
     * Metodo para obtener la lista del terer anio
     * @return La lista del tercer anio
     */
    public ListaEstatica getAnio3() {
        return anio3;
    }

    /**
     * Metodo para obtener la lista del cuarto anio
     * @return La lista del cuarto anio
     */
    public ListaEstatica getAnio4() {
        return anio4;
    }

    /**
     * Metodo para obtener todos los anios.
     * @return Una lista con todos los anios dentro.
     */
    public ListaEstatica listaAnios(){
        ListaEstatica anios = new ListaEstatica(4);
        anios.agregar(anio1);
        anios.agregar(anio2);
        anios.agregar(anio3);
        anios.agregar(anio4);
        return anios;
    }


    @Override
    public String toString() {
        return identificador+"";
    }

    /**
     * Metodo auxiliar para saber en que anio debe ir una tonelada al ingresarlas desde el archivo.
     * @param cuenta El numero en el que ban de los 48.
     * @param j El valor de las toneladas.
     */
    public void calcularAnio(int cuenta,double j){
        if(cuenta <12){
            anio1.agregar(j);
        }
        if(cuenta >12 && cuenta <24){
            anio2.agregar(j);
        }
        if(cuenta >24 && cuenta <36){
            anio3.agregar( j);
        }
        if(cuenta >36 && cuenta <48 ){
            anio4.agregar(j);
        }
    }

    /**
     * Metodo para leer el archivo y llenar las listas de anios.
     * @throws IOException Tira exepcion en caso de que haya un error en el proceso.
     */
    public void llenarAnios() throws IOException {
        try{
            BufferedReader obj = new BufferedReader(new FileReader(datos));
            String strng;
            int cuenta = 0;
            while ((strng = obj.readLine()) != null){
                calcularAnio(cuenta,Double.parseDouble(strng));
                cuenta++;
            }


        }catch (Exception e){
            SalidaPorDefecto.consola("El error es : " + e);

        }
    }

}
