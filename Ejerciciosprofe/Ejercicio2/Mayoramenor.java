package Ejercicio2;
import java.util.Scanner;
public class Mayoramenor {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el primer número");
        double num1 = s.nextDouble();
        System.out.println("Ingrese el segundo número");
        double num2 = s.nextDouble();
        System.out.println("Ingrese el tercer número");
        double num3 = s.nextDouble();

        double[] numeros = {num1,num2,num3};
        int n = numeros.length;
        boolean intercambio;

        do {

            intercambio = false;
            for (int i = 0; i < n - 1; i++){
                if (numeros[i] < numeros[i + 1]) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    double temp = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = temp;
                    intercambio = true;
                }
            }
        }while(intercambio);

        System.out.print("Los números ordenados de mayor a menor son: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        s.close();
    }
    
}
