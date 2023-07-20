package Modelo;


public class Forraje extends Vaca{
    protected double peso1;
    protected double peso2;
    protected double hectaria;
    
    public Forraje(double peso1, double peso2, double hectaria, double peso_adulto, double peso_ternero, double canti_adulto, double canti_ternero) {
        super(peso_adulto, peso_ternero, canti_adulto, canti_ternero);
        this.peso1 = peso1;
        this.peso2 = peso2;
        this.hectaria = hectaria;
    }
    
    public double getPeso1() {
        return peso1;
    }
    public void setPeso1(double peso1) {
        this.peso1 = peso1;
    }
    public double getPeso2() {
        return peso2;
    }
    public void setPeso2(double peso2) {
        this.peso2 = peso2;
    }
    public double getHectaria() {
        return hectaria;
    }
    public void setHectaria(double hectaria) {
        this.hectaria = hectaria;
    }
    //Calculo de peso de corte
    public double PesoTotalForraje(){
        return getPeso1() + getPeso2();
    }
    //Calculo de Culo de consumo de forraje verde Adulto
    @Override
    public double AdultoConsumo(){
        return (peso_adulto * 0.07) * canti_adulto;
    }
    //Calculo de Culo de consumo de forraje verde Ternero
    @Override
    public double TerneroConsumo(){
        return (peso_ternero * 0.05) * canti_ternero;
    }
    //Calculo del consumo total de adulto y ternero
    public double TotalConsumo(){
        return AdultoConsumo() + TerneroConsumo();
    }
    //Calculo de produccion de forraje x hectaria
    public double ForrajeTotal(){
        return PesoTotalForraje() * 0.8 * 2 * (getHectaria()*10000);
    }
    //Calculo cuantos dias durara el forraje
    public int DiasConsumo(){
        int dia=0;
        double sobra = ForrajeTotal();
        while(sobra >= TotalConsumo()){
            sobra-=TotalConsumo();
            dia++;
        }
        return dia;
    }
    //Calcular sobrante de peso
    public double Sobra(){
        double sobra = ForrajeTotal();
        while(sobra >= TotalConsumo()){
            sobra-=TotalConsumo();
        }
        return sobra;
    }
    //Metodo para mostarar los resultados

    @Override
    public String toString() {
        return "||======================DATOS=======================||\n"+
               "|| La cantidad de Hectaria es: [ " + getHectaria() + " ha ]\n"+
               "|| Peso del corte 1 es : [ " + getPeso1() + " Kg. ]\n"+
               "|| Peso del corte 2 es : [ " + getPeso2() + " Kg. ]\n"+
               "|| Cantidad de Ganado Adulto : [ "+canti_adulto+" ]\n"+
               "|| Peso Promedio de Adulto : [ "+peso_adulto+" Kg. ]\n"+
               "|| Cantidad de Ganado Ternero : [ "+canti_ternero+ " ]\n"+
               "|| Peso promedio de Ternero : [ "+peso_ternero+" Kg. ]\n"+
               "||=====================CALCULO======================||\n"+
               "|| Forraje producido x Hectaria es : [ "+ForrajeTotal()+" t. ]\n"+
               "|| Cantidad de Forraje consumo Adulto : [ "+AdultoConsumo()+" Kg. ]\n"+
               "|| Cantidad de Forraje consumo Ternero : [ "+TerneroConsumo()+" Kg. ]\n"+
               "|| Consumo total x Dia es : [ "+Math.round(TotalConsumo())+" Kg. ]\n"+
               "|| Dias que durara Forraje producido x Hectaria : ["+DiasConsumo()+" dias ]\n"+
               "|| Peso de Forraje restante es : [ "+Sobra()+" Kg. ]";
    }
    
    
    
    
}
