package herramientas.matematicas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Clase que maneja expresiones aritmeticas
 */
public class ExpresionesAritmeticas {
    /**
     * Metodo que transforma un expresion infija a postfija.
     * @param infija La expresion infija.
     * @return La expresion en su forma pstfija.
     */
    public static String infijaAPostfija(String infija) {
        String postfija = "";
        String numero = "";
        PilaEstatica pila = new PilaEstatica(infija.length());
        for(int indice =0; indice < infija.length(); indice++){
            if(ExpresionesAritmeticas.esOperando(infija.charAt(indice))){
                numero = numero + infija.charAt(indice);
                if(indice == infija.length()-1){
                    postfija = postfija + numero +" ";
                }
            }else{
                numero = numero + " ";
                postfija = postfija + numero;
                numero = "";
                if(infija.charAt(indice) == ')'){
                    while((char)pila.verUltimo() !='('){
                        postfija = postfija + pila.quitar();
                    }
                    pila.quitar();
                }else{
                    if(!pila.vacio()){
                        while(mayorIgualPrioridad(infija.charAt(indice),pila) && !pila.vacio()){
                            postfija = postfija + pila.quitar();
                        }
                    }
                    pila.poner(infija.charAt(indice));
                }
            }
        }
        while (!pila.vacio()){
            postfija = postfija + pila.quitar();
        }
        return postfija;
    }

    /**
     * Metodo que comprueba si un operador tiene menor prioridad que el ultimo de una cola.
     * @param operador El operador que comprobaremos.
     * @param pila La pila con operadores
     * @return true en caso de que sea cierto, false en caso contrario.
     */
    public static boolean mayorIgualPrioridad(char operador, PilaEstatica pila){
        if(!pila.vacio()){
            if(operador == '+' || operador == '-'){
                return (char) pila.verUltimo() == '*' || (char) pila.verUltimo() == '/' || (char) pila.verUltimo() == '^'|| (char) pila.verUltimo() == '+' || (char) pila.verUltimo() == '-';
            }
            if(operador == '*' || operador == '/' || operador == '%'){
                return (char) pila.verUltimo() == '^' || (char) pila.verUltimo() == '*' || (char) pila.verUltimo() == '/' || (char) pila.verUltimo() == '%';
            }
            if(operador == '^'){
                return (char) pila.verUltimo() == '^';
            }
            return false;
        }
        return false;
    }
    public static String infijaPrefija(String infija) {
        return "";
    }

    /**
     * Metodo que calcula el resultado de una expresion postfija
     * @param postfija La expresion en cuestion.
     * @return El resultado de los calculos.
     */
    public static Double evaluarPostfija(String postfija) {
        PilaEstatica pila = new PilaEstatica(postfija.length());

        //1) Tokenizar la expresión postfija.
        //  a b c d - * e f ^ /  +
        //  0 1 2 3 4 5 6 7 8 9 10, índiceToken
        String numero = "";
        for (int indiceToken = 0; indiceToken < postfija.length(); indiceToken++) {
            //2) Analizar de uno por uno los tokens.
            char token = postfija.charAt(indiceToken);

            if (esOperando(token) == true) {
                //2.1) Si el token es Operando, se mete en la pila.
                if(token != ' '){
                    numero = numero + token;
                }else{
                    if(numero != ""){
                        if (pila.poner("" + numero) == false) { //no hay espacio en la pila
                            return null;
                        }
                    }
                    numero = "";
                }

            } else { //es operador
                //2.2) Si el token es Operador, se sacan de la pila dos operandos
                //(el primer operando que se saque equivale a OP2).
                // Se aplica la operación del token y el resultado se mete en la
                //pila.
                String operando2 = (String) pila.quitar();
                String operando1 = (String) pila.quitar();

                if (operando1 == null || operando2 == null) { //no había elementos que sacar
                    return null;
                } else { //seguimos con el proceso
                    Double operacionParcial = aplicarOperacionA(token, Double.parseDouble(operando1),
                            Double.parseDouble(operando2));
                    if (operacionParcial == null) { //el operador es inválido
                        return null;
                    } else { //seguimos
                        if (pila.poner("" + operacionParcial) == false) { //no hab{ia espacio
                            return null;
                        }
                    }
                }
            }
        } //for
        //3) El resultado de la operación queda en la pila.
        String resultadoEvaluacion = (String) pila.quitar();

        if (resultadoEvaluacion == null) { //hubo error
            return null;
        } else {
            return Double.parseDouble(resultadoEvaluacion);
        }
    }

    /**
     * Metodo que aplica las operaciones a nuestro expresion
     * @param operador El operador que se utilizara.
     * @param operando1 El primer numero de la operacion.
     * @param operando2 El segundo numero de la operacion.
     * @return El resultado.
     */
    public static Double aplicarOperacionA(char operador, double operando1, double operando2) {
        if (operador == '+') {
            return operando1 + operando2;
        } else if (operador == '-') {
            return operando1 - operando2;
        } else if (operador == '*') {
            return operando1 * operando2;
        } else if (operador == '/') {
            if (operando2 == 0) {
                return null;
            } else {
                return operando1 / operando2;
            }
        } else if (operador == '%') {
            return operando1 % operando2;
        } else if (operador == '^') {
            return Math.pow(operando1, operando2);
        } else { //no es un operador del catálogo
            return null;
        }
    }

    /**
     * Metodo que dice si un token es operando.
     * @param token El token que queremos comprobar.
     * @return true e caso de que lo sea, false en caso contrario.
     */
    public static boolean esOperando(char token) {
        if (token == '+' || token == '-' || token == '*' || token == '/' || token == '^' || token == '(' || token == ')' || token == '%') {
            return false; //no es operando
        } else { //como no es operador y otro s{imbolo, es operando
            return true;
        }
    }

    public static Double evaluarPrefija(String prefija) {
        return 0.0;
    }

    /**
     * Metodo que identifica las variables de una expresion y pide sus valores para reemplazarlas.
     * @param cadena La expresion que queremos comprobar.
     * @return La cadena con las variables reemplazadas.
     */
    public static String  buscarVariables(String cadena){
        for(int indice =0; indice < cadena.length(); indice++){
            char caracter = cadena.charAt(indice);
            if(ExpresionesAritmeticas.esOperando(caracter) && ((Character.isLetter(caracter)) || caracter =='_' || caracter =='$' )){
                String atras = regresarCadenaDeAtras(cadena, indice);
                String adelante = regresarCadenaDeEnfrente(cadena,regresarPosicionFinalVariable(indice,cadena));
                String valor = pedirDatosVariables();
                indice = indice+ valor.length();
                cadena = atras +valor+ adelante;
            }
        }
        return cadena;
    }

    /**
     * Metodo que pide el valor de las variables.
     * @return El valor dado por el usuario.
     */
    public static String pedirDatosVariables(){
        SalidaPorDefecto.consola("Ingresa el valor de la varaible (en orden): \n");
        return EntradaPorDefecto.consolaCadenas();
    }

    /**
     * Metodo que regresa la parte de atras de una variable.
     * @param cadena La expresion de donde sacaremos la parte.
     * @param indice El indice donde comienza la cadena
     * @return La parte de atras procesada
     */
    public static String regresarCadenaDeAtras(String cadena, int indice){
        String nuevaCadena= "";
        for(int posicion = 0; posicion < indice; posicion++ ){
            nuevaCadena = nuevaCadena + cadena.charAt(posicion);
        }
        return nuevaCadena;
    }

    /**
     * Metodo que regresa donde termina una variable
     * @param cadena La expresion de donde sacaremos la parte.
     * @param incio El indice de inicio de la variable.
     * @return El indice donde termina.
     */
    public static int regresarPosicionFinalVariable(int incio,String cadena){
        for(int indice = incio; indice < cadena.length(); indice++){
            if(!ExpresionesAritmeticas.esOperando(cadena.charAt(indice)) || cadena.charAt(indice) == '(' || cadena.charAt(indice) == ')'){
                return  indice;
            }
        }
        return cadena.length();
    }

    /**
     * Metodo que regresa la parte de adelante de una variable.
     * @param cadena La expresion de donde sacaremos la parte.
     * @param indice El indice donde comenzaremos a obtener los valores de la cadena.
     * @return La parte de adenlante procesada.
     */
    public static String regresarCadenaDeEnfrente(String cadena,int indice){
        String nuevaCadena = "";
        for(int posicion = indice; posicion < cadena.length(); posicion++ ){
            nuevaCadena= nuevaCadena + cadena.charAt(posicion);
        }
        return nuevaCadena;
    }

    /**
     * Metodo que llamaran las demmas clases que validara si una expresion esta bien formada en cueston de caracteres de apertura y cierre.
     * @param expresion La expresion a validar.
     * @return La pila que estara vacia en caso de que la expresion este bien.
     */
    public static PilaEstatica validarExpresion(String expresion){
        PilaEstatica caracteres = new PilaEstatica(expresion.length());
        for(int indice =0; indice < expresion.length(); indice++){
            char caracter = expresion.charAt(indice);
            if(esCaracterApertura(caracter)){
                caracteres.poner(crearListaIndices(caracter,indice));
            }else if(esCaracterCierre(caracter)){
                if(validarCierre(caracter,caracteres)){
                    caracteres.quitar();
                }else{
                    return caracteres;
                }
            }

        }
        return caracteres;
    }

    /**
     * Metodo que dice si un caracter es de apertura o no.
     * @param caracter El caracter a comprobar.
     * @return true en caso de que lo sea, false en caso contrario.
     */
    private static boolean esCaracterApertura(char caracter){
        if(caracter == '(' || caracter == '[' || caracter == '{'){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que indica si un caracter es de cierre.
     * @param caracter El caracter acomprobar.
     * @return true en caso de que lo sea, false en caso contrario.
     */
    private static boolean esCaracterCierre(char caracter){
        if(caracter == ')' || caracter == ']' || caracter == '}'){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que valida si un caracter de cerrar se esta cerrando correctamente
     * @param caracter El caracter de cerrar que se validara
     * @param pila La pila con los caracteres de apertura
     * @return treu en caso de que el caracter de cerrar haya cerrado correctamente lo que corresponde, false en caso contrario
     */
    private static boolean validarCierre(char caracter, PilaEstatica pila){
        char apertura = (char) ((ListaEstatica)pila.verUltimo()).obtener(0);
        if(apertura == '(' && caracter != ')'){
            return false;
        }else if(apertura == '[' && caracter != ']'){
            return false;
        }else if (apertura == '{' && caracter != '}'){
            return false;
        }

        return true;
    }

    /**
     * Metodo que crea la lista que sera metica a la pila
     * @param caracter El caracter de apertura.
     * @param indice El indice de donde esta el caracter
     * @return la lista generada
     */
    private static ListaEstatica crearListaIndices(char caracter, int indice) {
        ListaEstatica lista = new ListaEstatica(2);
        lista.agregar(caracter);
        lista.agregar(indice);
        return lista;
    }
}


