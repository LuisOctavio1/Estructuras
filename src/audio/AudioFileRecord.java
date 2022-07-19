package audio;

import java.io.*;

import audio.wavfile.*;
import estructuraslineales.ListaEstaticaNumerica;

/**
 * Clase que maneja los audios, escribe y los lee.
 */
public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización
    private ListaEstaticaNumerica lista;
    private double volumen = 1.0;

    /**
     * Constructor de la clase
     * @param archivo El nombre del archivo
     */
    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
    }

    /**
     * Metodo que lee el audio y lo guarda en nuestro buffer.
     */
    public void leerAudio() {
        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new double[buffer.length];
            lista = new ListaEstaticaNumerica(buffer.length);

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.

            lista.guardarBuffer(buffer);

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     *Metodo que un nuevo audio que se encuetra en lista y que es copiado a buffer2.
     */
    public void EscribirAudio() {
        try {
            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta + "/_6" + nomArchivo);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal
            //lista.imprimir();
            leerListaADouble();

            wavFileW.writeFrames(buffer2, (int) numFrames);
            escribirBuffer2();
            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Metodo que copia el arreglo Object de lista  a buffer.
     */
    public void leerListaADouble(){
        Object []doubles = lista.leerArreglo();
        for(int indice = 0; indice <lista.numeroElementos(); indice++){
            buffer2[indice] = volumen *(double)doubles[indice];
        }

    }

    /**
     * Metodo que modifica el audio para aplicarle un filtro FIR.
     */
    public void preEnfasis(){
        for(int indice = 0; indice <buffer.length; indice++){
            lista.cambiar(indice,buffer[indice] +0.95*buffer[indice]);
        }
        EscribirAudio();
    }

    /**
     * Metodo que sube el volument de el auido en buffer2.
     * @param intensidad La intensidad que desea para el nuevo volumen.
     */
    public void subirVolumen(int intensidad){
        double cambio = comprobarVolumen(intensidad);
        if(cambio >volumen){
            volumen = cambio;
            lista.guardarBuffer(buffer2);
            EscribirAudio();
        }
        volumen = 1.0;
    }

    /**
     * Metodo que baja el volumen de el auido en buffer2.
     * @param intensidad La intensidad que desea para el nuevo volumen.
     */
    public void vajarVolumen(int intensidad){
        double cambio = comprobarVolumen(intensidad);
        if(cambio < volumen){
            volumen = volumen;
            lista.guardarBuffer(buffer2);
            escribirBuffer2();
            EscribirAudio();
        }
        volumen = 1.0;
    }

    /**
     * Metodo para comprobar el volumen a cambiar.
     * @param intensidad La intensidad nueva.
     * @return la intensidad a menos que sea menor a cer, en ese caso se regresa cero.
     */
    public double comprobarVolumen(int intensidad){
       if(intensidad <0){
            return 0.0;
        }else{
            return .01*intensidad;
        }
    }

    /**
     * Metodo que acelera la pista de audio.
     * @param velocidad La velocidad a la que quiere el nuevo audio.
     */
    public void acelerarPista(int velocidad){
        buffer2 = buffer;
        lista = new ListaEstaticaNumerica((((int) numFrames * numChannels)/velocidad));
        int veces = 1;
        double muestras = 0;
        for(int indice = 0; indice <(int) numFrames * numChannels; indice++){
            if(veces < velocidad){
                veces = veces+1;
                muestras = buffer[indice] +muestras;
            }else{
                veces = 1;
                lista.agregar(muestras/velocidad);
                muestras=0;
           }
        }
        long numFramesAux = numFrames;
        numFrames = numFrames/velocidad;
        long sampleRateAux = sampleRate;

        EscribirAudio();
        numFrames = numFramesAux;

    }

    /**
     * Metodo para decrementar el audio.
     * @param decremento El decremento a la que quiere reducir.
     */
    public void decrementarPista(int decremento){
        buffer2 = buffer;
        lista = new ListaEstaticaNumerica((((int) numFrames * numChannels)*decremento));
        for(int indice = 0; indice < buffer.length; indice++){
            lista.agregar(buffer2[indice]);
            for(int posicion =0; posicion <decremento; posicion++){
                if(indice+1 != buffer.length){
                    lista.agregar((buffer2[indice]+buffer2[indice+1])/2);
                    posicion++;
                }
            }
        }
        buffer2 = new double[lista.numeroElementos()];
        long numFramesAux = numFrames;
        numFrames =numFrames*decremento;
        EscribirAudio();
        numFrames = numFramesAux;
    }

    /**
     * Metodo para quitar las partes silenciosas de el audio.
     */
    public void eliminarSilencio(){
        lista = new ListaEstaticaNumerica(buffer.length);
        for(int indice = 0; indice < buffer.length; indice++){
            if(buffer[indice] != 0.0){
                lista.agregar(buffer[indice]);
            }
        }
        //lista.imprimir();
        System.out.println(lista.buscar(0.0));
        EscribirAudio();
    }

    /**
     * Metodo para invertir el audio.
     */
    public void inversionEjex(){
        lista = new ListaEstaticaNumerica(buffer.length);
        for(int indice = buffer.length-1; indice >0; indice--){
            lista.agregar(buffer[indice]);
        }
        EscribirAudio();
    }

    /**
     * Metodo para invertir las ondas de sonido en el eje y.
     */
    public void inversionEjey(){
        lista = new ListaEstaticaNumerica(buffer.length);
        for(int indice = 0; indice <buffer.length; indice++){
            lista.agregar(-1*buffer[indice]);
        }
        EscribirAudio();
    }

    /**
     * Metodo para obtener la enrgia de un audio.
     * @return La energia del audio.
     */
    public double obtenerEnergia(){
        lista.guardarBuffer(buffer);
        double suma = 0;
        for(int indice =0; indice <lista.numeroElementos(); indice++){
            suma = suma + ((double)lista.obtener(indice) * (double)lista.obtener(indice));
        }
        return suma;
    }

    /**
     * Escribe las primeras 200 muestras del buffer2
     */
    public void escribirBuffer2(){
        try
        {
            File archivo=new File("estructuras/src/audio/muestras.txt");
            FileWriter escribir=new FileWriter(archivo,true);
            for(int indece =0; indece < 200; indece++){
                escribir.write(String.valueOf(buffer2[indece]+"\n") );
            }
            escribir.write("-----------------------------------\n");
            escribir.close();
        }


        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
