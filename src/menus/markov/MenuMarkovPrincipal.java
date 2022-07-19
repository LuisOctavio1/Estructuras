package menus.markov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMarkovPrincipal extends JFrame{
    private JLabel titulo, imagen;
    private JButton preguntaA, preguntaB, preguntaC, preguntaD;

    public MenuMarkovPrincipal(){
        titulo = new JLabel("Modelo oculto de Markov");
        setSize(500,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Modelo oculto de Markov");
        titulo.setLocation(160,10);
        titulo.setSize(1000,30);
        getContentPane().add(titulo);
        titulo.setVisible(true);
        preguntaA = new JButton("a) Probabilidad de que el escenario inicie con un tiempo especifico:");
        preguntaA.setSize(460,30);
        preguntaA.setLocation(10,50);
        preguntaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPreguntaA menu = new MenuPreguntaA();
                setVisible(false);
                menu.setVisible(true);
            }
        });

        preguntaB = new JButton("b) Probabilidad de que los investigadores hagan cierta actividad ese día:");
        preguntaB.setSize(460,30);
        preguntaB.setLocation(10,100);
        preguntaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPreguntaB menu = new MenuPreguntaB();
                setVisible(false);
                menu.setVisible(true);
            }
        });

        preguntaC = new JButton("c) Probabilidad de que el día esté en cierto estado:");
        preguntaC.setSize(460,30);
        preguntaC.setLocation(10,150);
        preguntaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPreguntaC menu = new MenuPreguntaC();
                setVisible(false);
                menu.setVisible(true);
            }
        });

        preguntaD = new JButton("d) Probabilidad de que se de cierta secuencia de climas:");
        preguntaD.setSize(460,30);
        preguntaD.setLocation(10,200);
        preguntaD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPreguntaD menu = new MenuPreguntaD();
                setVisible(false);
                menu.setVisible(true);
            }
        });

        imagen = new JLabel(new ImageIcon("src/menus/markov/diagramaDeModelo.png"));
        imagen.setLocation(0,200);
        imagen.setSize(500,500);

        getContentPane().add(preguntaA);
        getContentPane().add(preguntaB);
        getContentPane().add(preguntaC);
        getContentPane().add(preguntaD);
        getContentPane().setBackground(new Color(255,255,255));
        getContentPane().add(imagen);
        setVisible(true);
    }


}
