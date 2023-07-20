package Controlador;

import Modelo.Forraje;
import Vista.*;
import java.awt.event.*;

public class ControlForraje implements ActionListener{
    
    private final Menu_Principal menupr1;
    private final Calculo_Forraje calfor4;
    private Forraje forra;
    
    public ControlForraje(Menu_Principal menupri, Calculo_Forraje calfor) {
        this.menupr1 = menupri;
        this.calfor4 = calfor;
        
        calfor4.calcular.addActionListener(this);
        calfor4.limpiar.addActionListener(this);
        calfor4.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        calfor4.setTitle("Calculo Forraje MyRancher [UwU]");
        calfor4.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :   
                                double hecta = Double.parseDouble(calfor4.Hectaria.getText());
                                double pes1 = Double.parseDouble(calfor4.Peso1.getText());
                                double pes2 = Double.parseDouble(calfor4.Peso2.getText());
                                double caAdulto = Double.parseDouble(calfor4.CantiAdulto.getText());
                                double pesadulto = Double.parseDouble(calfor4.PesoAdulto.getText());
                                double caTernero = Double.parseDouble(calfor4.CantTernero.getText());
                                double pesternero = Double.parseDouble(calfor4.PesoTernero.getText());
                                forra = new Forraje(pes1,pes2,hecta,pesadulto,pesternero,caAdulto,caTernero);
                                calfor4.TextSalida.append(forra.toString());
                                break;
            case "LIMPIAR" : 
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
                                menupr1.setVisible(true);
                                calfor4.setVisible(false);
                                break;
        }
    }
    
}
