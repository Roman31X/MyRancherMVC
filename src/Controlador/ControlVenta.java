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
    private final Menu_Principal menupr;
    private Calculo_Ventas vent4;
    private Ventas venta;
    ArrayList<String> data = new ArrayList<>();
    double peso=0;
    
    public ControlVenta( Menu_Principal menupr1,Calculo_Ventas ven) {
        this.menupr=menupr1;
        this.vent4 = ven;
        
        vent4.registrar.addActionListener(this);
        vent4.calcular.addActionListener(this);
        vent4.limpiar.addActionListener(this);
        vent4.generar.addActionListener(this);
        vent4.regresar.addActionListener(this);
    }
    
    public void Mostrar(){
        vent4.setTitle("Calculo Ventas MyRancher");
        vent4.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String opcion = e.getActionCommand();
        switch(opcion){
            case "REGISTRAR" :
                            String dato = vent4.PesoIngresado.getText();
                            double kilos = Double.parseDouble(vent4.PesoIngresado.getText());
                            data.add(dato);
                            peso+=kilos;
                            String contenido = "";
                            for (String d : data) {
                                contenido += d + "\n";
                            }
                            vent4.TextPesos.setText(contenido+"\n|| Total de Kilos: ["+peso+" Kg. ]");
                            vent4.PesoIngresado.setText("");
                            break;
            case "CALCULAR" :
                            int sacrificios = Integer.parseInt(vent4.CantiSacrificado.getText());
                            double precio = Double.parseDouble(vent4.PrecioKilo.getText());
                            venta = new Ventas(sacrificios,precio,peso);
                            vent4.TextSalida.append(venta.toString());
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
                            vent4.PanelGrafica.setLayout(new BorderLayout());
                            vent4.PanelGrafica.add(panel, BorderLayout.NORTH);
                            vent4.pack();
                            vent4.repaint();
                            break;
            case "LIMPIAR" : 
                            vent4.CantiSacrificado.setText("");
                            vent4.PesoIngresado.setText("");
                            vent4.PrecioKilo.setText("");
                            vent4.TextPesos.setText("");
                            vent4.TextSalida.setText("");
                            break;
            
            case "REGRESAR" :
                            menupr.setVisible(true);
                            vent4.setVisible(false);
                            break;
        }
        
    }
}
