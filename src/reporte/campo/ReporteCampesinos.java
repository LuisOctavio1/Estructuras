package reporte.campo;

import estructuraslineales.ListaEstatica;

/**
 * Clase que controla los reportes de los campesinos.
 */
public class ReporteCampesinos {
    private ListaEstatica campesinos;
    private ListaEstatica nombreMeses = new ListaEstatica(12);

    /**
     * Constructor para los reportes.
     * @param cantidad La cantidad de campesinos que tendra
     */
    public ReporteCampesinos(int cantidad){
        campesinos = new ListaEstatica(cantidad);
        nombreMeses.agregar("enero");
        nombreMeses.agregar("febrero");
        nombreMeses.agregar("marzo");
        nombreMeses.agregar("abril");
        nombreMeses.agregar("mayo");
        nombreMeses.agregar("junio");
        nombreMeses.agregar("julio");
        nombreMeses.agregar("agosto");
        nombreMeses.agregar("septiembre");
        nombreMeses.agregar("octubre");
        nombreMeses.agregar("noviembre");
        nombreMeses.agregar("diciembre");
    }

    /**
     * Metodo para agregar campesinos a la lista.
     * @param campesino El campesino a agregar.
     * @return true en caso de que se pueda agregar, en caso contrario false.
     */
    public boolean agregarCampesino(Campesino campesino){
        int valorRetornoAgregado=campesinos.agregar(campesino);
        if(valorRetornoAgregado==-1){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Metodo para calcular promedio de una lsita.
     * @param listaEstatica La lista a la que se le quiere saar el promedio.
     * @return El promedio.
     */
    public double calcularPromedio(ListaEstatica listaEstatica){
        double suma = 0;
        for(int indice = 0; indice <listaEstatica.numeroElementos(); indice++){
            suma = (double)listaEstatica.obtener(indice) + suma;
        }
        return suma/listaEstatica.numeroElementos();
    }

    /**
     *  Metodo que calcula el promedio de todos los anios de un campesino.
     * @param campesino El campesino al que se le calculara el promedio.
     * @return El promedio.
     */
    public double calcularPromedioAnual(Campesino campesino){
        ListaEstatica anios = regresarPromedioAnual(campesino);
        return ((double)anios.obtener(0)+(double)anios.obtener(1)
                +(double)anios.obtener(2)+(double)anios.obtener(3))/4;
    }

    /**
     * Metodo que regresa una lista con el promedio de todos los anios.
     * @param campesino El campesino al que se le calculara.
     * @return La lista con el promedio de los cuatro anios.
     */
    public ListaEstatica regresarPromedioAnual(Campesino campesino){
        double anio1 = calcularPromedio(campesino.getAnio1());
        double anio2 = calcularPromedio(campesino.getAnio2());
        double anio3 = calcularPromedio(campesino.getAnio3());
        double anio4 = calcularPromedio(campesino.getAnio4());
        ListaEstatica anios = new ListaEstatica(4);
        anios.agregar(anio1);
        anios.agregar(anio2);
        anios.agregar(anio3);
        anios.agregar(anio4);
        return anios;
    }

    /**
     * Metodo para calcular los promedios anuales de todos los campesinos
     * @return Una lista con los promedios
     */
    public ListaEstatica promedioPorCampesino(){
        ListaEstatica promedio = new ListaEstatica(campesinos.numeroElementos());
        for(int indice = 0; indice < campesinos.numeroElementos(); indice++){
            promedio.agregar(calcularPromedioAnual((Campesino) campesinos.obtener(indice)));
        }
        return promedio;
    }

    /**
     * Metodo que dice que cuantas veces en una lista hay una menor cantidad.
     * @param lista La lista que comprobaremos.
     * @param cantidad La cantidad con la que compararemos.
     * @return La cantidad de veces.
     */
    public int menorQueCantida(ListaEstatica lista,double cantidad){
        int menores = 0;
        for(int indice = 0; indice < lista.numeroElementos(); indice++){
            if((double)lista.obtener(indice)< cantidad){
                menores = menores +1;
            }
        }
        return menores;
    }

    /**
     * Este metodo cuenta cuantos meses son menores al promedio anual.
     * @param identificador identificador del campesino.
     * @return La cantidad de meses.
     */
    public int mesesMenorAlPromedio(int identificador){
        Campesino campesino = (Campesino) campesinos.obtener((int)campesinos.buscar(identificador)) ;
        int menores = 0;
        double promedio = calcularPromedioAnual(campesino);
        menores = menorQueCantida(campesino.getAnio1(),promedio) + menores;
        menores = menorQueCantida(campesino.getAnio2(),promedio) + menores;
        menores = menorQueCantida(campesino.getAnio3(),promedio) + menores;
        menores = menorQueCantida(campesino.getAnio4(),promedio) + menores;
        return menores;
    }

    /**
     * Este metodo sirve para saber el mes donde mas toneladas se tuvieron.
     * @param lista La lista con las toneladas.
     * @return Devuelve el indice donde fueron mayor toneladas.
     */
    public int mayorCantidadToneladas(ListaEstatica lista){
        int mayor = 0;
        for(int indice = 0; indice < lista.numeroElementos(); indice++){
            if((double)lista.obtener(indice)>mayor){
                mayor = indice;
            }
        }
        return mayor;
    }

    /**
     * Este metodo devuelve el mes que mayor cantidad tuve en los uatro anios.
     * @param identificador identificador del campesino.
     * @return Lista con los meses.
     */
    public ListaEstatica mayorCantidadAnios(int identificador){
        Campesino campesino = (Campesino) campesinos.obtener((int)campesinos.buscar(identificador)) ;
        ListaEstatica mayores = new ListaEstatica(4);
        double mayor = -1;
        mayores.agregar(mayorCantidadToneladas(campesino.getAnio1()));
        mayores.agregar(mayorCantidadToneladas(campesino.getAnio2()));
        mayores.agregar(mayorCantidadToneladas(campesino.getAnio3()));
        mayores.agregar(mayorCantidadToneladas(campesino.getAnio4()));
        for(int indice = 0; indice <mayores.numeroElementos(); indice++){
            if((int)mayores.obtener(indice)>mayor){
                mayores.agregar(indice);
            }
        }
        return mayores;
    }

    /**
     * Este metodo obtiene la cantidad del  mes indicado de todos los anios.
     * @param identificador identificador del campesino.
     * @param mes el numero del mes de 1 a 12.
     * @return lista con las toneladas en especifico.
     */
    public ListaEstatica obtenerToneladasEnMes(int identificador,int mes){
        Campesino campesino = (Campesino) campesinos.obtener((int)campesinos.buscar(identificador)) ;
        ListaEstatica ultimo = new ListaEstatica(4);
        ListaEstatica primer = campesino.getAnio1();
        ListaEstatica segundo = campesino.getAnio2();
        ListaEstatica tercer = campesino.getAnio3();
        ListaEstatica cuarto = campesino.getAnio4();
        ultimo.agregar(primer.obtener(mes-1));
        ultimo.agregar(segundo.obtener(mes-1));
        ultimo.agregar(tercer.obtener(mes-1));
        ultimo.agregar(cuarto.obtener(mes-1));
        return ultimo;
    }

    /**
     * Metodo que regresa la cantidad de toneladas del primer tirmestre de cada anio.
     * @param identificador identificador del campesino.
     * @return Debuelve una lista con la cantidad de los cuatro anios.
     */
    public ListaEstatica toneladasPrimerTrimestre(int identificador){
        Campesino campesino = (Campesino) campesinos.obtener((int)campesinos.buscar(identificador)) ;
        ListaEstatica toneladas = new ListaEstatica(4);
        double suma1 = 0,suma2 = 0,suma3 = 0,suma4 = 0;
        ListaEstatica primer = campesino.getAnio1();
        ListaEstatica segundo = campesino.getAnio2();
        ListaEstatica tercer = campesino.getAnio3();
        ListaEstatica cuarto = campesino.getAnio4();
        for(int indice = 0; indice<3;indice++ ){
            suma1 = suma1 + (double) primer.obtener(indice);
            suma2 = suma2 + (double) segundo.obtener(indice);
            suma3 = suma3 + (double) tercer.obtener(indice);
            suma4 = suma4 + (double) cuarto.obtener(indice);
        }
        toneladas.agregar(suma1);
        toneladas.agregar(suma2);
        toneladas.agregar(suma3);
        toneladas.agregar(suma4);
        return toneladas;
    }

    /**
     * Metodo que calcula el promedio por el anio especificado de cada campesino para saber quien es al que le fue mejor.
     * @param anio El anio que se quiere comprobar.
     * @return El campesino que mas tonaladas tiene en ese anio
     */
    public Campesino anio(int anio){
        Campesino mayor = (Campesino) campesinos.obtener(0);
        for(int indice = 0 ; indice < campesinos.numeroElementos(); indice++){
            Campesino campesino = (Campesino) campesinos.obtener(indice);
            if(calcularPromedio((ListaEstatica) campesino.listaAnios().obtener(anio)) >
                    calcularPromedio((ListaEstatica) mayor.listaAnios().obtener(anio))){
                mayor = campesino;
            }
        }
        return  mayor;
    }

    /**
     * Metodo que calcula a que campesino le fue mejor en cada anio.
     * @returnLista con los mejores campesinos de cada anio.
     */
    public ListaEstatica mejorAlAnio(){
        ListaEstatica mejorCampesinos = new ListaEstatica(4);
        mejorCampesinos.agregar(anio(0));
        mejorCampesinos.agregar(anio(1));
        mejorCampesinos.agregar(anio(2));
        mejorCampesinos.agregar(anio(3));
        return mejorCampesinos;
    }

    /**
     * Metodo que calucula la cantidad de toneladas en cada mes de todos los campesinos de todos los anios.
     * @return Lista con la cantidad total por mes
     */
    public ListaEstatica gananciaMeses(){
        ListaEstatica meses = new ListaEstatica(12);
        for(int indice = 0; indice < meses.maximo(); indice++){
            meses.agregar(0.0);
        }
        for(int indice = 0; indice < campesinos.numeroElementos(); indice++){
            Campesino campesino = (Campesino) campesinos.obtener(indice);
            for(int posicion = 0; posicion< meses.numeroElementos(); posicion++){
                double valor = (double)campesino.getAnio1().obtener(indice)+(double)campesino.getAnio2().obtener(indice)+
                        (double)campesino.getAnio3().obtener(indice)+(double)campesino.getAnio4().obtener(indice);
                double suma = (double)meses.obtener(posicion) + valor;
                meses.cambiar(posicion,suma);
            }
        }
        return meses;
    }

    /**
     * Metodo que dice cual fue el mes con mas ganancia para los campesinos en conjunto.
     * @return La posicion del mes.
     */
    public int dividendoMaximo(){
        ListaEstatica meses = gananciaMeses();
        double mayor = (double)meses.obtener(0);
        int mes = 0;
        for(int indice = 0; indice < meses.maximo(); indice++){
            if ((double)meses.obtener(indice) > mayor){
                mayor = (double)meses.obtener(indice);
                mes = indice;
            }
        }
        return mes;
    }

    /**
     * Metodo que calcula la ganancia por temporada del anio.
     * @return Devuelve el indice de la temporada.
     */
    public int gananciaTemporada(){
        ListaEstatica meses = gananciaMeses();
        ListaEstatica temporada = new ListaEstatica(4);
        for(int indice = 0; indice < 12; indice= indice+3){
            temporada.agregar((double)meses.obtener(indice)+(double)meses.obtener(indice+1)+(double)meses.obtener(indice+2));
        }
        int tempo = 0;
        double mayor = (double)meses.obtener(0);
        for(int indice = 0; indice <4; indice++){
            if ((double)meses.obtener(indice) > mayor){
                mayor = (double)meses.obtener(indice);
                tempo = indice;
            }
        }
        return tempo;
    }

    /**
     * Metodo para obtener la lista de campesinos.
     * @return La lista de campesinos.
     */
    public ListaEstatica getCampesinos() {
        return campesinos;
    }

    /**
     * Metodo para obtener la lista con los nombres de los meses.
     * @return La lista de los meses.
     */
    public ListaEstatica getNombreMeses() {
        return nombreMeses;
    }

    /**
     * Metodo para obtener la lista de las temporadas.
     * @return Lista de las temporadas.
     */
    public ListaEstatica getTemporadas(){
        ListaEstatica temporada = new ListaEstatica(4);
        temporada.agregar("Invierno");
        temporada.agregar("primavera");
        temporada.agregar("verano");
        temporada.agregar("otonio");
        return temporada;
    }
}
