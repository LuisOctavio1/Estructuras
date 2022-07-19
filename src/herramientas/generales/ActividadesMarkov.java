package herramientas.generales;

public class ActividadesMarkov {
    String nombre;
    double probabilidad;

    public ActividadesMarkov(String nombre, double probabilidad){
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
