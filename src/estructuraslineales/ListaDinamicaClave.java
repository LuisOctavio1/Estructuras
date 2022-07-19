package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliares.Nodo;
import estructuraslineales.auxiliares.NodoClave;
import estructurasnolineales.Matriz2;

/**
 * Clase que manejara las listas dinamicas con clave.
 */
public class ListaDinamicaClave {
    protected NodoClave primero;
    protected NodoClave ultimo;

    /**
     * Constructor que inicializa primero y ultimo.
     */
    public ListaDinamicaClave(){
        primero = null;
        ultimo = null;
    }

    /**
     * Metodo que agrega un valor con su respectiva clave.
     * @param clave La clave del contenido.
     * @param valor El valor real a agregar.
     * @return true si se pudo agregar, false en caso contrario.
     */
    public boolean agregar(Object clave, Object valor){
        NodoClave nuevoNodo=new NodoClave(valor,clave); //paso 1
        if(nuevoNodo!=null){
            if(vacia()){
                primero=nuevoNodo;
                ultimo=nuevoNodo;
                return true;
            }else{
                NodoClave temporal = primero;
                while (temporal!= null){
                    if(temporal.getClave().equals(clave)){
                        temporal.setContenido(valor);
                        return true;
                    }
                    temporal = temporal.getNodoDer();
                }
                ultimo.setNodoDer(nuevoNodo);
                ultimo = ultimo.getNodoDer();
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Metodo que elimina un elemento.
     * @param clave La clave del elemento que queremos eliminar.
     * @return El objeto eliminado, en caso de que no se haya encontrado el objeto con esa llave null
     */
    public Object eliminar(Object clave){
        if(!vacia()){
            NodoClave temporal = primero;
            NodoClave anterior = primero;
            Object contenidoEliminado = null;
            while (temporal!= null && !temporal.getClave().equals(clave)){
                anterior = temporal;
                temporal = temporal.getNodoDer();
            }
            if(temporal == null){
                return null;
            }else{
                NodoClave siguinete = temporal.getNodoDer();
                if(primero == ultimo){
                    contenidoEliminado = temporal.getContenido();
                    primero = null;
                    ultimo = null;
                }else if(temporal == primero){
                    contenidoEliminado = temporal.getContenido();
                    primero = siguinete;
                }else if(temporal == ultimo){
                    contenidoEliminado = temporal.getContenido();
                    ultimo = anterior;
                    ultimo.setNodoDer(null);
                }else{
                    contenidoEliminado = temporal.getContenido();
                    anterior.setNodoDer(siguinete);
                }
                return contenidoEliminado;
            }
        }
        return null;
    }

    /**
     * Metodo que indica si la lista esta vacia.
     * @return true si lo esta, false en caso contrario.
     */
    public boolean vacia(){
        return primero == null && ultimo == null;
    }

    /**
     * Metodo que busca un elemento mediante su clave.
     * @param clave La clave con la que buscaremos el elemento.
     * @return El contenido eliminado, en caso de que no se haya encontrado esa clave null.
     */
    public Object buscar(Object clave){
        if(!vacia()){
            NodoClave temporal = primero;
            while (temporal != null){
                if(temporal.getClave().equals(clave)){
                    return temporal.getContenido();
                }
                temporal = temporal.getNodoDer();
            }
            return null;
        }
        return null;
    }

    /**
     * Metodo que elimina el contenido buscandolo mediante su valor real.
     * @param valor El valor que buscaremos para eliminar.
     * @return El objeto eliminado, en caso de que no se haya eliminado nada null.
     */
    public Object eliminarContenido(Object valor){
        if(!vacia()){
            NodoClave buscado = primero;
            NodoClave anterior = primero;
            Object contenidoEliminado = null;
            while (buscado != null && !(buscado.getContenido() == valor)){
                anterior = buscado;
                buscado = buscado.getNodoDer();
            }
            if(buscado == null){
                return null;
            }else{
                NodoClave siguinete = buscado.getNodoDer();
                if(primero == ultimo){
                    contenidoEliminado = buscado.getContenido();
                    primero = null;
                    ultimo = null;
                }else if(buscado == primero){
                    contenidoEliminado = buscado.getContenido();
                    primero = siguinete;
                }else if(buscado == ultimo){
                    contenidoEliminado = buscado.getContenido();
                    ultimo = anterior;
                    ultimo.setNodoDer(null);
                }else{
                    contenidoEliminado = buscado.getContenido();
                    anterior.setNodoDer(siguinete);
                }
                return contenidoEliminado;
            }
        }
        return null;
    }

    /**
     * Metodo que busca un contenido.
     * @param valor El valor que buscamos.
     * @return El contenido encontrado, en caso de que no se encuentre null.
     */
    public Object buscarContenido(Object valor){
        if(!vacia()){
            NodoClave siguiente = primero;
            while (siguiente != null){
                if(siguiente.getContenido().equals(valor)){
                    return siguiente.getContenido();
                }
                siguiente = siguiente.getNodoDer();
            }
            return null;
        }
        return null;
    }

    /**
     * Metodo que cambie el contenido del elemento que tenga la llave dada.
     * @param clave La clave del elemento que modificaremos.
     * @param valor El valor nuevo que queremos darle.
     * @return true si se encontro, false en caso contrario.
     */
    public boolean cambiar(Object clave, Object valor){
        if(!vacia()){
            NodoClave siguiente = primero;
            while (siguiente != null){
                if(siguiente.getClave().equals(clave)){
                    siguiente.setContenido(valor);
                    return true;
                }
                siguiente = siguiente.getNodoDer();
            }
            return false;
        }
        return false;
    }

    /**
     * Metodo que cambia el valor dado por el valor nuevo.
     * @param valor El valor viejo a buscar.
     * @param valorNuevo El valor nuevo que se pondra.
     * @return true si se cambio, false en caso contrario.
     */
    public boolean cambiarValor(Object valor, Object valorNuevo){
        if(!vacia()){
            NodoClave siguiente = primero;
            while (siguiente !=null){
                if(siguiente.getContenido().equals(valor)){
                    siguiente.setContenido(valorNuevo);
                    return true;
                }
                siguiente = siguiente.getNodoDer();
            }
            return false;
        }
        return false;
    }

    /**
     * Metodo que imprime la lista con la clave y el contenido.
     */
    public void imprimir(){
        NodoClave iterador=primero; //paso inicial
        while(iterador!=null){
            Object contenido=iterador.getContenido(); //paso 1
            Object clave = iterador.getClave();
            SalidaPorDefecto.consola("Clave: " + clave + ", Contenido: " + contenido+" -> ");//paso 2
            iterador=iterador.getNodoDer();//paso 3
        }
        SalidaPorDefecto.consola("null\n");
    }

    /**
     * Metodo que imprime solamente la clave de los nodos.
     */
    public void imprimirClaves(){
        NodoClave iterador=primero; //paso inicial
        while(iterador!=null){
            Object contenido=iterador.getContenido(); //paso 1
            Object clave = iterador.getClave();
            SalidaPorDefecto.consola("Clave: " + clave + " -> ");//paso 2
            iterador=iterador.getNodoDer();//paso 3
        }
        SalidaPorDefecto.consola("null\n");
    }

    /**
     * Metodo que imprime solamente el contenido real de los nodos.
     */
    public void imprimirContenido(){
        NodoClave iterador=primero; //paso inicial
        while(iterador!=null){
            Object contenido=iterador.getContenido(); //paso 1
            Object clave = iterador.getClave();
            SalidaPorDefecto.consola("Contenido: " + contenido + " -> ");//paso 2
            iterador=iterador.getNodoDer();//paso 3
        }
        SalidaPorDefecto.consola("null\n");
    }

    /**
     * Metodo que convierte nuestra lista dinamica clave en dos listas estaticas, una con las claves y otra con los contenidos.
     * @return Una lista estatica con dos listas, la primera con las claves y la segunda con los contenidos.
     */
    public ListaEstatica aListasEstaticas(){
        ListaEstatica listaClavesContenido = new ListaEstatica(2);
        ListaEstatica claves = new ListaEstatica(1);
        ListaEstatica contenido = new ListaEstatica(1);
        if(!vacia()){
            NodoClave siguiente = primero;
            int numero = 0;
            while (siguiente != null){
                numero++;
                claves.redimensionar(numero);
                claves.agregar(siguiente.getClave());
                contenido.redimensionar(numero);
                contenido.agregar(siguiente.getContenido());
                siguiente = siguiente.getNodoDer();
            }
        }
        listaClavesContenido.agregar(claves);
        listaClavesContenido.agregar(contenido);
        return listaClavesContenido;
    }

    /**
     * Metodo que convierte nuestra lista dinamica clave a listas dinamicas.
     * @return Una lista dinamica con dos listas dinamicas, la primera contiene la claves y la segunda los contenidos.
     */
    public ListaDinamica aListasDinamicas(){
        ListaDinamica listaClavesContenido = new ListaDinamica();
        ListaDinamica claves = new ListaDinamica();
        ListaDinamica contenido = new ListaDinamica();
        if(!vacia()){
            NodoClave siguiente = primero;
            while (siguiente != null){
                claves.agregar(siguiente.getClave());
                contenido.agregar(siguiente.getContenido());
                siguiente = siguiente.getNodoDer();
            }
        }
        listaClavesContenido.agregar(claves);
        listaClavesContenido.agregar(contenido);
        return listaClavesContenido;
    }

    /**
     * Metodo que convierte la lista dinamica clave a una matriz 2d.
     * @return Una matriz en donde la primer columna es la clave y la segunda el contenido, el numero de renglones dependera del numero de elementos que tengamos en la lista.
     */
    public Matriz2 aMatriz2(){
        Matriz2 matriz2 = new Matriz2(numeroElementos(),2);
        NodoClave siguiente = primero;
        int posicion = 0;
        while (siguiente!= null){
            matriz2.cambiar(posicion,0,siguiente.getClave());
            matriz2.cambiar(posicion,1,siguiente.getContenido());
            posicion++;
            siguiente = siguiente.getNodoDer();
        }
        return matriz2;
    }

    /**
     * Metodo que cuenta el numero de elementos actuales.
     * @return El numero de elementos.
     */
    public int numeroElementos(){
        int numeroElementos = 0;
        NodoClave siguiente = primero;
        while (siguiente!= null){
            numeroElementos++;
            siguiente = siguiente.getNodoDer();
        }
        return numeroElementos;
    }

    /**
     * Metodo que obtiene un elemento mediante su clave.
     * @param clave La clave del elemento.
     * @return El contido asociado a la clave, en caso de no encontrarla se regresa null.
     */
    public Object obtener(Object clave){
        NodoClave siguiente = primero;
        while (siguiente!= null){
            if(siguiente.getClave().equals(clave)){
                return siguiente.getContenido();
            }
            siguiente = siguiente.getNodoDer();
        }
        return null;
    }

    /**
     * Metodo que agrega una lista dinamica clave a nuestra lista, en caso de que la clave este repetida se omitira ese elemento.
     * @param lista2 La lista clave que agregaremos.
     * @return true si hubo algun cambio, false en caso contrario.
     */
    public boolean agregarLista(ListaDinamicaClave lista2){
        NodoClave siguiente = lista2.primero;
        boolean cambio = false;
        while (siguiente != null){
            if(buscar(siguiente.getClave()) == null){
                agregar(siguiente.getClave(),siguiente.getContenido());
                cambio = true;
            }
            siguiente = siguiente.getNodoDer();
        }
        return cambio;
    }

    /**
     * Metodo que agrega las listas estaticas dadas a la lista dinamica clave actual, en caso de que la clave este repetida se omitira ese elemento..
     * @param arrgloClaves Lista estatica que contiene las claves.
     * @param arregloValores Lista estatica que contiene los valores de las claves.
     * @return true si se pudo agregar algo, false en caso contrario.
     */
    public boolean agregarListasEstaticas(ListaEstatica arrgloClaves, ListaEstatica arregloValores){
        boolean cambio = false;
        for(int indice = 0; indice < arrgloClaves.numeroElementos(); indice++){
            if(buscar(arrgloClaves.obtener(indice)) == null && indice < arregloValores.numeroElementos()){
                agregar(arrgloClaves.obtener(indice),arregloValores.obtener(indice));
                cambio = true;
            }
        }
        return cambio;
    }

    /**
     * Metodo que agrega las listas dinamicas dadas a la lista dinamica clave actual, en caso de que la clave este repetida se omitira ese elemento.
     * @param listaClaves Lista dinamica con las calves a agregar.
     * @param listaValores Lista dinamica con los contenidos a agregar.
     * @return true si hubo algun cambio, false en caso contrario.
     */
    public boolean agregarListasDinamicas(ListaDinamica listaClaves, ListaDinamica listaValores){
        boolean cambio = false;
        Nodo siguienteClave = listaClaves.primero;
        Nodo siguienteContenido = listaValores.primero;
        while (siguienteClave != null && siguienteContenido != null){
            if(buscar(siguienteClave.getContenido()) == null){
                agregar(siguienteClave.getContenido(),siguienteContenido.getContenido());
                cambio = true;
            }
            siguienteClave = siguienteClave.getNodoDer();
            siguienteContenido = siguienteContenido.getNodoDer();
        }
        return cambio;
    }

    /**
     * Metodo que agrega la matriz dada a la lista actual dada(tiene que tener dos columnas, la primera con la clave, la segunda con el contenido
     * , el numero de renglones es dependiendo del numero de elementos que se quiera agregar), en caso de que la clave este repetida se omitira ese elemento.
     * @param matriz La matriz con las claves y valores.
     * @return true si hubo algun cambio, false en caso contrario.
     */
    public boolean agregarMatriz2(Matriz2 matriz){
        boolean cambio = false;
        if(matriz.obtenerColumnas() == 2){
            for(int indice = 0; indice < matriz.obtenerRenglones(); indice++){
                if(buscar(matriz.obtener(indice,0)) == null ){
                    agregar(matriz.obtener(indice,0),matriz.obtener(indice,1));
                    cambio = true;
                }
            }
        }
        return cambio;
    }
}
