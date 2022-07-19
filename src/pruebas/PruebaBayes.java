package pruebas;

import herramientas.generales.ListaValidaciones;
import herramientas.matematicas.RedesBayesianas;
import menus.MenuRedesBayesianas;

public class PruebaBayes {
    public static void main(String[] args) {
        RedesBayesianas redes = new RedesBayesianas(7);
        redes.agregarNodo("Fuma");
        redes.agregarNodo("Cancer");
        redes.agregarNodo("Bronquitis");
        redes.agregarNodo("Tuberculosis");
        redes.agregarNodo("Dolor de pecho");
        redes.agregarNodo("Disnea");
        redes.agregarNodo("Escalofrios");
        redes.agregarRelacion("Fuma","Cancer");
        redes.agregarRelacion("Fuma","Bronquitis");
        redes.agregarRelacion("Cancer","Dolor de pecho");
        redes.agregarRelacion("Cancer","Disnea");
        redes.agregarRelacion("Bronquitis","Disnea");
        redes.agregarRelacion("Bronquitis","Dolor de pecho");
        redes.agregarRelacion("Tuberculosis","Disnea");
        redes.agregarRelacion("Tuberculosis","Escalofrios");
        redes.generarLista("Fuma");
        redes.generarLista("Cancer");
        redes.generarLista("Bronquitis");
        redes.generarLista("Tuberculosis");
        redes.generarLista("Dolor de pecho");
        redes.generarLista("Disnea");
        redes.generarLista("Escalofrios");
        redes.agregarProbabilidad("Fuma",.20,new ListaValidaciones(true).getValidaciones());
        redes.agregarProbabilidad("Cancer",.80,new ListaValidaciones(true).getValidaciones());
        redes.agregarProbabilidad("Bronquitis",.60,new ListaValidaciones(true).getValidaciones());
        redes.agregarProbabilidad("Tuberculosis",.35,new ListaValidaciones(true).getValidaciones());
        redes.agregarProbabilidad("Escalofrios",.8,new ListaValidaciones(true).getValidaciones());
        redes.agregarProbabilidad("Dolor de pecho",.9,new ListaValidaciones(true,true).getValidaciones());
        redes.agregarProbabilidad("Dolor de pecho",.7,new ListaValidaciones(true,false).getValidaciones());
        redes.agregarProbabilidad("Dolor de pecho",.6,new ListaValidaciones(false,true).getValidaciones());
        redes.agregarProbabilidad("Dolor de pecho",.3,new ListaValidaciones(false,false).getValidaciones());
        redes.agregarProbabilidad("Disnea",.95,new ListaValidaciones(true,true,true).getValidaciones());
        redes.agregarProbabilidad("Disnea",.80,new ListaValidaciones(true,false,true).getValidaciones());
        redes.agregarProbabilidad("Disnea",.70,new ListaValidaciones(false,true,true).getValidaciones());
        redes.agregarProbabilidad("Disnea",.35,new ListaValidaciones(false,false,true).getValidaciones());
        redes.agregarProbabilidad("Disnea",.85,new ListaValidaciones(true,true,false).getValidaciones());
        redes.agregarProbabilidad("Disnea",.75,new ListaValidaciones(true,false,false).getValidaciones());
        redes.agregarProbabilidad("Disnea",.30,new ListaValidaciones(false,true,false).getValidaciones());
        redes.agregarProbabilidad("Disnea",.1,new ListaValidaciones(false,false,false).getValidaciones());
        MenuRedesBayesianas.seleccionarOpcion(redes);
    }
}
