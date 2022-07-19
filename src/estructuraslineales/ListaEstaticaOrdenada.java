package estructuraslineales;

import utiles.Comparaciones;
import utiles.TipoOrden;

/**
 * Clase donde se manejaran las listas ordenadas.
 */
public class ListaEstaticaOrdenada extends ListaEstatica{

    TipoOrden orden;
    /**
     * Constructor para la Lista
     *
     * @param maximo Tamnio maximo de la lista
     */
    public ListaEstaticaOrdenada(int maximo, TipoOrden orden) {
        super(maximo);
        this.orden = orden;
    }
    public ListaEstaticaOrdenada(int maximo) {
        super(maximo);
    }

    @Override
    public int agregar(Object valor) {
        if(!llena()){
            int posicion = (int)buscar(valor);
            if(posicion<0){
                posicion=posicion*-1;
                posicion=posicion-1;
                ultimo++;
                for (int movimiento=ultimo; movimiento >=posicion+1; movimiento--){
                    datos[movimiento]=datos[movimiento-1];
                }
                datos[posicion] = valor;
                return posicion;
            }else{
                return -1;
            }
        }else {
            return -1;
        }
    }

    public Object buscarIncremental(Object valor){
        int posicion =0;
        while(posicion <= ultimo && Comparaciones.compararMayor(valor,datos[posicion])) {
            posicion = posicion + 1;
        }

        if(posicion == 0){
            return posicion-1;
        }
        if (posicion > ultimo || Comparaciones.compararMenor(valor, datos[posicion])) {
            return (posicion+1)*-1;
        }else{
            return posicion;
        }
    }

    public Object buscarDecremental(Object valor){
        int posicion =0;
        while(posicion <= ultimo && Comparaciones.compararMenor(valor, datos[posicion]) ) {
            posicion = posicion + 1;
        }
        if(posicion == 0){
            return posicion-1;
        }
        if (posicion > ultimo || Comparaciones.compararMayor(valor,datos[posicion])) {
            return (posicion+1)*-1;
        }else{
            return posicion;
        }
    }



    @Override
    public Object buscar(Object valor) {
        if(orden.getValor() ==1){
            return buscarIncremental(valor);
        }else{
            return buscarDecremental(valor);
        }

    }

    @Override
    public boolean cambiar(int indice, Object valor) {
        eliminar(indice);
        int cambio = agregar(valor);
        if(cambio ==-1){
            return false;
        }
        return true;
    }

    @Override
    public Object eliminar(Object valor) {
        Integer posicion=(Integer) buscar(valor);
        if(posicion>0){ //si lo encontramos
            Object valorEliminado=datos[posicion];

            ultimo--;
            for(int movimiento=posicion;movimiento<=ultimo;movimiento++){
                datos[movimiento]=datos[movimiento+1];
            }
            return valorEliminado;
        }else{  //no lo encontramos
            return null;
        }
    }

    @Override
    public boolean esIgual(Object lista2) {
        return super.esIgual(lista2);
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        boolean cambio = false;
        if((Integer)(buscar(valorViejo)) != null){
            eliminar(valorViejo);
            agregar(valorNuevo);
            cambio=true;
        }

        return cambio;
    }

    @Override
    public ListaEstatica buscarValores(Object valor) {
        return super.buscarValores(valor);
    }

    @Override
    public Object eliminar() {
        return super.eliminar();
    }

    @Override
    public void vaciar() {
        super.vaciar();
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof ListaEstaticaOrdenada){
            for(int indice = 0; indice < ((ListaEstaticaOrdenada) lista2).numeroElementos(); indice++){
                agregar(((ListaEstaticaOrdenada) lista2).obtener(indice));
            }
        }
        return true;
    }

    @Override
    public void invertir() {
        super.invertir();
        if(orden.getValor() == 2){
            orden = TipoOrden.INC;
        }else{
            orden = TipoOrden.DEC;
        }
    }

    @Override
    public int contar(Object valor) {
        return super.contar(valor);
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        return super.eliminarLista(lista2);
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        super.rellenar(valor, cantidad);
    }

    @Override
    public Object clonar() {
        return super.clonar();
    }

    @Override
    public Object sublista(int indiceInicial, int indiceFinal) {
        return super.sublista(indiceInicial, indiceFinal);
    }

    @Override
    public void rellenar(Object valor) {
        if(valor instanceof Number){
            if(orden.getValor() ==1){
                rellenarNumerosCrecientes(valor);
            }else{
                rellenarNumerosDecrcientes(valor);
            }
        }else{
            String letra = (String) valor;
            if(letra.length() ==1){
                rellenarLetra(letra);
            }else{
                rellenarCadena(letra);
            }
        }
    }

    public void rellenarNumerosCrecientes(Object valor){
        int limite = (int)valor;
        if(limite<0){
            /*
            for(int indice = 0; indice <limite*(-1); indice++){
                eliminar(0);
            }

             */
            for(int indice = -1; indice >=limite; indice--){
                agregar(indice);
            }

        }else{
            /*
            for(int indice = 0; indice <limite; indice++){
                eliminar(0);
            }

             */
            for(int indice = 1; indice <=limite; indice++){
                agregar(indice);
            }
        }
    }
    public void rellenarNumerosDecrcientes(Object valor){
        int limite = (int)valor;
        int aux = ultimo;
        if(limite <0){
            /*
            for(int indice = ultimo; indice >aux-(limite*-1); indice--){
                eliminar(ultimo);
            }

             */
            for(int indice = -1; indice >=limite; indice--){
                System.out.println(indice + "xd");
                agregar(indice);
            }
        }else{
            /*
            for(int indice = ultimo; indice >aux-limite; indice--){
                eliminar(ultimo);
            }

             */
            for(int indice = 1; indice <=limite; indice++){
                agregar(indice);
            }
        }
    }

    public void rellenarLetra(String valor){
        char e = valor.charAt(0);
        for(int indice = e; indice >=65; indice--){
            agregar((char)indice);
        }
    }

    public void rellenarCadena(String valor){
        for(int indice = 0; indice < valor.length(); indice++){
            agregar(valor.charAt(indice));
        }
    }

    public ListaAlmacenamiento arregloDesordenado(){
        ListaEstatica lista = new ListaEstatica(numeroElementos());
        int elementos =0;
        boolean esta = false;
        int [] numeros = new int[numeroElementos()];
        while(elementos<numeroElementos()-1){
            int numero = (int) (Math.random() * numeroElementos() + 0);
            for (int indice:
                 numeros) {
                if(numero == indice){
                    esta = true;
                    break;
                }else{
                    esta = false;
                }
            }
            if(!esta)
            {
                lista.agregar(datos[numero]);
                elementos++;
                numeros[elementos] = numero;
            }
        }
        return lista;
    }

    @Override
    public boolean esSublista(ListaAlmacenamiento lista2) {
        if(lista2 instanceof ListaEstaticaOrdenada){
            Object valor = (((ListaEstaticaOrdenada) lista2).obtener(0));
            Integer comienzo = (Integer) buscar(valor);
            int indiceLista = 0;
            if(comienzo != null){
                for(int indice = comienzo; indice <=((ListaEstaticaOrdenada) lista2).numeroElementos(); indice++){
                    System.out.println(indice);
                    if(obtener(indice) != ((ListaEstaticaOrdenada) lista2).obtener(indiceLista)){
                        return false;
                    }else{
                        indiceLista++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cambiarLista(ListaAlmacenamiento lista2, ListaAlmacenamiento lista2Nuevos) {
        if(lista2 instanceof ListaEstaticaOrdenada && lista2Nuevos instanceof ListaEstaticaOrdenada){
            ListaEstaticaOrdenada lista = (ListaEstaticaOrdenada) lista2;
            ListaEstaticaOrdenada listaCambio = (ListaEstaticaOrdenada) lista2Nuevos;
            for(int posicion = 0; posicion < lista.numeroElementos(); posicion++){
                Integer indice = (Integer) buscar(lista.obtener(posicion));
                if(indice!= null){
                    cambiar(indice,listaCambio.obtener(posicion));
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean retenerLista(ListaAlmacenamiento lista2) {
        boolean valido = false;
        for(int indice = 0; indice <numeroElementos(); indice++){
            int encontrado = 0;
            for(int posicion =0; posicion < ((ListaEstatica) lista2).numeroElementos(); posicion++){
                if(obtener(indice) == ((ListaEstatica) lista2).obtener(posicion)){
                    encontrado = 1;
                }
            }
            if(encontrado !=1){
                eliminar(indice);
                indice--;
                valido = true;
            }
        }
        return valido;
    }

    @Override
    public boolean insertar(int indice, Object valor) {
        if(orden.getValor() ==1){
            return insetarMayor(indice,valor);
        }else{
            return insertarMenor(indice,valor);
        }
    }

    public boolean insetarMayor(int indice, Object valor){
        if(llena()){
            eliminar(ultimo);
        }

        if(Comparaciones.compararMenor(valor, obtener(indice)) && Comparaciones.compararMayor(valor,obtener(indice-1))){
            agregar(valor);
            return true;
        }else{
            return false;
        }
    }

    public boolean insertarMenor(int indice,Object valor){
        if(llena()){
            eliminar(ultimo);
        }
        if(Comparaciones.compararMenor(valor, obtener(indice-1)) && Comparaciones.compararMayor(valor,obtener(indice))){
            agregar(valor);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean copiarLista(ListaAlmacenamiento lista2) {
        if(lista2 instanceof ListaEstaticaOrdenada){
            if(((ListaEstaticaOrdenada) lista2).numeroElementos() <= maximo() && ((ListaEstaticaOrdenada) lista2).orden == orden){
                for( int indice = 0; indice < ((ListaEstatica) lista2).numeroElementos(); indice++){
                    datos[indice] = ((ListaEstatica) lista2).obtener(indice);
                }
                ultimo = ((ListaEstatica) lista2).numeroElementos()-1;
                return true;
            }
            return false;
        }
        return false;
    }


}
