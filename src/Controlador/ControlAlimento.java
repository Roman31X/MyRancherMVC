
package Controlador;

import Modelo.Alimento;
import Vista.Calculo_Alimento;
import Vista.Menu_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlAlimento implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES Menu_Principal - 
    //CLASE Calculo_Alimento - CREAMOS UN OBJETO DE LA CLASE "Alimento" del paquete "Modelo"
    private final Menu_Principal menu1;
    private final Calculo_Alimento calali3;
    private Alimento ali;
    //CONTRUCTOR QUE RECIBE COMO PARAMETRO EL OBJETO CREADO EN LA CLASE ControlMenuPrincipal
    public ControlAlimento(Menu_Principal menupri,Calculo_Alimento calali) {
        this.menu1 = menupri;
        this.calali3 = calali;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ Calculo_Alimento "calali3" OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        calali3.calcular.addActionListener(this);
        calali3.limpiar.addActionListener(this);
        calali3.regresar.addActionListener(this);
    }
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE Calulo_Alimento
    public void Mostrar(){
        calali3.setTitle("Calculo de Alimento MyRancher");
        calali3.setVisible(true);        
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO Calculo_Alimento EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //CAPTURAMOS LA VARIABLE "e" Y LA CONTENDREMOS EN UN STRING PARA REALIZAR SU EVALUACION MEDIANTE
        //UN "switch" QUE DESIGNARA QUE FUNCION REALIZARA MERIANTE LA VARIABLE "opcion"
        String opcion = e.getActionCommand();
        switch(opcion){
            case "CALCULAR" :   //FUNCION CALCULAR
                                //solicitamos los datos para el calculo
                                //Para ello creamos atributos que capturen los datos
                                double peso_saco = Double.parseDouble(calali3.Peso_Saco.getText());
                                double cant_saco = Double.parseDouble(calali3.Cant_Saco.getText());
                                double cant_adulto = Double.parseDouble(calali3.Cant_Adulto.getText());
                                double cant_ternero = Double.parseDouble(calali3.Cant_Ternero.getText());
                                double peso_adulto = Double.parseDouble(calali3.Peso_Adulto.getText());
                                double peso_ternero = Double.parseDouble(calali3.Peso_Ternero.getText());
                                //ENVIO LOS VALORES ATRAVEZ DEL OBJETO CREADO PARA Calculo_Alimento A TRAVEZ DEL CONTRUCTOR
                                ali = new Alimento(cant_saco,peso_saco,peso_adulto,peso_ternero,cant_adulto,cant_ternero);
                                //utilizamos los objetos para mostar el mensaje en el TextArea
                                calali3.Tex_Mensaje.append(ali.toString());
                                break;
            case "LIMPIAR" : 
                                //POR MEDIO DEL OBJETO DE LA INTERFAC CALCULO DE ALIMENTO
                                //ACCEDEMOS A LA VARIBALES DE LA INTERFAZ Y MOSTRAREMOS 
                                //POR MEDIO DEL METODO SETTER LAS CASILLAR VASIAS YA QUE NO HAY CONTENIDO
                                //DENTRO DE LAS COMILLAS
                                calali3.Peso_Saco.setText("");
                                calali3.Cant_Saco.setText("");
                                calali3.Cant_Adulto.setText("");
                                calali3.Peso_Adulto.setText("");
                                calali3.Cant_Ternero.setText("");
                                calali3.Peso_Ternero.setText("");
                                calali3.Tex_Mensaje.setText("");
                                break;
            
            case "REGRESAR" :
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA MOSTRAR LA INTERFAZ "MenuPrincipal" 
                                menu1.setVisible(true);
                                //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                                //PARA OCULTAR LA INTERFAZ "Calculo_Alimento" 
                                calali3.setVisible(false);
                                break;
        }
    }
}
