package menus.menusPaginasWeb.PaginaCompra;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Clase que controla la pagina de compras
 */
public class MenuCompra {

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    public static void menuInicio(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/PaginaCompra/MenuPrincipal.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(1);
                menuCarrito(paginas);
                break;
            case 2:
                paginas.poner(1);
                menuProductos(paginas);
                break;
            case 3:
                volver(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuCarrito(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/PaginaCompra/Carrito.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(2);
                menuCheckout(paginas);
                break;
            case 2:
                paginas.poner(2);
                menuInicio(paginas);
                break;
            case 3:
                volver(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuCheckout(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/PaginaCompra/Check out.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                volver(paginas);
                break;
            case 2:
                paginas.poner(3);
                menuInicio(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuProductos(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/PaginaCompra/Productos.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(4);
                menuCarrito(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(4);
                menuInicio(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la "pagina" especificada por la ruta
     * @param ruta La ruta del archivo
     */
    private static void imprimirPagina(String archivo){
        ListaEstatica pagina = ArchivoTexto.leer(archivo);
        pagina.imprimirOI();
    }

    /**
     * Metodo que maneja la peticion de volver, con la pila volvera a su correspondiente indice o si esta vacia acabara el programa.
     * @param pilaEstatica pila con los indices de las paginas.
     */
    private static void volver(PilaEstatica pilaEstatica){
        if(!pilaEstatica.vacio()){
            switch ((int)pilaEstatica.quitar()){
                case 1:
                    menuInicio(pilaEstatica);
                    break;
                case 2:
                    menuCarrito(pilaEstatica);
                    break;
                case 3:
                    menuCheckout(pilaEstatica);
                    break;
                case 4:
                    menuProductos(pilaEstatica);
                    break;

            }
        }
    }
}
