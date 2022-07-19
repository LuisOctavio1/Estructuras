package menus.markov;

import herramientas.matematicas.ModeloOcultoMarkov;
import utiles.ModeloMarkovCientificos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuPreguntaC extends JFrame{
    private JLabel titulo;
    private ButtonGroup grupoBotones;
    private JComboBox estados1;
    private JComboBox estados2;
    private ModeloOcultoMarkov modelo = new ModeloMarkovCientificos().getModelo();
    private JLabel respuesta , imagen;
    private JButton retroceder;

    public MenuPreguntaC(){
        inicializarComponentes();
        getContentPane().add(titulo);
        getContentPane().add(estados1);
        getContentPane().add(estados2);
        getContentPane().add(respuesta);
        getContentPane().add(retroceder);
        getContentPane().setBackground(new Color(255,255,255));
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
        grupoBotones = new ButtonGroup();
        estados1 = new JComboBox<>();
        estados2 = new JComboBox<>();
        respuesta = new JLabel("");

        setTitle("Modelo oculto de Markov");
        estados1.addItem("Soleado");
        estados1.addItem("Nublado");
        estados1.addItem("Lluvioso");
        estados1.addItem("Despejado");

        estados2.addItem("Soleado");
        estados2.addItem("Nublado");
        estados2.addItem("Lluvioso");
        estados2.addItem("Despejado");

        estados1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                respuesta.setText("La probabilidad de que en el estado " + estados1.getSelectedItem() + " se pase al estado" +
                        " " + estados2.getSelectedItem() + " es de " + modelo.obtenerProbabilidad(estados1.getSelectedItem(), estados2.getSelectedItem()));
            }
        } );

        estados2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                respuesta.setText("La probabilidad de que en el estado " + estados1.getSelectedItem() + " se pase al estado" +
                        " " + estados2.getSelectedItem() + " es de " + modelo.obtenerProbabilidad(estados1.getSelectedItem(), estados2.getSelectedItem()));
            }
        } );

        estados2.setLocation(400,100);
        estados2.setSize(100,30);

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
