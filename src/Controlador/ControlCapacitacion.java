package Controlador;

import Vista.Capacitacion;
import Vista.*;
import java.awt.Desktop;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class ControlCapacitacion implements ActionListener{
    
    private final Menu_Principal men;
    private final Capacitacion ca2;
    
    public ControlCapacitacion(Menu_Principal men1,Capacitacion ca1) {
        this.men = men1;
        this.ca2 = ca1;
        
        ca2.manual.addActionListener(this);
        ca2.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        ca2.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String opcion = e.getActionCommand();
        switch(opcion){
            case "Manual MyRancher" : 
                                try{
                                    Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1fbJbT92fgJ5-vV9mPU9A2FyAVgITu5zC/view?usp=sharing"));
                                } catch (IOException | URISyntaxException a){
                                    JOptionPane.showMessageDialog(null, "ERROR AL ENCONTRAR ARCHIVO");
                                }
                                break;
            case "REGRESAR" : 
                                men.setVisible(true);
                                ca2.setVisible(false);
                                break;
        }
        
    }
    
}
