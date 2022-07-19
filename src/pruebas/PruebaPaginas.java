package pruebas;

import estructuraslineales.PilaEstatica;
import menus.menusPaginasWeb.Anime.MenuAnime;
import menus.menusPaginasWeb.PaginaCompra.MenuCompra;
import menus.menusPaginasWeb.RedSocial.MenuRedSocial;
import menus.menusPaginasWeb.Youtube.MenuYoutube;
import menus.menusPaginasWeb.netflix.MenuNetflix;

public class PruebaPaginas {
    public static void main(String[] args) {
        PilaEstatica pila = new PilaEstatica(100);
        MenuRedSocial.menuInicio(pila);
        //MenuCompra.menuInicio(pila);
        //MenuYoutube.menuInicio(pila);
        //MenuNetflix.menuInicio(pila);
        //MenuAnime.menuInicio(pila);
    }
}
