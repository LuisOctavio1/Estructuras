package escuela.centrocomputo;

public class Alumno {
    int matricula;
    String nombre;

    public Alumno(int matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return "Matricula: " + matricula;
    }
}
