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
    
    private final Capacitacion capacitacion;
    private Menu_Principal menu;
    
    public ControlCapacitacion(Capacitacion ca1) {
        this.capacitacion = ca1;
        
        capacitacion.manual.addActionListener(this);
        capacitacion.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        capacitacion.setTitle("Capacitación MyRancher");
        capacitacion.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        menu = new Menu_Principal();
        String opcion = e.getActionCommand();
        switch(opcion){
            case "Manual MyRancher" : 
                                try{
                                    Desktop.getDesktop().browse(new URI("https://github.com/Roman31X/MyRancherMVC/blob/master/test/ManualPDF/Manual_MyRancher.pdf"));
                                } catch (IOException | URISyntaxException a){
                                    JOptionPane.showMessageDialog(null, "ERROR AL ENCONTRAR ARCHIVO");
                                }
                                break;
            case "REGRESAR" : 
                                ControlMenuPrincipal principal = new ControlMenuPrincipal(menu);
                                principal.Mostrar();
                                capacitacion.setVisible(false);
                                break;
        }
        
    }
    
}
