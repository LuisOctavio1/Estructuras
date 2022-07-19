package menus.markov;

import herramientas.matematicas.ModeloOcultoMarkov;
import utiles.ModeloMarkovCientificos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuPreguntaA extends JFrame{
    private JLabel titulo;
    private JCheckBoxMenuItem estados;
    private JCheckBoxMenuItem actividades;
    private ButtonGroup grupoBotones;
    private JComboBox estados1;
    private ModeloOcultoMarkov modelo = new ModeloMarkovCientificos().getModelo();
    private JLabel respuesta, imagen;
    private JButton retroceder;

    public MenuPreguntaA(){
        inicializarComponentes();
        getContentPane().add(estados);
        getContentPane().add(titulo);
        getContentPane().add(estados1);
        getContentPane().add(respuesta);
        getContentPane().setBackground(new Color(255,255,255));
        getContentPane().add(retroceder);
        getContentPane().add(imagen);
        setVisible(true);
    }

    public void inicializarComponentes(){
        titulo = new JLabel("a) Probabilidad de que el escenario inicie con un tiempo especifico:");
        titulo.setLocation(100,10);
        titulo.setSize(1000,30);
        setSize(600,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        estados = new JCheckBoxMenuItem();
        grupoBotones = new ButtonGroup();
        estados1 = new JComboBox<>();
        respuesta = new JLabel("");

        setTitle("Modelo oculto de Markov");
        estados1.addItem("Soleado");
        estados1.addItem("Nublado");
        estados1.addItem("Lluvioso");
        estados1.addItem("Despejado");

        estados1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                respuesta.setText("La probabilidad de que en el estado " + estados1.getSelectedItem() + " sea el inicial" +
                      " es de " + modelo.obtenerProbabilidadInicial(estados1.getSelectedItem()));
            }
        } );


        respuesta.setLocation(10,100);
        respuesta.setSize(5000,200);

        estados1.setLocation(100,100);
        estados1.setSize(100,30);

        retroceder = new JButton("Menu inicial");
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
}
