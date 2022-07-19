package estructuraslineales;

import entradasalida.SalidaPorDefecto;

/**
 * Clase que controla las colas de prioridad
 */
public class ColaEstaticaPrioridad {
    protected ListaEstatica datos;
    protected int MAXIMO;

    /**
     * Constructor de la cola
     * @param maximo El maximo de elementos de la cola
     */
    public ColaEstaticaPrioridad(int maximo){
        MAXIMO=maximo;
        datos=new ListaEstatica(maximo);
    }

    /**
     * Metodo que indica si la cola esta vacia
     * @return true en caso de que si, false en caso contrario
     */
    public boolean vacio(){
        if(datos.numeroElementos()==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que indica si la cola esta llena.
     * @return true en caso de que este llena, false en caso contrario.
     */
    public boolean lleno(){
        if((datos.llena())){
            return true;
        }else{
            return false;
        }
    }

    public boolean poner(Object valor,int prioridad){
        if(lleno()==false){ //hay espacio
            ListaEstatica objeto = crearObjetoPrioridad(valor,prioridad);
            datos.agregar(objeto);
            return true;
        }else{ //no hay espacio  b)
            return false;
        }
    }

    /**
     * Metodo que crea la lista estica que meteremos en la cola.
     * @param valor El valor que queremos meter.
     * @param prioridad La prioridad del objeto.
     * @return La lista estatica generada.
     */
    public ListaEstatica crearObjetoPrioridad(Object valor, int prioridad){
        ListaEstatica objeto = new ListaEstatica(2);
        objeto.agregar(valor);
        objeto.agregar(prioridad);
        return objeto;
    }

    /**
     * Metodo que quita el elemento de mayor prioridad de la cola.
     * @return El objeto eliminado, en caso de que no habia elementos se devuelve un null.
     */
    public Object quitar(){
        if(vacio()==false){
            int mayorPrioridad = (int)((ListaEstatica)datos.obtener(0)).obtener(1);
            int posicion =0;
            for(int indice =1; indice < datos.numeroElementos(); indice++){
                if(mayorPrioridad < (int)((ListaEstatica)datos.obtener(indice)).obtener(1)){
                    mayorPrioridad = (int)((ListaEstatica)datos.obtener(indice)).obtener(1);
                    posicion = indice;
                }
            }
            return ((ListaEstatica)datos.eliminar(posicion)).obtener(0);
        }else{
            return null;
        }
    }

    /**
     * Metodo que imprime los elementos de la cola en orden de prioridad.
     */
    public void imprimir(){
        ColaEstaticaPrioridad aux = new ColaEstaticaPrioridad(MAXIMO);
        aux.datos = (ListaEstatica) datos.clonar();
        for(int indice=0; indice < datos.numeroElementos(); indice++){
            SalidaPorDefecto.consola(aux.quitar()+"\n");
        }
    }

    /**
     * Metodo que permite ver el ultimo elemento de la cola.
     * @return
     */
    public Object verUltimo(){
        if(vacio()==false){
            return datos.verUltimo();
        }else{
            return null;
        }
    }
}
