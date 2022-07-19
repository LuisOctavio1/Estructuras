package reporte.galeriaPintura;

public class Pintor {
    protected String nombre;
    protected String fechaNaciemiento;
    protected String domicilio;
    protected String RFC;
    protected String nivelEducativo;

    public Pintor(String nombre, String fechaNaciemiento, String domicilio, String RFC, String nivelEducativo) {
        this.nombre = nombre;
        this.fechaNaciemiento = fechaNaciemiento;
        this.domicilio = domicilio;
        this.RFC = RFC;
        this.nivelEducativo = nivelEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    @Override
    public String toString() {
        return RFC;
    }
}
