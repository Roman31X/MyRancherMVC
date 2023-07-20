
package Aplicativo;

import Controlador.ControladorLogin;
import Vista.Login;

public class MyRancher {
    public static void main(String[] args) {
        Login lo = new Login();
        ControladorLogin login = new ControladorLogin(lo);
        login.iniciar();
    }
}
