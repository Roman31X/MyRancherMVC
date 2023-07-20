
package Controlador;

import Modelo.Alimento;
import Vista.*;
import java.awt.event.*;

public class ControlAlimento implements ActionListener{
    
    private final Menu_Principal menu1;
    private final Calculo_Alimento calali3;
    private Alimento ali;
    
    public ControlAlimento(Menu_Principal menupri,Calculo_Alimento calali) {
        this.menu1 = menupri;
        this.calali3 = calali;
        
        calali3.calcular.addActionListener(this);
        calali3.limpiar.addActionListener(this);
        calali3.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        calali3.setTitle("Calculo de Alimento MyRancher");
        calali3.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :
                                double peso_saco = Double.parseDouble(calali3.Peso_Saco.getText());
                                double cant_saco = Double.parseDouble(calali3.Cant_Saco.getText());
                                double cant_adulto = Double.parseDouble(calali3.Cant_Adulto.getText());
                                double cant_ternero = Double.parseDouble(calali3.Cant_Ternero.getText());
                                double peso_adulto = Double.parseDouble(calali3.Peso_Adulto.getText());
                                double peso_ternero = Double.parseDouble(calali3.Peso_Ternero.getText());
                                ali = new Alimento(cant_saco,peso_saco,peso_adulto,peso_ternero,cant_adulto,cant_ternero);
                                calali3.Tex_Mensaje.append(ali.toString());
                                break;
            case "LIMPIAR" : 
                                calali3.Peso_Saco.setText("");
                                calali3.Cant_Saco.setText("");
                                calali3.Cant_Adulto.setText("");
                                calali3.Peso_Adulto.setText("");
                                calali3.Cant_Ternero.setText("");
                                calali3.Peso_Ternero.setText("");
                                calali3.Tex_Mensaje.setText("");
                                break;
            
            case "REGRESAR" :
                                menu1.setVisible(true);
                                calali3.setVisible(false);
                                break;
        }
    }
}
