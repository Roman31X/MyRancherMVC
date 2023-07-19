package Controlador;
import Vista.Calculo_Alimento;
import Vista.Calculo_Forraje;
import Vista.Calculo_Ventas;
import Vista.Capacitacion;
import Vista.Menu_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMenuPrincipal implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES Menu_Principal - 
    //CLASE Capacitacion - CLASE Calculo_Alimento - CLASE Calculo_Forraje - 
    //CLASE Calculo_Ventas
    private Menu_Principal menupri1;
    private Capacitacion cap1;
    private Calculo_Alimento calali;
    private Calculo_Forraje calfor;
    private Calculo_Ventas cave;
    //CONTRUCTOR QUE RECIBE COMO PARAMETRO EL OBJETO CREADO EN LA CLASE ControladorLogin
    public ControlMenuPrincipal(Menu_Principal menupri) {
        this.menupri1 = menupri;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ Memu_Principal "menupri1" OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        menupri1.Capacitacion.addActionListener(this);
        menupri1.CalculoAli.addActionListener(this);
        menupri1.CalculoForra.addActionListener(this);
        menupri1.CalculoVen.addActionListener(this);
        menupri1.Salir.addActionListener(this);        
    }   
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE MENU_PRINCIPAL
    public void Mostrar(){
        menupri1.setTitle("Menu Principal MyRancher [UwU]");
        menupri1.setVisible(true);        
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO Menu_Principal EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //MEDIANTE LOS OBJETOS CREADOS EN ESTA CLASE OBTENDRAN ACCESO A LA FNCIONALIDAD
        //DE LA INTERFAZ CREADAS EN EL PAQUETE "Vista" CON ELLO PODREMOS ENVIAR ESTOS TRIBUTOS
        //COMO PARAMETROS MEDINATE LOS CONTRUCTORES ASIGNADOS A CADA CONTROLADOR
        cap1 = new Capacitacion();
        calali = new Calculo_Alimento();
        calfor = new Calculo_Forraje();
        cave = new Calculo_Ventas();
        //CAPTURAMOS LA VARIABLE "e" Y LA CONTENDREMOS EN UN STRING PARA REALIZAR SU EVALUACION MEDIANTE
        //UN "switch" QUE DESIGNARA QUE FUNCION REALIZARA MERIANTE LA VARIABLE "opcion"
        String opcion = e.getActionCommand();
        //JOptionPane.showMessageDialog(null,opcion); //prueba para saber si caprura la variable asignadas
        //a los botones de Menu_Principal
        switch(opcion){
            case "CAPACITACION" : 
                                //Creamos un objeto del "ControlCapacitacion" y enviamos como parametros "menupri1 y cap1"                
                                ControlCapacitacion ca = new ControlCapacitacion(menupri1,cap1);
                                //MEDIANTE ESTA DECLARACION OCULTAREMOS LA INTERFAZ DE "Menu_Principal" YA QUE EL VALOR
                                //AL MOSTRAR ES "false" CON ESTO SE OCULTA 
                                menupri1.setVisible(false);
                                ca.Mostrar();
                                break;
            case "CALCULO DE ALIMENTO" : 
                                //Creamos un objeto del "ControlAlimento" y enviamos como parametros "menupri1 y calali"
                                ControlAlimento ali = new ControlAlimento(menupri1,calali);
                                //MEDIANTE ESTA DECLARACION OCULTAREMOS LA INTERFAZ DE "Menu_Principal" YA QUE EL VALOR
                                //AL MOSTRAR ES "false" CON ESTO SE OCULTA 
                                menupri1.setVisible(false);
                                ali.Mostrar();
                                break;
            case "CALCULO DE FORRAJE" : 
                                //Creamos un objeto del "ControlForraje" y enviamos como parametros "menupri1 y calfor"
                                ControlForraje forra = new ControlForraje(menupri1,calfor);
                                //MEDIANTE ESTA DECLARACION OCULTAREMOS LA INTERFAZ DE "Menu_Principal" YA QUE EL VALOR
                                //AL MOSTRAR ES "false" CON ESTO SE OCULTA 
                                menupri1.setVisible(false);
                                forra.Mostrar();
                                break;
            case "CALCULO DE VENTAS" : 
                                //Creamos un objeto del "ControlVenta" y enviamos como parametros "menupri1 y cave"
                                ControlVenta cven = new ControlVenta(menupri1,cave);
                                //MEDIANTE ESTA DECLARACION OCULTAREMOS LA INTERFAZ DE "Menu_Principal" YA QUE EL VALOR
                                //AL MOSTRAR ES "false" CON ESTO SE OCULTA 
                                menupri1.setVisible(false);
                                cven.Mostrar();
                                break;
            case "SALIR" : 
                                //MEDIANTE ESTA DECLARACION DAREMOS FIN A LA EJECUCION
                                System.exit(0);
                                break;
        }
    }
        
   
}
