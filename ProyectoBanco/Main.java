import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    private ArrayList <CuentaBancaria> cuentas = new ArrayList<>();
    private int numeroCuentaActual=1;
    private Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Main banco = new Main();
        banco.ejecutar();
    }
    //ejecutar

    public void ejecutar(){
        while (true){
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Mostrar Cuentas");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Retiro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = s.nextInt();

            switch (opcion){
                case 1: 
                    crearCuenta();
                    break;

                case 2: 
                    mostrarCuentas();
                    break;
                
                case 3: 
                    realizarDeposito();
                    break;
                    
                case 4: 
                    realizarRetiro();
                    break;

                case 5:
                    System.out.println("Gracias por elegirnos. Vuelva pronto!");
                    s.close();
                    System.exit(0);
                    break;

                default: 
                    System.out.println("Opción no válida.");
                    break;
            }


        }
    }


    //Métodos

    private void crearCuenta(){
        s.nextLine();
        System.out.println("1. Ingrese su nombre completo: ");
        String nombreCliente = s.nextLine();
        double saldoInicial = 0.0;

        cuentas.add(new CuentaBancaria(numeroCuentaActual, nombreCliente, saldoInicial));
        System.out.println("Cuenta creada con éxito. Número de cuenta: " + numeroCuentaActual);
        numeroCuentaActual++;
    }

    private void mostrarCuentas(){
        System.out.println("Lista de cuentas: ");
        for (CuentaBancaria cuenta : cuentas){
            System.out.println(cuenta);
        }
    }
    private void realizarDeposito(){
        System.out.println("Ingrese número de cuenta: ");
        int numeroCuenta = s.nextInt();
        CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
        if(cuenta != null){
            System.out.println("Ingreese cantidad de dinero a depositar: $");
            double cantidadDepositar = s.nextDouble();
            cuenta.depositar(cantidadDepositar);
            System.out.println("Deposito realizado con éxito");
        }else{
            System.out.println("Número de cuenta no encontrado");
        }
    }

    private void realizarRetiro(){
        System.out.println("Ingrese numero de cuenta: ");
        int numeroCuenta = s.nextInt();
        CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.print("Cantidad a retirar: $");
            double cantidad = s.nextDouble();
            
            if (cantidad > 0 && cantidad <= cuenta.getSaldo()) {
                cuenta.retirar(cantidad);
                System.out.println("Retiro realizado con éxito. Nuevo saldo: $" + cuenta.getSaldo());
            } else {
                System.out.println("Cantidad no válida o saldo insuficiente.");
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private CuentaBancaria buscarCuenta(int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
}