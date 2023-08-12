package Controlador;

import Modelo.Ventas;
import Vista.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControlVenta implements ActionListener{
    
    private Calculo_Ventas ventas;
    private Menu_Principal menu;
    ArrayList<String> data;
    double peso = 0;
    
    public ControlVenta(Calculo_Ventas ven) {
        this.ventas = ven;
        
        ventas.registrar.addActionListener(this);
        ventas.calcular.addActionListener(this);
        ventas.limpiar.addActionListener(this);
        ventas.generar.addActionListener(this);
        ventas.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        ventas.setTitle("Calculo Ventas MyRancher");
        ventas.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        data = new ArrayList<String>();
        Ventas calculo;
        String opcion = e.getActionCommand();
        switch(opcion){
            case "REGISTRAR" :
                            String dato = ventas.PesoIngresado.getText();
                            double kilos = Double.parseDouble(ventas.PesoIngresado.getText());
                            data.add(dato);
                            peso+=kilos;
                            String contenido = "";
                            for (String d : data) {
                                contenido += d + "\n";
                            }
                            ventas.TextPesos.setText(contenido+"\n|| Total de Kilos: ["+peso+" Kg. ]");
                            ventas.PesoIngresado.setText("");
                            break;
            case "CALCULAR" :
                            int sacrificios = Integer.parseInt(ventas.CantiSacrificado.getText());
                            double precio = Double.parseDouble(ventas.PrecioKilo.getText());
                            calculo = new Ventas(sacrificios,precio,peso);
                            ventas.TextSalida.append(calculo.toString());
                            break;
            case "GENERAR GRAFICA" :
                            DefaultCategoryDataset datos = new DefaultCategoryDataset();
                            for(int i=0; i<data.size(); i++ ){ 
                            datos.addValue(Integer.parseInt(data.get(i)), "Peso ["+(i+1)+"]", "Vaca ["+(i+1)+"]");
                            }
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
                            ChartPanel panel = new ChartPanel(grafico_barras);
                            panel.setMouseWheelEnabled(true);
                            panel.setPreferredSize(new Dimension(487, 188));
                            ventas.PanelGrafica.setLayout(new BorderLayout());
                            ventas.PanelGrafica.add(panel, BorderLayout.NORTH);
                            ventas.pack();
                            ventas.repaint();
                            break;
            case "LIMPIAR" : 
                            ventas.CantiSacrificado.setText("");
                            ventas.PesoIngresado.setText("");
                            ventas.PrecioKilo.setText("");
                            ventas.TextPesos.setText("");
                            ventas.TextSalida.setText("");
                            break;
            
            case "REGRESAR" :
                            ControlMenuPrincipal principal = new ControlMenuPrincipal(menu);
                            principal.Mostrar();
                            ventas.setVisible(false);
                            break;
        }
        
    }
}
