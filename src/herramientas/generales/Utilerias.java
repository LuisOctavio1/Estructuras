package herramientas.generales;

import estructuraslineales.ListaDinamicaDoble;
import estructuraslineales.auxiliares.NodoBusquedaArbol;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Utilerias {
    public static int compararObjetos(Object objeto1, Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof Number){ //numéricos
            Double numero1=Double.parseDouble(objeto1.toString());
            Double numero2=Double.parseDouble(objeto2.toString());
            //Number numero1Number=(Number)objeto1;
            //double numero1=numero1Number.doubleValue();

            if(numero1.doubleValue()>numero2.doubleValue()){
                return 1;
            }else if(numero1.doubleValue()<numero2.doubleValue()){
                return -1;
            }else{
                return 0;
            }
        }else{ //no numéricos: Personba, Alumno, Mueble, Casa...
            // regresa valores mayores a cero si el objeto1 es mayor a objeto2
            //si objeto1 es menor que objeto2  regresa valores menores acero
            //si objeto1 es igual a objeto2 regresa 0
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());
        }
    }

    public static ListaDinamicaDoble obtenerPosicion(String nombreArchivo) {
        boolean finArchivo = false;
        RandomAccessFile archivo = null;
        ListaDinamicaDoble listaDatos = new ListaDinamicaDoble();
        try {
            archivo = new RandomAccessFile(nombreArchivo, "r");
            System.out.println("El tamaño es: " + archivo.length());
            String cad="";

            while(true) {
                System.out.print("Pos: "+archivo.getFilePointer());
                cad = archivo.readLine();
                if (cad==null)
                    break;
                NodoBusquedaArbol nodo = new NodoBusquedaArbol(cad,archivo.getFilePointer());
                listaDatos.agregar(nodo);
                System.out.println(" - " +cad);
            }
        }catch (IOException fe) {
            System.out.println("No se encontro el archivo");
        }
        try{
            System.out.println("\n");
            archivo.seek(9071);
            System.out.println(archivo.readLine());
            System.out.println("\n");
            archivo.close();
        }catch (IOException fe){
            System.out.println("No se encontro el archivo");
        }
        return listaDatos;
    }

    public static int obtenerClave(Object valor) {
        if(valor instanceof Number){
            return Integer.parseInt(valor.toString());
        }else{
            int clave = 0;
            for(int indice = 0; indice < valor.toString().length(); indice++){
                clave = clave + valor.toString().charAt(indice);
            }
            return clave;
        }
    }

}
