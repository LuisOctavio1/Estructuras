package reporte.galeriaPintura;

public class Exposicion {
    protected String nombre;
    protected Lugar lugar;
    protected int numPersonas;

    public Exposicion(String nombre, Lugar lugar,int numPersonas) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.numPersonas = numPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    @Override
    public String toString() {
        return "Exposicion: " + nombre + " lugar: " + lugar;
    }
}

