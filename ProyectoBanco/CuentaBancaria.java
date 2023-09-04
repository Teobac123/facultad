public class CuentaBancaria {

    private int numeroCuenta;
    private String nombreCliente;
    private double saldo;

    public CuentaBancaria() {
    }
    public CuentaBancaria(int numeroCuenta, String nombreCliente, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidadDepositar){
        saldo += cantidadDepositar;
    }
    public void retirar(double cantidadRetirar){
        if(saldo >= cantidadRetirar){
            saldo -= cantidadRetirar;
        }else{
            System.out.println("No hay fondos suficientes. Ingrese una cantidad de acuerdo a su saldo");
        }
    }
    


    @Override
    public String toString() {
        return "CuentaBancaria [numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", saldo=" + saldo
                + "]";
    } 
}
