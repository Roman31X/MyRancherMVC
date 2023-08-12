
package Aplicativo;

import Controlador.ControladorLogin;
import Vista.Login;

public class MyRancher {
    public static void main(String[] args) {
        Login objetoLogin = new Login();
        ControladorLogin login = new ControladorLogin(objetoLogin);
        login.iniciar();
    }
}
