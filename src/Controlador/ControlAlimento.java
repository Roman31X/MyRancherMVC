
package Controlador;

import Modelo.Alimento;
import Vista.*;
import java.awt.event.*;

public class ControlAlimento implements ActionListener{
    
    private final Calculo_Alimento alimento;
    private Menu_Principal menu;
    private Alimento calculo;
    
    public ControlAlimento(Calculo_Alimento calali) {
        this.alimento = calali;
        
        alimento.calcular.addActionListener(this);
        alimento.limpiar.addActionListener(this);
        alimento.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        alimento.setTitle("Calculo de Alimento MyRancher");
        alimento.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        menu = new Menu_Principal();
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :
                        double peso_saco = Double.parseDouble(alimento.Peso_Saco.getText());
                        double cant_saco = Double.parseDouble(alimento.Cant_Saco.getText());
                        double cant_adulto = Double.parseDouble(alimento.Cant_Adulto.getText());
                        double cant_ternero = Double.parseDouble(alimento.Cant_Ternero.getText());
                        double peso_adulto = Double.parseDouble(alimento.Peso_Adulto.getText());
                        double peso_ternero = Double.parseDouble(alimento.Peso_Ternero.getText());
                        calculo = new Alimento(cant_saco,peso_saco,peso_adulto,peso_ternero,cant_adulto,cant_ternero);
                        alimento.Tex_Mensaje.append(calculo.toString());
                        break;
            case "LIMPIAR" : 
                        alimento.Peso_Saco.setText("");
                        alimento.Cant_Saco.setText("");
                        alimento.Cant_Adulto.setText("");
                        alimento.Peso_Adulto.setText("");
                        alimento.Cant_Ternero.setText("");
                        alimento.Peso_Ternero.setText("");
                        alimento.Tex_Mensaje.setText("");
                        break;
            
            case "REGRESAR" :
                        ControlMenuPrincipal principal = new ControlMenuPrincipal(menu);
                        principal.Mostrar();
                        alimento.setVisible(false);
                        break;
        }
    }
}
