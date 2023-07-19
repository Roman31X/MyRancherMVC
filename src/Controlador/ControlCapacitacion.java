/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Capacitacion;
import Vista.Login;
import Vista.Menu_Principal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class ControlCapacitacion implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES Menu_Principal - 
    //CLASE Capacitacion
    private Menu_Principal men;
    private  Capacitacion ca2;
    //CONTRUCTOR QUE RECIBE COMO PARAMETRO EL OBJETO CREADO EN LA CLASE ControlMenuPrincipal
    public ControlCapacitacion(Menu_Principal men1,Capacitacion ca1) {
        this.men = men1;
        this.ca2 = ca1;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ Capacitacion "ca2" OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        ca2.manual.addActionListener(this);
        ca2.regresar.addActionListener(this);
    }   
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE CAPACITACION
    public void Mostrar(){
        ca2.setTitle("Capacitación MyRancher");
        ca2.setVisible(true);
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO Capacitacion EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //CAPTURAMOS LA VARIABLE "e" Y LA CONTENDREMOS EN UN STRING PARA REALIZAR SU EVALUACION MEDIANTE
        //UN "switch" QUE DESIGNARA QUE FUNCION REALIZARA MERIANTE LA VARIABLE "opcion"
        String opcion = e.getActionCommand();
        switch(opcion){
            case "Manual MyRancher" : 
                                //FUNCION PARA DESCARGAR EL PDF MANUAL DEL APP "MyRancher"
                                try{
                                    Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1fbJbT92fgJ5-vV9mPU9A2FyAVgITu5zC/view?usp=sharing"));
                                } catch (IOException | URISyntaxException a){
                                    JOptionPane.showMessageDialog(null, "ERROR AL ENCONTRAR ARCHIVO");
                                }
                                break;
            case "REGRESAR" : 
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA MOSTRAR LA INTERFAZ "MenuPrincipal" 
                                men.setVisible(true);
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA OCULTAR LA INTERFAZ "Capacitacion" 
                                ca2.setVisible(false);
                                break;
        }
        
    }
    
}
