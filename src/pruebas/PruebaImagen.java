package pruebas;

import imagenes.ControlImagen;
import utiles.TipoTamano;

import java.awt.*;
import java.io.IOException;

public class PruebaImagen {
    public static void main(String[] args) {
        ControlImagen controlImagen = new ControlImagen();
        //controlImagen.escalaDeGrises();
        //controlImagen.modificarBrillo(10);
        controlImagen.imageninvertiaHorizontal();
        //controlImagen.imageninvertiaVertical();
        //controlImagen.rotar90();
        //controlImagen.rotar180();
        //controlImagen.rotar270();
        //controlImagen.transpuesta();
        Color color = new Color(203,50,17);
        //controlImagen.generarMarco(20,color);
        //controlImagen.mitadDisociada();
        //controlImagen.cambairTamano(TipoTamano.DOBLE);
    }
}
