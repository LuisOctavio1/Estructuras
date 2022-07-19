package reporte.galeriaPintura;

import estructuraslineales.ColaEstatica;
import estructuraslineales.ListaEstatica;

public class Lugar {
    protected String nombre;
    protected ListaEstatica eventos;

    public Lugar(String nombre, int numAnios,int numEventos){
        this.nombre = nombre;
        eventos = new ListaEstatica(numAnios);
        for(int inicio = 0; inicio < numAnios; inicio++){
            eventos.agregar(new ColaEstatica(365));
        }
    }

}
