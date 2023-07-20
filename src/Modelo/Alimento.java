
package Modelo;

public class Alimento extends Vaca{
    
    protected double cantidad_saco;
    protected double peso_saco;
    
    public Alimento(double cantidad_saco, double peso_saco, double peso_adulto, double peso_ternero, double canti_adulto, double canti_ternero) {
        super(peso_adulto, peso_ternero, canti_adulto, canti_ternero);
        this.cantidad_saco = cantidad_saco;
        this.peso_saco = peso_saco;
    }
    
    public double getCantidad_saco() {
        return cantidad_saco;
    }
    public void setCantidad_saco(double cantidad_saco) {
        this.cantidad_saco = cantidad_saco;
    }
    public double getPeso_saco() {
        return peso_saco;
    }
    public void setPeso_saco(double peso_saco) {
        this.peso_saco = peso_saco;
    }
    //Metodo para calculo de Concumo promedio de Adulto
    @Override
    public double AdultoConsumo(){
        return (peso_adulto * 0.03) * canti_adulto;
    }
    //Metodo para Calculo de Consumo promedio de Ternero
    @Override
    public double TerneroConsumo(){
        return (peso_ternero * 0.02) * canti_ternero;
    }
    //Metodo para Calcular consumo total
    public double ConsumoTotal(){
        return (AdultoConsumo() + TerneroConsumo());
    }
    //Metodo para calcular la cantidad de aliemnto existente
    public double AlimentoSaco(){
        return cantidad_saco * peso_saco;
    }
    //Metodo para calcular cuantos dias durara el alimento
    public int DiasAliment(){
        int dia = 0;
        double queda = AlimentoSaco();
        while(queda >= ConsumoTotal()){
            queda-=ConsumoTotal();
            dia++;
        }
        return dia;
    }
    //Metodo que arrojara cuanto Kilos de alimento sobro
    public double AlimentoRestante(){
        double queda = AlimentoSaco();
        while(queda >= ConsumoTotal()){
            queda-=ConsumoTotal();
        }
        return queda;
    }
    //Metodo que mostrara los resultados

    @Override
    public String toString() {
        return "||================DATOS===============||\n"+
               "|| Peso de saco                 [ "+getPeso_saco()+" ]\n"+
               "|| Cant. Sacos de Alimento:     [ "+getCantidad_saco()+" ]\n"+
               "|| Cant. Gando Adulto:          [ "+getCanti_adulto()+" ]\n"+
               "|| Peso promedio Adulto:        [ "+getPeso_adulto()+" Kg. ]\n"+
               "|| Cant. Ganado Ternero:        [ "+getCanti_ternero()+" ]\n"+
               "|| Peso promedio Ternero:       [ "+getPeso_ternero()+" Kg. ]\n"+
               "||============CÁLCULO================||\n"+
               "|| Peso a consumir Adulto:      [ "+AdultoConsumo()+" Kg. ]\n"+
               "|| Peso a consumir Ternero:     [ "+TerneroConsumo()+" Kg. ]\n"+
               "|| Peso Total consumo x DIA:    [ "+ConsumoTotal()+" Kg. ]\n"+
               "|| Peso actual de alimento:     [ "+AlimentoSaco()+" Kg. ]\n"+
               "|| Dias que durara el alimento: [ "+DiasAliment()+" dias ]\n"+
               "|| Cantidad restante de alimento: ["+Math.round(AlimentoRestante())+" Kg.]\n";
    }
    
}
