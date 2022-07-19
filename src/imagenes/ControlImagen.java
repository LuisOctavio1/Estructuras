package imagenes;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz2Numerica;
import utiles.TipoTamano;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Clase con la que se modificaran imagenes
 */
public class ControlImagen {
    //código .......
    BufferedImage imagen;
    Matriz2 matriz2;
    BufferedImage imagen2;

    /**
     * Constructor que obtiene la imagen, hace una nueva imagen xon sus dimenciones y crea la matriz con los pixeles de nuestra imagen.
     */
    public ControlImagen(){
        try{
            imagen = ImageIO.read(new File("estructuras/src/imagenes/perroTimbre.jpg"));
            int w = imagen.getWidth();
            int h = imagen.getHeight();
            matriz2 = new Matriz2(h,w);
            imagen2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }catch (Exception e){
            System.out.println(e);
        }
        for(int fila =0; fila < matriz2.obtenerRenglones(); fila++){
            for(int col =0; col < matriz2.obtenerColumnas(); col++){
                int pixel = imagen.getRGB(col,fila);
                matriz2.cambiar(fila,col,pixel);
            }
        }
    }

    /**
     * Metodo para obtener el alpha de un pixel.
     * @param pixel El pixel en cuestion.
     * @return
     */
    public int obterAlpha(int pixel){
        int suma = 0;
        pixel = pixel >>24;
        return pixel;
    }

    /**
     * Metodo para obtener el rojo de un pixel.
     * @param pixel El pixel en cuestion.
     * @return
     */
    public int obterRed(int pixel){
        pixel = pixel <<8;
        pixel = pixel >>24;
        return pixel;
    }

    /**
     * Metodo para obtener el verde de un pixel.
     * @param pixel El pixel en cuestion.
     * @return
     */
    public int obterGreen(int pixel){
        pixel = pixel <<16;
        pixel = pixel >>24;
        return pixel;
    }

    /**
     * Metodo para obtener el azul de un pixel.
     * @param pixel El pixel en cuestion.
     * @return
     */
    public int obterBlue(int pixel){
        pixel = pixel <<24;
        pixel = pixel >>24;
        return pixel;
    }

    /**
     * Metodo que pasa a nuestra imagen a escala de grises.
     */
    public void escalaDeGrises(){
        try{
            for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                for (int col =0; col < matriz2.obtenerColumnas(); col++){
                    int a = obterAlpha((Integer) matriz2.obtener(fila,col));
                    int r = obterRed((Integer) matriz2.obtener(fila,col));
                    int g = obterGreen((Integer) matriz2.obtener(fila,col));
                    int b = obterBlue((Integer) matriz2.obtener(fila,col));
                    int promedio = (a+r+g+b)/4;
                    matriz2.cambiar(fila,col,16843009*promedio);
                    imagen2.setRGB(col, fila, 16843009*promedio);
                }
            }
            ImageIO.write(imagen2, "JPG", new File("estructuras/src/imagenes/perroGris.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo para modificar el brillo de nuestra imagen.
     * @param brillo El brillo a aumentar.
     */
    public void modificarBrillo(int brillo){
        try{
            for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                for (int col =0; col < matriz2.obtenerColumnas(); col++){
                    int pixel = imagen2.getRGB(col,fila);
                    imagen2.setRGB(col,fila,pixel+brillo);
                    System.out.println(imagen2.getRGB(col,fila));
                }
            }
        ImageIO.write(imagen2, "JPG", new File("estructuras/src/imagenes/perroGrisBrillo.jpg"));
    }catch (Exception e){
        System.err.println(e);
    }
    }

    /**
     * Metodo para invertir nuestra imagen horizobntalmente.
     */
    public void imageninvertiaHorizontal(){
        try{
            for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                int posicion = 0;
                for (int col = matriz2.obtenerColumnas()-1; col >= 0; col--){
                    int xd = (int) matriz2.obtener(fila,col);
                    imagen2.setRGB(posicion,fila,xd);
                    posicion++;
                }
            }
            ImageIO.write(imagen2, "JPG", new File("estructuras/src/imagenes/perroInvertidoHorizontal.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo para invertir nuestra imagen verticalmente.
     */
    public void imageninvertiaVertical(){
        try{
            for(int col = 0; col < matriz2.obtenerColumnas(); col++){
                int posicion = 0;
                for (int fila = matriz2.obtenerRenglones()-1; fila >= 0; fila--){
                    int xd = (int) matriz2.obtener(fila,col);
                    imagen2.setRGB(col,posicion,xd);
                    posicion++;
                }
            }
            ImageIO.write(imagen2, "JPG", new File("estructuras/src/imagenes/perroinvertidoVertical.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo para rotar 90 grados la imagen.
     */
    public void rotar90(){
        try{
            BufferedImage imagen3 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
            for(int col = 0; col < matriz2.obtenerColumnas(); col++){
                int posicion =0;
                for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                    imagen3.setRGB(matriz2.obtenerRenglones()-posicion-1,col, (Integer) matriz2.obtener(fila,col));
                    posicion++;
                }
            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroRotado90.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo para rotar 180 grados la imagen.
     */
    public void rotar180(){
        try{
            BufferedImage imagen3 = new BufferedImage(imagen.getWidth(),imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
            for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                for(int col = 0; col < matriz2.obtenerColumnas(); col++){
                    imagen3.setRGB(matriz2.obtenerColumnas()-col-1,matriz2.obtenerRenglones()-fila-1, (Integer) matriz2.obtener(fila,col));
                }
            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroRotado180.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo para rotar la imagen 270 grados.
     */
    public void rotar270(){
        try{
            BufferedImage imagen3 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
            for(int col = 0; col < matriz2.obtenerColumnas(); col++){
                int posicion =0;
                for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                    imagen3.setRGB(fila,col, (Integer) matriz2.obtener(fila,col));
                    posicion++;
                }
            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroRotado270.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo que obtiene la transpuesta de la imagen.
     */
    public void transpuesta(){
        try{
            matriz2.transpuesta();
            BufferedImage imagen3 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
            for(int fila =0 ; fila < matriz2.obtenerRenglones(); fila++){
                for(int col =0; col < matriz2.obtenerColumnas(); col++){
                    imagen3.setRGB(col,fila,(int)matriz2.obtener(fila,col));
                }
            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroRotadoTraspuesta.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo que cambia el tamano de la imagen
     * @param tipoTamano ENumerado con el nuevo tamano.
     */
    public void cambairTamano(TipoTamano tipoTamano){
        try{
            BufferedImage imagen3 = new BufferedImage((int) (imagen.getHeight()*tipoTamano.getValor()), (int) (imagen.getWidth()*tipoTamano.getValor()), BufferedImage.TYPE_INT_RGB);
            if(tipoTamano.getValor() >= 1){
                for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                    int posicion =0;
                    for(int col = 0 ; col < matriz2.obtenerColumnas(); col++){
                        imagen3.setRGB(col,fila, (Integer) matriz2.obtener(fila,col));
                    }
                }

            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroTamano.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }

    }

    /**
     * Metodo que genera un marco a nuestra imagen.
     * @param grosor El grosor del marco.
     * @param color El color del marco.
     */
    public void generarMarco(int grosor, Color color){
        try{
            BufferedImage imagen3 = new BufferedImage(imagen.getWidth()+grosor,imagen.getHeight()+grosor, BufferedImage.TYPE_INT_RGB);
            for(int fila = 0; fila < matriz2.obtenerRenglones()+grosor; fila++){
                for(int col = 0 ; col < matriz2.obtenerColumnas()+grosor; col++){
                    if(fila < grosor || fila > matriz2.obtenerRenglones()-1){
                        imagen3.setRGB(col,fila,color.getRGB());
                    }else{
                        if(col < grosor || col > matriz2.obtenerColumnas()){
                            imagen3.setRGB(col,fila,color.getRGB());
                        }else{
                            imagen3.setRGB(col,fila, (int) matriz2.obtener(fila-grosor,col-grosor));
                        }
                    }
                }
            }
            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroConMarco.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Metodo que hace un efecto especial a la mitad de nuestra imagen
     */
    public void mitadDisociada(){
        try {
            BufferedImage imagen3 = new BufferedImage(imagen.getWidth(),imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
            for(int fila = 0; fila < matriz2.obtenerRenglones(); fila++){
                int posicion =0;
                for(int col =0; col < matriz2.obtenerColumnas();col++){
                    if(col < ((matriz2.obtenerColumnas())/2) ){
                        imagen3.setRGB(col,fila, (int) matriz2.obtener(fila,col));
                    }else{
                        imagen3.setRGB(col,fila, (Integer) matriz2.obtener(fila,col-posicion));
                        posicion++;
                    }
                }
            }

            ImageIO.write(imagen3,"JPG",new File("estructuras/src/imagenes/perroMitadDisociada.jpg"));
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
