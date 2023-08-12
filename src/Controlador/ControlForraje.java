package Controlador;

import Modelo.Forraje;
import Vista.*;
import java.awt.event.*;

public class ControlForraje implements ActionListener{
    
    private final Calculo_Forraje forraje;
    private Menu_Principal menu;
    private Forraje calculo;
    
    public ControlForraje(Calculo_Forraje calfor) {
        this.forraje = calfor;
        
        forraje.calcular.addActionListener(this);
        forraje.limpiar.addActionListener(this);
        forraje.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        forraje.setTitle("Calculo Forraje MyRancher");
        forraje.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :   
                                double hecta = Double.parseDouble(forraje.Hectaria.getText());
                                double pes1 = Double.parseDouble(forraje.Peso1.getText());
                                double pes2 = Double.parseDouble(forraje.Peso2.getText());
                                double caAdulto = Double.parseDouble(forraje.CantiAdulto.getText());
                                double pesadulto = Double.parseDouble(forraje.PesoAdulto.getText());
                                double caTernero = Double.parseDouble(forraje.CantTernero.getText());
                                double pesternero = Double.parseDouble(forraje.PesoTernero.getText());
                                calculo = new Forraje(pes1,pes2,hecta,pesadulto,pesternero,caAdulto,caTernero);
                                forraje.TextSalida.append(calculo.toString());
                                break;
            case "LIMPIAR" : 
                                forraje.Hectaria.setText("");
                                forraje.Peso1.setText("");
                                forraje.Peso2.setText("");
                                forraje.CantiAdulto.setText("");
                                forraje.PesoAdulto.setText("");
                                forraje.CantTernero.setText("");
                                forraje.PesoTernero.setText("");
                                forraje.TextSalida.setText("");
                                break;
            
            case "REGRESAR" :
                                ControlMenuPrincipal principal = new ControlMenuPrincipal(menu);
                                principal.Mostrar();
                                forraje.setVisible(false);
                                break;
        }
    }
    
}
