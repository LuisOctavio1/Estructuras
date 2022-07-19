package reporte.galeriaPintura;

public class FirmaAutografos {
    protected String lugar;

    public FirmaAutografos(String lugar) {
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
        return "La firma de autografos fue en " + lugar;
    }
}
