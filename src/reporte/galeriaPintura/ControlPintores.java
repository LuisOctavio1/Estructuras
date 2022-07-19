package reporte.galeriaPintura;

import estructuraslineales.ListaEstatica;
import estructurasnolineales.Matriz3;

public class ControlPintores {
    protected Matriz3 listaPorDias;
    protected ListaEstatica pintores;
    protected ListaEstatica anios;
    protected ListaEstatica lugares;
    protected ListaEstatica eventos;


    public ControlPintores(int pintores, int anios, int lugares,int eventos ){
        listaPorDias = new Matriz3(anios,365*anios,pintores);
        this.pintores = new ListaEstatica(pintores);
        this.lugares = new ListaEstatica(lugares);
        this.eventos = new ListaEstatica(eventos);
        for(int fila=0; fila<listaPorDias.obtenerRenglones(); fila++){
            for(int columna=0;columna< listaPorDias.obtenerColumnas(); columna++){
                for(int prof=0;prof< listaPorDias.obtenerProfundidad();prof++){
                    listaPorDias.cambiar(fila,columna,prof,new ListaEstatica(5));
                }
            }
        }
    }

    public boolean agregerPintor(Pintor pintor){
        Integer posicionBusqueda=(Integer)pintores.buscar(pintor);
        if(posicionBusqueda==null){ //no existe, se puede agregar
            int retorno=pintores.agregar(pintor);
            if(retorno==-1){ //no pudo agregarlo
                return false;
            }else{ //si pudo
                return true;
            }
        }else{  //ya existe
            return false;
        }
    }

    public boolean agregarEvento(Exposicion evento,int anio){
        Integer posicionBusqueda=(Integer)eventos.buscar(evento);
        if(posicionBusqueda==null){ //si no existe
            int retorno=eventos.agregar(evento);
            if(retorno==-1){ // está llena
                return false;
            }else{ // hay espacio
                return true;
            }
        }else{//si ya existe
            return false;
        }
    }

    public boolean agregarLugar(Lugar lugar){
        Integer posicionBusqueda=(Integer)lugares.buscar(lugar);
        if(posicionBusqueda==null){ //si no existe
            int retorno=eventos.agregar(lugar);
            if(retorno==-1){ // está llena
                return false;
            }else{ // hay espacio
                return true;
            }
        }else{//si ya existe
            return false;
        }
    }

    public boolean agregarAnio(int anio){
        Integer posicionBusqueda=(Integer)anios.buscar(anio);
        if(posicionBusqueda==null){ //si no existe
            int retorno=eventos.agregar(anio);
            if(retorno==-1){ // está llena
                return false;
            }else{ // hay espacio
                return true;
            }
        }else{//si ya existe
            return false;
        }
    }

    public boolean agregarActividad(Pintor pintor,int dia, int anio,Object actividad){
        Integer profundidad = (Integer) pintores.buscar(pintor);
        Integer renglones = (Integer) anios.buscar(anio);
        if(profundidad != null && renglones != null && dia >=0 && dia <=364){
            if(actividad instanceof Exposicion || actividad instanceof Pintura || actividad instanceof FirmaAutografos
            || actividad instanceof Viaje|| actividad == "descanso"){
                ListaEstatica actividades = (ListaEstatica) listaPorDias.obtener(renglones,dia,profundidad);
                if(actividades.agregar(actividad) == -1){
                    return false;
                }else {
                    listaPorDias.cambiar(renglones,dia,profundidad,actividades);
                    return true;
                }
            }else {
                return false;
            }
        }else{
            return false;
        }
    }
/*
    public int actividadMasPopular(Pintor pintor){
        int pintar = 0;
        int exponer = 0;
        int viajar = 0;
        int descansar =0;
        int

    }


 */
}
