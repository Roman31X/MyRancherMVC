
package Controlador;
import java.awt.event.*;
import Vista.*;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener{
    private final Login log1;
    private final Menu_Principal menu1;
    public ControladorLogin(Login logi, Menu_Principal menu1) {
        this.log1 = logi;
        this.menu1 = menu1;
        
        logi.Ingresar.addActionListener(this);
    }
    
    public void iniciar(){
        log1.setTitle("Login MyRancher");
        log1.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (log1.Usuario.getText().equals("admin") && log1.Contraseña.getText().equals("1234")) {
            JOptionPane.showMessageDialog(null,"SE HA INICIADO CORRECTAMENTE\n GRACIAS!!");
            ControlMenuPrincipal menu = new ControlMenuPrincipal(menu1);
            log1.setVisible(false);
            menu.Mostrar();            
        } else {
            JOptionPane.showMessageDialog(null,"El Usuario o Contraseña incorrecto\n vuelva ingresar por favor");
        }
    }
    
    
}
