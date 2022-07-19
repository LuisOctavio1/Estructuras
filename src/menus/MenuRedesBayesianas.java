package menus;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEstatica;
import herramientas.matematicas.RedesBayesianas;

public class MenuRedesBayesianas {
    /**
     * Metodo que imprime el menuPrincipal
     */
    public static void imprimirMenu(){
        SalidaPorDefecto.consola("Bienbenido, selecciona la opcion que quieras hacer:\n" +
                "1. Probabilidad de un elemento\n" +
                "2. Probabilidad conjunta\n" +
                "3. Salir\n");
    }

    /**
     * Metod que imprime el menu para seleccionar un nodo
     */
    public static void imprimirMenuElemento(){
        SalidaPorDefecto.consola("Elige la opcion que deseas calcular(ingresa el numero)\n");
        SalidaPorDefecto.consola("1. Fuma\n");
        SalidaPorDefecto.consola("2. Cancer\n");
        SalidaPorDefecto.consola("3. Bronquitis\n");
        SalidaPorDefecto.consola("4. Tuberculosis\n");
        SalidaPorDefecto.consola("5. Dolor de pecho\n");
        SalidaPorDefecto.consola("6. Disnea\n");
        SalidaPorDefecto.consola("7. Escalofrios\n");

    }

    /**
     * Metodo que sirve para elegir una opcion
     * @return La opcion elegida por el usuario
     */
    public static double elegirOpcion(){
        return EntradaPorDefecto.consolaDouble();
    }

    /**
     * Metodo que sirve para seleccionar una opcion de las principales.
     * @param redes EL objeto que tiene las relaciones.
     */
    public static void seleccionarOpcion(RedesBayesianas redes) {
        double opcion = 1.0;
        while (opcion != 3){
            imprimirMenu();
            opcion = elegirOpcion();
            switch ((int) opcion) {
                case 1:
                    obtenerProbabilidad(redes);
                    break;
                case 2:
                    probabilidadConjunta(redes);
                    break;
            }
        }

    }

    /**
     * Metodo para pedir los nodos para probabilidad conjunta
     * @param redes El objeto redesBayesianas.
     */
    public static void probabilidadConjunta(RedesBayesianas redes){
        Double opcion = 1.0;
        ListaEstatica lista = new ListaEstatica(7);
        while (opcion== 1.0){
            String eleccion = obtenerNombre();
            if(lista.buscar(eleccion) == null){
                lista.agregar(eleccion);
            }
            SalidaPorDefecto.consola("Ingresa 1 si quieres agregar otro nodo, en caso contrario 2\n");
            opcion = EntradaPorDefecto.consolaDouble();
        }
        imprimirProbabilidad(redes.probabilidadConjunta(lista));
    }

    /**
     * Metodo para obtener la prbabilidad de un evento.
     * @param redes El objeto redesBayesianas.
     */
    public static void obtenerProbabilidad(RedesBayesianas redes){
        imprimirMenuElemento();
        double opcion = elegirOpcion();
        double probabilidad = -1.0;
        switch ((int) opcion){
            case 1:
                probabilidad =  redes.pedirValidaciones("Fuma");
                break;
            case 2:
                probabilidad = redes.pedirValidaciones("Cancer");
                break;
            case 3:
                probabilidad = redes.pedirValidaciones("Bronquitis");
                break;
            case 4:
                probabilidad = redes.pedirValidaciones("Tuberculosis");
                break;
            case 5:
                probabilidad =  redes.pedirValidaciones("Dolor de pecho");
                break;
            case 6:
                probabilidad = redes.pedirValidaciones("Disnea");
                break;
            case 7:
                probabilidad = redes.pedirValidaciones("Escalofrios");
                break;
        }
        imprimirProbabilidad(probabilidad);
    }

    /**
     * Metodo para obtener el nombre del nodo.
     * @return
     */
    public static String obtenerNombre(){
        imprimirMenuElemento();
        double opcion = elegirOpcion();
        switch ((int) opcion){
            case 1:
                return "Fuma";
            case 2:
                return "Cancer";
            case 3:
                return "Bronquitis";
            case 4:
                return "Tuberculosis";
            case 5:
                return "Dolor de pecho";
            case 6:
                return "Disnea";
            case 7:
                return "Escalofrios";
        }
        return "";
    }

    /**
     * Metodo que imprime la probabilidad
     * @param probabilidad La probabilidad dada.
     */
    public static void imprimirProbabilidad(double probabilidad){
        SalidaPorDefecto.consola("La probabilidad es: " + probabilidad + "\n");
    }


}
