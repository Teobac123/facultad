package poo.Ejercicio2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Solicitar al usuario la cantidad de libros
        boolean cantidadLibrosValido = false;
        int cantidadLibros = 0;
        while (!cantidadLibrosValido) {
            try {
                System.out.println("¿Cuántos libros hay en su biblioteca?");
                cantidadLibros = s.nextInt();
                if (cantidadLibros <= 0) {
                    System.out.println("Solo puede colocar 1 o más libros.");
                } else {
                    cantidadLibrosValido = true;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ingrese un número válido de libros.");
                s.nextLine(); // Limpiar el buffer de entrada
            }
        }

        // Crear un arreglo que contenga todos los libros
        Libro[] biblioteca = new Libro[cantidadLibros];

        s.nextLine(); // Limpiar el buffer de entrada

        // Leer la información de los libros y crear un objeto libro almacenado en el arreglo
        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println("Ingrese el título del libro " + (i + 1) + ":");
            String titulo = s.nextLine();
            System.out.println("Ingrese el autor del libro " + (i + 1) + ":");
            String autor = s.nextLine();
            System.out.println("Ingrese el año de publicación del libro " + (i + 1) + ":");
            int anioPublicacion = s.nextInt();

            biblioteca[i] = new Libro(titulo, autor, anioPublicacion);
            s.nextLine(); // Limpiar el buffer de entrada
        }

        // Comparar las fechas de publicación de los libros
        for (int i = 0; i < cantidadLibros; i++) {
            for (int j = i + 1; j < cantidadLibros; j++) {
                if (biblioteca[i].getAnioPublicacion() < biblioteca[j].getAnioPublicacion()) {
                    System.out.println(biblioteca[i].getTitulo() + " fue publicado antes que " + biblioteca[j].getTitulo());
                } else if (biblioteca[i].getAnioPublicacion() > biblioteca[j].getAnioPublicacion()) {
                    System.out.println(biblioteca[j].getTitulo() + " fue publicado antes que " + biblioteca[i].getTitulo());
                } else {
                    System.out.println(biblioteca[i].getTitulo() + " y " + biblioteca[j].getTitulo() + " fueron publicados en el mismo año.");
                }
            }
        }

        s.close();
    }
}

