package estructuraslineales;

public interface InterfazHash {

    public boolean insertar(Object valor);

    public Object buscar(Object valor);

    public Object eliminar(Object valor);

    public int hash(int clave);
}
