package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import herramientas.generales.Utilerias;

/**
 * Clase que maneja las tablas hash con listas dobles.
 */
public class TablaHashEncadenamiento implements InterfazHash{

    int maximo;
    ListaEstatica arreglo;

    /**
     * Constructor de la tabla.
     * @param maximo El maximo numerod e elemntos.
     */
    public TablaHashEncadenamiento(int maximo){
        this.maximo = maximo;
        arreglo = new ListaEstatica(maximo);
        for(int indice = 0; indice < maximo; indice++){
            arreglo.agregar(new ListaDinamicaDoble());
        }
    }

    /**
     * Metodo que inserta un valor a nuestra tabla hash.
     * @param valor El objeto a ingresar.
     * @return true si se pudo agregar, false en caso contrario.
     */
    @Override
    public boolean insertar(Object valor) {
        int clave = Utilerias.obtenerClave(valor);
        int i = hash(clave);
        if(((ListaDinamicaDoble) arreglo.obtener(i)).buscar(valor) == null){
            ((ListaDinamicaDoble) arreglo.obtener(i)).agregar(valor);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que busca un elemento en nuestras tabla.
     * @param valor EL valor a buscar.
     * @return El objeto que se encontro, en caso de que no null.
     */
    @Override
    public Object buscar(Object valor) {

        int clave = Utilerias.obtenerClave(valor);
        int i = hash(clave);
        if(arreglo.obtener(i) != null){
            ListaDinamicaDoble lista = (ListaDinamicaDoble) arreglo.obtener(i);
            return lista.buscar(valor);
        }
        return null;
    }

    /**
     * Metodo que elimina un valor de nuestra tabla.
     * @param valor El valor a eliminar.
     * @return El bojeto eliminado, en caso de que no se haya elimiando nada null.
     */
    @Override
    public Object eliminar(Object valor) {
        int clave = hash(Utilerias.obtenerClave(valor));
        if(buscar(valor) != null){
            ListaDinamicaDoble lista = (ListaDinamicaDoble) arreglo.obtener(clave);
            return lista.eliminar(valor);
        }
        return null;
    }

    /**
     * Funcion hash por modulo para nuestra tabla.
     * @param clave La clave de el objeto a ingresar.
     * @return La posicion donde deberia ser insertada.
     */
    public int hash(int clave) {
        return clave % maximo;
    }

    /**
     * Metodo que imprime nuestra tabla hash.
     */
    public void imprimir(){
        for(int indice = arreglo.numeroElementos()-1; indice >= 0; indice--){
            ListaDinamicaDoble lista = (ListaDinamicaDoble) arreglo.obtener(indice);
            if(lista.numeroElementos() != 0){
                lista.imprimir();
            }else{
                SalidaPorDefecto.consola("Null\n");
            }
        }
    }
}
