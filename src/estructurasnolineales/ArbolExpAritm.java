package estructurasnolineales;

import estructuraslineales.PilaEstatica;
import estructuraslineales.auxiliares.NodoDoble;
import herramientas.matematicas.ExpresionesAritmeticas;

public class ArbolExpAritm extends ArbolBinario{

    public boolean generarArbolInfija(String infija) {
        // Paso 1: Convertir de manera sistemática una expresión infija a postfija (prefija).
        //invocamos a un método que convierta infija -> postfija
        //generarArbolPostfija(postfija)
        return true;
    }

    public boolean generarArbolPostfija(String postfija) {
        PilaEstatica pila=new PilaEstatica(postfija.length());

        for(int posToken=0;posToken<postfija.length();posToken++) {
            // Paso 2: (Asumiendo que se tiene una expresión postfija) Tokenizar la expresión izq -> der.
            char token=postfija.charAt(posToken);
            //         Paso 3: Comparar
            if(ExpresionesAritmeticas.esOperando(token)==true) {
                //           3.1 Si el token es un operando, crear un nodo con el token como contenido y se mete en la pila.
                NodoDoble nuevoNodo= new NodoDoble(token);
                if(pila.poner(nuevoNodo)==false) {
                    return false;
                }
            }else {
                //           3.2 Si el token es un operador, crear un nodo con el token como contenido; sacando dos nodos
                //               (operandos) de la pila (la primera extracción es op2, la siguiente es op1),
                //               enlazándolos a la subraíz creada (nodo creado). El nodo nuevo (subraíz) se mete en la pila.
                NodoDoble nuevoNodo=new NodoDoble(token);
                NodoDoble operando2=(NodoDoble) pila.quitar(); //hijo derecho
                NodoDoble operando1=(NodoDoble) pila.quitar(); //hijo izquyierdo
                nuevoNodo.setNodoIzq(operando1);
                nuevoNodo.setNodoDer(operando2);
                if(pila.poner(nuevoNodo)==false) {
                    return false;
                }
            }
        }
        // Paso 4: La raíz del árbol quedará guardada en la pila (solo debe haber un solo elemento).
        NodoDoble nodoRaiz= (NodoDoble) pila.quitar();
        if(nodoRaiz!=null){
            raiz=nodoRaiz;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que genera un arbol de expresion con una expresion en parentesis.
     * @param expParentesis La expresion de parentesis.
     */
    public void generarArbolParentesis(String expParentesis){
        PilaEstatica pila=new PilaEstatica(expParentesis.length());
        NodoDoble nodoActual = new NodoDoble("");
        boolean primerParentesis = true;
        for(int posToken =0; posToken < expParentesis.length(); posToken++){
            char token=expParentesis.charAt(posToken);
            if(token == '(' && !primerParentesis){
                NodoDoble nuevo = new NodoDoble("");
                if(nodoActual.getNodoIzq() == null){
                    nodoActual.setNodoIzq(nuevo);
                }else{
                    nodoActual.setNodoDer(nuevo);
                }
                nodoActual = nuevo;
                pila.poner(nodoActual);
            }
            if (token == '(' && primerParentesis){
                nodoActual = new NodoDoble("");
                raiz = nodoActual;
                pila.poner(nodoActual);
                primerParentesis = false;
            }
            if(ExpresionesAritmeticas.esOperando(token) && token != ' '){
                NodoDoble nuevo = new NodoDoble(token);
                if(nodoActual.getNodoIzq() == null){
                    nodoActual.setNodoIzq(nuevo);
                }else{
                    nodoActual.setNodoDer(nuevo);
                }
            }
            if(!ExpresionesAritmeticas.esOperando(token) && token != '(' && token != ')' && token != ' '){
                nodoActual = (NodoDoble) pila.quitar();
                nodoActual.setContenido(token);
            }
        }
    }

}
