/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Forraje;
import Vista.Calculo_Forraje;
import Vista.Menu_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlForraje implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES Menu_Principal - 
    //CLASE Calculo_Forraje - CREAMOS UN OBJETO DE LA CLASE "Forraje" del paquete "Modelo"
    private final Menu_Principal menupr1;
    private final Calculo_Forraje calfor4;
    private Forraje forra;
    //CONTRUCTOR QUE RECIBE COMO PARAMETRO EL OBJETO CREADO EN LA CLASE ControlMenuPrincipal
    public ControlForraje(Menu_Principal menupri, Calculo_Forraje calfor) {
        this.menupr1 = menupri;
        this.calfor4 = calfor;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ Calculo_Forraje "calfor4" OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        calfor4.calcular.addActionListener(this);
        calfor4.limpiar.addActionListener(this);
        calfor4.regresar.addActionListener(this);
    }
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE Calulo_Forraje
    public void Mostrar(){
        calfor4.setTitle("Calculo Forraje MyRancher [UwU]");
        calfor4.setVisible(true);        
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO Calculo_Forraje EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //CAPTURAMOS LA VARIABLE "e" Y LA CONTENDREMOS EN UN STRING PARA REALIZAR SU EVALUACION MEDIANTE
        //UN "switch" QUE DESIGNARA QUE FUNCION REALIZARA MERIANTE LA VARIABLE "opcion"
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :   //FUNCION BOTON "CALCULAR"
                                //solicitamos los datos para el calculo
                                //Para ello creamos atributos que capturen los datos
                                double hecta = Double.parseDouble(calfor4.Hectaria.getText());
                                double pes1 = Double.parseDouble(calfor4.Peso1.getText());
                                double pes2 = Double.parseDouble(calfor4.Peso2.getText());
                                double caAdulto = Double.parseDouble(calfor4.CantiAdulto.getText());
                                double pesadulto = Double.parseDouble(calfor4.PesoAdulto.getText());
                                double caTernero = Double.parseDouble(calfor4.CantTernero.getText());
                                double pesternero = Double.parseDouble(calfor4.PesoTernero.getText());
                                //ENVIO LOS VALORES ATRAVEZ DEL OBJETO CREADO PARA Forraje A TRAVEZ DEL CONTRUCTOR
                                //PARA REALIZAR LOS CALCULOS CORRESPONDIENTES
                                forra = new Forraje(pes1,pes2,hecta,pesadulto,pesternero,caAdulto,caTernero);
                                //utilizamos los objetos para mostar el mensaje en el TextArea
                                calfor4.TextSalida.append(forra.toString());
                                break;
            case "LIMPIAR" : 
                                //FUNCION BOTON "LIMPIAR"
                                //POR MEDIO DEL OBJETO DE LA INTERFAS CALCULO DE FORRAJE
                                //ACCEDEMOS A LA VARIBALES DE LA INTERFAZ Y MOSTRAREMOS 
                                //POR MEDIO DEL METODO SETTER LAS CASILLAR VACIAS YA QUE NO HAY CONTENIDO
                                //DENTRO DE LAS COMILLAS
                                calfor4.Hectaria.setText("");
                                calfor4.Peso1.setText("");
                                calfor4.Peso2.setText("");
                                calfor4.CantiAdulto.setText("");
                                calfor4.PesoAdulto.setText("");
                                calfor4.CantTernero.setText("");
                                calfor4.PesoTernero.setText("");
                                calfor4.TextSalida.setText("");
                                break;
            
            case "REGRESAR" :
                                //FUNCION BOTON "LIMPIAR"
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA MOSTRAR LA INTERFAZ "MenuPrincipal"
                                menupr1.setVisible(true);
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA OCULTAR LA INTERFAZ "Calculo_Forraje" 
                                calfor4.setVisible(false);
                                break;
        }
    }
    
}
