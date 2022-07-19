package estructurasnolineales;

import estructuraslineales.ListaEstatica;
import estructuraslineales.ListaEstaticaNumerica;
import utiles.TipoLogaritmo;

public class Matriz2Numerica extends Matriz2{

    /**
     * ConstructorDe la matriz.
     * @param renglones Los renglones deseados.
     * @param columnas Las columnas deseadas.
     */
    public Matriz2Numerica(int renglones, int columnas) {
        super(renglones, columnas);
    }

    /**
     * ConstructorDe la matriz.
     * @param renglones Los renglones deseados.
     * @param columnas Las columnas deseadas.
     * @param valor El valor con el que se rellenara
     */
    public Matriz2Numerica(int renglones, int columnas, Object valor) {
        super(renglones, columnas, valor);

    }

    /**
     * Comprueba que el valor sea heredaro de number, despues hace lo que hace el padre.
     * @param valor El valor especificado.
     */
    @Override
    public void rellenar(Object valor) {
        if(valor instanceof Number){
            super.rellenar(valor);
        }
    }

    /**
     * Comprueba que el valor sea heredaro de number, despues hace lo que hace el padre.
     * @param fila Fila donde se cambiara.
     * @param col Columna donde se cambiara
     * @param valor El nuevo valor.
     * @return Lo del metodo padre en caso de que si sea heredado de number, false en caso contrario.
     */
    @Override
    public boolean cambiar(int fila, int col, Object valor) {
        if(valor instanceof  Number){
            return super.cambiar(fila, col, valor);
        }else{
            return false;
        }

    }

    /**
     * Comprueba que el valor sea heredaro de number, despues hace lo que hace el padre.
     * @param filas El numero de filas que cambiaran.
     * @param valor El valor con el que cambiara.
     * @return Lo del metodo padre en caso de que si sea heredado de number, false en caso contrario.
     */
    @Override
    public boolean vectorColumna(int filas, Object valor) {
        if(valor instanceof Number){
            return super.vectorColumna(filas, valor);
        }else{
            return false;
        }

    }

    /**
     * Comprueba que el valor sea heredaro de number, despues hace lo que hace el padre.
     * @param columnas Las columnas que se afectaran.
     * @param valor El valor con el que se cambiara.
     * @return Lo del metodo padre en caso de que si sea heredado de number, false en caso contrario.
     */
    @Override
    public boolean vectorRenglon(int columnas, Object valor) {
        if(valor instanceof  Number){
            return super.vectorRenglon(columnas, valor);
        }else{
            return false;
        }

    }

    /**
     * Metodo que comprueba que una matriz tenga solo numeros.
     * @param matriz2 La matriz a comparar.
     * @return True en caso de que tenga solo numeros, false en caso contrario.
     */
    public boolean comprobarMatrizdeNumeros(Matriz2 matriz2){
        for(int fila = 0; fila < matriz2.renglones; fila++){
            for(int col = 0; col < matriz2.columnas; col++){
                if(!(matriz2.obtener(fila,col) instanceof Number)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba que una listaEstatica contenga solo numeros.
     * @param listaEstatica la lista estatica a coprobar.
     * @return True en caso de que solo tenga numeros, false en caso contrario.
     */

    public boolean comprobarArregloDeNumeros(ListaEstatica listaEstatica){
        for(int indice = 0; indice< listaEstatica.numeroElementos(); indice++){
            if(!(listaEstatica.obtener(indice) instanceof Number)){
                return false;
            }
        }
        return true;
    }

    /**
     * Comprueba que la matriz solo tenga numeros, despues regresa lo del padre.
     * @param matriz2 La matriz con la que se efinira nuestra matriz.
     * @return false en caso de que no sea una matriz de numeros, e caso contrario lo del padre.
     */
    @Override
    public boolean redefinir(Matriz2 matriz2) {
        if(comprobarMatrizdeNumeros(matriz2)){
            return super.redefinir(matriz2);
        }else {
            return false;
        }
    }

    /**
     * Comprueba que la matriz solo tenga numeros, despues regresa lo del padre.
     * @param matriz2 La matriz nueva.
     * @return false en caso de que no sea una matriz de numeros, e caso contrario lo del padre.
     */
    @Override
    public Matriz2 agregarMatrisActual(Matriz2 matriz2) {
        if(comprobarMatrizdeNumeros(matriz2)){
            return super.agregarMatrisActual(matriz2);
        }else{
            return null;
        }

    }

    /**
     * Comprueba que el arreglo sea de solo numeros
     * @param arreglo El renglon que agregaremos.
     * @return false en caso de que no sea solo de un numeros, en caso contrario lo del padre.
     */
    @Override
    public boolean agregarRenglon(ListaEstatica arreglo) {
        if(comprobarArregloDeNumeros(arreglo)){
            return super.agregarRenglon(arreglo);
        }else{
            return false;
        }
    }

    /**
     * Comprueba que el arreglo sea de solo numeros
     * @param arreglo La columna que agregaremos.
     * @return false en caso de que no sea solo de un numeros, en caso contrario lo del padre.
     */
    @Override
    public boolean agregarColumna(ListaEstatica arreglo) {
        if(comprobarArregloDeNumeros(arreglo)){
            return super.agregarColumna(arreglo);
        }else {
            return false;
        }

    }

    /**
     * Comprueba que la matriz solo tenga numeros, despues regresa lo del padre.
     * @param matriz2 La matriz que agregaremos.
     * @return false en caso de que no sea una matriz de numeros, e caso contrario lo del padre.
     */
    @Override
    public boolean agregarMatrizXColumna(Matriz2 matriz2) {
        if(comprobarMatrizdeNumeros(matriz2)){
            return super.agregarMatrizXColumna(matriz2);
        }else {
            return false;
        }

    }

    /**
     * Comprueba que la matriz solo tenga numeros, despues regresa lo del padre.
     * @param matriz2 La matriz que agregaremos.
     * @return false en caso de que no sea una matriz de numeros, e caso contrario lo del padre.
     */
    @Override
    public boolean agregarMatrizXRenglon(Matriz2 matriz2) {
        if(comprobarMatrizdeNumeros(matriz2)){
            return super.agregarMatrizXRenglon(matriz2);
        }else {
            return false;
        }

    }

    /**
     * Compruba que las matrices tengan numeros, despues lo del padre
     * @param matrices Lista con todas las matrices para la profundid ad.
     * @return false en caso de que no sean numeros, en caso contrario lo del padre .
     */
    @Override
    public Matriz3 aMatriz3(ListaEstatica matrices) {
        for(int indice = 0; indice <matrices.numeroElementos(); indice++){
            if(!comprobarMatrizdeNumeros((Matriz2) matrices.obtener(indice))){
                return null;
            }
        }
        return super.aMatriz3(matrices);
    }

    /**
     * Clona la matriz actual
     * @return La matriz clonada.
     */
    public Matriz2Numerica clonar(){
        Matriz2Numerica clon = new Matriz2Numerica(renglones,columnas);
        for(int fila=0;fila<renglones;fila++){   //reng x reng
            for(int col=0;col<columnas;col++){ //extrae col x col
                clon.cambiar(fila,col,datos[fila][col]);
            }
        }
        return clon;
    }

    /**
     * Metodo que multiplica la matriz por un escalar
     * @param escalar El escalar por el que multiplicaremos la matriz
     * @return true despues de hacer las operaciones
     */
    public boolean porEscalar(Number escalar){
        for(int fila = 0; fila <renglones; fila++){
            for(int col = 0; col <columnas; col++){
                datos[fila][col]=((double)datos[fila][col])*(double)escalar;
            }
        }
        return true;
    }

    /**
     * Metodo que multiplica nuestra columna por los escalares dados en su correspondiente indice.
     * @param escalares El arreglo con los escalares.
     * @return True en caso de que el numero de escalares sea menor que el numero de columnas, en caso contrario false.
     */
    public boolean porEscalares(ListaEstaticaNumerica escalares){
        if(escalares.numeroElementos() <= columnas){
            for(int fila = 0; fila <renglones; fila++){
                for(int col =0; col <escalares.numeroElementos(); col++){
                    datos[fila][col] = (double)datos[fila][col]*(double)escalares.obtener(col);
                }
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que suma a nuestra matriz un escalar.
     * @param escalar El escalar que sumaremos.
     * @return true despues de hacer todo el proceso.
     */
    public boolean sumarEscalar(Number escalar){
        for(int fila = 0; fila <renglones; fila++){
            for(int col = 0; col <columnas; col++){
                datos[fila][col]=((double)datos[fila][col])+(double)escalar;
            }
        }
        return true;
    }

    /**
     * Metodo que suma nuestra columna por los escalares dados en su correspondiente indice.
     * @param escalares El arreglo con los escalares.
     * @return True en caso de que el numero de escalares sea menor que el numero de columnas, en caso contrario false.
     */
    public boolean sumarEscalares(ListaEstaticaNumerica escalares){
        if(escalares.numeroElementos() <= columnas){
            for(int fila = 0; fila <renglones; fila++){
                for(int col =0; col <escalares.numeroElementos(); col++){
                    datos[fila][col] = (double)datos[fila][col]+(double)escalares.obtener(col);
                }
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que multiplica la matriz por otra matriz.
     * @param matriz2 La matriz por la que multiplicaremos.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean multiplicar(Matriz2Numerica matriz2){
        if(matriz2.columnas == renglones){
            double multiplicador = 0;
            int filaNuevaMatriz =0;
            int columnaNuevaMatriz =0;
            Matriz2Numerica nuevaMatriz = new Matriz2Numerica(matriz2.renglones, columnas);
            for(int fila = 0; fila < matriz2.renglones; fila++){
                for(int col = 0; col < matriz2.columnas; col++){
                    for(int colum =0; colum < renglones; colum++){
                        multiplicador =((double) matriz2.obtener(fila,col)*(double)datos[col][colum])+multiplicador;
                    }
                    if(columnaNuevaMatriz < nuevaMatriz.columnas){
                        nuevaMatriz.cambiar(filaNuevaMatriz,columnaNuevaMatriz,multiplicador);
                        columnaNuevaMatriz++;
                    }else{
                        columnaNuevaMatriz =0;
                        filaNuevaMatriz++;
                        nuevaMatriz.cambiar(filaNuevaMatriz,columnaNuevaMatriz,multiplicador);
                        columnaNuevaMatriz++;
                    }
                    multiplicador = 0;
                }

            }
            datos = nuevaMatriz.datos;
            columnas = nuevaMatriz.columnas;
            renglones = nuevaMatriz.renglones;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que suma una matriz a nuestra matriz.
     * @param matriz2 La matriz que sumaremos a nuestra matriz.
     * @return True en caso de que se pueda, false en caso contrario.
     */
    public boolean sumar(Matriz2Numerica matriz2){
        if(matriz2.columnas == columnas && matriz2.renglones == renglones){
            for(int fila = 0; fila < renglones; fila++){
                for(int col =0; col <columnas; col++){
                    datos[fila][col] = (double)datos[fila][col] + (double)matriz2.datos[fila][col];
                }
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metod que aplica un potencia a cada elemento de nuestra matriz.
     * @param escalar el escalar al que elevaremos nuestra matriz.
     * @return true despues de hacer el proceso.
     */
    public boolean aplicarPotencia(Number escalar){
        for(int fila =0; fila <renglones; fila++){
            for(int col =0; col <columnas;col++){
                datos[fila][col] = Math.pow((double)datos[fila][col],(double)escalar);
            }
        }
        return true;
    }

    /**
     * Metodo para encontrar un valor en la matriz.
     * @param valor El valor que buscaremos.
     * @return true en caso de encontrarlo, false en caso contrario.
     */
    public boolean encontrarValor(double valor){
        for(int fila =0; fila <renglones; fila++){
            for(int col = 0; col <columnas; col++){
                if ((double)datos[fila][col] == valor){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que aplica logaritmo a todos nuestros elementos de nuestra matriz,en caso de que sea cero no lo aplica.
     * @param tipoLogaritmo enum tipo logaritmo que dira de que tipo de logaritmo obtendremos el resultado,
     * @return treu despues de hacer el proceso.
     */
    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo){
        for(int fila = 0; fila <renglones; fila++){
            for(int col =0; col <columnas; col++){
                if((double)datos[fila][col] !=0){
                    datos[fila][col] = Math.log((double)datos[fila][col])/Math.log(tipoLogaritmo.getValor());
                }
            }
        }
        return true;
    }

    /**
     * Metodo para convertir nuestra matriz a matriz diagonal con el numero indicado.
     * @param contenido el numero que estara en la diagonal.
     * @return true despues de hacer todo el proceso.
     */
    public boolean matrizDiagonal(Number contenido){
        int diagonal =0;
        for(int fila = 0; fila <renglones; fila++){
            for(int col =0; col <columnas; col++){
                if(fila == col){
                    datos[fila][col] = contenido;
                }else{
                    datos[fila][col] = 0;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si en la esquina superior se encuentra el valor indicado y en los demas no
     * @param valor El valor que buscamos.
     * @param fila La fila donde lo buscamos.
     * @param col La columa donde lo buscamos.
     * @return treu en caso de que se encuentre el valor y en los demas no, false en caso contrario.
     */
    public boolean comprobarValorDiagonalSuperior(int valor,int fila,int col){
        if(fila == col){
            if((double)datos[fila][col]==valor){
                return false;
            }
        }else {
            if(col >fila){
                if((double)datos[fila][col] != valor){
                    return false;
                }
            }else {
                if((double)datos[fila][col] ==valor){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si nuestra matriz es una matriz diagonal superior.
     * @return treu en caso de que los sea, false en caso contrario
     */
    public boolean matrizDiagonalSuperior(){
        for(int fila =0; fila <renglones; fila++){
            for(int col =0; col <columnas; col++){
                if(!comprobarValorDiagonalSuperior(0, fila, col)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si en la esquina inferior se encuentra el valor indicado y en los demas no
     * @param valor El valor que buscamos.
     * @param fila La fila donde lo buscamos.
     * @param col La columa donde lo buscamos.
     * @return treu en caso de que se encuentre el valor y en los demas no, false en caso contrario.
     */
    public boolean comprobarValorDiagonalInferior(int valor,int fila,int col){
        if(fila == col){
            if((double)datos[fila][col]==valor){
                return false;
            }
        }else {
            if(col <fila){
                if((double)datos[fila][col] != valor){
                    return false;
                }
            }else {
                if((double)datos[fila][col] ==valor){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si nuestra matriz es una matriz diagonal inferior.
     * @return treu en caso de que los sea, false en caso contrario
     */
    public boolean matrizDiagonlInferior(){
        for(int fila =0; fila <renglones; fila++){
            for(int col =0; col <columnas; col++){
                if(!comprobarValorDiagonalInferior(0, fila, col)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo que potencia nuestra matriz a el exponente indicado.
     * @param exponente La cantidad de veces a la que elvearemos nuestra matriz.
     * @return true en caso de que se pueda, false en caso contrario.
     */
    public boolean potencia(int exponente){
        if(columnas == renglones){
            Matriz2Numerica matriz = clonar();
            for(int potencia=1; potencia <= exponente; potencia++){
                multiplicar(matriz);
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo para doblar los renglones de una matriz a la mitad.
     * @return true despues de hacer todo el proceso.
     */
    public boolean doblarRenglones(){
        Matriz2Numerica nueva = new Matriz2Numerica(renglones,columnas/2);
        int izquierda = (columnas/2)/2;
        int derecha = columnas-(int) Math.ceil((columnas/2.0)/2.0);
        for(int fila = 0; fila <renglones; fila++){
            double suma = 0;
            int posicion =0;
            for (int col =0; col < columnas; col++){
                if(col < izquierda){
                    suma = (double)datos[fila][col] + suma;

                }
                if(col == izquierda){
                    suma = (double)datos[fila][col]+ suma;
                    nueva.cambiar(fila,posicion,suma);
                    suma = 0;
                    posicion++;

                }
                if(col > columnas/2){
                    suma = (double)datos[fila][col] + suma;

                }
                if(col == columnas-1){
                    suma = suma + (double)datos[fila][col];
                    nueva.cambiar(fila,nueva.columnas-1,suma);

                }
                if(col > izquierda && col < derecha){
                    nueva.cambiar(fila,posicion,datos[fila][col]);
                    posicion++;
                }
            }

        }
        datos = nueva.datos;
        columnas = nueva.columnas;
        renglones = nueva.renglones;
        return true;
    }

    /**
     * Metodo para doblar los columas de una matriz a la mitad.
     * @return true despues de hacer todo el proceso.
     */
    public boolean doblarColumnas(){
        Matriz2Numerica nueva = new Matriz2Numerica(renglones/2,columnas);
        int izquierda = (renglones/2)/2;
        int derecha = renglones-(int) Math.ceil((renglones/2.0)/2.0);
        for(int col =0; col < columnas; col++){
            double suma = 0;
            int posicion =0;

            for (int fila = 0; fila <renglones; fila++){
                if(fila < izquierda){
                    suma = (double)datos[fila][col] + suma;

                }
                if(fila == izquierda){
                    suma = (double)datos[fila][col]+ suma;
                    nueva.cambiar(posicion,col,suma);
                    suma = 0;
                    posicion++;

                }
                if(fila > renglones/2){
                    suma = (double)datos[fila][col] + suma;

                }
                if(fila == renglones-1){
                    suma = suma + (double)datos[fila][col];
                    nueva.cambiar(nueva.renglones-1,col,suma);

                }
                if(fila > izquierda && fila < derecha){
                    nueva.cambiar(posicion,col,datos[fila][col]);
                    posicion++;
                }
            }

        }
        datos = nueva.datos;
        columnas = nueva.columnas;
        renglones = nueva.renglones;
        return true;
    }
}
