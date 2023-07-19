/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Ventas extends Vaca{
    //Atributos emcapsulados de la clase venta 
    protected int sacrificios;
    protected double precio;
    //Contructor
    public Ventas(int sacrificios, double precio, double peso_sacrificado) {
        super(peso_sacrificado);
        this.sacrificios = sacrificios;
        this.precio = precio;
    }
    //Metodo getter y setter
    public int getSacrificios() {
        return sacrificios;
    }
    public void setSacrificios(int sacrificios) {
        this.sacrificios = sacrificios;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //Metodo para calcular el peso de res sacrificadas por el precio
    public double Calculo(){
        return getPrecio() * peso_sacrificado;       
    }
    //metodos abtractos heredados
    @Override
    double AdultoConsumo() {return 0;}
    @Override
    double TerneroConsumo() {return 0;}
    //Metodo toString con el mensaje de resultado
    @Override
    public String toString() {
        return "||==============DATOS==============||\n" + 
               "|| N° de reces sacrificadas es : ["+sacrificios + " ]\n" +
               "|| Precio por Kilo de res es : [ S/."+getPrecio()+" ]\n"+
               "|| Peso total de reces sacrificadas : [ "+peso_sacrificado+" Kg. ]\n"+
               "|| Ganancia Total es de: [ S/."+Calculo()+" ]\n";
    }

    
        
    }