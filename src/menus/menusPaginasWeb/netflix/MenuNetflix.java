package menus.menusPaginasWeb.netflix;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Clase que maneja la "pagina" netflix.
 */
public class MenuNetflix {
    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    public static void menuInicio(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/netflix/MenuNetflix.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(1);
                menuTerror(paginas);
                break;
            case 2:
                paginas.poner(1);
                menuAccion(paginas);
                break;
            case 3:
                paginas.poner(1);
                MenuComedia(paginas);
                break;
            case 4:
                volver(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuTerror(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/netflix/MenuTerror.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(2);
                menuPeli(paginas);
                break;
            case 3:
                volver(paginas);
                break;
            case 4:
                paginas.poner(2);
                menuInicio(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuAccion(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/netflix/MenuAccion.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(3);
                menuPeli(paginas);
                break;
            case 3:
                volver(paginas);
                break;
            case 4:
                paginas.poner(3);
                menuInicio(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void MenuComedia(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/netflix/MenuComedia.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(4);
                menuPeli(paginas);
                break;
            case 3:
                volver(paginas);
                break;
            case 4:
                paginas.poner(4);
                menuInicio(paginas);
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuPeli(PilaEstatica paginas) {
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/netflix/menuPeli.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion) {
            case 1:
                volver(paginas);
                break;
            case 2:
                paginas.poner(5);
                menuInicio(paginas);
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
                    menuTerror(pilaEstatica);
                    break;
                case 3:
                    menuAccion(pilaEstatica);
                    break;
                case 4:
                    MenuComedia(pilaEstatica);
                    break;
                case 5:
                    menuPeli(pilaEstatica);
                    break;
            }
        }
    }

}
