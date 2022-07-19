package escuela.centrocomputo;

import estructuraslineales.ListaDinamica;

public class Escuela {
    ListaDinamica alumnos;
    ListaDinamica centrosDeComputo;

    public Escuela() {
        alumnos = new ListaDinamica();
        centrosDeComputo = new ListaDinamica();
    }

    public ListaDinamica getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ListaDinamica alumnos) {
        this.alumnos = alumnos;
    }

    public ListaDinamica getCentrosDeComputo() {
        return centrosDeComputo;
    }

    public void setCentrosDeComputo(ListaDinamica centrosDeComputo) {
        this.centrosDeComputo = centrosDeComputo;
    }

    public void agregarAlumno(Alumno alumno){
        alumnos.agregar(alumno);
    }

    public void agregarCentroComputo(CentroComputo centroComputo){
        centrosDeComputo.agregar(centroComputo);
    }
}
