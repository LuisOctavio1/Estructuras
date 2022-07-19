package pruebas;

import audio.AudioFileRecord;
import entradasalida.SalidaPorDefecto;

public class PruebaAudio {
    public static void main(String[] args) {
        AudioFileRecord audio = new AudioFileRecord("estructuras/src/audio/practica.wav");
        audio.leerAudio();
        audio.EscribirAudio();
        //audio.preEnfasis();
        //audio.vajarVolumen(70);
        //audio.subirVolumen(200);
        //audio.acelerarPista(2);
        audio.decrementarPista(2);
        //audio.eliminarSilencio();
        //audio.inversionEjex();
        //audio.inversionEjey();
        //SalidaPorDefecto.consola("La energia es: " + audio.obtenerEnergia());
    }
}
