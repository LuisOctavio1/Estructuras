package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import utiles.TipoColumna;
import utiles.TipoRenglon;

/**
 * Clase que maneja las matrices de dos dimenciones
 */
public class Matriz2 {
    protected int renglones;
    protected int columnas;
    protected Object datos[][];

    /**
     * Constructor que inicializa la matriz sin ningun valor inicial.
     * @param renglones La cantidad de renglones.
     * @param columnas La cantidad de columnas.
     */
    public Matriz2(int renglones, int columnas){
        this.renglones=renglones;
        this.columnas=columnas;
        datos=new Object[renglones][columnas];
    }

    /**
     * Contructor que inicializa la matriz y les da un valor incial.
     * @param renglones La cantidad de renglones.
     * @param columnas La cantidad de columnas.
     * @param valor El valor con el que se iniciara la matriz.
     */
    public Matriz2(int renglones, int columnas, Object valor){
        this.renglones=renglones;
        this.columnas=columnas;
        datos=new Object[renglones][columnas];
        rellenar(valor);
    }

    /**
     * Metodo que rellena la matriz con un valor.
     * @param valor El valor especificado.
     */
    public void rellenar(Object valor){
        for(int fila=0; fila<renglones; fila++){ //recorre fila por fila
            //podemos asumir que en nuestro escenario hay solo un renglón
            for(int columna=0;columna<columnas; columna++){ //recorremos una por una las columnas de un solo renglòn
                    datos[fila][columna]=valor;
            }
        }
    }

    /**
     * Metodo para obtener un valor de la matriz.
     * @param fila La fila de donde se obtendra.
     * @param col La columna de donde se obtendra.
     * @return El objeto de la posicion.
     */
    public Object obtener(int fila, int col){
        if(enRango(fila,renglones)==true && enRango(col,columnas)==true){
            return datos[fila][col];
        }else{ //índices fuera de rango
            return null;
        }
    }

    /**
     * Metodo para cambiar el valor de una posicion.
     * @param fila Fila donde se cambiara.
     * @param col Columna donde se cambiara
     * @param valor El nuevo valor.
     * @return True en caso de que se pueda, false en caso contrario.
     */
    public boolean cambiar(int fila, int col, Object valor){
        if(enRango(fila,renglones)==true && enRango(col,columnas)==true ){
            datos[fila][col]=valor;
            return true;
        }else{ //índices fuera de rango
            return false;
        }
    }

    /**
     * Metodo que nos dice si un indice esta en rango.
     * @param indice El indice que queremos comprobar.
     * @param limiteDimension El limite de la dimencion.
     * @return true en caso valido, false en caso contrario.
     */
    private boolean enRango(int indice, int limiteDimension){
        if(indice>=0 && indice<limiteDimension){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo para obtener los renglones.
     * @return Los renglones de la matriz.
     */
    public int obtenerRenglones(){
        return renglones;
    }

    /**
     * Metodo para obtener las columnas.
     * @return Las columnas de la matriz.
     */
    public int obtenerColumnas(){
        return columnas;
    }

    /**
     * Metodo que imprime la matriz poniendo las columnas primero.
     */
    public void imprimirXColumnas(){
        for(int col=0;col<columnas;col++){  //una columna
            for(int fila=0;fila<renglones;fila++){ //extrae renglón por renglón
                    SalidaPorDefecto.consola(datos[fila][col]+" ");
            }
            //Cuando termina cada renglon, hacer salto de línea
            SalidaPorDefecto.consola("\n");
        }
    }

    /**
     * Metodo que imprime la matriz con los renglones primero.
     */
    public void imprimirXRenglones(){
        for(int fila=0;fila<renglones;fila++){   //reng x reng
            for(int col=0;col<columnas;col++){ //extrae col x col
                SalidaPorDefecto.consola(datos[fila][col]+" ");
            }
            //Cuando termina cada columna, hacer salto de línea
            SalidaPorDefecto.consola("\n");
        }
    }

    /**
     * Metodo que transpuesta la matriz actual.
     */
    public void transpuesta(){
        Object transpuesta[][] = new Object[columnas][renglones];
        for(int indice =0; indice <columnas; indice++){
            for( int posicion =0; posicion < renglones; posicion++){
                transpuesta[indice][posicion] = datos[posicion][indice];
            }
        }
        int renglonesAux = renglones;
        renglones = columnas;
        columnas = renglonesAux;
        datos = transpuesta;
    }

    /**
     * Metodo para clonar la matriz actual.
     * @return La matriz generada.
     */
    public Matriz2 clonar(){
        Matriz2 clon = new Matriz2(renglones,columnas);
        for(int fila=0;fila<renglones;fila++){   //reng x reng
            for(int col=0;col<columnas;col++){ //extrae col x col
                clon.cambiar(fila,col,datos[fila][col]);
            }
        }
        return clon;
    }

    /**
     * Metodo para comprobar si una matriz es igual a otra.
     * @param matriz2 La matriz que queremos comprobar.
     * @return True en caso de que sean iguales, false en caso contrario.
     */
    public boolean esIgual(Matriz2 matriz2){
        if(columnas == matriz2.columnas && renglones == matriz2.renglones){
            for(int fila=0;fila<renglones;fila++){   //reng x reng
                for(int col=0;col<columnas;col++){ //extrae col x col
                    if( matriz2.obtener(fila,col)  != datos[fila][col]){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo que llena nuestra matriz con el vector columna especificado.
     * @param filas El numero de filas que cambiaran.
     * @param valor El valor con el que cambiara.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean vectorColumna(int filas, Object valor){
        if(filas <= renglones){
            for(int col = 0; col <columnas; col++){
                for(int fila =0; fila <filas; fila++){
                    datos[fila][col] = valor;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que llena nuestra matriz con el vector renglon especificado.
     * @param columnas Las columnas que se afectaran.
     * @param valor El valor con el que se cambiara.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean vectorRenglon(int columnas,Object valor){
        if(columnas <= this.columnas){
            for(int fila =0; fila< renglones;fila++){
                for(int col =0; col <columnas; col++){
                    datos[fila][col]=valor;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que redefine nuestra matriz a otra matriz.
     * @param matriz2 La matriz con la que se efinira nuestra matriz.
     * @return true en caso de que se pueda.
     */
    public boolean redefinir(Matriz2 matriz2){
        renglones = matriz2.renglones;
        columnas = matriz2.columnas;
        datos = matriz2.datos;
        return true;
    }

    /**
     * Metodo que agrega la matriz actual a otra matriz.
     * @param matriz2 La matriz nueva.
     * @return La matriz con los datos de nuestra matriz agregados.
     */
    public Matriz2 agregarMatrisActual(Matriz2 matriz2){
        if(matriz2.renglones >=renglones && matriz2.columnas >= renglones){
            for(int fila=0; fila <renglones; fila++){
                for(int col =0; col <columnas; col++){
                    matriz2.cambiar(fila,col,datos[fila][col]);
                }
            }
        }
        return matriz2;
    }

    /**
     * Metodo que permite agregar un renglon a nuestra matriz.
     * @param arreglo El renglon que agregaremos.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean agregarRenglon(ListaEstatica arreglo){
        if(arreglo.numeroElementos() <= columnas){
            Matriz2 nuevaMatriz = new Matriz2(renglones+1,columnas,0);
            nuevaMatriz = agregarMatrisActual(nuevaMatriz);
            for(int fila = renglones; fila < nuevaMatriz.renglones; fila++){
                for(int col =0; col <arreglo.numeroElementos(); col++){
                    nuevaMatriz.cambiar(fila,col,arreglo.obtener(col));
                }
            }
            datos = nuevaMatriz.datos;
            renglones = nuevaMatriz.renglones;
            columnas = nuevaMatriz.columnas;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que permite agregar una columna a nuestra matriz.
     * @param arreglo La columna que agregaremos.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean agregarColumna(ListaEstatica arreglo){
        if(arreglo.numeroElementos() <= columnas){
            Matriz2 nuevaMatriz = new Matriz2(renglones,columnas+1,0);
            nuevaMatriz = agregarMatrisActual(nuevaMatriz);
            for(int col=0;col<columnas;col++){  //una columna
                for(int fila=0;fila<arreglo.numeroElementos();fila++){ //extrae renglón por renglón
                    nuevaMatriz.cambiar(fila,col,arreglo.obtener(fila));
                }
            }
            datos = nuevaMatriz.datos;
            renglones = nuevaMatriz.renglones;
            columnas = nuevaMatriz.columnas;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que permite agregar una matriz a nuestra matriz actual hacia las columnas.
     * @param matriz2 La matriz que agregaremos.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean agregarMatrizXColumna(Matriz2 matriz2){
        if(matriz2.renglones <= renglones){
            Matriz2 nuevaMatriz = new Matriz2(renglones,columnas+ matriz2.columnas,0);
            nuevaMatriz = agregarMatrisActual(nuevaMatriz);
            for(int col =columnas; col < nuevaMatriz.columnas; col++){
                for(int fila = 0; fila < matriz2.renglones; fila++){
                    nuevaMatriz.cambiar(fila,col,matriz2.datos[fila][col-columnas]);
                }
            }
            datos = nuevaMatriz.datos;
            renglones = nuevaMatriz.renglones;
            columnas = nuevaMatriz.columnas;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que permite agregar una matriz a nuestra matriz actual hacia los renglones.
     * @param matriz2 La matriz que agregaremos.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean agregarMatrizXRenglon(Matriz2 matriz2){
        if(matriz2.columnas <= columnas){
            Matriz2 nuevaMatriz = new Matriz2(renglones+matriz2.renglones,columnas,0);
            nuevaMatriz = agregarMatrisActual(nuevaMatriz);
            for(int fila =renglones; fila < nuevaMatriz.renglones; fila++){
                for(int col = 0; col < matriz2.columnas; col++){
                    nuevaMatriz.cambiar(fila,col,matriz2.datos[fila-renglones][col]);
                }
            }
            datos = nuevaMatriz.datos;
            renglones = nuevaMatriz.renglones;
            columnas = nuevaMatriz.columnas;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Genera un vector columna a aprtir de nuestra matriz.
     * @return El vector coumna generado.
     */
    public Matriz2 aVectorColumna(){
        Matriz2 vectorColumna = new Matriz2(renglones*columnas,1);
        int posicion = 0;
        for(int col =0; col <columnas; col++ ){
            for(int fila =0; fila <renglones; fila++){
                vectorColumna.cambiar(posicion,0,datos[fila][col]);
                posicion++;
            }
        }
        return vectorColumna;
    }

    /**
     * Genera un vector renglon a partir de nuestra matriz.
     * @return El vector renglon generado.
     */
    public Matriz2 aVectorRenglon(){
        Matriz2 vectorRenglon = new Matriz2(1,renglones*columnas);
        int posicion = 0;
        for(int fila =0; fila <renglones; fila++){
            for(int col =0; col <columnas; col++){
                vectorRenglon.cambiar(0,posicion,datos[fila][col]);
                posicion++;
            }
        }
        return vectorRenglon;
    }

    /**
     * Metodo que genera una matriz de 3 dimensiones.
     * @param matrices Lista con todas las matrices para la profundidad.
     * @return La matriz 3d generada.
     */
    public Matriz3 aMatriz3(ListaEstatica matrices){
        Matriz3 matriz3 = new Matriz3(renglones,columnas,matrices.numeroElementos()+1);
        int posLista = 0;
        for(int fila = 0; fila <renglones; fila++){
            for(int col = 0; col < columnas; col++){
                for(int prof = 0; prof < matriz3.profundidad; prof++){
                    if(prof > 0){
                        if(((Matriz2)matrices.obtener(posLista)).columnas ==columnas && ((Matriz2)(matrices.obtener(posLista))).renglones ==renglones){
                            matriz3.cambiar(fila,col,prof,((Matriz2)matrices.obtener(posLista)).datos[fila][col]);
                        }
                        posLista++;
                    }
                    matriz3.cambiar(fila,col,prof,datos[fila][col]);
                }
            }
        }
        return matriz3;
    }

    /**
     * Metodo para quitar una columna(derecha o izquierda).
     * @param tipoColumna El enumerado que dira si en la izaquierda o derecha.
     * @return True en caso de que se pueda, false en caso contrario.
     */
    public boolean quitarColumna(TipoColumna tipoColumna){
        if(tipoColumna.getValor() ==1){
            return eliminarColumna(0);
        }else{
            return eliminarColumna(columnas);
        }
    }

    /**
     * Metodo que elimina la columna especificada.
     * @param columna Columna especificada.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean eliminarColumna(int columna){
        if(columna >=0 && columna<=columnas){
            Object nuevaMatriz[][] = new Object[renglones][columnas-1];
            for(int col = 0; col < columnas; col++){
                for(int fila = 0; fila <renglones; fila++){
                    if(col !=columna){
                        nuevaMatriz[fila][col-1] = datos[fila][col];
                    }
                }
            }
            datos = nuevaMatriz;
            columnas = columnas-1;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que quita un renglon especificado por tipo renglon.
     * @param tipoRenglon Enumerado que especificara si quita el renglon de arriba o abajo.
     * @return
     */
    public boolean quitarRenglon(TipoRenglon tipoRenglon){
        if(tipoRenglon.getValor() ==1){
            return eliminarRenglon(0);
        }else{
            return eliminarRenglon(renglones);
        }
    }

    /**
     * Metodo que quita el renglon especificado.
     * @param renglon Renglon especificado
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean eliminarRenglon(int renglon){
        if(renglon >=0 && renglon<=renglones){
            Object nuevaMatriz[][] = new Object[renglones-1][columnas];
            for(int fila = 0; fila <renglones; fila++){
                for(int col = 0; col < columnas; col++){
                    if(fila !=renglon){
                        nuevaMatriz[fila][col] = datos[fila][col];
                    }
                }
            }
            datos = nuevaMatriz;
            renglones = renglones-1;
            return true;
        }else{
            return false;
        }
    }

    public void matrizDiagonal(Object elemento){
        if(renglones==columnas){
            for(int diag=0;diag<renglones;diag++){
                datos[diag][diag]=elemento;
            }
        }else{ //hacer lo que corresponda,

        }
    }

}
