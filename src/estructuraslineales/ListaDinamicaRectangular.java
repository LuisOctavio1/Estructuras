package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliares.NodoRectangular;

public class ListaDinamicaRectangular {
    NodoRectangular primero;
    NodoRectangular ultimo;

    /**
     * Constructor de la lista
     */
     public ListaDinamicaRectangular(){
         primero = null;
         ultimo = null;
     }

    /**
     * Metodo que inserta un elemento al inicio de la lista
     * @param objeto El objeto a ingresar.
     * @return true si se pudo, false en caso contrario.
     */
     public boolean insertarPrimero(Object objeto){
         NodoRectangular nuevo  = new NodoRectangular(objeto);
         if(nuevo != null){
            if(primero == null){
                 primero = nuevo;
                 ultimo = nuevo;
                //ordenarConexionVertical();
                 return true;
             }else if(primero == ultimo){
                primero = nuevo;
                primero.setNodoVertical(ultimo);
                ultimo.setNodoVertical(primero);
                //ordenarConexionVertical();
            }else{
                nuevo.setNodoVertical(primero);
                nuevo.setNodoDer(primero.getNodoVertical());
                NodoRectangular arriba = primero;
                NodoRectangular abajo = primero.getNodoVertical();
                while (abajo != null && arriba != null){
                    abajo.setNodoVertical(arriba.getNodoDer());
                    arriba.setNodoVertical(abajo);
                    arriba = arriba.getNodoDer();
                    abajo = abajo.getNodoDer();
                }
                nuevo.setNodoVertical(primero);
                primero = nuevo;
                //ordenarConexionVertical();
                return true;
            }
         }
         return false;
     }

    /**
     * Metodo que inserta un elemento al final de la lista.
     * @param objeto El valor a insertar
     * @return true si se puede, false en caso contrario.
     */
     public boolean insertarUltimo(Object objeto){
         NodoRectangular nuevo  = new NodoRectangular(objeto);
         if(nuevo != null){
             if(primero == null){
                 primero = nuevo;
                 ultimo = nuevo;
                 //ordenarConexionVertical();
                 return true;
             }else if(primero == ultimo){
                 primero.setNodoVertical(nuevo);
                 ultimo = nuevo;
                 //ordenarConexionVertical();
                 return true;
             }else{
                 NodoRectangular siguiente = primero;
                 NodoRectangular anterior = primero;
                 while (siguiente.getNodoDer() != null){
                     anterior = siguiente;
                     siguiente = siguiente.getNodoDer();
                 }
                 if(siguiente.getNodoVertical() == null){
                     siguiente.setNodoVertical(nuevo);
                     anterior.getNodoVertical().setNodoDer(nuevo);
                     nuevo.setNodoVertical(siguiente);
                     ultimo = nuevo;
                     //ordenarConexionVertical();
                     return true;
                 }else{
                     siguiente.setNodoDer(nuevo);
                     ultimo = nuevo;
                     //ordenarConexionVertical();
                     return true;
                 }
             }
         }
         return false;
     }

    /**
     * Metodo que elimina el elemento al final de la lista.
     * @return El objeto eliminado, en caso de que no se elimine nada null.
     */
     public Object eliminarFinal(){
         if(primero != null){
             Object eliminado = ultimo.getContenido();
             if(primero == ultimo){
                 ultimo  = null;
                 primero = null;
                 //ordenarConexionVertical();
                 return eliminado;
             }
             NodoRectangular siguiente = primero;
             NodoRectangular anterior = primero;
             while (siguiente.getNodoDer() != null){
                 anterior = siguiente;
                 siguiente = siguiente.getNodoDer();
             }
             if(ultimo.getNodoVertical() == null){
                 ultimo = anterior.getNodoVertical();
                 anterior.setNodoDer(null);
                 ultimo.setNodoVertical(anterior);
                 ultimo.setNodoDer(null);
             }else{
                 ultimo = ultimo.getNodoVertical();
                 ultimo.setNodoVertical(null);
                 ultimo.setNodoDer(null);
             }
             //ordenarConexionVertical();
             return eliminado;
         }else{
             return null;
         }
     }

    /**
     * Metodo que elimina el incio de la lista.
     * @return El valor eliminado, en caso de no eliminar nada null.
     */
     public Object eliminarInicio(){
         if(primero != null){
             Object eliminado = primero.getContenido();
             if(primero == ultimo){
                 primero = null;
                 ultimo = null;
                 //ordenarConexionVertical();
                 return eliminado;
             }else{
                 NodoRectangular arriba = primero;
                 NodoRectangular abajo = primero.getNodoVertical();
                 while (abajo != null && arriba != null){
                     abajo.setNodoVertical(arriba.getNodoDer());
                     arriba.setNodoVertical(abajo);
                     abajo = abajo.getNodoDer();
                     arriba = arriba.getNodoDer();
                 }
                 primero = primero.getNodoVertical();
             }
             //ordenarConexionVertical();
             return eliminado;
         }
         return null;
     }

    /**
     * Metodo que imprime la lista
     */
     public void imprimir(){
         if(primero!= null){
             NodoRectangular siguiente = primero;
             while (siguiente != null){
                 SalidaPorDefecto.consola(siguiente.toString() + " -> ");
                 siguiente = siguiente.getNodoDer();
             }
             SalidaPorDefecto.consola("null");
             SalidaPorDefecto.consola("\n");
             siguiente = primero.getNodoVertical();
             if(siguiente != null){
                 while (siguiente != null){
                     SalidaPorDefecto.consola("|    ");
                     siguiente = siguiente.getNodoDer();
                 }
                 siguiente = primero.getNodoVertical();
                 SalidaPorDefecto.consola("\n");
                 while (siguiente != null){
                     SalidaPorDefecto.consola(siguiente + " -> ");
                     siguiente = siguiente.getNodoDer();
                 }
                 SalidaPorDefecto.consola("null");
             }
         }
     }

    /**
     * Metodo que busca un elemento en la lista
     * @param objecto El bobjeto a buscar
     * @return El objeto si sae encuentra, null en caso contrario.
     */
     public Object buscar(Object objecto){
         NodoRectangular siguiente = primero;
         while (siguiente !=null){
             if(siguiente.getContenido().equals(objecto)){
                 return objecto;
             }
             if(siguiente.getNodoVertical() != null){
                 if(siguiente.getNodoVertical().getContenido().equals(objecto)){
                     return objecto;
                 }
             }
             siguiente = siguiente.getNodoDer();
         }
         return null;
     }

    /**
     * Metodo que elimina un elemento de la lista especificado por parametro.
     * @param objecto El objetro a eliminar
     * @return El valor eliminado, en caso de no eliminar nada null
     */
     public Object eliminar(Object objecto){
         NodoRectangular siguiente = primero;
         NodoRectangular anterior = primero;
         while (siguiente !=null){
             if(siguiente.getContenido().equals(objecto)){
                 if(siguiente == primero){
                     return eliminarInicio();
                 }
                 if(siguiente == ultimo){
                     return eliminarFinal();
                 }
                 NodoRectangular temporal = siguiente.getNodoDer();
                 anterior.setNodoDer(siguiente.getNodoDer());
                 anterior.setNodoDer(anterior.getNodoVertical().getNodoDer());
                 anterior.getNodoVertical().setNodoDer(temporal);
                 temporal.setNodoVertical(anterior.getNodoDer());
                 anterior.getNodoDer().setNodoVertical(temporal);
                 return objecto;
             }
             if(siguiente.getNodoVertical() != null){
                 NodoRectangular arriba = siguiente;
                 if(siguiente.getNodoVertical().getContenido().equals(objecto)){
                     siguiente = siguiente.getNodoVertical();
                     anterior = anterior.getNodoVertical();
                     NodoRectangular temporal = arriba.getNodoDer();
                     if(primero.getNodoVertical().equals(siguiente)){
                         arriba.setNodoDer(siguiente.getNodoDer());
                         arriba.setNodoVertical(temporal);
                     }else{
                         siguiente.setNodoVertical(siguiente.getNodoDer());
                         anterior.setNodoDer(temporal);
                         anterior.setNodoVertical(siguiente.getNodoVertical());
                         siguiente.setNodoVertical(anterior.getNodoDer());
                         arriba.setNodoDer(siguiente.getNodoDer());
                     }


                 }
             }

             anterior = siguiente;
             siguiente = siguiente.getNodoDer();
         }
         return null;
     }
/*


 */
}
