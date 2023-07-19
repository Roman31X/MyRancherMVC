package Controlador;

import Modelo.Ventas;
import Vista.Calculo_Ventas;
import Vista.Menu_Principal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControlVenta implements ActionListener{
    //EMCAPSULAMIENTO DEL OBETOS CREADOS DEL PAQUETE "Vista" CLASES Menu_Principal - 
    //CLASE Calculo_Ventas - CREAMOS UN OBJETO DE LA CLASE "Venta" del paquete "Modelo"
    private final Menu_Principal menupr;
    private Calculo_Ventas vent4;
    private Ventas venta;
    //DECLARACION DE ARRAYLIST DE TIPO STRING 
    ArrayList<String> data = new ArrayList<>();
    //DECLARACION DE VARIABLE IMPLEMENTADA PARA ALMACENAR LA SUMA DE LOS PESOS REGISTRADOS
    double peso=0;
    //CONTRUCTOR QUE RECIBE COMO PARAMETRO EL OBJETO CREADO EN LA CLASE ControlMenuPrincipal
    public ControlVenta( Menu_Principal menupr1,Calculo_Ventas ven) {
        this.menupr=menupr1;
        this.vent4 = ven;
        //MEDIANTE EL OBEJETO DEL LA INTERFAZ Calculo_Ventas "vent4" OBTENGO EL ACCESO 
        //DE SUS VARIABLES ASISGNADAS A LOS BOTENES QUE SERAN RECEPCIONADAS 
        //MEDINATE EL METODO ActionListener QUE RECIBE EL NOMBRE DE VARIABLE 
        vent4.registrar.addActionListener(this);
        vent4.calcular.addActionListener(this);
        vent4.limpiar.addActionListener(this);
        vent4.generar.addActionListener(this);
        vent4.regresar.addActionListener(this);
    }
    //MÉTODO PARA INICIAR EL CONTROLADOR
    //MOSTRARÁ LA "VISTA" DE Calulo_Ventas
    public void Mostrar(){
        vent4.setTitle("Calculo Ventas MyRancher");
        vent4.setVisible(true);        
    }
    //EL CONTROLADOR SE HACE CARGO DE MANEJAR EL EVENTO
    //CLIC DEL BOTÓN QUE ESTÁ EN EL FORMULARIO Calculo_Ventas EN EL PAQUETE "VISTA"
    @Override
    public void actionPerformed(ActionEvent e) {
        //CAPTURAMOS LA VARIABLE "e" Y LA CONTENDREMOS EN UN STRING PARA REALIZAR SU EVALUACION MEDIANTE
        //UN "switch" QUE DESIGNARA QUE FUNCION REALIZARA MERIANTE LA VARIABLE "opcion"
        String opcion = e.getActionCommand();
        switch(opcion){
            case "REGISTRAR" :
                            //FUNCION BOTON REGISTRAR
                            //Obtenermos el peso registrado y lo designamos a dato de tipo String
                            //para ser almacenado en el ArrayList
                            String dato = vent4.PesoIngresado.getText();
                            //Almacenamos el mismo peso registrados en el area de peso y es transformado
                            //a un dato Double
                            double kilos = Double.parseDouble(vent4.PesoIngresado.getText());
                            //Agregamos al ArrayList el peso registrado en la variable dato de tipo String
                            data.add(dato);
                            //La varibale esta inicializada en 0 pero sumara el peso registrado en la variable
                            //kilos para ir sumando los pesos registrados
                            peso+=kilos;
                            //Inicializamos un variable de tipo String para almacenar datos de tipos String
                            String contenido = "";
                            //Implementacion de forn para el recorrido del ArrayList
                            for (String d : data) {
                                contenido += d + "\n";
                            }
                            //Una vez recorrido el Arraylist en la caja TextList mostraremos los datos
                            //La variable Contenido que contendra los datsos del ArrayList y a su ves la
                            //suma de los pesos registrados 
                            vent4.TextPesos.setText(contenido+"\n|| Total de Kilos: ["+peso+" Kg. ]");
                            //Medinate la intancia del objeto mostraremos con el metodo setter la casilla vacia
                            //que corresponde a la casilla del peso
                            vent4.PesoIngresado.setText("");
                            break;
            case "CALCULAR" :
                            //FUNCION BOTON CALCULAR
                            //solicitamos los datos para el calculo
                            //Para ello creamos atributos que capturen los datos
                            int sacrificios = Integer.parseInt(vent4.CantiSacrificado.getText());
                            double precio = Double.parseDouble(vent4.PrecioKilo.getText());
                            //ENVIO LOS VALORES ATRAVEZ DEL OBJETO CREADO PARA Calculo_Ventas A TRAVEZ DEL CONTRUCTOR
                            venta = new Ventas(sacrificios,precio,peso);
                            //utilizamos los objetos para mostar el mensaje en el TextArea
                            vent4.TextSalida.append(venta.toString());
                            break;
            case "GENERAR GRAFICA" :
                            //FUNCION BOTON GRAFICA
                            //INSTACIAMOS UN OBJETO DE LA CLASE DefaultCategoryDataset
                            DefaultCategoryDataset datos = new DefaultCategoryDataset();
                            //Implementamos un ciclo for para enviar los datos almacenados en el ArrayLit 
                            //Medinate el objeto "datos" para agregarlo 
                            for(int i=0; i<data.size(); i++ ){ 
                            datos.addValue(Integer.parseInt(data.get(i)), "Peso ["+(i+1)+"]", "Vaca ["+(i+1)+"]");
                            }
                            //Se envian los parametros mediante el contructor de la Clase para generar la grafica
                            JFreeChart grafico_barras = ChartFactory.createBarChart(
                                    "Ventas de cabeza de res",//nombre de la grafica
                                    "Pesos",//nombre de las barras columnas
                                    "Pesos de ganado",//nombre de la numeración
                                    datos,//datos de la grafica
                                    PlotOrientation.VERTICAL,//orientacion de la grafica
                                    false,//leyenda de barras individuales
                                    true, //herramientas
                                    false// url de la grafica
                            );
                            //Designamos datos para mostar la grafica
                            ChartPanel panel = new ChartPanel(grafico_barras);
                            panel.setMouseWheelEnabled(true);
                            panel.setPreferredSize(new Dimension(487, 188));
                            //Designamos medinate los objetos donde se mostrara la grafica
                            vent4.PanelGrafica.setLayout(new BorderLayout());
                            vent4.PanelGrafica.add(panel, BorderLayout.NORTH);
                            //Metodos de importacion de datos de la Clase
                            vent4.pack();
                            vent4.repaint();
                            break;
            case "LIMPIAR" : 
                            //POR MEDIO DEL OBJETO DE LA INTERFAS CALCULO_VENTAS
                            //ACCEDEMOS A LA VARIBALES DE LA INTERFAZ Y MOSTRAREMOS 
                            //POR MEDIO DEL METODO SETTER LAS CASILLAR VACIAS YA QUE NO HAY CONTENIDO
                            //DENTRO DE LAS COMILLAS
                            //Funcion del boton Limpiar
                            vent4.CantiSacrificado.setText("");
                            vent4.PesoIngresado.setText("");
                            vent4.PrecioKilo.setText("");
                            vent4.TextPesos.setText("");
                            vent4.TextSalida.setText("");
                            break;
            
            case "REGRESAR" :
                            //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                            //PARA MOSTRAR LA INTERFAZ "MenuPrincipal" 
                            menupr.setVisible(true);
                            //MEDINATE EL OBJETOS REALIZAREMOS LAS ACCIONESS 
                            //PARA OCULTAR LA INTERFAZ "Calculo_Ventas" 
                            vent4.setVisible(false);
                            break;
        }
        
    }
}
