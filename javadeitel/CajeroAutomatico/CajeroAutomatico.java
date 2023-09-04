package CajeroAutomatico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Banco extends CajeroAutomatico{
    
    private Map<String, Usuarios> usuarios;

    public Banco() {
        this.usuarios = new HashMap<>();
    }

    public void crearUsuario(String name, double saldo) {
        Usuarios nuevoUsuario = new Usuarios(name, saldo);
        usuarios.put(name, nuevoUsuario);
        System.out.println("Usuario creado exitosamente.");
    }

    public Usuarios obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }

    public void mostrarUsuarios() {
        System.out.println("Lista de Usuarios:");
        for (Usuarios usuario : usuarios.values()) {
            System.out.println("Nombre: " + usuario.getName());
            System.out.println("Saldo: $" + usuario.getSaldo());
            System.out.println("--------------");
        }
    }
}

class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("1. Crear Usuario");
            System.out.println("2. Ingresar a cuenta");
            System.out.println("3. Mostrar Usuarios");
            System.out.println("4. Salir");
            int opcion = s.nextInt();
            s.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nombre completo:");
                    String name = s.nextLine();
                    double saldo = 0.0;

                    // Validar que el saldo inicial sea un número válido
                    boolean saldoValido = false;
                    while (!saldoValido) {
                        try {
                            System.out.println("Saldo Inicial: $");
                            saldo = Double.parseDouble(s.nextLine());
                            saldoValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número válido para el saldo inicial.");
                        }
                    }

                    banco.crearUsuario(name, saldo);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de usuario: ");
                    String nombreUsuario = s.nextLine();

                    Usuarios usuarioActual = banco.obtenerUsuario(nombreUsuario);
                    if (usuarioActual != null) {
                        System.out.println("Bienvenido, " + nombreUsuario);
                        realizarOperaciones(usuarioActual, s);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 3:
                    banco.mostrarUsuarios();
                    break;

                case 4:
                    System.out.println("Gracias por su confianza en nosotros, vuelva pronto");
                    s.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void realizarOperaciones(Usuarios usuario, Scanner scanner) {
        while (true) {
            System.out.println("Operaciones disponibles:");
            System.out.println("1. Depositar fondos");
            System.out.println("2. Retirar efectivo");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Validar el depósito como un número válido
                    boolean cantidadDepositoValida = false;
                    while (!cantidadDepositoValida) {
                        try {
                            System.out.print("Ingrese la cantidad a depositar: ");
                            double cantidadDeposito = Double.parseDouble(scanner.next());
                            usuario.aumentarSaldo(cantidadDeposito);
                            cantidadDepositoValida = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número válido para la cantidad a depositar.");
                        }
                    }
                    break;

                    case 2:
                    // Validar el retiro como un número válido
                    boolean cantidadRetiroValida = false;
                    double cantidadRetiro = 0.0;
                
                    while (!cantidadRetiroValida) {
                        try {
                            System.out.print("Ingrese la cantidad a retirar: ");
                            cantidadRetiro = Double.parseDouble(scanner.next());
                
                            if (cantidadRetiro <= 0) {
                                System.out.println("Ingrese una cantidad válida para el retiro.");
                            } else if (cantidadRetiro > usuario.getSaldo()) {
                                System.out.println("No tiene suficientes fondos para realizar este retiro.");
                            } else {
                                cantidadRetiroValida = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número válido para la cantidad a retirar.");
                        }
                    }
                
                    usuario.retirarEfectivo(cantidadRetiro);
                    break;
                

                case 3:
                    System.out.println("Saldo actual: " + usuario.getSaldo());
                    break;

                case 4:
                    System.out.println("Saliendo de la cuenta.");
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        }
    }
}