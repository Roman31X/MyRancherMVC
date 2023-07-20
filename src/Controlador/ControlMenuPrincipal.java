package Controlador;
import Vista.*;
import java.awt.event.*;

public class ControlMenuPrincipal implements ActionListener{
    private Menu_Principal menupri1;
    private Capacitacion cap1;
    private Calculo_Alimento calali;
    private Calculo_Forraje calfor;
    private Calculo_Ventas cave;
    
    public ControlMenuPrincipal(Menu_Principal menupri) {
        this.menupri1 = menupri;
        
        menupri1.Capacitacion.addActionListener(this);
        menupri1.CalculoAli.addActionListener(this);
        menupri1.CalculoForra.addActionListener(this);
        menupri1.CalculoVen.addActionListener(this);
        menupri1.Salir.addActionListener(this);        
    }
    
    public void Mostrar(){
        menupri1.setTitle("Menu Principal MyRancher [UwU]");
        menupri1.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        cap1 = new Capacitacion();
        calali = new Calculo_Alimento();
        calfor = new Calculo_Forraje();
        cave = new Calculo_Ventas();
        
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CAPACITACION" :               
                                ControlCapacitacion ca = new ControlCapacitacion(menupri1,cap1);
                                menupri1.setVisible(false);
                                ca.Mostrar();
                                break;
            case "CALCULO DE ALIMENTO" : 
                                ControlAlimento ali = new ControlAlimento(menupri1,calali);
                                menupri1.setVisible(false);
                                ali.Mostrar();
                                break;
            case "CALCULO DE FORRAJE" : 
                                ControlForraje forra = new ControlForraje(menupri1,calfor);
                                menupri1.setVisible(false);
                                forra.Mostrar();
                                break;
            case "CALCULO DE VENTAS" :
                                ControlVenta cven = new ControlVenta(menupri1,cave);
                                menupri1.setVisible(false);
                                cven.Mostrar();
                                break;
            case "SALIR" : 
                                System.exit(0);
                                break;
        }
    }
        
   
}
