package pruebas;

import SO.EjecucionSO;
import menus.menusimulaciones.MenuProgramasSO;

public class PruebaEjecucionSO {
    public static void main(String[] args) {
        EjecucionSO so = new EjecucionSO(5);
        MenuProgramasSO.imprimirAgregarObjeto(so.agregarPrograma("Word",2));
        MenuProgramasSO.imprimirAgregarObjeto(so.agregarPrograma("IntelliJ",5));
        MenuProgramasSO.imprimirAgregarObjeto(so.agregarPrograma("Valorant",7));
        MenuProgramasSO.imprimirProgramaTerminado(so.terminarEjecucion());
        MenuProgramasSO.imprimirAgregarObjeto(so.agregarPrograma("Overwtach",7));
        so.imprimirColaProgramas();
        MenuProgramasSO.imprimirProgramaTerminado(so.terminarEjecucion());
        MenuProgramasSO.imprimirProgramaTerminado(so.terminarEjecucion());
        so.imprimirColaProgramas();
        MenuProgramasSO.imprimirProgramaTerminado(so.terminarEjecucion());
        MenuProgramasSO.imprimirProgramaTerminado(so.terminarEjecucion());



    }
}
