package menus.menusPaginasWeb.RedSocial;

import entradasalida.EntradaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;

/**
 * Pagina que maneja la pagina de una red social
 */
public class MenuRedSocial {

    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    public static void menuInicio(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/MenuPrincipal.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(1);
                menuPerfiles(paginas);
                break;
            case 2:
                paginas.poner(1);
                menuAmigos(paginas);
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
    private static void  menuPerfiles(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/Perfil.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                paginas.poner(2);
                menuFoto(paginas);
                break;
            case 2:
                paginas.poner(2);
                menuDescripcion(paginas);
                break;
            case 3:
                paginas.poner(2);
                menuPublicaciones(paginas);
                break;
            case 4:
                volver(paginas);
                break;
            case 5:
                paginas.poner(2);
                menuInicio(paginas);
            default:
                break;
        }
    }
    /**
     * Metodo que imprime la pagina en cuestion y manda/regresa otra pagina especificada ya sea por el menu propio o la pila.
     * @param paginas Pila con los indices de la pagina
     */
    private static void menuFoto(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/Foto.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int) opcion){
            case 1:
                volver(paginas);
                break;
            case 2:
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
    private static void menuAmigos(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/Amigos.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int)opcion){
            case 1:
                paginas.poner(3);
                menuPerfiles(paginas);
                break;
            case 2:
                volver(paginas);
                break;
            case 3:
                paginas.poner(3);
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
    private static void menuPublicaciones(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/publicaciones.txt");
        double opcion = EntradaPorDefecto.consolaDouble();
        switch ((int)opcion){
            case 1:
                volver(paginas);
                break;
            case 2:
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
    private static void menuDescripcion(PilaEstatica paginas){
        imprimirPagina("estructuras/src/menus/menusPaginasWeb/RedSocial/descripcion.txt");
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
    private static void imprimirPagina(String ruta){
        ListaEstatica pagina =ArchivoTexto.leer(ruta);
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
                    menuPerfiles(pilaEstatica);
                    break;
                case 3:
                    menuAmigos(pilaEstatica);
                    break;
                case 4:
                    menuFoto(pilaEstatica);
                    break;
                case 5:
                    menuPublicaciones(pilaEstatica);
                    break;
                case 6:
                    menuDescripcion(pilaEstatica);
                    break;
            }
        }
    }
}
