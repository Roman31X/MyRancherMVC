
package Aplicativo;

import Controlador.ControladorLogin;
import Vista.Login;
import Vista.Menu_Principal;

public class MyRancher {
    public static void main(String[] args) {
        Login lo = new Login();
        Menu_Principal me = new Menu_Principal();
        ControladorLogin login = new ControladorLogin(lo,me);
        login.iniciar();
    }
}
