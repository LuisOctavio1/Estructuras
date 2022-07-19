package menus.markov;

import estructuraslineales.ListaEstatica;
import herramientas.matematicas.ModeloOcultoMarkov;
import utiles.ModeloMarkovCientificos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPreguntaD extends JFrame{
    private JLabel titulo;
    private JButton estado1,estado2,estado3,estado4;
    private ModeloOcultoMarkov modelo = new ModeloMarkovCientificos().getModelo();
    private JLabel listaEstados;
    private JLabel indicacion;
    private JLabel respuesta;
    private JLabel imagen;
    private JButton retroceder;
    private String estadoActual = "";
    private double probabilidadActual = 1.0;

    public MenuPreguntaD(){
        inicializarComponentes();
        getContentPane().add(titulo);
        getContentPane().add(indicacion);
        getContentPane().add(listaEstados);
        getContentPane().add(estado1);
        getContentPane().add(estado2);
        getContentPane().add(estado3);
        getContentPane().add(respuesta);
        getContentPane().add(retroceder);
        getContentPane().add(estado4);
        getContentPane().add(imagen);
        getContentPane().setBackground(new Color(255,255,255));
        setVisible(true);
    }

    public void inicializarComponentes(){
        titulo = new JLabel("d) Probabilidad de que se de cierta secuencia de climas:");
        titulo.setLocation(100,10);
        titulo.setSize(1000,30);
        setSize(600,700);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        indicacion = new JLabel("");
        listaEstados = new JLabel();
        retroceder = new JButton("Menu inicial");
        setTitle("Modelo oculto de Markov");
        ListaEstatica listaBotones = new ListaEstatica(4);
        estado1 = new JButton("Soleado");
        estado2 = new JButton("Nublado");
        estado3 = new JButton("Lluvioso");
        estado4 = new JButton("Despejado");
        listaBotones.agregar(estado1);
        listaBotones.agregar(estado2);
        listaBotones.agregar(estado3);
        listaBotones.agregar(estado4);
        inicializarBotones(listaBotones);

        indicacion.setLocation(10,100);
        indicacion.setSize(5000,200);
        indicacion.setText("La probabilidad de la siguiente secuencia es: ");

        listaEstados.setLocation(10,125);
        listaEstados.setSize(5000,200);

        respuesta = new JLabel();
        respuesta.setLocation(10,150);
        respuesta.setSize(5000,200);

        retroceder.setLocation(450,625);
        retroceder.setSize(120,25);
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuMarkovPrincipal menu = new MenuMarkovPrincipal();
                menu.setVisible(true);
            }
        });

        imagen = new JLabel(new ImageIcon("src/menus/markov/diagramaDeModelo.png"));
        imagen.setLocation(40,200);
        imagen.setSize(500,500);
    }

    public void inicializarBotones(ListaEstatica listaBotones){
        int posicionX = 100;
        for(int indice = 0; indice < listaBotones.numeroElementos(); indice++){
            JButton boton = (JButton) listaBotones.obtener(indice);
            boton.setLocation(posicionX,50);
            boton.setSize(100,20);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(estadoActual.equals("")){
                        estadoActual = boton.getText();
                        probabilidadActual = probabilidadActual * modelo.obtenerProbabilidadInicial(estadoActual);
                        listaEstados.setText(listaEstados.getText() + estadoActual);
                        respuesta.setText("Probabilidad: " + probabilidadActual);
                    }else{
                        probabilidadActual = probabilidadActual * modelo.obtenerProbabilidad(estadoActual,estado3.getText());
                        estadoActual = boton.getText();
                        listaEstados.setText(listaEstados.getText() + " -> " + estadoActual);
                        respuesta.setText("Probabilidad: " + probabilidadActual);
                        estadoActual = boton.getText();
                    }
                }
            });
            posicionX = posicionX + 100;
        }
    }
}
