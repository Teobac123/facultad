package Ejercicio1;
import java.util.Scanner;

public class AreaCirculo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1. Calcular el área del círculo");
            System.out.println("2. Calcular el perimetro de un círculo");
            System.out.println("3. Salir");
            int opcion = s.nextInt();
            s.nextLine();

            switch(opcion){
                case 1: System.out.println("Ingrese el tamaño del radio en cm");
                        double radio = s.nextDouble();

                        double area = Math.PI * Math.pow(radio,2);

                        System.out.println("El área del circulo es: " + area);
                        break;
                case 2: System.out.println("Ingrese el radio del círculo");
                        double radio2 = s.nextDouble();
                        
                        double area2 = radio2 * 2;

                        System.out.println("El perímetro del círculo es: " + area2);
                        break;

                case 3: System.out.println("Gracias!");
                        s.close();
                        System.exit(0);
                        break;
                default: System.out.println("Opción no válida. Ingrese una opción correcta.");
                        break;
            }


        }





    }
    
}
