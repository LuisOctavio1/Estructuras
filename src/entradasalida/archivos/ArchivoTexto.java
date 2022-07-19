package entradasalida.archivos;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.*;
import java.io.*;

public class ArchivoTexto {

    public static ListaEstatica leer(String archivo){
        FileReader input=null;
        int registro=0;
        ListaEstatica datos=null;
        BufferedReader buffer = null;

        try {
            String cadena=null;
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            datos=new ListaEstatica((int)buffer.lines().count());
            buffer.close();
            input.close();
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            while((cadena = buffer.readLine())!=null) {
                datos.agregar(cadena);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                input.close();
                buffer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }
    public static void escribir(ListaEstatica arreglo, String archivo){
        FileWriter output=null;
        try {
            output = new FileWriter(archivo);
            for(int posicion=0;posicion<arreglo.numeroElementos() -1 ;posicion++) {
                output.write((String)arreglo.obtener(posicion)+ "\n");
            }
            output.write((String)arreglo.obtener(arreglo.numeroElementos() - 1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void agregarConLista(String dato, String archivo){
        FileWriter output=null;
        try {
            output = new FileWriter(archivo,true);
            output.write("\n"+dato);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void escribirListaDinamica(ListaDinamicaDoble arreglo, String archivo){
        FileWriter output=null;
        try {
            output = new FileWriter(archivo);
            arreglo.inicializarIteradorIzquierdo();
            output =  escribirLista(arreglo,output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private static  FileWriter escribirLista(ListaDinamicaDoble arreglo,FileWriter salida){
        try {
            if(!arreglo.hayNodosIzquierdo()){
                return salida;
            }else{
                salida.write(arreglo.obtenerNodo().toString() + "\n");
                return escribirLista(arreglo,salida);
            }
        }catch (IOException e){
            SalidaPorDefecto.consola(e + "");
        }
        return salida;
    }

    public static ListaDinamicaDoble leerListaDinamica(String archivo){
        FileReader input=null;
        ListaDinamicaDoble datos= new ListaDinamicaDoble();
        BufferedReader buffer = null;
        try {
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            buffer.close();
            input.close();
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            datos = leerDatos(buffer,datos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                input.close();
                buffer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }

    private static ListaDinamicaDoble leerDatos(BufferedReader buffer,ListaDinamicaDoble lista){
        try{
            String cadena =buffer.readLine();
            if( cadena== null){
                return lista;
            }else{
                lista.agregar(cadena);
                return leerDatos(buffer,lista);
            }
        }catch (Exception e){
            SalidaPorDefecto.consola(e + "");
        }

        return null;
    }
}
