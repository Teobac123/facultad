package poo.Ejercicio2;

public class Libro {

    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + "\n Autor=" + autor + ",\n Año de publicación= " + anioPublicacion + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
}
