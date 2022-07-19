package menus.menusPaginasWeb.Youtube;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Clase que maneja la "pagina" de youtube.
 */
public class MenuYoutube {
    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    public static void menuInicio(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/MenuPrincipal.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(1);
                menuCanal(paginas);
                break;
            case 2:
                paginas.poner(1);
                menuSuscripciones(paginas);
                break;
            case 3:
                paginas.poner(1);
                menuRecomendados(paginas);
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
    private static void  menuCanal(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/Canal.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(2);
                menuVideo(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(2);
                menuInicio(paginas);
                break;
            default:
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuRecomendados(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/Recomendados.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(3);
                menuVideo(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(3);
                menuInicio(paginas);
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuSuscripciones(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/Suscripciones.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int)opcion){
            case 1:
                paginas.poner(4);
                menuSuscripcion(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(4);
                menuInicio(paginas);
                break;
            default:
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuSuscripcion(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/Suscripcion.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int)opcion){
            case 1:
                paginas.poner(5);
                menuVideo(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(5);
                menuInicio(paginas);
                break;
            default:
                break;
        }
    }

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuVideo(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Youtube/video.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                volver(paginas);
                break;
            case 2:
                paginas.poner(6);
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
                    menuCanal(pilaEstatica);
                    break;
                case 3:
                    menuRecomendados(pilaEstatica);
                    break;
                case 4:
                    menuSuscripciones(pilaEstatica);
                    break;
                case 5:
                    menuSuscripcion(pilaEstatica);
                    break;
                case 6:
                    menuVideo(pilaEstatica);
                    break;
            }
        }
    }
}
