package escuela.centrocomputo;

import estructuraslineales.ListaDinamica;

public class CentroComputo {
    int id;
    String nombre;
    ListaDinamica computadoras;

    public CentroComputo(int id, String nombre){
        this.id = id;
        this.nombre= nombre;
        computadoras = new ListaDinamica();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaDinamica getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(ListaDinamica computadoras) {
        this.computadoras = computadoras;
    }

    public void agregarComputadora(Computadora computadora){
        computadoras.agregar(computadora);
    }

    public String toString(){
        return "ID: " + id;
    }
}
