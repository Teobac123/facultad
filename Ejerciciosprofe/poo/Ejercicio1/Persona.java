package poo.Ejercicio1;

public class Persona {

    protected String nombre;
    protected int edad;
    protected int dni;

    
    public Persona(String nombre) {
        this.nombre = nombre;
    }


    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public String dameNombre(){
        return "El nombre es " + nombre;
    }

    public String dameDNI(){
        return "El dni de " + nombre + " es " + dni;
    }

    public String dameEdad(){
        return "La edad de " + nombre + " es " + edad;
    }


    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
    }
    
    
}