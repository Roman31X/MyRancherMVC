
package Modelo;

public abstract class Vaca {
    //Atributos de la vaca
    protected double peso_adulto;
    protected double peso_ternero;
    protected double canti_adulto;
    protected double canti_ternero;
    protected double peso_sacrificado;
    //CONTRUCTOR PARA VACA ADULTA
    public Vaca(double peso_adulto, double peso_ternero, double canti_adulto, double canti_ternero) {
        this.peso_adulto = peso_adulto;
        this.peso_ternero = peso_ternero;
        this.canti_adulto = canti_adulto;
        this.canti_ternero = canti_ternero;
    }
    public Vaca(double peso_sacrificado) {
        this.peso_sacrificado = peso_sacrificado;
    }
    
    //Metodoso getter y setter
    public double getPeso_adulto() {
        return peso_adulto;
    }
    public void setPeso_adulto(double peso_adulto) {
        this.peso_adulto = peso_adulto;
    }
    public double getPeso_ternero() {
        return peso_ternero;
    }
    public void setPeso_ternero(double peso_ternero) {
        this.peso_ternero = peso_ternero;
    }
    public double getCanti_adulto() {
        return canti_adulto;
    }
    public void setCanti_adulto(double canti_adulto) {
        this.canti_adulto = canti_adulto;
    }
    public double getCanti_ternero() {
        return canti_ternero;
    }
    public void setCanti_ternero(double canti_ternero) {
        this.canti_ternero = canti_ternero;
    }
    //metodos abstractos
    abstract double AdultoConsumo();
    abstract double TerneroConsumo();
    
}
