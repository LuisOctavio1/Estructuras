package utiles;

import herramientas.matematicas.ModeloOcultoMarkov;

public class ModeloMarkovCientificos {
    ModeloOcultoMarkov modelo = new ModeloOcultoMarkov(4,3);
    public ModeloMarkovCientificos(){
        modelo.agregarEstado("Soleado",.1);
        modelo.agregarEstado("Lluvioso",.3);
        modelo.agregarEstado("Nublado",.2);
        modelo.agregarEstado("Despejado",.4);
        modelo.agregarActividad("Muestreo");
        modelo.agregarActividad("Parcela");
        modelo.agregarActividad("Indice de riqueza natural");
        modelo.agregarProbabilidadActivbidad("Despejado","Muestreo",.5);
        modelo.agregarProbabilidadActivbidad("Despejado","Parcela",.3);
        modelo.agregarProbabilidadActivbidad("Despejado","Indice de riqueza natural",.2);

        modelo.agregarProbabilidadActivbidad("Lluvioso","Muestreo",.3);
        modelo.agregarProbabilidadActivbidad("Lluvioso","Parcela",.4);
        modelo.agregarProbabilidadActivbidad("Lluvioso","Indice de riqueza natural",.3);

        modelo.agregarProbabilidadActivbidad("Nublado","Muestreo",.2);
        modelo.agregarProbabilidadActivbidad("Nublado","Parcela",.2);
        modelo.agregarProbabilidadActivbidad("Nublado","Indice de riqueza natural",.6);

        modelo.agregarProbabilidadActivbidad("Soleado","Muestreo",.3);
        modelo.agregarProbabilidadActivbidad("Soleado","Parcela",.6);
        modelo.agregarProbabilidadActivbidad("Soleado","Indice de riqueza natural",.1);

        modelo.agregarDependencia("Despejado","Despejado",.4);
        modelo.agregarDependencia("Nublado","Despejado",.2);
        modelo.agregarDependencia("Lluvioso","Despejado",.2);
        modelo.agregarDependencia("Soleado","Despejado",.4);

        modelo.agregarDependencia("Nublado","Nublado",.2);
        modelo.agregarDependencia("Despejado","Nublado",.4);
        modelo.agregarDependencia("Lluvioso","Nublado",.2);
        modelo.agregarDependencia("Soleado","Nublado",.2);

        modelo.agregarDependencia("Lluvioso","Lluvioso",.3);
        modelo.agregarDependencia("Nublado","Lluvioso",.5);
        modelo.agregarDependencia("Despejado","Lluvioso",.1);
        modelo.agregarDependencia("Soleado","Lluvioso",.1);

        modelo.agregarDependencia("Soleado","Soleado",.3);
        modelo.agregarDependencia("Nublado","Soleado",.1);
        modelo.agregarDependencia("Despejado","Soleado",.3);
        modelo.agregarDependencia("Lluvioso","Soleado",.3);
    }


    public  ModeloOcultoMarkov getModelo(){
        return modelo;
    }


}
