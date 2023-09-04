package CajeroAutomatico;


public class Usuarios {

    private String name;
    private double saldo;
    
    
    public Usuarios(String name, double saldo) {
        this.name = name;
        this.saldo = saldo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void aumentarSaldo(double monto){
        saldo = saldo + monto;
    }
    public void retirarEfectivo(double monto){
        saldo = saldo - monto;
    }
    @Override
    public String toString() {
        return "Usuarios [name=" + name + ", saldo=" + saldo + "]";
    }

    

    
}
