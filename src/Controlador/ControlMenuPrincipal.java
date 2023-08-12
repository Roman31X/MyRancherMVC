package Controlador;
import Vista.*;
import java.awt.event.*;

public class ControlMenuPrincipal implements ActionListener{
    private final Menu_Principal menu;
    private Capacitacion capacitacion;
    private Calculo_Alimento alimento;
    private Calculo_Forraje forraje;
    private Calculo_Ventas ventas;
    
    public ControlMenuPrincipal(Menu_Principal menupri) {
        this.menu = menupri;
        
        menu.Capacitacion.addActionListener(this);
        menu.CalculoAli.addActionListener(this);
        menu.CalculoForra.addActionListener(this);
        menu.CalculoVen.addActionListener(this);
        menu.Salir.addActionListener(this);        
    }
    
    public void Mostrar(){
        menu.setTitle("Menu Principal MyRancher");
        menu.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        capacitacion = new Capacitacion();
        alimento = new Calculo_Alimento();
        forraje = new Calculo_Forraje();
        ventas = new Calculo_Ventas();
        
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CAPACITACION" :               
                                ControlCapacitacion ca = new ControlCapacitacion(capacitacion);
                                menu.setVisible(false);
                                ca.Mostrar();
                                break;
//            case "CALCULO DE ALIMENTO" : 
//                                ControlAlimento ali = new ControlAlimento(alimento);
//                                menu.setVisible(false);
//                                ali.Mostrar();
//                                break;
//            case "CALCULO DE FORRAJE" : 
//                                ControlForraje forra = new ControlForraje(forraje);
//                                menu.setVisible(false);
//                                forra.Mostrar();
//                                break;
//            case "CALCULO DE VENTAS" :
//                                ControlVenta cven = new ControlVenta(ventas);
//                                menu.setVisible(false);
//                                cven.Mostrar();
//                                break;
            case "SALIR" : 
                                System.exit(0);
                                break;
        }
    }
        
   
}
