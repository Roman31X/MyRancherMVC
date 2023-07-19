
package Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Vista.Login;
import Vista.Menu_Principal;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES INTERFAZ LOGIN y CLASES INTERFAZ MENU
    private final Login log1;
    private final Menu_Principal menu1;
    //CONSTRUCTOR QUE RECIBE COMO PARAMETROS EL OBEJTO DE LOGIN Y MENU_PRINCIPAL
    public ControladorLogin(Login logi, Menu_Principal menu1) {
        this.log1 = logi;
        this.menu1 = menu1;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ LOGIN "logi." OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        logi.Ingresar.addActionListener(this);
    }    
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE LA INTERFAZ LOGIN
    public void iniciar(){
        log1.setTitle("Login MyRancher");
        log1.setVisible(true);
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO LOGIN EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //FUNCION DEL CONTROLADOR PARA VARIDAR AL USUARIO ADMIN Y SU CONTRASEÑA 1234
        if (log1.Usuario.getText().equals("admin") && log1.Contraseña.getText().equals("1234")) {
            JOptionPane.showMessageDialog(null,"SE HA INICIADO CORRECTAMENTE\n GRACIAS!!");
            //SE CREA UN OBJETO INTACIADO DEL CONTROLADORMENUPRINCIPAL Y ENVIAMOS EL PARAMETRO DE "menu1"
            //PARA TENER ACCESO A ASU VARIABLES Y FUNCIONAMIENTO
            ControlMenuPrincipal menu = new ControlMenuPrincipal(menu1);
            //MEDIANTE ESTA DECLARACION OCULTAREMOS LA INTERFAZ DE LOGIN YA QUE EL VALOR
            //AL MOSTRAR ES "false" CON ESTO SE OCULTA 
            log1.setVisible(false);
            //MEDIANTE EL OBJETO MENU PODEMOS TENER ACCESO AL METODO "Mostrar()"
            //EL CUAL CUMPLE LA FUNCION DE MOSTRA LA INTERFAZ
            menu.Mostrar();            
        } else {
            //EL CASO LOS DATOS INGRESADOS NO SEAN IGUALES SE MANDA UN MENSAJE DE ALERTA A TRAVES DE 
            //"UN JOptionPane"
            JOptionPane.showMessageDialog(null,"El Usuario o Contraseña incorrecto\n vuelva ingresar por favor");
        }
    }
    
    
}
