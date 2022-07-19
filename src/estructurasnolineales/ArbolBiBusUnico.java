package estructurasnolineales;

import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaDinamicaDoble;
import estructuraslineales.auxiliares.NodoBusquedaArbol;
import herramientas.generales.Utilerias;

public class ArbolBiBusUnico {
    String archivo;
    public ArbolBiBusUnico(String archivo){
        this.archivo = archivo;
       ListaDinamicaDoble datos = Utilerias.obtenerPosicion(archivo);
       datos.inicializarIteradorIzquierdo();
       while (datos.hayNodosIzquierdo()){
           agregarElemento((NodoBusquedaArbol) datos.obtenerNodo());
       }
    }

    ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

    private boolean agregarElemento(NodoBusquedaArbol nodo){
        if(arbol.buscar(nodo) == null){
            arbol.agregar(nodo);
            return true;
        }else{
            return false;
        }
    }

    public boolean agregar(Object valor){
        if(arbol.buscar(valor) == null){
            ArchivoTexto.agregarConLista(valor.toString(),archivo);
            ListaDinamicaDoble datos = Utilerias.obtenerPosicion(archivo);
            NodoBusquedaArbol nuevo = (NodoBusquedaArbol) datos.verUltimo();
            arbol.agregar(nuevo);
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminar(Object valor){
        NodoBusquedaArbol nuevo = new NodoBusquedaArbol(valor,"");
        arbol.eliminacionABB(nuevo);
         return true;
    }

    public void inordern(){
        arbol.inorden();
    }

    public void buscar(Object valor){
        NodoBusquedaArbol nodo = (NodoBusquedaArbol) arbol.buscar(valor);
    }
}
