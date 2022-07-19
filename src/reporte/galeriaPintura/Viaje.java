package reporte.galeriaPintura;

public class Viaje {
    private String lugar;

    public Viaje(String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return lugar;
    }
}
