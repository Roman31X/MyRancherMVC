
package Aplicativo;

import Controlador.ControladorLogin;
import Vista.Login;
import Vista.Menu_Principal;

public class MyRancher {
    //CLASE PRINCIPAL DE EJECUCION
    public static void main(String[] args) {
        //CREA UN OBJETO PARA LA INTERFAS LOGIN Y MENU PRINCIPAL DEL APLICATIVO MYRANCHER
        Login lo = new Login();
        Menu_Principal me = new Menu_Principal();
        //CREAMOS UN OBJETO DEL CONTROLADOR CONTROLADOR LOGIN Y ENVIAMOS COMO PARAMETROS
        //LOS OBJETOS CREADOS
        ControladorLogin login = new ControladorLogin(lo,me);
        //INICIAMOS MEDIANTE EL OBJETO DEL CONTRUCTOR CONTROLLOGIN
        //EL OBJETO LLAMA AL METODO INICIAR() QUE TIENE COMO FUNCION
        //MOSTRAR LA INTERFAZ DE LOGIN
        login.iniciar();
    }
}
