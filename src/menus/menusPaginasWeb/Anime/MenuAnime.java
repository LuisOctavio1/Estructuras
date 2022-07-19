package menus.menusPaginasWeb.Anime;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Clase que maneja el menu de la pagina de anime
 */
public class MenuAnime {
    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    public static void menuInicio(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Anime/MenuGeneros.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(1);
                menuShounen(paginas);
                break;
            case 2:
                paginas.poner(1);
                menuSeinen(paginas);
                break;
            case 3:
                paginas.poner(1);
                menuClasiscos(paginas);
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
    private static void menuShounen(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Anime/MenoShounen.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(2);
                menuVideo(paginas);
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
    private static void menuSeinen(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Anime/MenuSeine.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(3);
                menuVideo(paginas);
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
    private static void menuClasiscos(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Anime/MenuClasicos.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
            case 2:
                paginas.poner(4);
                menuVideo(paginas);
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
    private static void menuVideo(PilaEstatica paginas) {
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/Anime/menuAnime.txt");
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
                    menuShounen(pilaEstatica);
                    break;
                case 3:
                    menuSeinen(pilaEstatica);
                    break;
                case 4:
                    menuClasiscos(pilaEstatica);
                    break;
                case 5:
                    menuVideo(pilaEstatica);
                    break;
            }
        }
    }
}
