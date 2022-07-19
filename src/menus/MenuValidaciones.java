package menus;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEstatica;
import estructuraslineales.PilaEstatica;
import herramientas.matematicas.ExpresionesAritmeticas;
import herramientas.validacion.ValidacionPogramas;

/**
 * Clase que maneja el menu para validar archivos o expreciones.
 */
public class MenuValidaciones {

    /**
     * Metodo que imprime el menu de las validaciones.
     */
    private static void imprimirMenu(){
        SalidaPorDefecto.consola("1. Verificar archivo java\n");
        SalidaPorDefecto.consola("2. Verificar expresion aritmetica\n");
        SalidaPorDefecto.consola("3. Salir\n");
    }

    /**
     * Metodo que pide la ruta del archivo.
     * @return La ruta dada por el usuario.
     */
    private static String pedirRutaArchivo(){
        SalidaPorDefecto.consola("Ingresa la ruta del archivo\n");
        return EntradaPorDefecto.consolaCadenas();
    }

    /**
     * Metodo que pide la expresion.
     * @return La expresion dada por el usuario.
     */
    private static String pedirExpresion(){
        SalidaPorDefecto.consola("Ingresa la expresion aritmetica\n");
        return EntradaPorDefecto.consolaCadenas();
    }

    /**
     * Metodo que imprime los resultados dados por la clase ValidacionProgramas de forma que sean legibles por el usuario.
     * @param ruta La ruta del archivo
     */
    private static void verificarArchivoJava(String ruta){
        ListaEstatica archivo = ArchivoTexto.leer(ruta);
        PilaEstatica revisado = ValidacionPogramas.validarPrograma(archivo);
        if (revisado.vacio()){
            SalidaPorDefecto.consola("No hay ningun error\n");
        }else{
            imprimirLineaErronea((ListaEstatica) revisado.quitar(),archivo);
        }
    }

    /**
     * Metodo que imprime de forma entendible por el usuario un error en el archivo
     * @param lista Lista con los indices y con los caracteres.
     * @param archivo La lista con las lineas del archivo.
     */
    private static void imprimirLineaErronea(ListaEstatica lista,ListaEstatica archivo){
        SalidaPorDefecto.consola("Linea " + lista.obtener(1) + "\n");
        SalidaPorDefecto.consola( archivo.obtener((int)lista.obtener(1)-1) + "\n");
        for(int indice = 0; indice < (int)lista.obtener(2); indice++){
            SalidaPorDefecto.consola(" ");
        }
        SalidaPorDefecto.consola("^ Falto cerrar " + lista.obtener(0) + "\n");
    }

    /**
     * Metodo que imprime de manera legible para el usuario si hay un error en la expresion o no.
     * @param expresion La expresion dada por el usuario.
     */
    private static void verificarExpresion(String expresion){
        PilaEstatica revisado = ExpresionesAritmeticas.validarExpresion(expresion);
        if(revisado.vacio()){
            SalidaPorDefecto.consola("No hay ningun error \n");
        }else{
            imprimirErrorAritmentico((ListaEstatica) revisado.quitar());
        }
    }

    /**
     * Metodo que imprime sai hay un error en la expresion.
     * @param lista La lista con los indices y el caracter.
     */
    private static void imprimirErrorAritmentico(ListaEstatica lista){
        for(int indice =0; indice < (int)lista.obtener(1); indice++){
            SalidaPorDefecto.consola(" ");
        }
        SalidaPorDefecto.consola("^ Falto cerrar " + lista.obtener(0) + "\n");
    }

    /**
     * Metodo que llamara la prueba que manejara el menu y todas las opciones
     */
    public static void manejarMenu(){
        double opcion =0;
        SalidaPorDefecto.consola("Bienvenido, elige la opcion que desees\n");
        do{
            imprimirMenu();
            opcion = EntradaPorDefecto.consolaDouble();
            switch ((int) opcion){
                case 1:
                    verificarArchivoJava(pedirRutaArchivo());
                    break;
                case 2:
                    verificarExpresion(pedirExpresion());
                    break;
                default:
                    break;
            }
        }while (opcion !=3);
    }
}
