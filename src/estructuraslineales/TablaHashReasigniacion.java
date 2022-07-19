package estructuraslineales;

import herramientas.generales.Utilerias;
/**
 * Clase que maneja las tablas hash con reasignacion.
 */
public class TablaHashReasigniacion implements InterfazHash{
    int maximo;
    ListaEstatica arreglo;

    /**
     * Constructor de la tabla.
     * @param maximo El maximo numerod e elemntos.
     */
    public TablaHashReasigniacion(int maximo){
        this.maximo = maximo;
        arreglo = new ListaEstatica(maximo);
        for(int indice = 0; indice < maximo; indice++){
            arreglo.agregar(null);
        }
    }
    /**
     * Metodo que inserta un valor a nuestra tabla hash.
     * @param valor El objeto a ingresar.
     * @return true si se pudo agregar, false en caso contrario.
     */
    @Override
    public boolean insertar(Object valor) {
        int j = 0;
        int clave = Utilerias.obtenerClave(valor);
        while (j !=maximo){
            int i = hash(clave,j);
            if(arreglo.obtener(i) == null){
                arreglo.insertar(i,valor);
                return true;
            }
            j++;
        }
        return false;
    }

    /**
     * Metodo que busca un elemento en nuestras tabla.
     * @param valor EL valor a buscar.
     * @return El objeto que se encontro, en caso de que no null.
     */
    @Override
    public Object buscar(Object valor) {
        int j = 0;
        int clave = Utilerias.obtenerClave(valor);
        int i = 0;
        while (j != maximo){
            i = hash(clave,j);
            if(arreglo.obtener(i) != null){
                if(arreglo.obtener(i) == valor){
                    return arreglo.obtener(i);
                }
            }
            j++;
        }
        return null;
    }

    public Integer buscarIndice(Object valor) {
        int j = 0;
        int clave = Utilerias.obtenerClave(valor);
        int i = 0;
        while (j != maximo){
            i = hash(clave,j);
            if(arreglo.obtener(i) != null){
                if(arreglo.obtener(i) == valor){
                    return i;
                }
            }
            j++;
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
        Integer indice = buscarIndice(valor);
        if(indice != null){
            arreglo.insertarValor(indice,null);
            return valor;
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
     * Metodo auxiliar para evitar coaliciones, este es de tipo prueba lineal/
     * @param clave La clave de nuestro objeto/
     * @param iteracion El numero de iteracion en donde vamos.
     * @return La posicion donde deberia ir.
     */
    private int hash(int clave, int iteracion){
        return (hash(clave) + iteracion) % maximo;
    }

    /**
     * Metodo que imprime la tabla hash/
     */
    public void imprimir(){
        arreglo.imprimir();
    }
}
