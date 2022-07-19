package escuela.centrocomputo;

import estructuraslineales.ListaDinamica;
import estructuraslineales.ListaEstatica;

public class Computadora {
    int numComputadora;
    CentroComputo centroComputo;
    int ram;
    int discoDuro;
    String porcesador;
    String marca;
    ListaDinamica aplicaciones;
    ListaDinamica usos;

    public Computadora(int numComputadora, CentroComputo centroComputo, int ram, int discoDuro, String porcesador, String marca, ListaDinamica aplicaciones) {
        this.numComputadora = numComputadora;
        this.centroComputo = centroComputo;
        this.ram = ram;
        this.discoDuro = discoDuro;
        this.porcesador = porcesador;
        this.marca = marca;
        this.aplicaciones = aplicaciones;
    }

    public CentroComputo getCentroComputo() {
        return centroComputo;
    }

    public int getNumComputadora() {
        return numComputadora;
    }

    public void setCentroComputo(CentroComputo centroComputo) {
        this.centroComputo = centroComputo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getPorcesador() {
        return porcesador;
    }

    public void setPorcesador(String porcesador) {
        this.porcesador = porcesador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ListaDinamica getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(ListaDinamica aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public void agregarUso(Alumno alumno, int dia, String horaInicio,String horaFinal, ListaDinamica aplicacionesUsadas){
        ListaEstatica uso = new ListaEstatica(5);
        usos.agregar(alumno);
        usos.agregar(dia);
        usos.agregar(horaInicio);
        usos.agregar(horaFinal);
        usos.agregar(aplicacionesUsadas);
        usos.agregar(uso);
    }

    public String toString(){
        return "ID: " + numComputadora;
    }
}
