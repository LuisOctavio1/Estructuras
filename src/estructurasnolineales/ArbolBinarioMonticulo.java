package estructurasnolineales;

import estructuraslineales.auxiliares.NodoDoble;
import herramientas.generales.Utilerias;
import utiles.TipoOrden;

/**
 * Clase que maneja los arboles binarios de monticulo.
 */
public class ArbolBinarioMonticulo extends ArbolBinario{
    private  TipoOrden orden;

    /**
     * Constructor de la clase.
     * @param orden Enumerando que definira si es ascendente o descendente.
     */
    public ArbolBinarioMonticulo(TipoOrden orden){
        this.orden = orden;
    }

    /**
     * Metodo que llaman las demas clases que agrega un elemento al monticulo.
     * @param objeto El objeto a agregar.
     */
    public void agregar(Object objeto){
        NodoDoble nuevo = new NodoDoble(objeto);
        if(raiz == null){
            raiz = nuevo;
        }else{
            agregar(raiz,nuevo);
        }
    }

    /**
     * Metodo recursivo el cual sirve para agregar objetos.
     * @param actual El nodo actual del recorrido.
     * @param nuevo El nodo a insertar.
     */
    private void agregar(NodoDoble actual,NodoDoble nuevo){
        if(actual.getNodoDer() !=null && actual.getNodoIzq() != null){
            if(actual.getNodoIzq().getNodoIzq() ==null || actual.getNodoIzq().getNodoDer() == null){
                agregar(actual.getNodoIzq(),nuevo);
            }else{
                agregar(actual.getNodoDer(),nuevo);
            }
        }else{
            Object aux = actual.getContenido();
            if(actual.getNodoIzq() == null){
                actual.setNodoIzq(nuevo);
            }else{
                actual.setNodoDer(nuevo);
            }
            if(comprobarNodoSuperior(actual.getContenido(),nuevo.getContenido())){
                actual.setContenido(nuevo.getContenido());
                nuevo.setContenido(aux);
            }
        }
    }

    /**
     * Metodo que comprueba si es mayor o menor dependiendo del enum.
     * @param valor El valor a comprobar.
     * @param valorNuevo El nuevo valor a comprobar.
     * @return true si se cumple dependiendo el enum, false en caso contrario.
     */
    private boolean comprobarNodoSuperior(Object valor,Object valorNuevo ){
        if(orden.getValor() == 1){
            if(Utilerias.compararObjetos(valorNuevo,valor) > 0){
                return true;
            }else{
                return false;
            }
        }else{
            if(Utilerias.compararObjetos(valorNuevo,valor) > 0){
                return false;
            }else{
                return true;
            }
        }
    }

    /**
     * Metodo que elimina un elemento del monticulo.
     */
    public void eliminar(){
        if(raiz != null){
            if(raiz.getNodoDer() == null && raiz.getNodoIzq() == null){
                raiz = null;
            }else{
                eliminar(raiz,raiz);
            }
        }
    }

    /**
     * Metodo recursivo que elimina un elemento.
     * @param actual El nodo actual recorrido.
     * @param anterior El nodo anterior.
     */
    private void eliminar(NodoDoble actual,NodoDoble anterior){
        if(actual.getNodoDer()== null && actual.getNodoIzq() == null){
            raiz.setContenido(actual.getContenido());
            if(anterior.getNodoDer() != null){
                anterior.setNodoDer(null);
            }else{
                anterior.setNodoIzq(null);
            }
            acomodarEliminacion(raiz);
        }else{
            if(actual.getNodoDer() != null){
                eliminar(actual.getNodoDer(),actual);
            }else{
                eliminar(actual.getNodoIzq(),actual);
            }
        }
    }

    /**
     * Metodo que acomoda el arbol despues de una eliminacion.
     * @param actual El nodo actual del recorrido.
     */
    private void acomodarEliminacion(NodoDoble actual){
        Object aux = actual.getContenido();
        if(actual.getNodoDer() != null || actual.getNodoIzq()!= null){
            Object hijoDerValor;
            Object hijoIzqValor;
            if(actual.getNodoDer() == null){
                if(orden.getValor()==1){
                    hijoDerValor = (double)actual.getNodoIzq().getContenido()-1;
                    hijoIzqValor = actual.getNodoIzq().getContenido();
                }else{
                    hijoDerValor = (double)actual.getNodoIzq().getContenido()+1;
                    hijoIzqValor = actual.getNodoIzq().getContenido();
                }
            }else if(actual.getNodoIzq() == null){
                if(orden.getValor()==1){
                    hijoDerValor = actual.getNodoDer().getContenido();
                    hijoIzqValor = (double)actual.getNodoDer().getContenido() -1;
                }else{
                    hijoDerValor = actual.getNodoDer().getContenido();
                    hijoIzqValor = (double)actual.getNodoDer().getContenido() + 1;
                }

            }else{
                hijoDerValor = actual.getNodoDer().getContenido();
                hijoIzqValor = actual.getNodoIzq().getContenido();
            }
            if(!comprobarNodoSuperior(hijoDerValor,hijoIzqValor)){
                if(comprobarNodoSuperior(actual.getContenido(),hijoDerValor)){
                    actual.setContenido(actual.getNodoDer().getContenido());
                    actual.getNodoDer().setContenido(aux);
                    acomodarEliminacion(actual.getNodoDer());
                }
            }else{
                if(comprobarNodoSuperior(actual.getContenido(),hijoIzqValor)){
                    actual.setContenido(actual.getNodoIzq().getContenido());
                    actual.getNodoIzq().setContenido(aux);
                    acomodarEliminacion(actual.getNodoIzq());
                }
            }
        }
    }
}

