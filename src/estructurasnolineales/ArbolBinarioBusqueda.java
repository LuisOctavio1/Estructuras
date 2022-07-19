package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliares.Nodo;
import estructuraslineales.auxiliares.NodoDoble;
import herramientas.generales.Utilerias;

import javax.security.auth.Subject;

public class ArbolBinarioBusqueda extends ArbolBinario{

    public boolean agregar(Object valor){
        if(raiz==null){ //el valor lo agregaremos como la nueva raíz
            NodoDoble nuevoNodo=new NodoDoble(valor);
            if(nuevoNodo!=null){ //si hay espacio
                raiz=nuevoNodo;
                return true;
            }else{ //no hay espacio o hay error
                return false;
            }
        }else{ //ya hay nodos
            return agregar(raiz,valor);
        }
    }

    private boolean agregar(NodoDoble subRaiz, Object valor){
        //Comparar si el valor es mayor o menor a la subraíz
        if(Utilerias.compararObjetos(valor,subRaiz.getContenido())<0){ //valor < subRaiz
            if(subRaiz.getNodoIzq()==null){ //llegamos a la posicion donde le toca ser insertado
                NodoDoble nuevoNodo=new NodoDoble(valor);
                if(nuevoNodo!=null){ // si hay espacio
                    subRaiz.setNodoIzq(nuevoNodo);
                    return true;
                }else{ //no hay espacio
                    return false;
                }
            }else{ //hacemos llamada recursiva hacia esa rama
                return agregar(subRaiz.getNodoIzq(),valor);
            }
        }else if(Utilerias.compararObjetos(valor,subRaiz.getContenido())>0){ //valor > subRaiz
            if(subRaiz.getNodoDer()==null){ //llegamos a la posicion donde le toca ser insertado
                NodoDoble nuevoNodo=new NodoDoble(valor);
                if(nuevoNodo!=null){ // si hay espacio
                    subRaiz.setNodoDer(nuevoNodo);
                    return true;
                }else{ //no hay espacio
                    return false;
                }
            }else{ //hacemos llamada recursiva hacia esa rama
                return agregar(subRaiz.getNodoDer(),valor);
            }
        }else{ //valor = subRaiz
            return false;
        }
    }

    public Object buscar(Object valor){
        return buscar(raiz, valor);
    }

    private Object buscar(NodoDoble subRaiz, Object valor){
        if(subRaiz!=null){ //hay donde buscar
            if (Utilerias.compararObjetos(valor,subRaiz.getContenido())<0) {   //<
                return buscar(subRaiz.getNodoIzq(), valor);
            }else if (Utilerias.compararObjetos(valor,subRaiz.getContenido())>0){  //>
                return buscar(subRaiz.getNodoDer(), valor);
            }else{ //si son iguales
                return subRaiz.getContenido();
            }
        }else{ //no hay donde buscar
            return null;
        }
    }

    /**
     * Metodo que llamaran las demas clases para eliminar un elemento.
     * @param info EL valor a eliminar.
     */
    public void eliminacionABB(Object info){
        eliminacionABB(raiz,raiz,info);
    }

    /**
     * Metodo que elimina un valor de el arbol.
     * @param apnodo El nodo actual que se esta recorriendo, tambien sera el nodo que eliminaremos.
     * @param anterior El nodo anterior.
     * @param info El valor que queremos eliminar.
     */
    private void eliminacionABB(NodoDoble apnodo, NodoDoble anterior, Object info){
        if(apnodo != null){
            if(Utilerias.compararObjetos(info,apnodo.getContenido()) < 0){
                eliminacionABB(apnodo.getNodoIzq(),apnodo,info);
            }else{
                if(Utilerias.compararObjetos(info,apnodo.getContenido()) > 0){
                    eliminacionABB(apnodo.getNodoDer(),apnodo,info);
                }else{
                    if(apnodo.getNodoIzq() != null && apnodo.getNodoDer() != null){
                        NodoDoble aux = apnodo.getNodoIzq();
                        boolean bo = false;
                        NodoDoble aux1 = apnodo;
                        while (aux.getNodoDer() != null){
                            aux1 = aux;
                            aux = aux.getNodoDer();
                            bo = true;
                        }
                        apnodo.setContenido(aux.getContenido());
                        if(bo){
                            aux1.setNodoDer(aux.getNodoIzq());
                        }else{
                            apnodo.setNodoIzq(aux.getNodoIzq());
                        }
                    }else{
                        NodoDoble otro = apnodo;
                        if( otro.getNodoDer() == null){
                            if(otro.getNodoIzq() != null){
                                otro = apnodo.getNodoIzq();
                                if(anterior != null){
                                    if(Utilerias.compararObjetos(info,anterior.getContenido()) < 0){
                                        anterior.setNodoIzq(otro);
                                    }else{
                                        anterior.setNodoDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }else{
                                if(anterior  == null){
                                    raiz = null;
                                }else{
                                    if(Utilerias.compararObjetos(info,anterior.getContenido()) < 0){
                                        anterior.setNodoIzq(null);
                                    }else{
                                        anterior.setNodoDer(null);
                                    }
                                }
                            }
                        }else{
                            if(otro.getNodoIzq() == null){
                                otro = apnodo.getNodoDer();
                                if(anterior != null){
                                    if(Utilerias.compararObjetos(info,anterior.getContenido())<0){
                                        anterior.setNodoIzq(otro);
                                    }else{
                                        anterior.setNodoDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }
                        }
                    }
                }
            }
        }else{
            SalidaPorDefecto.consola("El dato no esta en el arbol");
        }
    }
}
