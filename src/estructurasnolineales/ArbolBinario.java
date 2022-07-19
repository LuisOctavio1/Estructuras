package estructurasnolineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaDinamica;
import estructuraslineales.PilaDinamica;
import estructuraslineales.auxiliares.NodoDoble;

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario(){
        raiz=null;
    }

    public boolean generarArbol(){
        SalidaPorDefecto.consola("Indica la raíz: ");
        String contenidoNodo= EntradaPorDefecto.consolaCadenas();
        NodoDoble nuevoNodo=new NodoDoble(contenidoNodo);
        if(nuevoNodo!=null){ //hay espacio de memoria
            raiz=nuevoNodo;
            generarArbol(raiz);
            return true;
        }else{ //no hay espacio de memoria
            return false;
        }
    }

    private void generarArbol(NodoDoble subRaiz){ //Por cada Subraiz
        //Agregar hijo izquierdo
        SalidaPorDefecto.consola("¿El nodo "+ subRaiz.getContenido()+ " tiene hijo izquierdo ? ");
        String respuestaPreguntaHijoIzq=EntradaPorDefecto.consolaCadenas();
        if(respuestaPreguntaHijoIzq.equalsIgnoreCase("s")){ //si quiuere agregar un hijo izquierdo
            SalidaPorDefecto.consola("Indica el dato del hijo izquierdo: ");
            String contenidoNodoIzquierdo=EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoIzquierdo=new NodoDoble(contenidoNodoIzquierdo);
            if(nuevoNodoIzquierdo!=null){ //si hay espacio
                subRaiz.setNodoIzq(nuevoNodoIzquierdo); //ligamos la subraiz a este hijo nuevo
                //llamada recursiva para ver si a este nodo izquierdo le corresponden tener hijo también
                generarArbol(subRaiz.getNodoIzq());
            }
        }//si no quiere tener hijo izquierdo, no hacemos nada, es decir, caso base

        //Agregar hijo derecho
        SalidaPorDefecto.consola("¿El nodo "+ subRaiz.getContenido()+ " tiene hijo derecho ? ");
        String respuestaPreguntaHijoDer=EntradaPorDefecto.consolaCadenas();
        if(respuestaPreguntaHijoDer.equalsIgnoreCase("s")){ //si quiuere agregar un hijo derecho
            SalidaPorDefecto.consola("Indica el dato del hijo derecho: ");
            String contenidoNodoDerecho=EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoDerecho=new NodoDoble(contenidoNodoDerecho);
            if(nuevoNodoDerecho!=null){ //si hay espacio
                subRaiz.setNodoDer(nuevoNodoDerecho); //ligamos la subraiz a este hijo nuevo
                //llamada recursiva para ver si a este nodo derecho le corresponden tener hijo también
                generarArbol(subRaiz.getNodoDer());
            }
        }//si no quiere tener hijo derecho, no hacemos nada, es decir, caso base
    }

    public void inorden(){
        inorden(raiz);
    }

    private void inorden(NodoDoble subRaiz){
        //IRD
        if(subRaiz!=null) {
            inorden(subRaiz.getNodoIzq());
            SalidaPorDefecto.consola(subRaiz.getContenido() + " ");
            inorden(subRaiz.getNodoDer());
        } //en el else el caso base, donde n ose hace nada
    }

    public void preorden(){
        preorden(raiz);
    }

    private void preorden(NodoDoble subRaiz){
        //RID
        if(subRaiz!=null) {
            SalidaPorDefecto.consola(subRaiz.getContenido() + " ");
            preorden(subRaiz.getNodoIzq());
            preorden(subRaiz.getNodoDer());
        } //en el else el caso base, donde n ose hace nada
    }

    public void postorden(){
        postorden(raiz);
    }

    private void postorden(NodoDoble subRaiz){
        //IDR
        if(subRaiz!=null) {
            postorden(subRaiz.getNodoIzq());
            postorden(subRaiz.getNodoDer());
            SalidaPorDefecto.consola(subRaiz.getContenido() + " ");
        } //en el else el caso base, donde n ose hace nada
    }

    /**
     * Metodo que imprime el arbol de manero postorden sin usar recursion.
     */
    public void postordenIterativo(){
        NodoDoble nodoSiguiente = raiz;
        PilaDinamica pila = new PilaDinamica();
        PilaDinamica pilaFinal = new PilaDinamica();
        pila.poner(nodoSiguiente);
        if (nodoSiguiente != null){
            while (!pila.vacio()){
                nodoSiguiente = (NodoDoble) pila.verUltimo();
                pilaFinal.poner(pila.quitar());
                if(nodoSiguiente.getNodoIzq() != null){
                    pila.poner(nodoSiguiente.getNodoIzq());
                }
                if(nodoSiguiente.getNodoDer() != null){
                    pila.poner(nodoSiguiente.getNodoDer());
                }
            }
            while (!pilaFinal.vacio()){
                SalidaPorDefecto.consola(pilaFinal.quitar() + " ");
            }
        }
    }

    /**
     * Metodo que recorre el arbol de forma amplitud.
     */
    public  void amplitud(){
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);
        while (!cola.vacio()){
            NodoDoble nodoActual = (NodoDoble) cola.quitar();
            SalidaPorDefecto.consola(nodoActual + " ");
            if(nodoActual.getNodoIzq() != null){
                cola.poner(nodoActual.getNodoIzq());
            }
            if(nodoActual.getNodoDer() != null){
                cola.poner(nodoActual.getNodoDer());
            }
        }
    }

    /**
     * Metodo que sigue el algoritmo de amplitud pero reemplaza la cola por una pila.
     */
    public  void amplitudPila(){
        PilaDinamica pila = new PilaDinamica();
        pila.poner(raiz);
        while (!pila.vacio()){
            NodoDoble nodoActual = (NodoDoble) pila.quitar();
            SalidaPorDefecto.consola(nodoActual + " ");
            if(nodoActual.getNodoIzq() != null){
                pila.poner(nodoActual.getNodoIzq());
            }
            if(nodoActual.getNodoDer() != null){
                pila.poner(nodoActual.getNodoDer());
            }
        }
    }
}