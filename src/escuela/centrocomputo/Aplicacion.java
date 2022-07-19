package escuela.centrocomputo;

public class Aplicacion {
    String nombre;
    String logo;
    String autores;
    int version;
    int ramMinima;

    public Aplicacion(String nombre, String logo, String autores, int version, int ramMinima) {
        this.nombre = nombre;
        this.logo = logo;
        this.autores = autores;
        this.version = version;
        this.ramMinima = ramMinima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRamMinima() {
        return ramMinima;
    }

    public void setRamMinima(int ramMinima) {
        this.ramMinima = ramMinima;
    }

    public String toString(){
        return nombre;
    }
}
