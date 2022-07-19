package estructuraslineales;

/**
 * Clase donde se manejaran las listas con numeros solamente
 */
public class ListaEstaticaNumerica extends ListaEstatica {

    /**
     * Constructor para la Lista
     *
     * @param maximo Tamnio maximo de la lista
     */
    public ListaEstaticaNumerica(int maximo) {
        super(maximo);
    }

    @Override
    /**
     * Primero comprueba que el objeto sea un Number, despues hace el metodo del padre.
     */
    public boolean cambiar(int indice, Object valor) {
        if (valor instanceof Number) {
            return super.cambiar(indice, valor);
        } else {
            return false;
        }
    }

    /**
     * Primero comprueba que las listas sean una ListaEstaticaNumerica, despues hace el metodo del padre
     * @param indicesBusqueda Los indices que deberan ser cambiados.
     * @param valoresNuevos Los nuevos valores que se ingresaran.
     * @return Lo que devuelve el metodo padre o false si no es instancia
     */
    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica valoresNuevos) {
        if (valoresNuevos instanceof ListaEstaticaNumerica) {
            return super.cambiarListaEstatica(indicesBusqueda, valoresNuevos);
        } else {
            return false;
        }
    }

    /**
     * Primero comprueba que el objeto sea un Number, despues hace el metodo del padre
     * @param valor Es el dato que se va a agregar en la lista.
     * @return Ultimo o -1si no hay espacio.
     */
    @Override
    public int agregar(Object valor) {
        if (valor instanceof Number) {
            return super.agregar(valor);
        } else {
            return -1;
        }
    }

    /**
     * Comprueba que el objeto sea instancia de Number, despues hace el metodo padre
     * @param valor El valor que queremos buscar.
     * @return false si no es instancia de Number, si lo es devuelve lo que le metodo padre
     */
    @Override
    public Object buscar(Object valor) {
        if (valor instanceof Number) {
            return super.buscar(valor);
        } else {
            return null;
        }
    }

    /**
     * Comprueba que el valor sea instancia de Number despues hace el metodo padre.
     * @param valor El objeto que queremos eliminar.
     * @return El valor eliminado.
     */
    @Override
    public Object eliminar(Object valor) {
        if (valor instanceof Number) {
            return super.eliminar(valor);
        } else {
            return null;
        }
    }

    /**
     * Comprueba que los valores sean instancia de Numvber, despues hace el metodo padre.
     * @param valorViejo El valor que queremos cambiar.
     * @param valorNuevo El valor al que queremos cambair.
     * @param numVeces La cantidad de veces que queremos buscar el valor que queremos cambiar.
     * @return
     */
    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        if (valorNuevo instanceof Number && valorViejo instanceof Number) {
            return super.cambiar(valorViejo, valorNuevo, numVeces);
        } else {
            return false;
        }
    }

    /**
     * Comprueba que los valores sean instancia de Numvber, despues hace el metodo padre.
     * @param valor El valor que deseamos buscar.
     * @return La lista con los indices
     */
    @Override
    public ListaEstatica buscarValores(Object valor) {
        if (valor instanceof Number) {
            return super.buscarValores(valor);
        } else {
            return null;
        }
    }

    /**
     * Comprueba que los valores sean instancia de Numvber, despues hace el metodo padre.
     * @param valor El valor con el que se colocara en la lista
     * @param cantidad La cantidad de veces que se colocara el valor.
     */
    @Override
    public void rellenar(Object valor, int cantidad) {
        if (valor instanceof Number) {
            super.rellenar(valor, cantidad);
        }
    }

    /**
     * Comprueba que los valores sean instancia de Numvber, despues hace el metodo padre.
     * @param valor
     */
    @Override
    public void rellenar(Object valor) {
        if (valor instanceof Number) {
            super.rellenar(valor);
        }
    }

    /**
     * Multiplica todo el arreglo por el escalar dado.
     * @param escalar El numero a multiplicar.
     * @return true si se pudo, false en caso contrario.
     */
    public boolean porEscalar(Number escalar) {
        if (!vacia()) {
            for (int indice = 0; indice < numeroElementos(); indice++) {
                datos[indice] = ((double) datos[indice]) * (Double) escalar;
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * Suma todo el arreglo por el escalar dado.
     * @param escalar El numero a sumar.
     * @return true si se puede, false si no.
     */
    public boolean sumarEscalar(Number escalar) {
        if (!vacia()) {
            for (int indice = 0; indice < numeroElementos(); indice++) {
                datos[indice] = ((double) datos[indice]) + (Double) escalar;
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * Suma el numero de la posicion correspondiente al arreglo en la posicion correspondiente.
     * @param lista2 La lista con los numeros a sumar.
     * @return true si se pudo, false si no.
     */
    public boolean sumar(ListaEstaticaNumerica lista2) {
        if (numeroElementos() == lista2.numeroElementos()) {
            for (int indce = 0; indce < numeroElementos(); indce++) {
                datos[indce] = (double) datos[indce] + (double) lista2.obtener(indce);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Suma el numero de la posicion correspondiente al arreglo en la posicion correspondiente.
     * @param lista2 La lista con los numeros a multiplicar.
     * @return true en caso de poder, false en caso contrario.
     */
    public boolean multiplicar(ListaEstaticaNumerica lista2) {
        if (numeroElementos() == lista2.numeroElementos()) {
            for (int indce = 0; indce < numeroElementos(); indce++) {
                datos[indce] = (double) datos[indce] * (double) lista2.obtener(indce);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Eleva todo el arreglo al numero indicado.
     * @param number El  numero al que se elevara nuestros numeros.
     * @return true en caso de que se puede, false en caso contrario
     */
    public boolean aplicarPotencia(Number number) {
        if (!vacia()) {
            for (int indce = 0; indce < numeroElementos(); indce++) {
                double potencia = (double) datos[indce];
                for (int comienzo = 1; comienzo < (double) number; comienzo++) {
                    potencia = potencia * (double) datos[indce];
                }
                datos[indce] = potencia;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Eleva al numero de la posicion correspondiente al arreglo en la posicion correspondiente.
     * @param lista2 La lista con los exponentes.
     * @return true si se pudo, false en caso contrario.
     */
    public boolean aplicarPotencia(ListaEstaticaNumerica lista2) {
        if (numeroElementos() == lista2.numeroElementos()) {
            for (int indce = 0; indce < numeroElementos(); indce++) {
                double potencia = (double) datos[indce];
                for (int comienzo = 1; comienzo < (double) lista2.obtener(indce); comienzo++) {
                    potencia = potencia * (double)datos[indce];
                }

                datos[indce] = potencia;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcula el producto escalar de nuestro arreglo y lista2.
     * @param lista2 La lista2 con la que se obtendra el producto.
     * @return El resultado del producto escalar.
     */
    public double productoEscalar(ListaEstaticaNumerica lista2) {
        double producto = 0;
        if (numeroElementos() == lista2.numeroElementos()) {
            for (int indice = 0; indice < numeroElementos(); indice++) {
                producto = ((double) datos[indice] * (double) lista2.obtener(indice)) + producto;
            }

        }
        return producto;
    }

    /**
     * Calcula la norma de nuestro arreglo.
     * @return El calculo de la norma.
     */
    public double norma() {
        double norma = 0;
        for (int indice = 0; indice < numeroElementos(); indice++) {
            norma = ((double) datos[indice] * (double) datos[indice]) + norma;
        }

        return Math.sqrt(norma);
    }

    /**
     * Calcula la norma euclidina que se obtiene con la norma de ab y sacando la raiz cuadrada.
     * @param arreglo2 El segundo vector con el que sacaremos la norma euclidiana
     * @return El valor de la norma Euclidiana.
     */
    public double normaEuclidiana(ListaEstaticaNumerica arreglo2) {
        double normaEuclidiana = 0;
        if (numeroElementos() == arreglo2.numeroElementos()) {
            for (int indice = 0; indice < numeroElementos(); indice++) {
                double productoResta = (double) arreglo2.obtener(indice) - (double) datos[indice];
                normaEuclidiana = (productoResta * productoResta) + normaEuclidiana;
            }
        }
        return normaEuclidiana;
    }

    /**
     * Metodo que calcula la suma de todos los elementos.
     * @return La suma.
     */
    public double sumarElementos() {
        double suma = 0;
        for (int indice = 0; indice < numeroElementos(); indice++) {
            suma = (double) datos[indice] + suma;
        }
        return suma;
    }

    /**
     * Calcula la suma del arreglo mas la suma de los arreglos.
     * @param listas La lista con los arreglos a sumar
     * @return El calculo total de la suma.
     */
    public double sumarListaEstatica(ListaEstatica listas) {
        double suma = 0;
        for (int indice = 0; indice < listas.numeroElementos(); indice++) {
            for (int posicion = 0; posicion < ((ListaEstaticaNumerica) listas.obtener(indice)).numeroElementos(); posicion++) {
                suma = (double) ((ListaEstaticaNumerica) listas.obtener(indice)).obtener(posicion) + suma;
            }
        }
        return suma + sumarElementos();
    }

    /**
     * Calcula la suma de la lista actual mas la lista dada.
     * @param escalares La lista a sumar.
     * @return La suma de los arreglos.
     */
    public double sumarEscalares(ListaEstaticaNumerica escalares) {
        return escalares.sumarElementos() + sumarElementos();
    }

    /**
     * Suma los indices indicados de nuestro arreglo.
     * @param listaInidces La lista con los indices a sumar.
     * @return La suma total.
     */
    public double sumarIndices(ListaEstaticaNumerica listaInidces) {
        double suma = 0;
        for (int indice = 0; indice < listaInidces.numeroElementos(); indice++) {
            if (indicesValidos((double) listaInidces.obtener(indice))) {
                suma = (double) datos[indice] + suma;
            }
        }
        return suma;
    }

    /**
     * Regresa una lista numerica con los indices indicados.
     * @param listaIndices La lista con los indices a agregar a la lista nueva.
     * @return La lista generado con los indices
     */
    public ListaEstaticaNumerica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstaticaNumerica subLista = new ListaEstaticaNumerica(listaIndices.numeroElementos());
        subLista = (ListaEstaticaNumerica) llenarSublista(listaIndices, subLista);
        return subLista;
    }

    /**
     * Metodo que calcula la suma de la multiplicacion de listas y la cantidad de ceros.
     * @param lista La lista con la que se haran las operaciones
     * @return Una lista con la suma en el primer indice y la cantidad de veces que fue cero la posicion de nuestro areglo.
     */
    public ListaEstaticaNumerica sumaYcantidadCeros(ListaEstaticaNumerica lista) {
        int cantidadCeros = 0;
        double suma = 0;
        for(int indice = 0; indice <numeroElementos(); indice++) {
            for (int posicion = 0; posicion < numeroElementos(); posicion++) {
                double valor = (double) (datos[posicion]) * (double) (lista.obtener(posicion));
                if ((double)datos[posicion] == 0) {
                    cantidadCeros++;
                }
                suma = valor + suma;
            }
        }
        ListaEstaticaNumerica sumaYceros = new ListaEstaticaNumerica(2);
        sumaYceros.agregar(suma);
        sumaYceros.agregar(cantidadCeros);
        return sumaYceros;
    }

    /**
     * Metodo que comprueba si ciertos arreglos son linealmente dependientes a nuestro arreglo.
     * @param listaVectores La lista con los vectores a comprobar.
     * @return true en caso de que todos sean linealmente dependeientes, false en caso contrario.
     */
    public boolean sonLinealmenteDependientes(ListaEstatica listaVectores){
        for(int indice = 0; indice <listaVectores.numeroElementos(); indice++){
            ListaEstaticaNumerica sumayCeros =  sumaYcantidadCeros((ListaEstaticaNumerica) listaVectores.obtener(indice));
            if((double)sumayCeros.obtener(0) == 0 && (int)sumayCeros.obtener(1) == numeroElementos()){
                return false;
            }
        }
        return true;
    }

    /**
     *Metodo que comprueba si ciertos arreglos son linealmente independientes a nuestro arreglo.
     * @param listaVectores La lista con los vectores a comprobar.
     * @return true en caso de que todos sean linealmente independientes, false en caso contrario.
     */
    public boolean sonLinealmenteIndependientes(ListaEstatica listaVectores){
        for(int indice = 0; indice <listaVectores.numeroElementos(); indice++){
            ListaEstaticaNumerica sumayCeros =  sumaYcantidadCeros((ListaEstaticaNumerica) listaVectores.obtener(indice));
            if((double)sumayCeros.obtener(0) == 0 && (int)sumayCeros.obtener(1) != numeroElementos()){
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si nuestro arreglo es ortogonal a la lista2.
     * @param lista2 La lista con la que comprobaremos si es ortogonal.
     * @return true en caso de que lo sea, false en caso contrario.
     */
    public boolean esOrtogonal(ListaEstaticaNumerica lista2){
        double productoEscalar = productoEscalar(lista2);
        if(productoEscalar == 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que comprueba si nuestro arreglo es ortonormal a la lista2.
     * @param lista2 La lista con la que comprobaremos si es ortonormal.
     * @return true en caso de que lo sea, false en caso contrario.
     */
    public boolean esOrtonormal(ListaEstaticaNumerica lista2){
        if(esOrtogonal(lista2)){
            if(norma() == 1 && lista2.norma() ==1){
                return true;
            }else {
                return true;
            }
        }
        return false;
    }
}
