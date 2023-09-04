package Ejercicio4;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Ingrese un número entero positivo");
        int n = s.nextInt();

        if(n <= 0){
            System.out.println("Por favor ingrese un número enter positivo");
        }else{
            int suma= 0;
            for(int i = 1; i <= n;i++){
                suma += i;
            }

            System.out.println("La suma de los primeros " + n + " numeros es: " + suma);

        }
        s.close();
    }
    
}
